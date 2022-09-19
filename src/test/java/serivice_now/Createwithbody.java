package serivice_now;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Createwithbody {

	@Test
	public void PostInc() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "W++3tkE9KphX");
		File jsonfile = new File("./data/TC01_Create_incident");
		RequestSpecification req = RestAssured
				.given()
				//send req in JSON format
				.contentType(ContentType.JSON)
				.queryParam("sysparm_fields","number,short_description,priority,category,"
						+ "sys_id,opened_at,closed_at")
				//accept the response in JSON format
				.accept(ContentType.JSON)
				.body(jsonfile);
		Response response = req.post();
		String stlin=response.statusLine();
		System.out.println("Response of status line is "+stlin);
		response.prettyPrint();
		String sys_id=response.jsonPath().get("result.sys_id");
		System.out.println("Sys_id is "+sys_id);
		
	}
	
}