package com.xebia.tdd.training.hotelreservation.chapter3;

import org.springframework.stereotype.Component;

@Component
public class ConfigurationsDao {

	public CitySortOrder getSortOrder() {
		// Getting the result from the DB
		return CitySortOrder.ASC;
	}

}
