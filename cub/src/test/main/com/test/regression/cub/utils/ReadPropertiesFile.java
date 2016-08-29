package com.test.regression.cub.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	String result = "";
	FileInputStream inputStream;
 
	public String getPropValue(String wantedPropertyValue) throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
			
			inputStream = new FileInputStream(new File(propFileName));
 
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			result = prop.getProperty(wantedPropertyValue);
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}
