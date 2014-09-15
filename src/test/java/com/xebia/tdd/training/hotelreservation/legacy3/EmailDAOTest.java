package com.xebia.tdd.training.hotelreservation.legacy3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.xebia.tdd.training.hotelreservation.legacy2.Email;
import com.xebia.tdd.training.hotelreservation.legacy4.DBUtils;
import com.xebia.tdd.training.hotelreservation.legacy4.EmailDAO;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DBUtils.class,EmailDAO.class})
public class EmailDAOTest {

	@Test
	public void shouldSaveEmailCorrectly(){
		EmailDAO dao = new EmailDAO();
		Email email = new Email("email");
		email.setSubject("Subject");
		
		PowerMockito.mockStatic(DBUtils.class);
		PowerMockito.when(DBUtils.getNextAvailableNumber()).thenReturn(1);
		
		dao.saveEmail(email);
	}
	
	@Test(expected=RuntimeException.class)
	public void shouldThrowRunTimeExceptionIfNoSubjectSpecified() {
		EmailDAO dao = new EmailDAO();
		dao.saveEmail(new Email("email"));
	}

}
 	