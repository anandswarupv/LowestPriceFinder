package com.xebia.tdd.training.hotelreservation.chapter4;

/**
 * Created by Anand V on 7/21/16.
 */
public class Message<T> {

    private T t;

    public Message(T t) {
        this.t = t;
    }

    public T getValue(){
        return t;
    }

}
