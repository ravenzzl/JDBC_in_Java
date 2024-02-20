package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteValuesInDB {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			PreparedStatement stmt=con.prepareStatement("delete from account where email=?");
			stmt.setString(1, "stalin@gmail.com");
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
