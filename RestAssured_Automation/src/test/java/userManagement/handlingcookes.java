/**
 * handling cookies   
 This test is used when we have a requirement for cookies 
 As of now this below test will fail as its a test cookie 
 using build method from cookie class of rest assured we're doing it
 single and multiple cookies can be sent 
 */
package userManagement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
//use * when error is faced in this module level - Error Handling
import static io.restassured.http.Cookie.*; 

public class handlingCookies {
	//key and value pair is passed inside builder() 
	Cookie cookies =  new Cookie.Builder("cookie1", "cookies1")
    //pass the cookie name here . To know whats being passed we do this
	.setComment("using cookie Key")
	.build();
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}

	  @Test(description = "cookie passing") public void useCookies_way1() { 
		  given()
	  // multiple cookies can be sent 
	  .cookies("cookie 1", "cookies 1") // cookie key and value pair is sent here .cookies("cookie 2", "cookies 2") // cookie
	  .cookies("cookie 3", "cookies 3")  
	  .cookies("cookie 4", "cookies 4") 
	  .when() .get("/api/users?page=2") 
	  .then()
	  .statusCode(200) .body("response", equalTo("expected response"));
	  System.out.println("useCookies passed execution"); }
	 
	
	@Test(description = "cookie with builder method")
	public void useCookies_way2() {
	given()
	.cookie(cookies) // cookie key and value pair is sent here
	.when()
	.get("/api/users?page=2")
	.then()
	.statusCode(200)
	.body("response", equalTo("expected response"));
	System.out.println("useCookies passed execution");
	}
}
