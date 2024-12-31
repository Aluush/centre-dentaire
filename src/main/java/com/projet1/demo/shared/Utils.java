package com.projet1.demo.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component; 

@Component
public class Utils {

	private final Random random =  new SecureRandom();
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	
     public String generateUserId(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
    

}
