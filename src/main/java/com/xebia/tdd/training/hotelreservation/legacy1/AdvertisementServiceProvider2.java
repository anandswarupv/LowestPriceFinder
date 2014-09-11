package com.xebia.tdd.training.hotelreservation.legacy1;

import java.util.List;

import com.xebia.tdd.training.roomreservation.legacy1.AdvertisementDataMother;

public class AdvertisementServiceProvider2 {

	public List<Advertisement> getAdvertisements() {
		return AdvertisementDataMother.getAdvertisements("Facebook");
//		return null;
	}

}
