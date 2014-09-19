package com.xebia.tdd.training.hotelreservation.session4;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelEmployeeService {

	private Integer counter = 0;

	@Autowired
	HotelEmployeeDAO hotelEmployeeDAO;

	@Autowired
	HotelEmployeeMailService mailService;

	public List<HotelEmployee> searchEmployee(
			EmployeeSearchParameters searchParameters) {
		return hotelEmployeeDAO.searchEmployee(
				searchParameters.getEmployeeName(),
				searchParameters.getEmployeeAge(),
				searchParameters.getEmployeeCountry());
	}

	public void saveEmployee(HotelEmployee employee) {
		employee.setModifiedDate(new Date());
		employee.setSerialId(++counter);

		hotelEmployeeDAO.saveEmployee(employee);
	}

	public void updateEmployee(HotelEmployee employee) {
		hotelEmployeeDAO.updateEmployee(employee);
	}

	public void updateEmployeeEmailAddress(HotelEmployee employee,
			String emailAddress) {
		hotelEmployeeDAO.updateEmployee(employee);
		mailService.sendEmail(employee);
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public void setHotelEmployeeDAO(HotelEmployeeDAO hotelEmployeeDAO2) {
		hotelEmployeeDAO = hotelEmployeeDAO2;
	}

	public void setHotelEmployeeEmailService(
			HotelEmployeeMailService emailService) {
		mailService = emailService;
	}

}
