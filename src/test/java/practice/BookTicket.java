package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {

	@Test(dataProvider="dataProvider_bookTicketTest")
	public void bookTicketTest(String src,String dest) {
		System.out.println("Book Ticket From "+src+" To "+dest);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicketTest(){
		Object[][] objAry=new Object[5][2];
		
		objAry[0][0]="Bengaluru";
		objAry[0][1]="Mysore";
		
		objAry[1][0]="Bengaluru";
		objAry[1][1]="Delhi";
		
		objAry[2][0]="Bengaluru";
		objAry[2][1]="Patna";
		
		objAry[3][0]="Bengaluru";
		objAry[3][1]="Hydrabad";
		
		objAry[4][0]="Bengaluru";
		objAry[4][1]="Goa";
		return objAry;
		
	}
}
