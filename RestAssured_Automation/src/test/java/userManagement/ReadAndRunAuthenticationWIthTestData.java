package userManagement;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.jsonReader;

import static io.restassured.RestAssured.given;

public class basicAuthenticationWithTestDataFile {
	
	@Test(description =  "basic authentication with test data file being read here")
	public void authWithTestData() throws Exception, IOException, org.json.simple.parser.ParseException {
	String uname = jsonReader.getTestData("username");
	String pwd = jsonReader.getTestData("password");
	System.out.println("username : " + uname + "| password : " + pwd); // pre-check if data is read properly
	Response response = given()
			.relaxedHTTPSValidation()
			.auth()
			// . // un-comment this to see more auth methods
			.basic(uname, pwd)
			.when()
			.get("https://postman-echo.com/basic-auth");
	
	int actualStatuscode = response.statusCode();
	assertEquals(actualStatuscode,200);
	System.out.println("authWithTestData passed "); // printing body of response
	}
	
}
