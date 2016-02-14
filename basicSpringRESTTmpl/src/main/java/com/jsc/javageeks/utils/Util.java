package com.jsc.javageeks.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	private static final String propertiesFileName = "application.properties";
	private InputStream inputStream;

	public String getProperty(String property) throws IOException {
		Properties prop = new Properties();

		inputStream = getClass().getClassLoader().getResourceAsStream(
				propertiesFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '"
					+ propertiesFileName + "' not found in the classpath");
		}

		return prop.getProperty(property);
	}
}
