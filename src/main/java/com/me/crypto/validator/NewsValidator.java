package com.me.crypto.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.crypto.pojo.News;



@Component
public class NewsValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(News.class);
	}

	public void validate(Object obj, Errors errors) {
		News newNews = (News) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "error.invalid.amount", "Amount Required");

	}
}
