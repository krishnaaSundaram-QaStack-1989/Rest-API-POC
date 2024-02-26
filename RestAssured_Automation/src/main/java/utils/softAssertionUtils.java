package utils;
import org.testng.asserts.SoftAssert;
// wrapper class creation is comon practice .From here we can decide / control and 
//  restrict the methods which the team can have access to and avoid them from 
//  using all the methods 

public class softAssertionUtils {
	
	private SoftAssert softAssert;

	public softAssertionUtils() {
		softAssert = new SoftAssert();
	}
	
	public void assertTrue(boolean condition, String message) {
		try {
			softAssert.assertTrue(condition, message);			
		} catch (AssertionError e) {
				softAssert.fail(message);
		}
	}
	
	public void assertFalse(boolean condition, String message) {
		try {
			softAssert.assertFalse(condition, message);			
		} catch (AssertionError e) {
				softAssert.fail(message);
		}
	}
	
	public void assertEquals(Object actual, Object expected, String message) {
		try {
			softAssert.assertEquals(actual,  expected, message);			
		} catch (AssertionError e) {
				softAssert.fail(message);
		}
	}
	
	public void assertNotEquals(Object actual, Object expected, String message) {
		try {
			softAssert.assertNotEquals(actual,  expected, message);			
		} catch (AssertionError e) {
				softAssert.fail(message);
		}
	}
	
	public void assertAll() {
		softAssert.assertAll();
	}	
	
}
