package com.xebia.tdd.training.hotelreservation.legacy1;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementService {

	public AdvertisementService() {
	}

	/**
	 * Fetch All Advertisements to be displayed on screen.
	 * 
	 * @return
	 */
	public List<Advertisement> getAllAdvertisements() {
		List<Advertisement> advertisements = new ArrayList<Advertisement>();

		AdvertisementServiceProvider1 advertisementServiceProvider1 = new AdvertisementServiceProvider1();
		AdvertisementServiceProvider2 advertisementServiceProvider2 = new AdvertisementServiceProvider2();

		List<Advertisement> provider1Advertisements = advertisementServiceProvider1
				.getAdvertisements();
		List<Advertisement> provider2Advertisements = advertisementServiceProvider2
				.getAdvertisements();

		advertisements.addAll(provider1Advertisements);
		advertisements.addAll(provider2Advertisements);
		
		return advertisements;
	}
}
