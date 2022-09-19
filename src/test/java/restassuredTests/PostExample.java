package restassuredTests;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class PostExample {

	@Test
	public void expost() {
		/*HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("Saranya","L&T Infotech");
		hm.put("Karthik", "Oracle");
		System.out.println("Map without JSON " +hm);
		
		JSONObject request = new JSONObject(hm);
		System.out.println("JSONObject map" +request);
		*/
		JSONObject req = new JSONObject();
		req.put("Karthik", "Principle Engineer");
		req.put("Saranya", "Specialist");
		System.out.println("JSONcreation "+req.toJSONString());
		
		given().
		    body(req.toJSONString()).
		when().
		    post("https://reqres.in/api/users").	
		 then().
		    statusCode(201);
		  
		
	}
}
