package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("E:\\user\\Java_Batch_Workspace\\Selenium_Framework_2\\testData\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
		
	}
	
	public static String readExel(int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("E:\\user\\Java_Batch_Workspace\\Selenium_Framework_2\\testData\\Book1.xlsx");
		Sheet sheet1 = WorkbookFactory.create(file).getSheet("Sheet1");
		String value=sheet1.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
		
	}

}
