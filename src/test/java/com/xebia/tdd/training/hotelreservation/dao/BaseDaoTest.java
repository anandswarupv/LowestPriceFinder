package com.xebia.tdd.training.hotelreservation.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.BeforeClass;

public class BaseDaoTest {

    protected static Connection connection;

    /**
     * sets the system properties to use In Memory Datasource Instead of running
     * instances of postgres.
     * 
     * @throws Exception
     */
    @BeforeClass
    public static void init() throws Exception {
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=PostgreSQL;TRACE_LEVEL_SYSTEM_OUT=1";
        String driver = "org.h2.Driver";
        String userName = "sa";
        String password = "password";
        System.setProperty("database.dbcp.url", url);
        System.setProperty("database.dbcp.username", userName);
        System.setProperty("database.dbcp.driverClassName", driver);
        System.setProperty("database.dbcp.password", password);
        System.setProperty("database.datasource.type", "dbcp");
        System.setProperty("database.datasource.jndiname", "jdbc/mdm-ds");

        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        connection = ds.getConnection();
        try {
            createTables();
        } catch (Throwable e) {
            e.printStackTrace();
        }
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

}
