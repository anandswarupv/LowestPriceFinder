package com.xebia.tdd.training.hotelreservation.session1;

public class Unit {

	public Integer sum(Integer a, Integer b) {
		return getNonNullValue(b) + getNonNullValue(a);
	}

	private int getNonNullValue(Integer integer) {
		return integer == null ? 0 : integer;
	}

	
	public Integer subtract(Integer a, Integer b) {
		return getNonNullValue(b) - getNonNullValue(a);
	}


}
