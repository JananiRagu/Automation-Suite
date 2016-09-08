package com.test.regression.farmfresh.utils;

public class Constant {
	
	public static String URL;
	
	public static String browser_name;
	
	Constant(){
		
		ReadPropertiesFile properties = new ReadPropertiesFile();
		
		    try {
		    	URL = properties.getPropValue("testURL");
		    
	
		    	browser_name = properties.getPropValue("browser");
		    }
		    catch (Exception e) {
		    	System.out.println("Exception: " + e);
		    }
		
		 
	}
	
	
	
	
	
    //public static final String screenshots_folder = "C:\\Users\\jrag00m\\Desktop\\B2C_Screenshots\\";
}
