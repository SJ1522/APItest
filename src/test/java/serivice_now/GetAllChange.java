package serivice_now;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllChange {

	@Test
	public void getAllLowPrioChange() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin","W++3tkE9KphX");
		HashMap<String,String> hmquery = new HashMap<String,String>();
		hmquery.put("sysparm_fields", "sys_id");
		hmquery.put("priority","4");
		RequestSpecification req= RestAssured
									.given()
									.queryParams(hmquery)
									.accept(ContentType.JSON);
		Response response =req.get();
		String stline=response.getStatusLine();
		System.out.println("Status Line is "+stline);
		response.prettyPrint();
		List<String> chcount = response.jsonPath().getList("result.sys_id");
		System.out.println("Number of change request "+chcount.size());
		
	}
}
