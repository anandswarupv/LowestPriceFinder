package org.training.roomreservation.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager implements DisposableBean {

	private String db_connect_string = "jdbc:postgresql://127.0.0.1:5432/anand";
	private String db_userid = "postgres";
	private String db_password = "postgres";

	private static Connection connection;

	private void initConnection() {
		try {
			System.out.println("Inside Connection Manager");
			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(db_connect_string, db_userid, db_password);
			connection.setAutoCommit(false);
			System.out.println("Connection Established");
		} catch (Exception e) {
			System.out.println("Unable to establish the connection "
					+ e.getMessage());
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			initConnection();
		}
		return connection;
	}

	@Override
	public void destroy() throws Exception {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("Connection Closed");
			}		
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
