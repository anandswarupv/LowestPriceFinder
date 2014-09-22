package com.xebia.tdd.training.hotelreservation.session1;

public class Unit {

	public Integer sum(Integer a, Integer b) {
		return getNonNullValue(a) + getNonNullValue(b);
	}

	private int getNonNullValue(Integer integer) {
		return integer == null ? 0 : integer;
	}

}
