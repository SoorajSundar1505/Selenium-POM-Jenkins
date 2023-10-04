package com.automation.ui.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

		private static String configProp = System.getProperty("user.dir")+"/src/main/resource/config.properties";
		static String configValue = null;
		
		
		public static String readConfigFile(String key) throws IOException {
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream(configProp);
			prop.load(file);
			configValue = prop.getProperty(key);
			return configValue;
		}
		
}
