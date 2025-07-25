package com.bs.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	static Properties properties = new Properties();

	static {
		try {
			FileInputStream fileInputStream = new FileInputStream("config.properties");
			properties.load(fileInputStream);
		}
		catch(IOException e) {
			throw new RuntimeException("Properties file not found");
		}

	}

	public static String get(String key) {
		return properties.getProperty(key).toLowerCase();
	}

}
