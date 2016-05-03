package test;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;



public class ITest{//.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar;

	@Test
	public  void main()  {
		String oldJson = "{\"a1\":\"1\",\"a2\":\"2\",\"list\":[{\"a8\":\"8\"},{\"a9\":\"9\"}]}";
		JSONObject oldJSONObject = JSONObject.fromObject(oldJson);
		JSONArray list = (JSONArray) oldJSONObject.get("list");
		for (Object object : list) {
			JSONObject jsonObject = ((JSONObject)object);
			if(null != jsonObject.opt("a8")){
				jsonObject.put("a8", "new A8");
			}
			
		}
		System.out.println(oldJSONObject.toString());
	}
	@Test
	public void wdw() {
		System.out.println(1);

	}
}
