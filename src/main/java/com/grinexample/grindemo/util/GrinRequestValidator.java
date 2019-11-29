package com.grinexample.grindemo.util;

public class GrinRequestValidator {
	public static final boolean validateidScooter(String idScooter) {
		return idScooter.length() == 4 ? true : false;
	}
}
