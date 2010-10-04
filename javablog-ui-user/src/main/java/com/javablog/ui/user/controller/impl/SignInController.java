package com.javablog.ui.user.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.storage.SectionDAO;
import com.javablog.core.storage.UserDAO;

public class SignInController extends AbstractController{

	private SectionDAO sectionDAO;

	private UserDAO usersDAO;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		final ModelAndView mav = new ModelAndView("signin");
		
		mav.addObject("sections", sectionDAO.list());
		return mav;
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
