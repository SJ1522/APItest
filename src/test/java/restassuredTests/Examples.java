package restassuredTests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class Examples {

	//Get example 
	/*public void test_get() {
		baseURI = "http://localhost:3000";
	    given().
	        param("name","API").
	        get("/subjects").
	    then().
	        statusCode(200).
	        log().all();
	
	}*/

	//post example
/*//@Test
public void test_post(){
	
	JSONObject jsreq = new JSONObject();
	jsreq.put("firstName", "Latha");
	jsreq.put("LastName","Viswanathan");
	jsreq.put("subjectId",1);
	
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
*/

   //patch example
/*@Test
public void test_patch() {
	JSONObject jsreqp = new JSONObject();
	jsreqp.put("firstName","Karthik");
	
	baseURI ="http://localhost:3000";
	
	given().
	    contentType(ContentType.JSON).
	    accept("ContentType.JSON").
	    header("Content-Type","application/json").
	    body(jsreqp.toJSONString()).
	when().
	    patch("/users/7").
	then().
	    statusCode(200).
	    log().all();
	   
}*/
	//Put example
//@Test
public void test_put() {
	
	JSONObject jsreqp = new JSONObject();
	jsreqp.put("firstName","Visawanathan");
	jsreqp.put("LastName","Sambandam");
	jsreqp.put("subjectId",1);
	
	
	baseURI ="http://localhost:3000";
	
	given().
	    contentType(ContentType.JSON).
	    accept("ContentType.JSON").
	    header("Content-Type","application/json").
	    body(jsreqp.toJSONString()).
	when().
	    put("/users/3").
	then().
	    statusCode(200).
	    log().all();
	   
}

@Test
public void test_delete() {
	
	baseURI ="http://localhost:3000";
	
	when().
	   delete("/users/6").
	 then().
	    statusCode(200).
	    log().all();
	    
}
}
