package com.CIplatform.service;

import java.security.SecureRandom;

public class TokenGenerator {
	
	protected static SecureRandom random = new SecureRandom();
    
    public static String generateToken( ) {
            long longToken = Math.abs( random.nextLong() );
            String random = Long.toString( longToken, 16 );
            return (random);
    }
}
