package userManagement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class digestAuthentication {
	
	@Test(description =  "digest authentication")
	public void auth() {
	Response response = given()
			.relaxedHTTPSValidation() // This is not in the course added to handle error
			.auth()
			.digest("postman", "password")
			.when()
			.get("https://postman-echo.com/basic-auth");
	
	int actualStatuscode = response.statusCode();
	assertEquals(actualStatuscode,200);
	System.out.println(response.body().asString()); // printing body of response
	}	
}

