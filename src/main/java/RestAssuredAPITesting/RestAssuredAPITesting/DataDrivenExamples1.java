package RestAssuredAPITesting.RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DataDrivenExamples1 extends DataforTests
{
	
	//@Test(dataProvider="fetchdata")
	public void test_post(String fn,String ln, int subID){
		
		JSONObject jsreq = new JSONObject();
		jsreq.put("firstName", fn);
		jsreq.put("LastName",ln);
		jsreq.put("subjectId",subID);
		
		baseURI = "http://localhost:3000";
		  given().
		  	accept("contentType.JSON").
		  	header("Content-Type","application/json").
		  	body(jsreq.toJSONString()).
		  when().
		     post("/users").
	      then().
	        statusCode(201).
	        log().all();    
	    }  
	
	
	
	//@Test(dataProvider="deleteData")
	public void test_delete(int userid) {
		
		baseURI ="http://localhost:3000";
		
		when().
		   delete("/users/"+userid).
		 then().
		    statusCode(200).
		    log().all();
	}
	
	@Parameters({"userid"})
	@Test
	public void test_delete2(int userid) {
		baseURI ="http://localhost:3000";
		
		when().
		   delete("/users/"+userid).
		 then().
		    statusCode(200).
		    log().all();
	
	}
}
