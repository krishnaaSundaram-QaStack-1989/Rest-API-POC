package userManagement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class basicAuthentication {
	
	@Test(description =  "basic authentication")
	public void auth() {
	Response response = given()
			.relaxedHTTPSValidation()
			.auth()
			// . // un-comment this to see more auth methods
			.basic("postman", "password")
			.when()
			.get("https://postman-echo.com/basic-auth");
	
	int actualStatuscode = response.statusCode();
	assertEquals(actualStatuscode,200);
	System.out.println(response.body().asString()); // printing body of response
	}
	
}

