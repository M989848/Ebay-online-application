package ebay.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public String getDataFromPropertyFile(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/ConfigurationData/CommonData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String data=pro.getProperty(Key);
		return data;
		
	}
}
