package com.xebia.tdd.training.hotelreservation.session2;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class StringCalulatorTest {

	@Test
	public void shouldAdd2NumbersCorrectly(){
		StringCalculator stringCalculator = new StringCalculator();
		String numbersString = "1,2";
		int result = stringCalculator.add(numbersString);
		
		Assert.assertThat(2, Matchers.is(result));
	}
	
	@Test
	public void shouldReturn1ForEmptyString(){
		StringCalculator stringCalculator = new StringCalculator();
		String numbersString = "";
		int result = stringCalculator.add(numbersString);
		
		Assert.assertThat(1, Matchers.is(result));
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfNonNumericCharactersAreUsed(){
		StringCalculator stringCalculator = new StringCalculator();
		String numbersString = "1,D";
		int result = stringCalculator.add(numbersString);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionIfIncorrectDelimeterisUsed(){
		StringCalculator stringCalculator = new StringCalculator();
		String numbersString = "1;D";
		int result = stringCalculator.add(numbersString);
		
	}
	
}