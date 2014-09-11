package com.xebia.tdd.training.hotelreservation.model;

import java.io.Serializable;

/**
 * <p>
 * <strong>Address</strong> is the model/entity class that represents an Address.
 * </p>
 * 
 * @author Anand Swarup V
 */
public class Address implements Serializable{
    
	private static final long serialVersionUID = 3652179005187137173L;
	private final String addressLine;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;
    
    public Address(String addressLine, String city, String state, String zip, String country) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    /**
     * @return the addressLine
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    @Override
    public String toString() {
        String separator = ", ";
        return addressLine + separator + city + separator + state + separator + zip + separator + country;
    }
    
}
