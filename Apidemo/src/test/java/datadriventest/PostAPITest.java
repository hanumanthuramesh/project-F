package datadriventest;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAPITest {
	@Test
	public void testPostAPI() throws IOException{
		// provide the path to your json file
		String jsonFilePath="C:\\Users\\USER\\Downloads\\testing files\\testdata1.json\\";
		
		JSONObject requestData=readJsonFile(jsonFilePath);
		//specified API end point or Base uri 
				String endpoint="https://reqres.in/api/users";
		
		//to send API request and capture the request 
		
		Response response = RestAssured.given()
				
			.contentType(ContentType.JSON)
			.body(requestData.toString())
			.post(endpoint);
			// validate response code 
		
		response.then().statusCode(201);
		String responseBody=response.getBody().asString();
	System.out.println("responseis "+ responseBody );
	Assert.assertEquals("Vijaya",response.jsonPath().getString("name"));
	Assert.assertEquals("Tester",response.jsonPath().getString("job"));	
	}
	private JSONObject readJsonFile(String filePath)throws IOException{
		
		FileReader fileReader =new 	FileReader(filePath);
		
		JSONObject jsonObject=new JSONObject();
		fileReader.close();
		return jsonObject;
		
		
		
	}
}
	
	
	
	


