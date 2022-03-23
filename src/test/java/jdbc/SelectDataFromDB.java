package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectDataFromDB {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("connection is done");
        Statement stat=conn.createStatement();
        String quary = "select * from project";
        ResultSet resultset=stat.executeQuery(quary);
        while(resultset.next()) {
        	System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
        }
	}
        catch(Exception e){
        }finally {
        	conn.close();
        	System.out.println("-------------close db connection ------------------");
        }
	}

}
