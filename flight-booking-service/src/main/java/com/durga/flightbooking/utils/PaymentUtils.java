package com.durga.flightbooking.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.durga.flightbooking.exception.InsufficientAmountException;
@Component
public class PaymentUtils {
	private static Map<String, Double> paymentMap = new HashMap<>();
	
	static{
		paymentMap.put("account1",  50000.0);
		paymentMap.put("account2",  5000.0);
		paymentMap.put("account3",  10000.0);
		paymentMap.put("account4",  85000.0);
	}
	
	public static boolean validateCreditLimit(String accountNo , double requestedAmount) {
		
		
		if(requestedAmount > paymentMap.get(accountNo)) {
			throw new InsufficientAmountException("Insufficent amount..");
		}else {
			return true;
		}
	}
	

}
