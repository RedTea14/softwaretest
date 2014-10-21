package cn.edu.tsinghua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resource {
    private static Properties prop = new Properties();
    
	static {
	    ClassLoader loader = Resource.class.getClassLoader();
	    InputStream stream = loader.getResourceAsStream("Labels.properties");
	    try {
			prop.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String name) {
		return prop.getProperty(name);
	}
}
