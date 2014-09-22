package com.xebia.tdd.training.hotelreservation.session4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelEmployeeService {

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

	public boolean saveEmployee(HotelEmployee employee) {
		return hotelEmployeeDAO.saveEmployee(employee);
	}
	
	public boolean updateEmployee(HotelEmployee employee) {
		employee.setSerialId(employee.getSerialid()+1);
		return hotelEmployeeDAO.updateEmployee(employee);
	}

	public void updateEmployeeEmailAddress(HotelEmployee employee,
			String emailAddress) {
		hotelEmployeeDAO.updateEmployee(employee);
		mailService.sendEmail(employee);
	}

	public void setHotelEmployeeDAO(HotelEmployeeDAO hotelEmployeeDAO2) {
		hotelEmployeeDAO = hotelEmployeeDAO2;
	}

	public void setHotelEmployeeEmailService(
			HotelEmployeeMailService emailService) {
		mailService = emailService;
	}

}
