package com.xebia.tdd.training.hotelreservation.session1;

public class Unit {

	public Integer sum(Integer a, Integer b) {

		return getNonNullValue(a) + getNonNullValue(b);
	}

	private int getNonNullValue(Integer b) {
		return b == null ? 0 : b;
	}

}
