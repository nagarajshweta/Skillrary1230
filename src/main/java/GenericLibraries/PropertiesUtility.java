package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods to perform actions on Properties file
 * Properties file
 * @author HP
 *
 */

public class PropertiesUtility {
	
	private Properties property;
	
	/**
	 * This method is used to initialize Properties file
	 * @param filePath
	 */
	
	public void propertiesInitialization(	String filePath) {
		FileInputStream fis=null;
		try { 
			fis=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property=new Properties();
		
		try {
			property.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to read data from Properties file
	 * @param Key
	 * @return
	 */
	public String fetchProperty(String Key) {
		return property.getProperty(Key);
	}

}
