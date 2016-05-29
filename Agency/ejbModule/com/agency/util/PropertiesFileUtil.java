/**
 * 
 */
package com.agency.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author jvagas033
 *
 */
public class PropertiesFileUtil {

	/**
	 * 
	 */
	public final static String PROVIDER_CONFIG = "config/providerConfig.properties";

	/**
	 * Get a value from provider configuration file
	 * 
	 * @param key
	 *            Property key
	 * @return Value associated to the key parameter
	 * @throws Exception 
	 */
	public static String getProviderConfigPropertyValue(String key)
			throws Exception {
		try {
			Properties properties = new Properties();
			InputStream inputStream = PropertiesFileUtil.class.getClassLoader()
					.getResourceAsStream(PROVIDER_CONFIG);

			if (inputStream == null) {
				throw new FileNotFoundException("Property file "
						+ PROVIDER_CONFIG + " not found.");
			}
			
			properties.load(inputStream);

			return properties.getProperty(key);
		} catch (Exception e) {
			throw e;
		}
	}
}
