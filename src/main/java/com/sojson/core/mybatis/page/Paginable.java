package com.sojson.core.mybatis.page;

/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年5月8日 　<br/>
 * <p>
 * 分页实体
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年5月8日 <br/>
 * 
 */
public interface Paginable {


		/**
		 * 总记录数
		 * 
		 * @return
		 */
		public int getTotalCount();

		/**
		 * 总页数
		 * 
		 * @return
		 */
		public int getTotalPage();

		/**
		 * 每页记录数
		 * 
		 * @return
		 */
		public int getPageSize();

		/**
		 * 当前页号
		 * 
		 * @return
		 */
		public int getPageNo();

		/**
		 * 是否第一页
		 *
		 * @return
		 */
		public boolean isFirstPage();

		/**
		 * 是否最后一页
		 * 
		 * @return
		 */
		public boolean isLastPage();

		/**
		 * 返回下页的页号
		 */
		public int getNextPage();

		/**
		 * 返回上页的页号
		 */
		public int getPrePage();
	}
