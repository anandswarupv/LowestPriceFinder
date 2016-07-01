package com.xebia.tdd.training.hotelreservation.legacy5;

import com.xebia.tdd.training.hotelreservation.chapter4.HotelEmployeeDAO;
import com.xebia.tdd.training.hotelreservation.chapter4.HotelEmployeeMailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Anand V on 6/21/16.
 */
public class Payment {

    @Autowired
    HotelEmployeeDAO hotelEmployeeDAO;

    @Autowired
    HotelEmployeeMailService mailService;

    public CardType getCard() {
        CardType cardType = new CardType("amex");
        return cardType;
    }
}
