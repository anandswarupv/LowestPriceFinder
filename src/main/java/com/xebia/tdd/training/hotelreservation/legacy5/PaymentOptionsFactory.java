package com.xebia.tdd.training.hotelreservation.legacy5;

import java.util.List;

public class PaymentOptionsFactory {

//	public static final PaymentOptionsFactory instance = new PaymentOptionsFactory();
	
	private PaymentOptionDAO paymentOptionsDAO;
	private List<PaymentOption> paymentOptions;
	
	public PaymentOptionsFactory() {
		this.paymentOptions = paymentOptionsDAO.getPaymentOptions();
	}

	public PaymentOption getPaymentOption(String optionName){
		for (PaymentOption option : getAllPaymentOptions()) {
			if(option.getName().equals(optionName))
				return option;
		}
		return null;
	}
	
	public void setPaymentOptionsDAO(PaymentOptionDAO paymentOptionsDAO) {
		this.paymentOptionsDAO = paymentOptionsDAO;
	}

	 List<PaymentOption> getAllPaymentOptions() {
		return paymentOptions;
	}
}
