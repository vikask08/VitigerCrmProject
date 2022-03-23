package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ProjectUnitTest {

	@Test
	public void projectUnitTest() throws Throwable {
		String projrctName = "Infosis";
		Connection conn=null;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("connection is done");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement stat=conn.createStatement();
			String quary = "select * from project";
			ResultSet resultse=stat.executeQuery(quary);
			boolean flag = false;
			while(resultse.next()) {
				String actProjectName = resultse.getString(4);
				if(actProjectName.equals(projrctName)) {
					System.out.println("hf");
					flag=true;
				}
			}
			Assert.assertTrue(flag);
		}
		catch(Exception e){
		}finally {
			conn.close();
			System.out.println("---------------close db connection-------------");
		}
	}
}
