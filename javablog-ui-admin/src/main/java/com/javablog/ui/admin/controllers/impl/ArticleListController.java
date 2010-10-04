package com.javablog.ui.admin.controllers.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.entity.Section;
import com.javablog.core.storage.ArticleDAO;
import com.javablog.core.storage.SectionDAO;

public class ArticleListController extends AbstractController {

	private Logger logger = Logger.getLogger(ArticleListController.class);

	private SectionDAO sectionsDAO;
	
	private ArticleDAO articlesDAO;
	
	private static final String SECTION_ID_PARAMETER = "sid";
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("ArticleListController");
		final ModelAndView mav = new ModelAndView("articles");

		List<Section> sections = sectionsDAO.list();
		mav.addObject("sections", sections);

		Integer sectionId = ServletRequestUtils.getIntParameter(request, SECTION_ID_PARAMETER, -1);
		mav.addObject("sid", sectionId);
		
		if(sectionId != -1){
			mav.addObject("articles", articlesDAO.list(sectionId));
			mav.addObject("section", sectionsDAO.get(sectionId));
		}else{
			mav.addObject("articles", articlesDAO.list());
		}
		
		return mav;
	}
	
	public void setSectionsDAO(SectionDAO sectionsDAO) {
		this.sectionsDAO = sectionsDAO;
	}

	public void setArticlesDAO(ArticleDAO articlesDAO) {
		this.articlesDAO = articlesDAO;
	}
	
	
}
