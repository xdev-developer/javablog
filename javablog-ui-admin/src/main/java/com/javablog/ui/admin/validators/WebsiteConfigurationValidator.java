package com.javablog.ui.admin.validators;

import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javablog.core.entity.WebsiteConfiguration;

public class WebsiteConfigurationValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(WebsiteConfiguration.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WebsiteConfiguration configuration = (WebsiteConfiguration)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "defaultArticleAuthor", "required",
				"Field value required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mailSmtpHost", "required",
		"Field value required");

		if(!EmailValidator.getInstance().isValid(configuration.getAdminEmail())){
			errors.rejectValue("adminEmail", "is.not.valid");
		}

		if(!EmailValidator.getInstance().isValid(configuration.getMailSenderAddress())){
			errors.rejectValue("mailSenderAddress", "is.not.valid");
		}
	}

}
