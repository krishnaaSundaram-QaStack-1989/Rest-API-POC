package userManagement;
import org.testng.annotations.Test;

import bsh.ParseException;
import utils.jsonReader;

import static io.restassured.RestAssured.given;

import java.io.IOException;
public class jsonArrayGetData {
	@Test (description = "we're reading an array object and its values using array method")
	public void getUserData() {
		given(). 
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat(). 
		statusCode(200);	
	}
	
	@Test (description = "we're reading an array object and its values using array method")
	public void getArrayData() throws ParseException, IOException, org.json.simple.parser.ParseException {
		jsonReader.getJsonArrayData("languages", 0);
		System.out.println("Json read data passed");
	}
	
}
