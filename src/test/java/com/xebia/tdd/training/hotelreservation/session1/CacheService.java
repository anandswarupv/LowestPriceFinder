package com.xebia.tdd.training.hotelreservation.session1;

import java.util.HashMap;
import java.util.Map;

public class CacheService {

	private boolean returnNullForBlank = true;
	private Map<String, String> keyValueMap = new HashMap<String, String>();

	public String get(String key) {
		String value = keyValueMap.get(key);
		if (null == value) {
			if (returnNullForBlank) {
				value = null;
			} else {
				value = "";
			}
		}

		return value;
	}

	public boolean getReturnNullForBlank() {
		return returnNullForBlank;
	}

	public void setReturnNullForBlank(boolean returnNullForBlank) {
		this.returnNullForBlank = returnNullForBlank;
	}
}
