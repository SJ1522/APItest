package serivice_now;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.internal.reflect.MethodMatcher;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateChange {
	
	@Test
	public void postchange() {
		RestAssured.baseURI="https://dev99347.service-now.com/api/now/table/incident";
		List<Header> hl = new ArrayList<Header>();
		hl.add(new Header("Authorization","Basic YWRtaW46VysrM3RrRTlLcGhY"));
		hl.add(new Header("ContentType","ContentType.JSON"));
		hl.add(new Header("accept","application/JSON"));
		Headers allh =new Headers(hl);
		
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("sysparm_fields","short_description,number,sys_id,priority");
		hm.put("priority","1");
	
		
		RequestSpecification req=RestAssured
									.given()
									.log().all()
									.headers(allh)
									.queryParams(hm);
		Response res = req.when().get();
		res.prettyPrint();
		res.then().assertThat().statusCode(200);
		res.then().assertThat().body("result[1].priority",Matchers.equalTo("1") );
		
	}
	
}