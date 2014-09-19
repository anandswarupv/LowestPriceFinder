package com.xebia.tdd.training.hotelreservation.session4;

import java.util.List;

public class HotelEmployeeDAO {

	public boolean saveEmployee(HotelEmployee employee) {
		// Save employee in database
		return true;
	}

	public boolean updateEmployee(HotelEmployee employee) {
		if (employee.getSerialid() == 0)
			throw new IllegalArgumentException("Object should have an Id");
		// update employee in database
		return true;
	}

	public List<HotelEmployee> searchEmployee(String employeeName,
			Integer employeeAge, String employeeCountry) {
		// Search the result in the database
		return null;
	}

}
