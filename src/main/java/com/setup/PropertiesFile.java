package com.setup;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import io.qameta.allure.Description;

public class PropertiesFile {

	static Properties prop;
	static FileInputStream fileinput;
	static FileOutputStream fileoutput;

	@Description("Read value using properies file")
	public static String readFile(String key)
	{
		String value=null;
		try {
			fileinput = new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			prop = new Properties();
			prop.load(fileinput);
			if(value==null)
			{
				value = prop.getProperty(key);
				System.out.println("Value retrieved from key is : "+ value);				
			}
			fileinput.close();
		} catch(Exception e) {
			System.out.println("Exception Occured");
		}
		return value;
	}	

	@Description("Write value using properies file")
	public static String writeFile(String key, String value)
	{
		try {
			fileoutput = new FileOutputStream(System.getProperty("user.dir")+"/config/config.properties2");
			prop = new Properties();
			prop.setProperty(key, value);
			prop.store(fileoutput, value);
			fileoutput.close();
			System.out.println("Value written in file are :" + key + value);
		}  catch(Exception e) {
			System.out.println("Exception Occured");
		}
		return value;
	}

}
