/**
 * Adding 2 values and verifyiapplication/x-www-form-urlencoded; charset=utf-8ng response code is 201
 * Asserting added values are present
 * Printing the added values 
 */
package userManagement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FormParamsTest {

@BeforeClass
public void setup() {
RestAssured.baseURI = "https://reqres.in";
}

  @Test public void testCreateUserWithFormParam() 
  { 
	  
  Response response = given()
  .contentType("application/x-www-form-urlencoded; charset=utf-8") 
  .formParam("name","morpheus") 
  .formParam("job", "leader") 
  .when() .post("/api/users")
  .then().statusCode(201)
  .extract()
  .response();
  
  // Verify added information in the response body
  response.then().assertThat().body("name", equalTo("morpheus"));
  response.then().assertThat().body("job", equalTo("leader"));
  System.out.println(response.body().asString());
  }  
}

