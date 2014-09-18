package com.xebia.tdd.training.hotelreservation.session1;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UnitTestWithAnnotations {

	private static Unit unit;

	@BeforeClass
	public static void init() {
		unit = new Unit();
	}

	@Before
	public void setup() {

	}

	@Test
	public void shouldNotThrowNullPointerExceptionForNullArguments()
			throws Exception {
		Integer a = 10;
		Integer b = null;

		// Execution
		Integer sum = unit.sum(a, b);

		// Verification
		assertTrue(10 == sum);

		// Execution
		sum = unit.sum(b, a);

		// Verification
		assertTrue(10 == sum);
	}

	@After
	public void teadDown() {

	}

	@AfterClass
	public static void shutDown() {
	}

}
