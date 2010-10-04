package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.storage.SectionDAO;

public class SectionListController extends AbstractController {

	private Logger logger = Logger.getLogger(SectionListController.class);

	private SectionDAO sectionsDAO;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.info("SectionListController");
			
		final ModelAndView mav = new ModelAndView("sections");
		
		mav.addObject("sections", sectionsDAO.list());

		return mav;
	}

	public void setSectionsDAO(SectionDAO sectionsDAO) {
		this.sectionsDAO = sectionsDAO;
	}
}
