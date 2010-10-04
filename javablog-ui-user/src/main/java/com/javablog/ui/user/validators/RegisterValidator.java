package com.javablog.ui.user.validators;

import java.sql.SQLException;

import org.apache.commons.validator.EmailValidator;
import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javablog.core.storage.UserDAO;
import com.javablog.ui.user.dto.RegisterDTO;

public class RegisterValidator implements Validator {

	private UserDAO usersDAO;
	
	private Logger logger = Logger.getLogger(RegisterValidator.class);

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(RegisterDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		RegisterDTO registerDTO = (RegisterDTO)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required",
				"Username required");

		String username = registerDTO.getUsername();
		try {
			if(usersDAO.getByUsername(username) != null){
				errors.rejectValue("username", "already.exists");
			}
		} catch (SQLException e) {
			logger.error(e, e);
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required",
		"Password required");
		
		if(!registerDTO.getPassword().equalsIgnoreCase(registerDTO.getRetypePassword())){
			errors.rejectValue("retypePassword", "is.not.equals");
		}

		String email = registerDTO.getEmail();
		
		if(!EmailValidator.getInstance().isValid(email)){
			errors.rejectValue("email", "is.not.valid");
		}

		try {
			if(usersDAO.getByEmail(email) != null){
				errors.rejectValue("email", "already.exists");
			}
		} catch (SQLException e) {
			logger.error(e, e);
		}
	}

	public void setUsersDAO(UserDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
}
