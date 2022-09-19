package restassuredTests;

import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutExample {
  
	@Test
	public void putEx() {
		LinkedHashMap<String,Object> lh = new LinkedHashMap<String,Object>();
		
		lh.put("Saranya","Daughter");
		lh.put("Dhivya","Daughter-in-law");
		lh.put("Manjula","Wife");
		lh.put("Latha","Mother");
		JSONObject js = new JSONObject(lh);
		System.out.println("json is " +js.toJSONString());
		
	}
}
