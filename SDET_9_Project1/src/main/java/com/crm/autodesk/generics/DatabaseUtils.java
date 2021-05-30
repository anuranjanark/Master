package com.crm.autodesk.generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author divya
 *
 */
public class DatabaseUtils {
	/**
	 * used to execute select db query & return the table in the form of resultset
	 * @param query
	 * @return
	 * @throws SQLException 
	 */

	public ResultSet executeDBQuery(String query) throws SQLException {
		Connection con=null;
		ResultSet result=null;
		try {
			// register to database
			Driver mysqlDriver=new Driver();
			DriverManager.registerDriver(mysqlDriver);
			// connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet9", "root", "root");
			// create a statement
			Statement stmt = con.createStatement();
			// execute query
			result = stmt.executeQuery(query);
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
		return null;

	}
	/**
	 * used to execute nonselect db query & return result in the form of int if 0==>invalid 1==> valid
	 * @throws SQLException 
	 * 
	 */
	public int executeDBNonSelectQuery(String query) throws SQLException {
		Connection con=null;
		int result=0;
		try {
			// register to database
			Driver mysqlDriver=new Driver();
			DriverManager.registerDriver(mysqlDriver);
			// connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet9", "root", "root");
			// create a statement
			Statement stmt = con.createStatement();
			// execute query
			result = stmt.executeUpdate(query);
			if(result==1) {
				System.out.println("query created");
			}}
		catch (Exception e) {
			// TODO: handle exception
			if(result==0)
				System.out.println("query invalid");
			System.out.println(result);
		}

		finally {
			// close the connection	
			con.close();	
			System.out.println("connection closed");
		}
		return result;
	}
}
