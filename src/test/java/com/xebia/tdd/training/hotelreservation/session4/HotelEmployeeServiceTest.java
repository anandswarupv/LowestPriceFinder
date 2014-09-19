package com.xebia.tdd.training.hotelreservation.session4;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

public class HotelEmployeeServiceTest {

	
	// Argument Matchers Scenario
	@Test
	public void shouldSaveEmployeeCorrectly() throws Exception {
		HotelEmployeeService employeeService = new HotelEmployeeService();
		employeeService.setCounter(1);
		HotelEmployeeDAO hotelEmployeeDAO = Mockito.mock(HotelEmployeeDAO.class);
		employeeService.setHotelEmployeeDAO(hotelEmployeeDAO);
		employeeService.saveEmployee(new HotelEmployee());
		
		ArgumentMatcher<HotelEmployee> argumentMatcher = new ArgumentMatcher<HotelEmployee>() {
			@Override
			public boolean matches(Object argument) {
				HotelEmployee employee = (HotelEmployee)argument;
				Assert.assertThat(2 ,Matchers.is(employee.getSerialid()));
				return true;
			}
		};

		
		Mockito.verify(hotelEmployeeDAO , Mockito.times(1)).saveEmployee(Mockito.argThat(argumentMatcher));
		Mockito.verifyNoMoreInteractions(hotelEmployeeDAO);
	}
	

	// Exception Throws Scenario
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionOnUpdateIfNoSerialId() throws Exception {
		HotelEmployeeService employeeService = new HotelEmployeeService();
		HotelEmployeeDAO hotelEmployeeDAO = Mockito.mock(HotelEmployeeDAO.class);
		employeeService.setHotelEmployeeDAO(hotelEmployeeDAO);
		
		HotelEmployee employee = new HotelEmployee();
		Mockito.when(hotelEmployeeDAO.updateEmployee(Mockito.eq(employee))).thenThrow(new IllegalArgumentException());

		employeeService.updateEmployee(employee);
		
	}

	// Mocks Execution Order Scenario
	
}