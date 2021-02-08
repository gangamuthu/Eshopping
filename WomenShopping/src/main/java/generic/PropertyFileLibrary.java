package generic;

// If you want to read the data from the property file, we can use this

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileLibrary
{
  public static String getData(String filepath,String key)
  {
  try
  {
	  FileInputStream fin=new FileInputStream(filepath);
	   
	  Properties prop=new Properties();
	  
	  prop.load(fin);
	  return prop.getProperty(key);
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
	 return null; 
  }
}
