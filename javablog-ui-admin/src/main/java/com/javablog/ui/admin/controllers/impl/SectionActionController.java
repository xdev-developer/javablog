package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.apache.log4j.Logger;

import com.javablog.core.entity.Section;
import com.javablog.core.storage.SectionDAO;

public class SectionActionController extends MultiActionController{
	
	private Logger logger = Logger.getLogger(SectionActionController.class);
	
	private SectionDAO sectionsDAO;
	
	private static final String SECTION_ID_PARAMETER = "sid";
	
	@Override
	protected ModelAndView handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("redirect:sections.shtml");
	}


    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	Integer sectionId = ServletRequestUtils.getIntParameter(request, SECTION_ID_PARAMETER);
    	Section section = sectionsDAO.get(sectionId);
    	if(section == null){
    		logger.error("Section not found in storage");
    		throw new Exception("Section not found in storage");
    	}
        sectionsDAO.delete(sectionId);
        
	return new ModelAndView("redirect:sections.shtml");
    }

	public void setSectionsDAO(SectionDAO sectionsDAO) {
		this.sectionsDAO = sectionsDAO;
	}
}
