package com.xebia.tdd.training.hotelreservation.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class ConnectionManager implements DisposableBean {

    private String db_connect_string = "jdbc:postgresql://127.0.0.1:5432/anand";
    private String db_userid = "postgres";
    private String db_password = "postgres";

    private static String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL;TRACE_LEVEL_SYSTEM_OUT=1";
    private static String driver = "org.h2.Driver";
    private static String userName = "sa";
    private static String password = "password";

    private static Connection connection;

    private void initConnection() {
        try {
            System.out.println("Inside Connection Manager");
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, userName, password);
            connection.setAutoCommit(true);
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
