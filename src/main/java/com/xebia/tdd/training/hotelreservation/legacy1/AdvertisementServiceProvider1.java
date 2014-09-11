package com.xebia.tdd.training.hotelreservation.legacy1;

import java.util.List;

import com.xebia.tdd.training.hotelreservation.legacy1.AdvertisementDataMother;

public class AdvertisementServiceProvider1 {

	public List<Advertisement> getAdvertisements() {
		return AdvertisementDataMother.getAdvertisements("Google","Amazon");
		//throw new RuntimeException("Unable to connect to remote");
	}

}
