package org.training.roomreservation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.roomreservation.model.CustomerType;
import org.training.roomreservation.model.Hotel;
import org.training.roomreservation.model.SearchResult;
import org.training.roomreservation.services.LowestPriceFinderService;

/**
 * <p>
 * Program to help an online customer find the cheapest hotel
 * </p>
 * 
 * @author Anand Swarup V
 */
@Component
public class HotelRoomReservationApp {
    
    @Autowired
    LowestPriceFinderService lowestPriceFinderService;
    
    /**
     * Main method to find the cheapest {@link Hotel} for the given dates and {@link CustomerType}
     * 
     * @param arguments
     */
    public String findHotel(List<Date> dates, CustomerType customerType) {
        SearchResult lowestPriceHotelForGivenDates = lowestPriceFinderService.getLowestPriceHotelForGivenDates(dates, customerType);
        return lowestPriceHotelForGivenDates.getHotel().getName();
    }

}
