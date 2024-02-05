package userManagement;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
public class queryPathFormParams {

	@Test(description = "single query params")
	public void validateStatusCodeGetUser() {
	
	Response resp = 
			given()
			.queryParam("page", 2)
			.when()
			.get("https://reqres.in/api/users");
	int actualStatusCode = resp.statusCode(); 
	
	assertEquals(actualStatusCode, 200); 
}
	@Test(description = "multiple query params")
	public void multipleQueryParams() {
		
	Response resp = 
			given()
			.queryParam("page", 2)
			.queryParam("per_page", 3)
			.when()
			.get("https://reqres.in/api/users");
	int actualStatusCode = resp.statusCode(); 
	
	assertEquals(actualStatusCode, 200); 
	}
	// Query param is optionnal for filterr
	// path param is mandatory for request success . See examples if needed
	
	@Test(description = "Validate the Path Params")
	public void validateResponseBodyGetPathParam() {
		String raceSeasonValue = "2017";
		Response resp = given().pathParam("raceSeason", raceSeasonValue)
		.when()
		.get("http://ergast.com/api/f1/{raceSeason}/circuits.json");
		//RestAssured
		int actualStatusCode = resp.statusCode(); //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println(resp.body().asString());
		}	
}