package com.xebia.tdd.training.hotelreservation.session1;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UnitTestWithHamchrest {

	@Test
	public void shouldSumNegativeIntegersCorrectly() throws Exception {
		// Setup
		Unit unit = new Unit();
		Integer a = -10;
		Integer b = null;

		// Execution
		Integer sum = unit.sum(a, b);

		// Verification
		assertThat(-10, is(equalTo(sum)));
	}

}
