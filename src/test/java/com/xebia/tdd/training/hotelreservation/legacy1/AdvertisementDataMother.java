package com.xebia.tdd.training.hotelreservation.legacy1;

import java.util.ArrayList;
import java.util.List;

import com.xebia.tdd.training.hotelreservation.legacy1.Advertisement;

public class AdvertisementDataMother {

	public static List<Advertisement> getAdvertisements(String...names) {
			List<Advertisement>  advertisements = new  ArrayList<Advertisement>();
			for (String name : names) {
				advertisements.add(new Advertisement(name));
				
			}
		return advertisements;
	}
}
