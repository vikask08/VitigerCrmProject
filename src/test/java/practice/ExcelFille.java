package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelFille {
	@Test
	public void readExelTest() throws Throwable {
		FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
		System.out.println(data);
	}
}
