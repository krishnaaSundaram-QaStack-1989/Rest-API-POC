package userManagement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class testNG_1 {
	@Test
	public void getUserData() {
		given(). 
		when().
		get("https://reqres.in/api/users?page=2").
		then().
		assertThat(). 
		statusCode(200);	
	}
	
	@DataProvider(name = "testdata")
	public Object[][] testData() {
	return new Object[][] {
	{"1", "John"},
	{"2", "Jane"},
	{"3", "Bob"}
	};
	}
	
	@Test(dataProvider = "testdata")
	@Parameters({"id", "name"})
	public void testEndpoint(String id, String name) {
		given()
		.queryParam("id", id)
		.queryParam("name", name)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.statusCode(200);
		}
	}

