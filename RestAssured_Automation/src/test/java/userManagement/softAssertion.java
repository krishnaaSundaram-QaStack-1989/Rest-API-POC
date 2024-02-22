package userManagement;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import java.util.List;

public class softAssertion {
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
	@Test
	public void softAssert() {
		SoftAssert sa = new SoftAssert();
		System.out.println("soft assert");
		sa.assertTrue(false);
		sa.assertTrue(true);
		sa.assertAll();
	}
}
