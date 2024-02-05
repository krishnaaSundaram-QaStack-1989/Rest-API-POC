package userManagement;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType; 
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;

public class PUT_PATCH_Examples {
	@Test  
	public void PUT1() {
		JSONObject request = new JSONObject();
		request.put("name", "krishna");
		request.put("Job", "QA");
		System.out.println(request.toJSONString());
			
		baseURI = "https://reqres.in/api";
		 
		given()
		.header("content-type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/2")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test  
	public void PUT() {
		JSONObject request = new JSONObject();
		request.put("name", "krishna");
		request.put("Job", "QA");
		System.out.println(request.toJSONString());		
		baseURI = "https://reqres.in/api";
		 
		given()
		.header("content-type", "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/2")
		.then()
		.statusCode(200)
		.log().all();
	}
}






