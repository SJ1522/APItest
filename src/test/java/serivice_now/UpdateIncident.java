package serivice_now;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {

	@Test
	public void updateIncident() {
	RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
	RestAssured.authentication = RestAssured.basic("admin", "W++3tkE9KphX");
	File jsonfile = new File("./data/TC02_Update_incident");
	RequestSpecification req = RestAssured
			.given()
			.log().all()
			//send req in JSON format
			.contentType(ContentType.JSON)
			.queryParam("sysparm_fields","number,short_description,priority,category,"
					+ "sys_id,opened_at,closed_at")
			//accept the response in JSON format
			.accept(ContentType.JSON)
			.body(jsonfile);
	Response response = req.patch("fe817da597e15110544771571153af1f");
	int stcode=response.statusCode();
	System.out.println("Response of status code is "+stcode);
	String stline=response.statusLine();
	System.out.println("Response of status code is "+stline);
	response.prettyPrint();
	String sys_id=response.jsonPath().get("result.sys_id");
	System.out.println("Sys_id is "+sys_id);
}
}
