package com.javablog.ui.admin.validators;


import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javablog.core.entity.Article;

public class ArticleValidator implements Validator{

	private Logger logger = Logger.getLogger(ArticleValidator.class);

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(Article.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required", "Article title required");
		
		if(logger.isDebugEnabled())
			logger.debug("Validate : " + target +" Validate result : " + errors);

	}
}
