package utils;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties{
		
	private static Properties properties;
	
	public static void loadProperties() {
		if(properties == null) {
			properties = new Properties();
			try {
				properties.load(LoadProperties.class.getClassLoader().getResourceAsStream(StringConstants.getConfigFileName()));
			} catch (IOException e) {
				System.out.println("Properties file is not loaded. " + e.getMessage());
			}
		}
	}
	
	public static String getProperties(final String key) {
		loadProperties();
		if (properties != null && properties.containsKey(key))
		{
			return properties.getProperty(key);
		}
		return "";
	}

}
