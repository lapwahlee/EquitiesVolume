package com.potodds.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class MySQLDB {
	DataSource datasource;
	
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public void run() {
		Connection connection = null;
		try {
			connection = datasource.getConnection();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public static void main(String[] args) { 
		new MySQLDB().run();
	}	
}
