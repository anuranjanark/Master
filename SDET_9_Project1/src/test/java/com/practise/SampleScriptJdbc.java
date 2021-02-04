package com.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleScriptJdbc {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			// register to database
			Driver mysqlDriver=new Driver();
			DriverManager.registerDriver(mysqlDriver);
			// connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet9", "root", "root");
			// create a statement
			Statement stmt = con.createStatement();
			// execute query
			ResultSet result = stmt.executeQuery("select * from emp");
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t" + result.getString(2));
			}}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("query invalid");
		}
		finally {
			// close the connection	
			con.close();	
			System.out.println("connection closed");
		}


	}
}
