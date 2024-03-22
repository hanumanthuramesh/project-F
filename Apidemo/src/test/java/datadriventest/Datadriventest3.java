package datadriventest;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Datadriventest3 
{
	@Test
    public void testPostAPI() throws IOException, ParseException {
        // Provide the path to your JSON file
        String jsonFilePath = "C:\\Users\\USER\\Downloads\\testing files\\testdata1.json";

        Object requestData = readJsonFile(jsonFilePath);
        // Specified API endpoint or Base URI
        String endpoint = "https://reqres.in/api/users";

        // Send API request and capture the response
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestData.toString())
                .post(endpoint);

        // Validate response code
        response.then().statusCode(201);

        // Extract response body and perform assertions
        String responseBody = response.getBody().asString();
        System.out.println("Response is " + responseBody);
        // Assuming you are expecting both "morpheus" and "Vijaya"
Assert.assertTrue(response.jsonPath().getString("name").contains("morpheus"));
Assert.assertTrue(response.jsonPath().getString("name").contains("Vijaya"));

    }

    private Object readJsonFile(String filePath) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);

        Object obj = jsonParser.parse(fileReader);

        fileReader.close();

        return obj;
	
	
	    }	
}
