package com.me.crypto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.crypto.pojo.News;
import com.me.crypto.pojo.Transaction;

public class TransactionValidator implements Validator{


	public boolean supports(Class aclass) {
		return aclass.equals(Transaction.class);
	}

	
	public void validate(Object obj, Errors errors) {
		Transaction news = (Transaction) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");

		
		
		
		
	}
	
	
	
}