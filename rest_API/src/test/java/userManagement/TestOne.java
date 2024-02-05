package userManagement;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
//Static imports - https://github.com/rest-assured/rest-assured/wiki/Usage#static-imports 
// dynamic calling of dependencies 
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;
import io.restassured.matcher.ResponseAwareMatcher;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOne {
	@Test
	public void test_1() {
		Response response  = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_2() {
		// baseURI comes from rest assured class
		baseURI = "https://reqres.in/api";
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		// use json path finder to hit the exact data in json response of API or Chrome plugin is also there
		.body("data[1].id", equalTo(8)); // at index 1 of data we have the required as below 
		/*
		 * {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
		 * */
		
	}
	
	@Test
	public void test_3() {
		// baseURI comes from rest assured class
		baseURI = "https://reqres.in/api";
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		// use json path finder to hit the exact data in json response of API or Chrome plugin is also there
		.body("data[1].id", equalTo(8)); // at index 1 of data we have the required as below 
		/*
		 * {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
		 * */		
	}
}




