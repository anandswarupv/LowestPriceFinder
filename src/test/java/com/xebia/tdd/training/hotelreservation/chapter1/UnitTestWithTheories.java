package com.xebia.tdd.training.hotelreservation.chapter1;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.xebia.tdd.training.hotelreservation.chapter1.Unit;

@RunWith(Theories.class)
public class UnitTestWithTheories {

	@DataPoints
	public static Integer[][] Integers() {
		return new Integer[][] { { null, 1, 1 }, { 2, null, 2 },
				{ null, null, 0 } };
	}

	@Theory
	public void shouldNotThrowNullPointerExceptionForNullArguments(
			final Integer[] input) throws Exception {
		// Setup
		Unit unit = new Unit();

		// Execution
		Integer sum = unit.sum(input[0], input[1]);

		// Verification
		assertTrue(input[2] == sum);

	}
}
