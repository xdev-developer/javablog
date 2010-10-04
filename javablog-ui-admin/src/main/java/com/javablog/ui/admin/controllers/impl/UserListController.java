package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.storage.UserDAO;

public class UserListController extends AbstractController{

	private UserDAO usersDAO;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final ModelAndView mav = new ModelAndView("users");
		mav.addObject("users", usersDAO.list());
		return mav;
	}
	
	public void setUsersDAO(UserDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

}
