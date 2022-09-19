package serivice_now;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearningHeaders {

	@Test
	public void learnHeaders() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
		//Declare array list to get all headers
		List<Header> hdlist = new ArrayList<Header>();

		hdlist.add(new Header("Authorization","Basic YWRtaW46VysrM3RrRTlLcGhY"));
		hdlist.add(new Header("ContentType","ContentType.JSON"));
		hdlist.add(new Header("accept","ContentType.JSON"));
		
		//Use the hdlist object to header class
		Headers allhead = new Headers(hdlist);
		
       //use map to call parameters-query parameters
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("category","software");
		hm.put("sysparm_fields","number,short_description,sys_id,category");
		
		RequestSpecification req= RestAssured
				                .given()
				                .log().all()
				                .headers(allhead)
				                .contentType(ContentType.JSON)
				                .accept(ContentType.JSON)
								.queryParams(hm);
		Response resp = req.when().get();
		System.out.println("Status line "+resp.statusLine()	);
		List<String> sysid=resp.jsonPath().getList("result.sys_id");
		System.out.println("Total number of incidents "+sysid.size());
		resp.then().assertThat().statusCode(200);
		resp.prettyPrint();
		resp.then().assertThat().body("result[0].number",Matchers.containsString("INC"));
		resp.then().assertThat().body("result.number",Matchers.hasItem("INC0000012") );
		resp.then().assertThat().body("result[0].category",Matchers.equalTo("software"));
	}
}
