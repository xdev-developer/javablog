package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.javablog.core.entity.Section;
import com.javablog.core.storage.SectionDAO;

/**
 * Section edit controller
 * @author xdev
 *
 */
public class SectionEditController extends SimpleFormController {

    private Logger logger = Logger.getLogger(SectionEditController.class);
    
    private SectionDAO sectionsDAO;
	
    private static final String SECTION_ID_PARAMETER = "sid";

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        //Get section id from request
        Integer sectionId = ServletRequestUtils.getIntParameter(request, SECTION_ID_PARAMETER, -1);
        Section section = new Section(-1, "");

        if (sectionId != -1) {
            section = sectionsDAO.get(sectionId);
        }
        return section;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        Section section = (Section) command;
        if (section.getId() > 0) {
            sectionsDAO.save(section);
        } else {
            sectionsDAO.add(section);
        }
        return new ModelAndView(getSuccessView());
    }

    /**
     * set the section dao
     * @param sectionsDAO
     */
    public void setSectionsDAO(SectionDAO sectionsDAO) {
        this.sectionsDAO = sectionsDAO;
    }
}
