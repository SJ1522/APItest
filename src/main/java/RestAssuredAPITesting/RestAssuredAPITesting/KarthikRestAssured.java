package RestAssuredAPITesting.RestAssuredAPITesting;


	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;

	import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	public class KarthikRestAssured {
	    @BeforeClass
	    public static void setup() {
	        RestAssured.baseURI = "https://reqres.in";
	    }

	    @Test
	    public void getRequest() {
	        Response response = given()
	        		.relaxedHTTPSValidation("TLSv1.2")
	                .contentType(ContentType.JSON)
	                .when()
	                .get("/api/users/2")
	                .then()
	                .extract().response();

	        Assert.assertEquals(200, response.statusCode());
	    }
	}
