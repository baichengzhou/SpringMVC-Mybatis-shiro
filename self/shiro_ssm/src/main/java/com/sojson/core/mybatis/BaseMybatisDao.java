package com.sojson.core.mybatis;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sojson.common.utils.StringUtils;
import com.sojson.core.mybatis.page.MysqlDialect;
import com.sojson.core.mybatis.page.Pagination;

@SuppressWarnings( { "unchecked" })
public class BaseMybatisDao<T> extends SqlSessionDaoSupport {

	private String namespace;

	protected final Log logger = LogFactory.getLog(BaseMybatisDao.class);

	public BaseMybatisDao() {
		try {
			Object genericClz = getClass().getGenericSuperclass();
			if (genericClz instanceof ParameterizedType) {
				Class<T> entityClass = (Class<T>) ((ParameterizedType) genericClz)
						.getActualTypeArguments()[0];
				namespace = entityClass.getPackage().getName() + "."
						+ entityClass.getSimpleName();
			}
		} catch (RuntimeException e) {
			logger.error("jdbc.error.code.BaseMyBatisMapper", e);
			throw e;// WYFException("jdbc.error.code.BaseMyBatisMapper", new
					// String[] { "no constructor parames" }, e);
		}
	}

	public Pagination<?> findByPageBySqlId(String sqlId,
			Map<String, Object> params, Integer pageNo, Integer pageSize) {

		pageNo = null == pageNo ? 1 : pageNo;
		pageSize = null == pageSize ? 10 : pageSize;

		sqlId = namespace + "." + sqlId;

		Pagination page = new Pagination();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Configuration c = this.getSqlSession().getConfiguration();
		BoundSql boundSql = c.getMappedStatement(sqlId).getBoundSql(params);
		String sqlcode = boundSql.getSql();
		logger.debug("findByPageBySqlId sql = " + sqlcode);
		try {
			Connection conn = this.getSqlSession().getConnection();

			int offset = (page.getPageNo() - 1) * page.getPageSize();
			List resultList = this.getSqlSession().selectList(sqlId, params,
					new RowBounds(offset, pageSize));
			page.setList(resultList);
			PreparedStatement ps = getPreparedStatement(boundSql.getSql(),
					boundSql.getParameterMappings(), params, conn);
			ps.execute();
			ResultSet set = ps.getResultSet();

			while (set.next()) {
				page.setTotalCount(set.getInt(1));
			}
		} catch (Exception e) {
			logger.error("jdbc.error.code.findByPageBySqlId", e);
			e.printStackTrace();
			// throw new WYFException("jdbc.error.code.findByPageBySqlId", new
			// String[] { BaseMybatisDao.class.getName() }, e);
		}
		return page;
	}

	/**
	 * 解决分页查询,但是不需要分页数据,只需要List集合
	 */
	public List<?> findList(String sqlId, Map<String, Object> params,
			Integer pageNo, Integer pageSize) {
		pageNo = null == pageNo ? 1 : pageNo;
		pageSize = null == pageSize ? 10 : pageSize;

		int offset = (pageNo - 1) * pageSize;
		String _page = " limit " + offset + "," + pageSize;
		params.put("_page", _page);
		sqlId = namespace + "." + sqlId;

		List resultList = this.getSqlSession().selectList(sqlId, params);
		return resultList;
	}

	/**
	 * 重载减少参数"findAll"
	 * 
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<?> findList(Map<String, Object> params, Integer pageNo,
			Integer pageSize) {
		return findList("findAll", params, pageNo, pageSize);
	}

	/**
	 * 新分页,解决物理分页问题
	 * 
	 * @param sqlId
	 *            主语句
	 * @param countId
	 *            Count 语句
	 * @param params
	 *            参数
	 * @param pageNo
	 *            第几页
	 * @param pageSize每页显示多少条
	 * @return
	 */
	public Pagination findPage(String sqlId, String countId,
			Map<String, Object> params, Integer pageNo, Integer pageSize) {
		pageNo = null == pageNo ? 1 : pageNo;
		pageSize = null == pageSize ? 10 : pageSize;
		Pagination page = new Pagination();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		Configuration c = this.getSqlSession().getConfiguration();
		int offset = (page.getPageNo() - 1) * page.getPageSize();
		String _page = " limit " + offset + "," + pageSize;
		params.put("_page", _page);

		sqlId = namespace + "." + sqlId;

		BoundSql boundSql = c.getMappedStatement(sqlId).getBoundSql(params);
		String sqlcode = boundSql.getSql();
		logger.debug("findByPageBySqlId sql = " + sqlcode);

		String countCode = "";
		BoundSql countSql = null;
		if (StringUtils.isBlank(countId)) {
			countCode = sqlcode;
			countSql = boundSql;
		} else {
			countId = namespace + "." + countId;
			countSql = c.getMappedStatement(countId).getBoundSql(params);
			countCode = countSql.getSql();
		}
		try {
			Connection conn = this.getSqlSession().getConnection();

			List resultList = this.getSqlSession().selectList(sqlId, params); // ,new
																				// RowBounds(offset,
																				// pageSize)

			page.setList(resultList);
			PreparedStatement ps = getPreparedStatement(countCode, countSql
					.getParameterMappings(), params, conn);
			ps.execute();
			ResultSet set = ps.getResultSet();

			while (set.next()) {
				page.setTotalCount(set.getInt(1));
			}
		} catch (Exception e) {
			logger.error("jdbc.error.code.findByPageBySqlId", e);
			e.printStackTrace();
			// throw new WYFException("jdbc.error.code.findByPageBySqlId", new
			// String[] { BaseMybatisDao.class.getName() }, e);
		}
		return page;

	}

	public PreparedStatement getPreparedStatement(String sql,
			List<ParameterMapping> parameterMappingList,
			Map<String, Object> params, Connection conn) throws SQLException {
		/**
		 * 分页根据数据库分页
		 */
		MysqlDialect o = new MysqlDialect();

		PreparedStatement ps = conn.prepareStatement(o.getCountSqlString(sql));
		int index = 1;
		for (int i = 0; i < parameterMappingList.size(); i++) {
			ps.setObject(index++, params.get(parameterMappingList.get(i)
					.getProperty()));
		}
		return ps;
	}

	public Map<String, Object> callProcedureUtils(Map<String, Object> params,
			String proName) {
		this.getSqlSession().selectList(proName, params);
		return params;
	}

	/**
	 * 重载减少参数"findAll", "findCount"
	 * 
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination findPage(Map<String, Object> params, Integer pageNo,
			Integer pageSize) {

		return findPage("findAll", "findCount", params, pageNo, pageSize);
	}

}
