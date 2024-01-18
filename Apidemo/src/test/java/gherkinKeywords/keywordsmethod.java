package gherkinKeywords;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class keywordsmethod {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI= "https://reqres.in/api";
	}
	@Test
	public void createResource() {
		//To declare the payload/initiate the payload
		String requestBody= "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		// we provide information about payload data type,header fields information
		Response response= RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				// to send the request
				.when()
				 .post("/users")
				// to capture the response
				 .then()
				  .extract().response();
		// to print the response and status code
		  // to print the status code
		int statuscode = response.getStatusCode();
		System.out.println("Status code is"+statuscode);
		// to print the response
		String responseBody= response.getBody().asString();
		System.out.println("Response bOdy is"+responseBody);
		// validations/check points for response
		Assert.assertEquals(201,statuscode);
		Assert.assertEquals("morpheus",response.jsonPath().getString("name"));
		Assert.assertEquals("leader",response.jsonPath().getString("job"));
				
	}

}

