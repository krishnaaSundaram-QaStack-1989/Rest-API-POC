package userManagement;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class getUsers {
	@Test
	public void getUserData() {
		given(). 
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat(). 
		statusCode(200);	
	}

}
