package com.selenium.automation.achala.Supporters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertiesReaders {
	
	private FileInputStream fileInputStream;
	private Properties properties;
	private String value;
	

	public PropertiesReaders(String filepath ) throws IOException {
		
		fileInputStream = new FileInputStream(filepath);
	    properties = new Properties();
	    Optional<Properties> optional = Optional.ofNullable(properties);
	    if (optional.isPresent()) {
	    	properties.load(fileInputStream);
	    }
		else {
			System.out.println("PROPERTIES OBJECTS POINTING IS NULL");		
			
		}	
		
	}
	
	public String getValueForKey(String key){
		value=properties.getProperty(key);		
		 return value;
		
	}
	 
	public String getValueForKey(String key,String defaultvalue) {
		 value=properties.getProperty(key);
		 if (value==null) {
			 value=defaultvalue;
			
		 }
		 return value;
		
	}
	public String getValueForKey(Object key,Object defaultValue){
		Object val=properties.getOrDefault(key, defaultValue);
		value = (String) val;
		if (value==null) {
			value=(String) defaultValue;
			
		}
		 return value;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
