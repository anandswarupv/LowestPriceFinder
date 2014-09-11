package com.xebia.tdd.training.hotelreservation.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * <strong>Rates</strong> is the model/entity class that defines the Weekday and Weekend Rates 
 * for the {@link Hotel}.
 * </p>
 * 
 * @author Anand Swarup V
 */
public class Rates implements Serializable{
    
	private static final long serialVersionUID = -4489715416554183362L;
	private final BigDecimal weekdayRates;
    private final BigDecimal weekdayRatesForRewardsMembers;
    private final BigDecimal weekendRates;
    private final BigDecimal weekendRatesForRewardsMembers;
    
    public Rates(BigDecimal weekdayRates, BigDecimal weekdayRatesForRewardsMembers, BigDecimal weekendRates,  
            BigDecimal weekendRatesForRewardsMembers) {
        this.weekdayRates = weekdayRates;
        this.weekdayRatesForRewardsMembers = weekdayRatesForRewardsMembers;
        this.weekendRates = weekendRates;
        this.weekendRatesForRewardsMembers = weekendRatesForRewardsMembers;
    }

    /**
     * @return the weekdayRates
     */
    public BigDecimal getWeekdayRates() {
        return weekdayRates;
    }

    /**
     * @return the weekendRates
     */
    public BigDecimal getWeekendRates() {
        return weekendRates;
    }

    /**
     * @return the weekdayRatesForRewardsMembers
     */
    public BigDecimal getWeekdayRatesForRewardsMembers() {
        return weekdayRatesForRewardsMembers;
    }

    /**
     * @return the weekendRatesForRewardsMembers
     */
    public BigDecimal getWeekendRatesForRewardsMembers() {
        return weekendRatesForRewardsMembers;
    }
    
    

}
