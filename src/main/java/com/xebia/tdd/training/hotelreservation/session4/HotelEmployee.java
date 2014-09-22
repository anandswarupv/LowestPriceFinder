package com.xebia.tdd.training.hotelreservation.session4;

import java.util.Date;

public class HotelEmployee {

	private Integer serialid = 0;
	private Date modifiedDate;

	public void setSerialId(Integer serialid) {
		this.serialid = serialid;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		
	}

	public Integer getSerialid() {
		return serialid;
	}

	public void setSerialid(Integer serialid) {
		this.serialid = serialid;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

}
