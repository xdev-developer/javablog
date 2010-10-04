package com.javablog.ui.user.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.javablog.core.entity.Article;
import com.javablog.core.storage.ArticleDAO;
import com.javablog.core.storage.CommentsDAO;
import com.javablog.core.storage.SectionDAO;

public class ArticleViewController extends AbstractController {

	private Logger logger = Logger.getLogger(ArticleViewController.class);
	
	private ArticleDAO articleDAO;

	private SectionDAO sectionDAO;
	
	private CommentsDAO<Integer> commentsDAO;

	private static final String ARTICLE_ID_PARAMETER = "id";

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		final ModelAndView mav = new ModelAndView("view_article");
		
		Integer articleId = ServletRequestUtils.getRequiredIntParameter(request, ARTICLE_ID_PARAMETER);
		
		Article article = articleDAO.get(articleId);
		mav.addObject("sections", sectionDAO.list());
		mav.addObject("article", article);
		mav.addObject("currentSection", article.getSection());
		mav.addObject("comments", commentsDAO.getByArticleId(articleId));
		
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
	
	public void setCommentsDAO(CommentsDAO<Integer> commentsDAO) {
		this.commentsDAO = commentsDAO;
	}
}
