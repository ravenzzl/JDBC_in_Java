package com.jdbc.advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDemo {
  
	//resultset is usally only return the values in column
	//but resultsetmetadata is used to return the columnnames,columncount like that 
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			PreparedStatement stmt=con.prepareStatement("select * from account");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			ResultSetMetaData rmeta=rs.getMetaData();
			System.out.println(rmeta.getColumnCount()+" numbers column names in table");
			//column names in table
			for(int i=1;i<=rmeta.getColumnCount();i++) {
				System.out.println(rmeta.getColumnName(i));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
