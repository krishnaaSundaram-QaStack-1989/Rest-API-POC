/**
 * fetch headers using header class from response
 */
package userManagement;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.Map;
public class handleMultipleHeadersUsingMap {

	@BeforeClass
	public void setup() {
	RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test(description = "fetch headers using header class from response")
	public void testTwoHeadersusingMap() {		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Bearer ywtefdu13tx4fdub1t3ygdxuy3gnx1iuwdheni1u3y4gfuy1t3bx");
		// Send a get request
		given()
		.headers(headers)
		.when()
		.get("/api/users?page=2")
		.then()
		.statusCode(200);
		System.out.println("multiple headers using map executed and passed");
	}
}