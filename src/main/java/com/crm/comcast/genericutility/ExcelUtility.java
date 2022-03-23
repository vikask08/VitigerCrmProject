package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POi libraries , which used to handle Microsoft Excel sheet
 * @author Vikask
 *
 */
public class ExcelUtility {
	/**
	 * its used read the data from excel base don below arguments 
	 * @param sheet
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheet,int rowno,int cellno) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis)	;
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String data = cell.getStringCellValue();
		return data;
	}
	/**
	 * it is used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws Throwable, IOException {
		FileInputStream f=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		Sheet sh = wb.getSheet(sheetName);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	/**
	 * it is used to write the data into excel file
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable 
	 */
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data ) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/TestScript.xlsx");
		wb.write(fos);
		wb.close();
	}
}
