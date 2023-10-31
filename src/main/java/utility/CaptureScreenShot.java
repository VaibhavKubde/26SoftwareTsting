package utility;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class CaptureScreenShot extends TestBase
{
	/*public static String getDate()
	{
		String dateName= new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
		return dateName;
	}*/
	
	public static void screenshot(String nameOfMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("E:\\user\\Java_Batch_Workspace\\Selenium_Framework_2\\Screenshot\\"+nameOfMethod+".jpeg");
		FileHandler.copy(source, dest);
	
	}
	


}
