package restassuredRequests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiMethods {
@BeforeClass	
	//To declare the base uri 
	public void setup() {
		RestAssured.baseURI ="https://reqres.in/api";
	}
	@Test
	public void createNewResource() {
		//To initiate the pay-load
		String requestBody= "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"tester\"\r\n"
				+ "}";
		//To provide the information about payload type and header
		RequestSpecification request=RestAssured.given();
		 request.header("contentType","application/json");
		 request.body(requestBody);
		 //To send the request and capture the response
		 Response response=request.put("/users/2");
		 
		 // To print the response(to convert json to string) and status code
		String responseBody=response.getBody().asString();
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+statuscode);
		System.out.println("Response is"+responseBody);
		Assert.assertEquals(201,statuscode);
		
	}
	@Test
	public void getResource() {
		//To provide information header 
		RequestSpecification Ramesh=RestAssured.given();
		Ramesh.header("contentType","application/json");
		//To send the request to browser  and capture the response
		Response response=Ramesh.get("/unknown/2");
		// To print the response(to convert json to string) and status code
		String responseBody=response.getBody().asString();
		int statuscode=response.getStatusCode();
		System.out.println("status code is"+statuscode);
		System.out.println("Response is"+responseBody);
		
	}

}





