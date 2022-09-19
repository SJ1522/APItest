package serivice_now;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident {

	@Test
	public void deleteIncident() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "W++3tkE9KphX");
		RequestSpecification req = RestAssured
				.given()
				.log().all();
		Response deletresp= req.delete("61cdfa6d97e55110544771571153af03");
		System.out.println("Statusline "+deletresp.statusLine());
				
	}
}
