package serivice_now;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class CreateInc {

	public void PostInc() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "W++3tkE9KphX");
			
		RequestSpecification req = RestAssured
				.given()
				//send req in JSON format
				.contentType(ContentType.JSON)
				//.queryParam("sysparm_fields","number,short_description,priority,category,"
				//		+ "sys_id,opened_at,closed_at")
				//accept the response in JSON format
				.accept(ContentType.JSON)
				.body("{\r\n" + 
						"    \"category\": \"Hardware\",\r\n" + 
						"    \"short_description\": \"Hardware_issue\",\r\n" + 
						"    \"opened_at\": \"2022-08-23 13:48\",\r\n" + 
						"    \"closed_at\": \"2022-08-25 13:00\"\r\n" + 
						"}");
		Response response = req.post();
		String stlin=response.statusLine();
		System.out.println("Response of status line is "+stlin);
		response.prettyPrint();
		String sys_id=response.jsonPath().get("result.sys_id");
		System.out.println("Sys_id is "+sys_id);
		//generate the schema from post incident and place it in data folder
	    response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema
	    		(new File("./data/TC03_JSON_schema_validator")));
	}
	
	
	
}
