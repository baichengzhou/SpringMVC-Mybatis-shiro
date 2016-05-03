package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.elasticsearch.client.Requests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sojson.bang.service.BangService;
import com.sojson.common.model.SOBang;
import com.sojson.core.elasticsearch.manager.InsertManager;
import com.sojson.core.elasticsearch.manager.MappingManager;
import com.sojson.core.elasticsearch.utils.ESTools;
import com.sojson.core.mybatis.page.Pagination;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class ElasticsearchAPITest{

	public static final Map<String,Object> resultMap = new HashMap<String,Object>();
	
	public static Integer pageSize=100,pageNo=1;
	@Autowired
	BangService bangService;
	
	@Test
	public void insertTest(){
		
		try {
			for (int i = 1; i < 100; i++) {
				List<SOBang> list = bangService.findByList(resultMap, pageSize, i);
				InsertManager.save(MappingManager.INDEX, MappingManager.TYPE, "id",list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void insertmapping(){
		
	}
	//@Before
	public void insertIndex(){
		

	}
	public static void main(String[] args) {
//		BulkRequestBuilder bulkRequest =   ESTools.client.prepareBulk();
//		IndexRequestBuilder irb = ESTools.client.prepareIndex("zhidao_index","zhidao_type");
//		irb.setSource(new HashMap<String, Object>());
//		bulkRequest.add(irb);//装箱
//		BulkResponse bulkResponse = bulkRequest.execute().actionGet();//执行
//		
//		JSONObject json = JSONObject.fromObject(bulkResponse);
//		System.out.println(json.toString());
//		MappingManager.createBangMapping();
		
//		CreateIndexRequest request = new CreateIndexRequest("zhidao_index");
//		ESTools.client.admin().indices().create(request);
		ESTools.client.admin().indices().create(Requests.createIndexRequest("zhidao_index")).actionGet();
		MappingManager.createBangMapping();
		MappingManager.createBanggMapping();
	}
}
