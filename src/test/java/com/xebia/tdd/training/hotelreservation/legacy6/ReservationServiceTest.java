package com.xebia.tdd.training.hotelreservation.legacy6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PaymentService.class})
public class ReservationServiceTest {

	@Test
	public void shouldCallAllTheServicesInOrder() throws Exception {
		ReservationService reservationService = new ReservationServiceExt();
		PaymentService paymentService = PowerMockito.mock(PaymentService.class);
		
		reservationService.setPaymentService(paymentService);
		reservationService.doPayment(null, null);
	}

	class ReservationServiceExt extends ReservationService {
		@Override
		public boolean checkRoomAvailability(Booking booking) {
			return true;
		}

		@Override
		public boolean validateCoupan(Booking booking) {
			return true;
		}

		@Override
		public boolean reserveRoom(Booking booking) {
			return true;
		}
	}
}
