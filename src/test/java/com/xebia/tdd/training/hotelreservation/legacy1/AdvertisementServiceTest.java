package com.xebia.tdd.training.hotelreservation.legacy1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.xebia.tdd.training.hotelreservation.legacy1.Advertisement;
import com.xebia.tdd.training.hotelreservation.legacy1.AdvertisementService;

public class AdvertisementServiceTest {

	@Test
	public void shouldGetUniqueAdvertisements(){

		AdvertisementService advertisementService = new AdvertisementService();
		List<Advertisement> allAdvertisements = advertisementService.getAllAdvertisements();
		
		assertUniqueNames(allAdvertisements);
		
	}


	private void assertUniqueNames(List<Advertisement> allAdvertisements) {
		List<String> uniqueNames = new ArrayList<String>();
		for (Advertisement ad : allAdvertisements) {
			if(uniqueNames.contains(ad.getName())){
				System.out.println(ad.getName());
				Assert.fail("Non Unique Names");
			}
			else{
				uniqueNames.add(ad.getName());
			}
		}
	}
}
