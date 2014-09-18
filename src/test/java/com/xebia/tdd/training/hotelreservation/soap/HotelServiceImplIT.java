package com.xebia.tdd.training.hotelreservation.soap;

import static org.junit.Assert.*;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

public class HotelServiceImplIT {

	@Test
	public void testGetHotelName() throws Exception {
        URL wsdlUrl = new URL("http://localhost:8080/soap?wsdl");
        QName serviceName = new QName("http://soap.hotelreservation.training.tdd.xebia.com/", "HotelServiceImplService");
        Service service = Service.create(wsdlUrl, serviceName);
        HotelService port = service.getPort(HotelService.class);
        String hotelName = port.getHotelName((Long)1001L);
        assertEquals("Lakewood HOTELS", hotelName);
    }

}
