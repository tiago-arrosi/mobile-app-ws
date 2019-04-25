package com.tiagoarrosi.app.ws.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDON = new SecureRandom();
	private final String ALPHABET = "01234569ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final int ITERARIONS = 10000;
	private final int KEY_LENGTH = 256;
	
	public String generateId(int length) {
		return generateRandomString(length);
	}
	
	private String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDON.nextInt(ALPHABET.length())));
		}
		
		return new String(returnValue);
	}
 	
}
