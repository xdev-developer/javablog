package com.javablog.ui.user.controller.impl;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.javablog.core.entity.User;
import com.javablog.core.storage.SectionDAO;
import com.javablog.core.storage.UserDAO;
import com.javablog.ui.user.dto.RegisterDTO;

public class RegisterController extends SimpleFormController{

	private SectionDAO sectionDAO;

	private UserDAO usersDAO;

	@Override
	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		
		request.setAttribute("sections", sectionDAO.list());
		
		return super.referenceData(request, command, errors);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		RegisterDTO registerInfo = (RegisterDTO)command;
		
		User user = new User();
		user.setUsername(registerInfo.getUsername());
		user.setPassword(registerInfo.getPassword());
		user.setEmail(registerInfo.getEmail());
		user.setRegistered(new Timestamp(System.currentTimeMillis()));
		
		usersDAO.addUser(user);
		
		return new ModelAndView(getSuccessView());
	}
	/**
	 * @param sectionDAO the sectionDAO to set
	 */
	public void setSectionDAO(SectionDAO sectionDAO) {
		this.sectionDAO = sectionDAO;
	}
	
	public void setUsersDAO(UserDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
}
