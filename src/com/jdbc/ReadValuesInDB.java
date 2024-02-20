package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadValuesInDB {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
		    PreparedStatement stmt=con.prepareStatement("select * from mydb.account");
		    ResultSet rs= stmt.executeQuery();
		    while(rs.next()) {
		    	System.out.println(rs.getString(1));
		    	System.out.println(rs.getString(2));
		    	System.out.println(rs.getString(3));
		    	System.out.println(rs.getString(4));
		    }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
