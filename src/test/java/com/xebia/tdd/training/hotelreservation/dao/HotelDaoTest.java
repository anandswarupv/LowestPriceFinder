package com.xebia.tdd.training.hotelreservation.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.xebia.tdd.training.hotelreservation.model.Address;
import com.xebia.tdd.training.hotelreservation.model.Hotel;
import com.xebia.tdd.training.hotelreservation.utils.ConnectionManager;

public class HotelDaoTest extends BaseDaoTest {

    private static HotelDao hotelDao;
    private static RatesDao ratesDao = Mockito.mock(RatesDao.class);
    private static AddressDao addressDao = Mockito.mock(AddressDao.class);
    private static ConnectionManager connectionManager = Mockito.mock(ConnectionManager.class);

    private static final String Address1_AddressLine = "1111 1st St";
    private static final String Address1_City = "Santa Monica";
    private static final String Address1_State = "CA";
    private static final String Address1_Zip = "90403";
    private static final String Address1_Country = "USA";

    private static final String Hotel1_Name = "Lakewood HOTELS";
    private static final Long Hotel1_Id = 1001L;
    private static final int Hotel1_Rating = 3;

    private static final String Rates1_WeekendRates = "90";
    private static final String Rates1_WeekendRatesForRewardsMembers = "80";
    private static final String Rates1_WeekdayRates = "110";
    private static final String Rates1_WeekdayRatesForRewardsMembers = "80";

    @Before
    public void setup() throws Exception {
        createTestData();
        createMocks();
        hotelDao = new HotelDao(connectionManager, ratesDao, addressDao);
    }

    @After
    public void cleanUp() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from rates");
        statement.executeUpdate("delete from address");
        statement.executeUpdate("delete from hotel");
        statement.close();
    }

    private void createMocks() {
        Address address = new Address(Address1_AddressLine, Address1_City, Address1_State, Address1_Zip, Address1_Country);
        Mockito.when(connectionManager.getConnection()).thenReturn(connection);
        Mockito.when(addressDao.getAddressForHotelId(1001L)).thenReturn(address);
    }

    @Test
    public void testGetHotel() throws Exception {
        Hotel hotel = hotelDao.getHotel((Long) 1001L);
        Assert.assertEquals(Hotel1_Id, hotel.getId());
        Assert.assertEquals(Hotel1_Name, hotel.getName());
        Assert.assertEquals(Hotel1_Rating, hotel.getRating());
        Assert.assertEquals(Address1_AddressLine, hotel.getAddress().getAddressLine());
        Assert.assertEquals(Address1_Zip, hotel.getAddress().getZip());
    }

    @Test
    public void testGetHotels() throws Exception {
        List<Hotel> hotels = hotelDao.getHotels();
        Assert.assertEquals(3, hotels.size());
    }

    private void createTestData() throws SQLException {
        initializeHotel();
        initializeAddress();
        initializeRates();
    }

    private void initializeRates() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO RATES VALUES (" + Hotel1_Id + "," + Rates1_WeekdayRates + "," +
                Rates1_WeekdayRatesForRewardsMembers + "," + Rates1_WeekendRates + "," +
                Rates1_WeekendRatesForRewardsMembers + ")");
        statement.close();
    }

    private void initializeAddress() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO ADDRESS VALUES (" + Hotel1_Id + ", '"
                + Address1_AddressLine + "','" + Address1_City + "','" + Address1_State + "','"
                + Address1_Zip + "','" + Address1_Country + "')");
        statement.close();
    }

    private void initializeHotel() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO HOTEL VALUES (" + Hotel1_Id + ", '" + Hotel1_Name +
                "'," + Hotel1_Rating + " )");
        statement.execute("INSERT INTO HOTEL VALUES (1002, 'Bridgewood HOTELS', 4)");
        statement.execute("INSERT INTO HOTEL VALUES (1003, 'Ridgewood HOTELS', 5)");
        statement.close();
    }

    @Test
    public void testGetHotelNameUsingStoredProcedure() throws Exception {
        String hotelName = hotelDao.getHotelNameUsingStoredProcedure((Long) 1001L);
        Assert.assertEquals(Hotel1_Name, hotelName);
    }

    @Test
    public void testGetHotelUsingStoredProcedure() throws Exception {
        Hotel hotel = hotelDao.getHotelUsingStoredProcedure((Long) 1001L);
        Assert.assertEquals(Hotel1_Name, hotel.getName());
    }
}
