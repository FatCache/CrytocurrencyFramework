package com.me.crypto.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.crypto.pojo.Coin;


public class CoinValidator implements Validator {

	
	public boolean supports(Class aClass) {
		return aClass.equals(Coin.class);
	}

	public void validate(Object obj, Errors errors) {
		Coin newCoin = (Coin) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "worth", "error.invalid.worth", "Worth Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coinType", "error.invalid.cointype", "Cointype Required");
        }	
	}

