package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example_GET_Request {

	@Test
	public void test01() {
		
		//System.setProperty("jsse.enableSNIExtension", "false");
		
		System.out.println("Befre calling Rest assured");
		Response resp = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println("After calling rest api from internet public domain");
		//Response resp = get("https://mail.google.com");
		//	System.out.println("Response is "+resp.asString());
		//	System.out.println("Response of the body is "+resp.getBody().asString());
			System.out.println(resp.getStatusCode());
			System.out.println(resp.getStatusLine());
			System.out.println(resp.getHeader("Content-Type"));
			System.out.println(resp.getTime());
			
			int stcode = resp.getStatusCode();
			Assert.assertEquals(stcode,200);
	}
	
	/*@Test
	public void test02() {
			given().
			    get("https://mail.google.com").
			   then().
			     statusCode(200);
			*/
			
		/*//Specify base URI 
		RestAssured.baseURI="https://api.coindesk.com/v1/bpi/currentprice.json";
		
		//Specify req obj 
		RequestSpecification req = RestAssured.given();
		
		//response obj
		Response response = req.request(Method.GET,"?page=2");
		
		System.out.println("Response of the API " +response.getBody().asString() );
		
		//status code validation starts
		int statuscode = response.getStatusCode();
		System.out.println("Status code "+statuscode);
		Assert.assertEquals(statuscode,200);
		
		String statline = response.getStatusLine();
		System.out.println("Status Line "+statline);
		Assert.assertEquals(statline,"HTTP/1.1 200 OK");
		
		System.out.println("Response header is "+response.getHeader("Content-type"));
		System.out.println("Response time is " + response.getTime());
		*/
}
