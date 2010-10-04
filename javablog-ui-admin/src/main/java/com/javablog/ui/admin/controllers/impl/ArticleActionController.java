package com.javablog.ui.admin.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.apache.log4j.Logger;

import com.javablog.core.entity.Article;
import com.javablog.core.storage.ArticleDAO;

public class ArticleActionController extends MultiActionController{
	
	private Logger logger = Logger.getLogger(ArticleActionController.class);
	
	private ArticleDAO articleDAO;
	
	private static final String ARTICLE_ID_PARAMETER = "aid";
	
	@Override
	protected ModelAndView handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("redirect:articles.shtml");
	}


    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	Integer articleId = ServletRequestUtils.getIntParameter(request, ARTICLE_ID_PARAMETER);
    	Article article = articleDAO.get(articleId);
    	if(article == null){
    		logger.error("Article not found in storage");
    		throw new Exception("Article not found in storage");
    	}
    	articleDAO.delete(articleId);
        
        return new ModelAndView("redirect:articles.shtml");
    }

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
}
