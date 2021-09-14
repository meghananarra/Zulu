package com.Zulu.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib
{
	public String readPropertyData(String propPath,String key)throws Throwable
	{
		FileInputStream fis=new FileInputStream(propPath);
		Properties prop=new Properties();
		prop.load(fis);
		String PropValue=prop.getProperty(key,"Incorrect key");
		return PropValue;
	}
	
	public String readExcelData(String path,String sheetName,int row,int cell)
	throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		String excelValue=wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		return excelValue;
	}
	
	public void writeExcelData(String path, String sheetName, int row, int cell, String data)throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
	}
	public int rowcount(String path,String sheetName)throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
}

	 




