package restassuredRequests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class newmethod {
	// To set base URI or end point before all test execution
	@BeforeClass
	public void setup  () {
		RestAssured.baseURI	="https://reqres.in/api";
	}
	@Test
	public void createNewResource() 
	{
	
		//To initiate the pay-load
		String requestBody=" {\r\n"
				+ "	    \"name\": \"morpheus\",\r\n"
				+ "	    \"job\": \"zion resident\" ";
		//To provide the information about payload type and header
		RequestSpecification API=RestAssured.given();
		API.header ("contentType","application/json");
		API.body(requestBody);
		//To send the request  to the browser and capture the response
		
		
		
		
		
		
		
		
		
		
		/* START 
		//https://reqres.in/api/users/2
		/*{
	    "name": "morpheus",
	    "job": "zion resident"
	}*/
		package datadriventest;

		import org.testng.annotations.Test;

		import io.restassured.RestAssured;
		import io.restassured.http.ContentType;
		import io.restassured.response.Response;

		public class Datadriventestwithjsonfile {
			@Test
			public void postmethod() {
			//provide json file path 
				String jsonFilePath="file path address";
				//reading the data from json file 
						String jsonData= "";
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
						 .post("we will provide metho URI")
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
				
				*/END
				
			}
			

		}
	
		
		
		
		
}
}