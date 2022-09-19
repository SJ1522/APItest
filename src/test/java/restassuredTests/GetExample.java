package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetExample {

	@Test
	public void Getpost() {
		given().
		   accept("application.JSON").
		   get("https://reqres.in/api/users?page=2").
		 then().
		    statusCode(200).
		    body("data.id[2]",equalTo(9)).
		    body("data.first_name",hasItems("Michael","Lindsay")).
		    body("data.last_name",hasItems("Lawson","Ferguson"));
		
	}
}
