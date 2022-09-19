package serivice_now;

import java.util.HashMap;
import java.util.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidents {

	@Test
	public void getAllIncidents() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "W++3tkE9KphX");
		
		HashMap<String,String> hmquery = new HashMap<String,String>();
		hmquery.put("sysparm_fields","short_description,description,number,category");
		hmquery.put("category","software");
		
		RequestSpecification req=RestAssured
				.given()
				.queryParams(hmquery)
				.accept(ContentType.JSON);
	    Response response = req.get();
		int status =response.getStatusCode();
		System.out.println("Status code "+status);
		response.prettyPrint();
		String stline=response.getStatusLine();
		System.out.println("Status Line " +stline);
		
		List<String> sysid=response.jsonPath().getList("result.sys_id");
		System.out.println("Sys id "+sysid.size());
				                 
	}
	
}
