package org.training.roomreservation.model;

import java.io.Serializable;

/**
 * <p>
 * <strong>Hotel</strong> is the model/entity class that represents a hotel.
 * </p>
 * 
 * @author Anand Swarup V
 */
public class Hotel implements Serializable {
    
	private static final long serialVersionUID = -371571627537440184L;
	private final Long id;
    private final String name;
    private final Address address;
    private final int rating;
    private final Rates rates;
    
    public Hotel(Long id, String name, Address address, int rating, Rates rates){
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.rates = rates;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }


    /**
     * @return the rates
     */
    public Rates getRates() {
        return rates;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
