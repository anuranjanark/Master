package com.crm.autodesk.generics;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author divya
 *
 */
public class FileUtility {
	/**
	 * used to get data from property file based on key
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws Throwable  {

		FileInputStream fis = new FileInputStream("./data/commondataa.property");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);

		return value;
	}

}
