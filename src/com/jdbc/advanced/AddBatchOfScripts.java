package com.jdbc.advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatchOfScripts {
	
	
	//we can run multiple script at onetime by adding it to batch
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
			Statement stmt=con.createStatement();
			stmt.addBatch("insert into account values('iron','man','ironman@gmail','345');");
			stmt.addBatch("insert into account values('captian','america','captainamerica@gmailcom','34512');");
			int[] executeBatch = stmt.executeBatch();
			for(int i=0;i<executeBatch.length;i++) {
				System.out.println(i+" rows got affected");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
