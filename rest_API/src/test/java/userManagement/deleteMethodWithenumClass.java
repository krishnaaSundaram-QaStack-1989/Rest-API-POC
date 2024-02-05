package userManagement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import core.statusCode;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class deleteMethodWithenumClass {
	
	@Test(description =  "delete method status code 204 no content using enum class")
	public void auth() {
	Response response = given()
			.delete("https://reqres.in/api/users/2");
	
	assertEquals(response.getStatusCode(),statusCode.NO_CONTENT.code);
	System.out.println("delete operation passed");
	}	
}

