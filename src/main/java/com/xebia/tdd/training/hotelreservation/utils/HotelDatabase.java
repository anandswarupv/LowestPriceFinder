package com.xebia.tdd.training.hotelreservation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDatabase {
    
    protected static Connection connection;

    /**
     * Sets the In Memory Datasource
     * 
     * @throws Exception
     */
    public static void init() throws Exception {
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL;TRACE_LEVEL_SYSTEM_OUT=1";
        String driver = "org.h2.Driver";
        String userName = "sa";
        String password = "password";
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection(url, userName, password);
        try {
            createTables();
            initializeTables();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void initializeTables() throws SQLException {
        initializeHotel();
        initializeAddress();
        initializeRates();
    }

    public Connection getConnection() {
        return connection;
    }

    private static void createTables() throws SQLException {
        createTableHotel();
        createTableAddress();
        createTableRates();
    }

    private static void createTableRates() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE RATES ("
                + "HOTEL_ID BIGINT NOT NULL, "
                + "WEEKDAYRATES BIGINT, "
                + "WEEKDAYRATESFORREWARDSMEMBERS BIGINT, "
                + "WEEKENDRATES BIGINT, "
                + "WEEKENDRATESFORREWARDSMEMBERS BIGINT, "
                + "CONSTRAINT HOTEL_ID_ROW_FK FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID)"
                + ")");
        statement.close();
    }

    private static void createTableAddress() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE ADDRESS ("
                + "HOTEL_ID BIGINT, "
                + "ADDRESSLINE VARCHAR, "
                + "CITY VARCHAR, "
                + "STATE VARCHAR, "
                + "ZIP VARCHAR, "
                + "COUNTRY VARCHAR, "
                + "CONSTRAINT ADDRESS_ROW_FK FOREIGN KEY (HOTEL_ID) REFERENCES HOTEL (ID)"
                + ")");
        statement.close();
    }

    private static void createTableHotel() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE HOTEL ("
                + "ID BIGINT NOT NULL, "
                + "NAME CHARACTER VARYING(36) NOT NULL, "
                + "RATING BIGINT,  "
                + "CONSTRAINT PRIMARY_KEY_HOTEL PRIMARY KEY (ID )"
                + ")");
        statement.close();
    }
    
    private static void initializeRates() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO RATES VALUES (1001, 110, 80, 90, 80)");
        statement.execute("INSERT INTO RATES VALUES (1002, 160, 110, 60, 50)");
        statement.execute("INSERT INTO RATES VALUES (1003, 220, 100, 150, 40)");
        statement.close();
    }

    private static void initializeAddress() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO ADDRESS VALUES (1001, '1111 1st St','Santa Monica','CA','90403','USA')");
        statement.execute("INSERT INTO ADDRESS VALUES (1002, '1112 2nd St','Santa Monica','CA','90403','USA')");
        statement.execute("INSERT INTO ADDRESS VALUES (1003, '1113 3rd St','Santa Monica','CA','90403','USA')");
        statement.close();
    }

    private static void initializeHotel() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO HOTEL VALUES (1001, 'Lakewood HOTELS', 3)");
        statement.execute("INSERT INTO HOTEL VALUES (1002, 'Bridgewood HOTELS', 4)");
        statement.execute("INSERT INTO HOTEL VALUES (1003, 'Ridgewood HOTELS', 5)");
        statement.close();
    }

}
