/**
 * Handling Headers in Rest Assured
 */
package userManagement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class handleHeaders {

	@BeforeClass
	public void setup() {
	RestAssured.baseURI = "https://reqres.in";
	}

	@Test(description = "single header")
	public void handlingSingleheader() {
		given()
				.header("Content-Type", "application/json")
				.when()
				.get("/api/users?page=2")
				.then()
				.statusCode(200);
		System.out.println("handlingheaders executed and passed");
}
	
	@Test(description = "multiple headers")
	public void handlingMultipleheaders() {
		given()
		.header("Authorization", "bearer ywtefdu13tx4fdub1t3ygdxuy3gnx1iuwdheni1u3y4gfuy1t3bx")
				.header("Content-Type", "application/json")
				.when()
				.get("/api/users?page=2")
				.then()
				.statusCode(200);
		
		System.out.println("multiple headers executed and passed");
}
	
}