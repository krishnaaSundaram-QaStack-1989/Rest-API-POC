// We're reading TestData And Property Files Together
package userManagement;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import bsh.ParseException;
import io.restassured.response.Response;
import utils.jsonReader;
import utils.propertyReader;

import static io.restassured.RestAssured.given;
// Best practice to run a API call main API call and specific endpoint in another file 
public class readTestDataAndPropertyFilesTogetherr {
	
	@Test
	public void readServerAddressFromPropertyfile() throws ParseException, IOException, org.json.simple.parser.ParseException {
		String serverEndpoint = propertyReader.propertyReader("config.properties", "serverAddress");
		String endpoint = jsonReader.getTestData("endpoint");
		String URL = serverEndpoint + endpoint;
		System.out.println("server address is : " + URL);
	
	Response response = given()
	.queryParam("page", 2)
	.when()
	.get(URL) // property file method  + server address from property file 
	//is the main concept we're learning in this test script 
	
	.then()
	.statusCode(200)
	.extract()
	.response();
	
	response.then().body("data[0].email", is("michael.lawson@reqres.in"));
	response.then().body("data[0].first_name", is("Michael"));
	response.then().body("data[0].last_name", is("Lawson"));
	response.then().body("data[0].avatar",is("https://reqres.in/img/faces/7-image.jpg"));
	System.out.println(" script executed successfully " + URL);
	}
}

