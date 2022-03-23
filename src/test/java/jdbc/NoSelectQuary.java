package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import com.mysql.cj.jdbc.Driver;

public class NoSelectQuary {

	public static void main(String[] args) throws SQLException{
		Connection conn=null;
		int result = 0;
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("===========connection is done============");
		Statement stat=conn.createStatement();
		String quary="insert into project values('TY_PROJ_2130','Deepak','12/01/2022','Infosis','Completed',10)";
	     result =stat.executeUpdate(quary);
	     
		}catch(Exception e) {
			
		}finally {
			if(result==1) {
				System.out.println("project is inserted successfully");
			}
			else {
				System.out.println("project is not inserted");
			}
			conn.close();
			System.out.println("-----------close db connection------------");
		}

	}

}
