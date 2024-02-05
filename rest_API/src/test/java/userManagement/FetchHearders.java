/**
 * Fetch headers  
 */
package userManagement;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FetchHearders {

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@Test(description = "Fetch headers")
	public void testFetchHeaders() {
		Response response = given().when().get("/api/users?page=2").then().extract().response();

		Headers headers = response.getHeaders();

		/*
		 * // Prints entire response 
		 * for (Header h : headers) {
		 * System.out.println(h.getName() + "  :  "+ h.getValue()); }
		 */
		
		// Prints specific response
		for (Header h : headers) { 
		 if ( h.getName().contains("Server")) 
		 {

			 // System.out.println(h.getName() + "  :  "+ h.getValue()); -- this prints info
		 
			 // asserting the value
			 assertEquals(h.getValue() , "cloudflare");
			 System.out.println("testFetchHeaders has executed and passed");
		 }
		 
// Interview questions
		 /**
		  * How you'll manage headers from response ? Using Header class
		  * How to validate a specific header and its value ? or
		  * Write a code to validate XXX field from header . 
		  * same answer for both is below
		
		// headers is a class and header
		
		// methods used to fetch getname and getvalue
		
		Headers headers = response.getHeaders();
		for (Header h : headers) { 
		 if ( h.getName().contains("Server")) 
		 {
			 assertEquals(h.getValue() , "cloudflare");
		 }
		 * 

		  */
}
			 

	}
}