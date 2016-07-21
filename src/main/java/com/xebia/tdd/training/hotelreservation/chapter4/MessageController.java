package com.xebia.tdd.training.hotelreservation.chapter4;

/**
 * Created by Anand V on 7/21/16.
 */
public class MessageController {

    private Message<String> message;

    public boolean setMessage(Message<String> message) {
        this.message = message;
        return true;
    }

    public void print() {
        System.out.println(message);
    }


}
