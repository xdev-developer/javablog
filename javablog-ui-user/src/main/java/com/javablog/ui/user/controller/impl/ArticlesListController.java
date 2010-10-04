package com.javablog.ui.user.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.storage.ArticleDAO;
import com.javablog.core.storage.SectionDAO;

public class ArticlesListController extends AbstractController {

	private Logger logger = Logger.getLogger(ArticlesListController.class);
	
	private SectionDAO sectionDAO;
	
	private ArticleDAO articleDAO;

	private static final String SECTION_URL_PARAMETER = "su";
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		final ModelAndView mav = new ModelAndView("articles_list");
		
		String sectionUrl = ServletRequestUtils.getRequiredStringParameter(request, SECTION_URL_PARAMETER);
		mav.addObject("sections", sectionDAO.list());
		mav.addObject("currentSection", sectionDAO.getByUrl(sectionUrl));
		
		return mav;
	}
	/**
	 * @param sectionDAO the sectionDAO to set
	 */
	public void setSectionDAO(SectionDAO sectionDAO) {
		this.sectionDAO = sectionDAO;
	}
	/**
	 * @param articleDAO the articleDAO to set
	 */
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}	
}
