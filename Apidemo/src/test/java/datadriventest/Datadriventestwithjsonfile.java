package datadriventest;

import java.io.IOException;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import org.testng.reporters.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Datadriventestwithjsonfile {
	@Test
	public void postmethod() {
	//provide json file path 
		String jsonFilePath="C:\\Users\\USER\\Downloads\\testdata1.json";
		//reading the data from json file 
				String jsonData= "";


				/*try {
					jsonData=new String(Files.readAllBytes(Paths.get(jsonFilePath)));

				}

				catch (IOException e){
					// TODO: handle exception
					e.printStackTrace();
				}*/
						
		//To provide file your  details 
		String name="morpheus";
		String job="leader";
		jsonData=jsonData.replace("{{name}}",name);
		jsonData=jsonData.replace("{{job}}",job);
		//To send the request and capture the response
		
		Response response =RestAssured.given()
				.contentType(ContentType.JSON)
				.body(jsonData)
				.when()
				 .post("https://reqres.in/api/users")
		        .then()
		         .extract().response();
		        
		
		//print the  response and status code 
		String responsebody= response.getBody().asString();
		int statuscode= response.getStatusCode();
		System.out.println("response body" + responsebody);
		System.out.println("status code" + statuscode);
		
		
		
		
		
		//"C:\Users\USER\Downloads\testdata1.json"
		
		/*"";


		try {
			jsonData=new String(Files.readAllBytes(Paths.get(jsonFilePath)));

		}

		catch (IOException e){
			// TODO: handle exception
			e.printStackTrace();
		}*/

		//.post("https://reqres.in/api/users");
		
		
	}
	

}
