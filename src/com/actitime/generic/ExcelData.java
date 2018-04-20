package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
   //To get the data
	public static String getData(String pathname,String sheetname,int rn,int cn)
	{
		try {
			   FileInputStream fis=new FileInputStream(new File(pathname));
			   Workbook wb = WorkbookFactory.create(fis);
			   String data = wb.getSheet(sheetname).getRow(rn).getCell(cn).getStringCellValue();
			   return data;
		} 
		catch (Exception e) 
		{
			return "";
		}
	}
	
	//To get row count
	public static int getRowCount(String pathname,String sheetname)
	{
		try {
			   FileInputStream fis=new FileInputStream(new File(pathname));
			   Workbook wb = WorkbookFactory.create(fis);
			   int rc = wb.getSheet(sheetname).getLastRowNum();
			   return rc;
	     	} 
		catch (Exception e) 
		{
			return 0;
		}	   
	}
	public static int getCellCount(String pathname,String sheetname,int rn)
	{
		
		try {
			   FileInputStream fis=new FileInputStream(new File(pathname));
			   Workbook wb = WorkbookFactory.create(fis);
			   int cc = wb.getSheet(sheetname).getRow(rn).getLastCellNum();
			   return cc;
	     	} 
		catch (Exception e) 
		{
			return 0;
		}	   
	}
	
	public static void main(String args[])
	{
		String data = ExcelData.getData("./datat/input.xlsx", "sheet1", 0, 0);
		System.out.println(data);
		int rc = ExcelData.getRowCount("./datat/input.xlsx", "sheet1");
		System.out.println(rc);
		int cc=ExcelData.getCellCount("./data/input.xlsx", "sheet1", 0);
		System.out.println(cc);
	}
}
