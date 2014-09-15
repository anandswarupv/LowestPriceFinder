package com.xebia.tdd.training.hotelreservation.legacy6;

import com.xebia.tdd.training.hotelreservation.legacy4.User;

public class ReservationService {

	public boolean doReservation(User user , Booking booking) throws Exception{
		
		RoomService roomService = new RoomService();
		boolean isAvailable = roomService.isRoomAvailable(booking.getHotel(), booking.getRoomType());
		if(!isAvailable) throw new Exception("Please Do a New Booking, Room Unavailable");
		
		boolean isValidCoupan = validateCoupan(booking);
		if(!isValidCoupan) throw new Exception("Coupan is Invalid");

		boolean paymentSuccessfull = doPayment(user, booking);
		if(!paymentSuccessfull) throw new Exception("Payment Failure");
		
		boolean reservationComplete = roomService.reserve(booking);
		if(!reservationComplete) throw new Exception("Reservation Failed");
		
		return true;
		
	}

	private boolean validateCoupan(Booking booking) {
		boolean isValidCoupan = CouponValidator.validatCoupans(booking);
		return isValidCoupan;
	}

	public boolean doPayment(User user, Booking booking) throws Exception {
		PaymentService paymentService = new PaymentService();
		return paymentService.doPayment(user,booking);
	}
}
