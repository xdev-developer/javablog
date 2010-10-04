package com.javablog.ui.user.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.storage.ArticleDAO;
import com.javablog.core.storage.SectionDAO;

public class HomeController extends AbstractController{

	private Logger logger = Logger.getLogger(HomeController.class);
	
	private SectionDAO sectionDAO;
	
	private ArticleDAO articleDAO;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final ModelAndView mav = new ModelAndView("home");
		mav.addObject("sections", sectionDAO.list());
		mav.addObject("articles", articleDAO.list());
		//mav.addObject("mostCommentedArticles", articleDAO.listMostCommented());
		
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
