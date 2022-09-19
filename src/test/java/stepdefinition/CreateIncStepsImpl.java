package stepdefinition;
import java.io.File;

import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncStepsImpl {

	RequestSpecification req;
	Response resp;
	
	@Given("Endpoint must be declared")
	public void setEndpoint() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
	}
	
	@And("Authentication must be provided")
	public void setAuthentication() {
		RestAssured.authentication=RestAssured.basic("admin","W++3tkE9KphX");
	}
	
	@And("Add header details")
	public void setContentType() {
		req=RestAssured.given().log().all();
		req.contentType(ContentType.JSON);
		req.accept(ContentType.JSON);
	}
 
	@And("query parameter must be defined")
	public void setQueryParam() {
		req.queryParam("sysparm_fields","number,short_description,sys_id,Category");
	}
	
	@When("Send the request post as a file {string} in the body")
	public void postreqbody(String fileName) {
		File crefile = new File("./data/"+fileName+".json");
		req.body(crefile);
	}
	
	@When("Send the request post for creating the incident")
	public void sendRequest() {
		resp=req.when().post();
		resp.then().log().all();
	}
	
	@Then("get the status code")  
	public void getStatusCode() {
		int statcode=resp.getStatusCode();
	}
	
	@And("validate the statuscode")
	public void validateResponse() {
		resp.then().assertThat().statusCode(201);			
	}
	
	@And("validate the response contains the number with approporiate value")
	public void validateNumber() {
		 resp.then().assertThat().body("result.number",Matchers.containsString("INC"));
	}
}
