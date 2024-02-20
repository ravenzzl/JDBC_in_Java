package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertionValuesInDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			String sql="insert into account values(?,?,?,?);";
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, "lenin");
			stmt.setString(2, "Selvamani");
			stmt.setString(3, "lenin@gmail.com");
			stmt.setString(4, "1000");
			int rs=stmt.executeUpdate();
			if(rs>0) {
				System.out.println(rs+" rows got affected");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
