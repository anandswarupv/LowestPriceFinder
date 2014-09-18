package com.xebia.tdd.training.hotelreservation.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.xebia.tdd.training.hotelreservation.dao.HotelDao;
import com.xebia.tdd.training.hotelreservation.model.Address;
import com.xebia.tdd.training.hotelreservation.model.CustomerType;
import com.xebia.tdd.training.hotelreservation.model.Hotel;
import com.xebia.tdd.training.hotelreservation.model.Rates;
import com.xebia.tdd.training.hotelreservation.model.SearchResult;

@RunWith(MockitoJUnitRunner.class)
public class LowestPriceFinderServiceTest {

    @Mock
    HotelDao hotelDao;

    @InjectMocks
    LowestPriceFinderService lowestPriceFinderService = new LowestPriceFinderService();

    @Before
    public void setUp() throws Exception {
        List<Hotel> hotels = getTestHotels();
        Mockito.when(hotelDao.getHotels()).thenReturn(hotels);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGetLowestPriceHotelForGivenDates() throws Exception {
        Date fromDate = new Date(2014, 9, 15);
        Date toDate = new Date(2014, 9, 17);
        List<Date> dates = new ArrayList<Date>();
        dates.add(fromDate);
        dates.add(toDate);
        SearchResult searchResult = lowestPriceFinderService.getLowestPriceHotelForGivenDates(dates, CustomerType.REGULAR);
        String actualHotelName = searchResult.getHotel().getName();
        String expectedHotelName = "Lakewood HOTELS";
        Assert.assertEquals(expectedHotelName, actualHotelName);
    }

    private List<Hotel> getTestHotels() {
        Address address1 = new Address("1111 1st St", "Santa Monica", "CA", "90403", "USA");
        Rates rates1 = new Rates(new BigDecimal(110), new BigDecimal(80), new BigDecimal(90), new BigDecimal(80));
        Hotel hotel1 = new Hotel(1001L, "Lakewood HOTELS", address1, 3, rates1);
        Address address2 = new Address("1112 1st St", "Santa Monica", "CA", "90403", "USA");
        Rates rates2 = new Rates(new BigDecimal(160), new BigDecimal(110), new BigDecimal(60), new BigDecimal(50));
        Hotel hotel2 = new Hotel(1002L, "Bridgewood HOTELS", address2, 4, rates2);
        Address address3 = new Address("1113 1st St", "Santa Monica", "CA", "90403", "USA");
        Rates rates3 = new Rates(new BigDecimal(220), new BigDecimal(110), new BigDecimal(150), new BigDecimal(40));
        Hotel hotel3 = new Hotel(1003L, "Ridgewood HOTELS", address3, 5, rates3);
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(hotel1);
        hotels.add(hotel2);
        hotels.add(hotel3);
        return hotels;
    }

}
