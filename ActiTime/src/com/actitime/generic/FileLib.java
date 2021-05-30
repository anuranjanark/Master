package com.actitime.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
public String getPropertyValue(String key) throws IOException
{
FileInputStream fis=new FileInputStream("./data/commondata.property");
Properties p=new Properties();
p.load(fis);
String value=p.getProperty(key);
return value;
}
public String getExcelValue(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./data/Actitime.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
	return value;
	
}
public void setExcelValue(String sheetName,int row,int cell,String status) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("./data/Actitime.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(status);
	FileOutputStream fout=new FileOutputStream("./data/Actitime.xlsx");
	wb.write(fout);
	wb.close();
}
}
