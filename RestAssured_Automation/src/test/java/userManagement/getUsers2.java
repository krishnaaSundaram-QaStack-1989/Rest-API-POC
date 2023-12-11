package userManagement;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class getUsers2 {
	@Test(enabled = false)
	public void getUserData() {
		given(). 
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat(). 
		statusCode(200);	
	}
	@Test(enabled = false)
	public void validateGetResponseBody() {
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
		given()
        .when()
        .get("/todos/1")
        .then()
        .assertThat()
        .statusCode(200) // Best practices 1
        .body(not(emptyString())) // Best practices 2 
        .body("Title", equalTo("xxx"))
        .body("userId", equalTo(1));	
		// Note status code > Body isn't empty then assert the values of Body		
		//eg hamcrest matchers - asserttrue(response.getbody().asstring.contains('some string')
		// containsString, equalto, hasitems, hasSize
	}
	
	@Test
	public void validateResponseHasItems() {
		// base URI setup
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
		
		//Send get request and store response in a variable
		Response response = given()
				.when()
				.get("/posts")
				.then()
				.extract()
				.response();
		
		  List<String> titlesList = response.jsonPath().getList("title");
		  // only 1st 2 titles are asserted and not entire list of titles
		  List<String> firstTwoTitles = titlesList.subList(0, Math.min(2, titlesList.size()));
//		  assertThat(titlesList, contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "qui est esse" )); // soft assertion
		  assertThat(firstTwoTitles, containsInAnyOrder("qui est esse","sunt aut facere repellat provident occaecati excepturi optio reprehenderit" )); // soft assertion
		  
		  
        }
	
}

