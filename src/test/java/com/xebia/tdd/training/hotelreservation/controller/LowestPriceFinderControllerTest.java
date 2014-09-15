package com.xebia.tdd.training.hotelreservation.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xebia.tdd.training.hotelreservation.dao.AddressDao;
import com.xebia.tdd.training.hotelreservation.dao.HotelDao;
import com.xebia.tdd.training.hotelreservation.dao.RatesDao;
import com.xebia.tdd.training.hotelreservation.model.Address;
import com.xebia.tdd.training.hotelreservation.model.Hotel;
import com.xebia.tdd.training.hotelreservation.model.Rates;
import com.xebia.tdd.training.hotelreservation.services.LowestPriceFinderService;
import com.xebia.tdd.training.hotelreservation.utils.ConnectionManager;
import com.xebia.tdd.training.hotelreservation.utils.HotelDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class LowestPriceFinderControllerTest {

    private static final String expectedContent = "{\"id\":1,\"name\":\"\",\"address\":{"
            + "\"addressLine\":\"addressLine\",\"city\":\"city\",\"state\":\"state\",\"zip\":\"zip\",\"country\":"
            + "\"country\"},\"rating\":3,\"rates\":{\"weekdayRates\":100,\"weekdayRatesForRewardsMembers\":100,"
            + "\"weekendRates\":100,\"weekendRatesForRewardsMembers\":100}}";

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetDummyHotel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/hotel/dummy")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetHotel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/hotel/1001")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedContent));
    }

    @Test
    public void testShouldThrow404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/hotel")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());

    }

    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {

        @Bean
        public LowestPriceFinderController lowestPriceFinderController() {
            LowestPriceFinderController LowestPriceFinderController = new LowestPriceFinderController();
            return LowestPriceFinderController;
        }

        @Bean
        public LowestPriceFinderService lowestPriceFinderService() {
            LowestPriceFinderService lowestPriceFinderService = Mockito.mock(LowestPriceFinderService.class);
            Address address = new Address("addressLine", "city", "state", "zip", "country");
            Rates rates = new Rates(new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(100));
            Hotel dummyHotel = new Hotel((long) 1, "", address, 3, rates);
            Mockito.when(lowestPriceFinderService.getHotel((Long) 1001L)).thenReturn(dummyHotel);
            return lowestPriceFinderService;
        }

        @Bean
        public HotelDao hotelDao() {
            HotelDao hotelDao = new HotelDao(connectionManager(), ratesDao(), addressDao());
            return hotelDao;
        }

        @Bean
        public RatesDao ratesDao() {
            RatesDao ratesDao = new RatesDao();
            return ratesDao;
        }

        @Bean
        public AddressDao addressDao() {
            AddressDao addressDao = new AddressDao(connectionManager());
            return addressDao;
        }

        @Bean
        public ConnectionManager connectionManager() {
            ConnectionManager connectionManager = new ConnectionManager();
            return connectionManager;
        }

        @Bean
        public HotelDatabase hotelDatabase() {
            HotelDatabase hotelDatabase = new HotelDatabase();
            return hotelDatabase;
        }

    }

}
