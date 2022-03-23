package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;

public class Sample_Test{
	@Test(dataProvider="dataProvider_addToCartAndBill")
	public void addToCartAndBill(String pName,String qty) {
		System.out.println("Execute"+pName+"Add to Cart And Bill");
	}

	@DataProvider
	public Object[][] dataProvider_addToCartAndBill() throws Throwable, Throwable{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("product");
		
		Object[][] objAry=new Object[rowCount][2];

		for(int i=0;i<rowCount;i++) {
			objAry[i][0]=eLib.getDataFromExcel("product", i, 0);
			objAry[i][0]=eLib.getDataFromExcel("product", i, 1);
		}
		return objAry;
	}
}
