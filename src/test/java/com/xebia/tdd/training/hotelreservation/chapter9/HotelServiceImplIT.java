package com.xebia.tdd.training.hotelreservation.chapter9;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.sql.SQLException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Before;
import org.junit.Test;

import com.xebia.tdd.training.hotelreservation.soap.HotelService;

public class HotelServiceImplIT extends BaseIntegrationTest{

	@Before
	public void setup() throws SQLException {
		initalizeBaseDataSet();
	}
	
    @Test
    public void testGetHotelName() throws Exception {
        URL wsdlUrl = new URL("http://localhost:8080/soap?wsdl");
        QName serviceName = new QName("http://soap.hotelreservation.training.tdd.xebia.com/", "HotelServiceImplService");
        Service service = Service.create(wsdlUrl, serviceName);
        HotelService port = service.getPort(HotelService.class);
        String hotelName = port.getHotelName((Long) 1001L);
        assertEquals("Lakewood HOTELS", hotelName);
    }

}
