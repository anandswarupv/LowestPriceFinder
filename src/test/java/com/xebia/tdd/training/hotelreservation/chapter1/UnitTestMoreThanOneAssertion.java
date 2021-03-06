package com.xebia.tdd.training.hotelreservation.chapter1;

import org.junit.Assert;
import org.junit.Test;

import com.xebia.tdd.training.hotelreservation.chapter1.Unit;

public class UnitTestMoreThanOneAssertion {

	@Test
	public void testUnitClass(){
		
		Unit unit = new Unit();
		Integer sum = unit.sum(10, 12);
		
		Assert.assertTrue(22 == sum);
		
		Integer subtract = unit.subtract(12, 10);
		
		Assert.assertTrue(2 == subtract);
	}
}
