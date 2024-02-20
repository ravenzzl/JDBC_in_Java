package com.jdbc.advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionData {

	// we need to maintain some transaction where need to execute all statement or do nothing ex.online Banking
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			Statement stmt=con.createStatement();
			con.setAutoCommit(false); //we are saying don't commit anything untill i say 
			//let say we need to run both of sql at sametime or we no need to run anyone of this
			stmt.executeUpdate("update account set firstname='sherlock' where email='lenin@gmail.com'");  
			//int f=10/0; // we are creating error so above will run but below will fail
			//but we need to make sure it will happen
			stmt.executeUpdate("update account set lastname='homes' where email='lenin@gmail.com'");
			con.commit(); // we are saying to commit if code reach here 
			con.rollback();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
