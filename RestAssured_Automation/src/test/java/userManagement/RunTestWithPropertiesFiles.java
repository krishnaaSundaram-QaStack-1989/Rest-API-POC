package userManagement;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.propertyReader;

import static io.restassured.RestAssured.given;

public class RunTestWithPropertiesFiles {
	
	@Test
	public void readServerAddressFromPropertyfile() {
		String serverAddress = propertyReader.propertyReader("config.properties", "server");
		
		System.out.println("server address is : " + serverAddress);
	
	Response response = given()
	.queryParam("page", 2)
	.when()
	.get(serverAddress + "/users") // property file method  + server address from property file 
	//is the main concept we're learning in this test script 
	
	.then()
	.statusCode(200)
	.extract()
	.response();
	
	response.then().body("data[0].email", is("michael.lawson@reqres.in"));
	response.then().body("data[0].first_name", is("Michael"));
	response.then().body("data[0].last_name", is("Lawson"));
	response.then().body("data[0].avatar",is("https://reqres.in/img/faces/7-image.jpg"));
	
	System.out.println(" script executed successfully " + serverAddress);
	
	}
}

