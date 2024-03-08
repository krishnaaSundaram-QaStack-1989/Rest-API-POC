package utils;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import bsh.ParseException;

public class jsonReader {

	public static String getTestData(String key) throws IOException, ParseException, org.json.simple.parser.ParseException {
		@SuppressWarnings("unused")
		String value;
		return value = (String) getjsondata().get(key); // input is the key
	}
	
	public static JSONObject getjsondata() throws IOException, org.json.simple.parser.ParseException {
		
		File filename = new File("src\\main\\resources\\TestData\\testData.json");
		
		//convert json file to string 
		
		String json = FileUtils.readFileToString(filename, "UTF-8");
		//parse string intoobject
		
		Object obj = new JSONParser().parse(json);
		
		//give json object  so that i can return it to function everytie it get called
		
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}

	package utils;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import bsh.ParseException;

public class jsonReader {

	public static String getTestData(String key) throws IOException, ParseException, org.json.simple.parser.ParseException {
		@SuppressWarnings("unused")
		String value;
		return value = (String) getjsondata().get(key); // input is the key
	}
	
	public static JSONObject getjsondata() throws IOException, org.json.simple.parser.ParseException {
		
		File filename = new File("src\\main\\resources\\TestData\\testData.json");
		
		//convert json file to string 
		
		String json = FileUtils.readFileToString(filename, "UTF-8");
		//parse string intoobject
		
		Object obj = new JSONParser().parse(json);
		
		//give json object  so that i can return it to function everytie it get called
		
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}	
	
	public static JSONArray getJsonArray(String key) throws IOException, ParseException, org.json.simple.parser.ParseException {
		JSONObject jsonObject = getjsondata();
		JSONArray JsonArray = (JSONArray) jsonObject.get(key);
		return JsonArray;
	}
	
	public static Object getJsonArrayData(int index) throws ParseException, IOException, 
	org.json.simple.parser.ParseException {
		JSONArray language = getJsonArray("languages");
		return language.get(index);
	}
	
	
}	


}	
