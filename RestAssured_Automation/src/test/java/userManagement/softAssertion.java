package userManagement;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import core.statusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.softAssertionUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import java.util.List;

public class softAssertion {

	softAssertionUtils sa = new softAssertionUtils();	
/*	
 * few examplesof hard assertion given below
 * assertEquals(actualcode, 200);
 * response.then().body("data[0].id", is(7));
 * 
 * public void testGetUsersWithQueryParameters() {
	// Assert that the first user in the list has the correct values
	response.then().body("data[0].id", is(7));
	response.then().body("data[0].email", is("michael.lawson@reqres.in"));
	response.then().body("data[0].first_name", is("Michael"));
	response.then().body("data[0].last_name", is("Lawson"));
	response.then().body("data[0].avatar",is("https://reqres.in/img/faces/7-image.jpg"));
	}
	*/
	// If we dont use softassert.assertall() method then we'll always get pass everytime
	// this willbe misleading for us 
	// multiple assertions are to be done then we use soft assertion
	// else hard assert we can use 
	// To Do - Create and move this to utility class
	
	@Test (description = "Without utility class we're doing this")
	public void softAssert() {
		SoftAssert sa = new SoftAssert();
		System.out.println("soft assert");
		sa.assertTrue(false);
		sa.assertTrue(true);
		sa.assertAll();
	}
	
	@Test (description = "1 - using soft assertion utility class")
	public void softAssertions() {
		softAssertionUtils sa = new softAssertionUtils();
		System.out.println("soft assert with utility class");
		sa.assertTrue(true, "Test Message");
		sa.assertAll();
	}
	
	@Test (description = "2 - using soft assertion utility class")
	public void softAssertionsValidation() {
		System.out.println("soft assert with utility class");
		// Set base URI for the API
		RestAssured.baseURI = "https://reqres.in/api";
		
		Response response = given()
		.queryParam("page", 2)
		.when()
		.get("/users")
		.then()
		.statusCode(200)
		.extract()
		.response();
		
		response.then().body("data", hasSize(6));
		
		sa.assertEquals(response.getStatusCode(), statusCode.SUCCESS.code, "status code is not 200");
		sa.assertAll();
		System.out.println("softAssertionsValidation passed");
		
	}
	
	@Test (description = "3- using soft assertion utility class force failing for assertion check")
	public void softAssertionsValidationForceFailing() {
		System.out.println("soft assert with utility class");
		// Set base URI for the API
		RestAssured.baseURI = "https://reqres.in/api";
		
		Response response = given()
		.queryParam("page", 2)
		.when()
		.get("/users")
		.then()
		.statusCode(200)
		.extract()
		.response();
		
		response.then().body("data", hasSize(6));
		
		sa.assertEquals(response.getStatusCode(), statusCode.NO_CONTENT.code, "status code is not 200");
		sa.assertAll(); // mandatory else test results will show as passed
		System.out.println("softAssertionsValidationForceFailing passed");
		
	}
	
	
	
}

