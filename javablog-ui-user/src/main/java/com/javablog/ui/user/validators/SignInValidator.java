package com.javablog.ui.user.validators;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javablog.core.entity.User;
import com.javablog.core.storage.UserDAO;
import com.javablog.ui.user.dto.SignInDTO;

public class SignInValidator implements Validator {

	private UserDAO usersDAO;

	private Logger logger = Logger.getLogger(SignInValidator.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(SignInDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required",
		"Username required");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required",
		"Password required");	
		
		SignInDTO signinInfo = (SignInDTO)target;

		try {
			User u = usersDAO.login(signinInfo.getUsername(), signinInfo.getPassword());
			if(u == null){
				errors.rejectValue("username", "incorrect");
			}
		} catch (SQLException e) {
			logger.error(e, e);
		}
	}

	public void setUsersDAO(UserDAO usersDAO) {
		this.usersDAO = usersDAO;
	}	
}
