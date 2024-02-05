package userManagement;
import java.util.Map;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
//Static imports - https://github.com/rest-assured/rest-assured/wiki/Usage#static-imports 
// dynamic calling of dependencies 
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PATCH_PUT_Examples {
	
	@Test  // logging all responses
	public void GET() {
		baseURI = "https://reqres.in/api";
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name", hasItems("George", "Rachel"));
	}
	
	@Test  // logging all responses
	public void POST() {

		JSONObject request = new JSONObject();
		request.put("name", "krishna");
		request.put("Job", "QA");
		System.out.println("With json simple library : " + request);
			
		baseURI = "https://reqres.in/api";
		
		given()
		.header("content-type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
}




