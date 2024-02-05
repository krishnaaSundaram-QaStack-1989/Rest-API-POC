package userManagement;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class deleteMethod {
	
	@Test(description =  "validate delete method status code 204 no content")
	public void auth() {
	Response response = given()
			.delete("https://reqres.in/api/users/2");
	
	assertEquals(response.getStatusCode(),204);
	System.out.println("delete operation passed");
	}	
}

