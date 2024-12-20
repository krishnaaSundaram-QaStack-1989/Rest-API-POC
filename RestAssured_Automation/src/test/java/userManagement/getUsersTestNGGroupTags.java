package userManagement;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import java.util.List;

public class getUsersTestNGGroupTags {
	//These are same as tags we have in playwright automation
	@Test(groups = "smokeTests")
	public void validateResponseHasSize() {
	// Set base URI for the API
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	// Send a GET request and store the response in a variable
	Response response = given()
	.when()
	.get("/comments")
	.then()
	.extract()
	.response();
	// Use Hamcrest to check that the response body has a specific size
	assertThat(response.jsonPath().getList(""), hasSize(500));
	}

	@Test(groups = {"smokeTests", "regressionTests"})
	public void validateListContainsInOrder() {
	// Set base URI for the API
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	// Send a GET request and store the response in a variable
	Response response = given()
	.when()
	.get("/comments?postId=1")
	.then()
	.extract()
	.response();
	// Use Hamcrest to check that the response body contains specific items in a specific order
	List<String> expectedEmails = Arrays.asList("Eliseo@gardner.biz",
	"Jayne_Kuhic@sydney.com",
	"Nikita@garfield.biz","Lew@alysha.tv","Hayden@althea.biz");
	List<String> mailList = response.jsonPath().getList("email");
	assertThat(mailList, contains(expectedEmails.toArray(new String[0])));
	}
	
	// specific assertion of the response body
	@Test(groups = {"smoketests", "regTests"}) // 2 tags grouping done 
	//to run them  for both smoke and regression test runs
	public void testGetUsersWithQueryParameters() {
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
	
	// Assert that the response contains 6 users
	response.then().body("data", hasSize(6));
	
	// Assert that the first user in the list has the correct values
	response.then().body("data[0].id", is(7));
	response.then().body("data[0].email", is("michael.lawson@reqres.in"));
	response.then().body("data[0].first_name", is("Michael"));
	response.then().body("data[0].last_name", is("Lawson"));
	response.then().body("data[0].avatar",is("https://reqres.in/img/faces/7-image.jpg"));
	}
}

