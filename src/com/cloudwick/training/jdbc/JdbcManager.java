package com.cloudwick.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcManager {

	private Connection con;

	private void getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/test";
		con = DriverManager.getConnection(url, "root", "hadoop123");
		// System.out.println("Working...");

	}

	private void insertData(String uName, String pwd) throws SQLException {
		con.setAutoCommit(false);
		String query = "Insert into User (username , password) values (?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, uName);
		ps.setString(2, pwd);
		int count = ps.executeUpdate();

		System.out.println("USers Inserted :" + count);
		con.commit();

	}

	private void updateContent(int userid, String uname) throws SQLException {
		String query = "Update user set username = '" + uname
				+ "' where user_id =" + userid;
		Statement st = con.createStatement();
		int count = st.executeUpdate(query);
		System.out.println("Users updated : " + count);
	}

	private void fetchData() throws SQLException {
		String query = "Select * from user";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println("User_id " + rs.getInt(1));
			System.out.println("Username " + rs.getString(2));
			System.out.println("pwd " + rs.getString(3));
		}
	}
	
	private void insertBatchData() throws SQLException{
		String query = "Insert into user (username,password) values (? ,?)";
		PreparedStatement ps = con.prepareStatement(query);
		long starttime = System.currentTimeMillis();
		ps.setString(1, "a");
		ps.setString(2, "b");
		ps.addBatch();
		ps.setString(1, "c");
		ps.setString(2, "d");
		ps.addBatch();
		int data[] = ps.executeBatch();
		long endtime = System.currentTimeMillis();
		long duration =  endtime - starttime;
		System.out.println(data.length);
		System.out.println("Execution time :"+duration);
	}

	public static void main(String[] args) throws SQLException {
		JdbcManager obj = new JdbcManager();
		obj.getConnection();
		//obj.insertData("Raki", "1234");
		//obj.insertData("Ritu", "4321");
		//obj.insertData("Rinni", "1424");
		//obj.insertData("Riya", "14524");
		//obj.updateContent(2, "Rahul");
		//obj.fetchData();
		obj.insertBatchData();

	}

}
