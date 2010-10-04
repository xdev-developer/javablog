package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.javablog.core.entity.WebsiteConfiguration;
import com.javablog.core.storage.WebsiteConfigurationDAO;

public class WebsiteConfigurationController extends SimpleFormController {

	private Logger logger = Logger
			.getLogger(WebsiteConfigurationController.class);

	private WebsiteConfigurationDAO websiteConfigurationDAO;

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return websiteConfigurationDAO.getDefault();
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		WebsiteConfiguration websiteConfiguration = (WebsiteConfiguration) command;
		websiteConfigurationDAO.save(websiteConfiguration);

		return new ModelAndView("redirect:configuration.shtml");
	}

	public void setWebsiteConfigurationDAO(
			WebsiteConfigurationDAO websiteConfigurationDAO) {
		this.websiteConfigurationDAO = websiteConfigurationDAO;
	}
}
