package org.training.roomreservation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.training.roomreservation.model.Address;
import org.training.roomreservation.model.Hotel;
import org.training.roomreservation.model.Rates;
import org.training.roomreservation.utils.RESTConstants;

@Controller
public class LowestPriceFinderController {
	
	private static final Logger logger = LoggerFactory.getLogger(LowestPriceFinderController.class);
    
    Map<Integer, Hotel> hotelData = new HashMap<Integer, Hotel>();
    
    @RequestMapping(value = RESTConstants.DUMMY_HOTEL, method = RequestMethod.GET)
    public @ResponseBody Hotel getDummyHotel() {
        logger.info("Start getDummyEmployee");
        Address address = new Address("addressLine", "city", "state", "zip", "country");
        Rates rates = new Rates(new BigDecimal(100), new BigDecimal(100),new BigDecimal(100),new BigDecimal(100));
        Hotel dummyHotel = new Hotel((long)1, "",address,3,rates);
        hotelData.put(1, dummyHotel);
        return dummyHotel;
    }
     
    @RequestMapping(value = RESTConstants.GET_HOTEL, method = RequestMethod.GET)
    public @ResponseBody Hotel getHotel(@PathVariable("id") int hotelId) {
        logger.info("Start getHotel. ID="+hotelId);
        return hotelData.get(hotelId);
    }

}
