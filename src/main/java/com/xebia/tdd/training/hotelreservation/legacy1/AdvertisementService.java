package com.xebia.tdd.training.hotelreservation.legacy1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvertisementService {

	private AdvertisementServiceProvider1 advertisementServiceProvider1;
	private AdvertisementServiceProvider2 advertisementServiceProvider2;

	public AdvertisementService() {
	}

	/**
	 * Fetch All Advertisements to be displayed on screen.
	 * 
	 * @return
	 */
	public List<Advertisement> getAllAdvertisements() {
		List<Advertisement> advertisements = new ArrayList<Advertisement>();
		Map<String,Advertisement> advertisementsMap = new HashMap<String, Advertisement>();
		
		List<Advertisement> provider1Advertisements = advertisementServiceProvider1.getAdvertisements();
		List<Advertisement> provider2Advertisements = advertisementServiceProvider2.getAdvertisements();

	
		advertisements.addAll(provider1Advertisements);
		advertisements.addAll(provider2Advertisements);
		
		for (Advertisement advertisement : advertisements) {
			advertisementsMap.put(advertisement.getName(), advertisement);
		}
		
		return new ArrayList(advertisementsMap.values());
	}
}
