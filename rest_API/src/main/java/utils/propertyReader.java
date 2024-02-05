package utils;
//import java.io.File;
import java.io.IOException;
//import org.apache.commons.io.FileUtils;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import bsh.ParseException;
import java.io.*;
import java.util.Properties;

// when we read a property file no external depedencies are present

// java utils - file / IO / properties / Inputstream etc

public class propertyReader {

	public static String propertyReader(String filePath,String key)

	{
	        String value = null;
	       
	        //Inputstream is required while loading into properties
	   
	       try (InputStream input = new FileInputStream(filePath))
	        {
	           
	           // object creation for Property class
	            Properties prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            //getProperty will fetch the value according to the key
	            value=prop.getProperty(key);
	         

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return value;  
	    }	
}