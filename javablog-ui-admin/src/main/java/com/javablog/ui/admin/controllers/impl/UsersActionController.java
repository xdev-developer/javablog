package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.apache.log4j.Logger;

import com.javablog.core.entity.User;
import com.javablog.core.storage.UserDAO;

public class UsersActionController extends MultiActionController{
	
	private Logger logger = Logger.getLogger(UsersActionController.class);
	
	private UserDAO usersDAO;
	
	private static final String USER_ID_PARAMETER = "id";
	
	private static final String REDIRECT_URL = "redirect:users.shtml";
	
	@Override
	protected ModelAndView handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView(REDIRECT_URL);
	}


    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	Integer id = ServletRequestUtils.getIntParameter(request, USER_ID_PARAMETER, -1);
        if(id > 0){
        	usersDAO.delete(id);
        }
    	return new ModelAndView(REDIRECT_URL);
    }

    public ModelAndView changeStatus(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	Integer id = ServletRequestUtils.getIntParameter(request, USER_ID_PARAMETER, -1);
        if(id > 0){
        	User user = usersDAO.getById(id);
        	if(user == null){
        		throw new Exception("User not found in storage");
        	}
        	user.setEnabled(!user.getEnabled());
        	usersDAO.save(user);
        }
    	return new ModelAndView(REDIRECT_URL);
    }
    
	public void setUsersDAO(UserDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
}
