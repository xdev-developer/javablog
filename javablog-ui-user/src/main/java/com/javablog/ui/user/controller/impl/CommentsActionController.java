package com.javablog.ui.user.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.javablog.core.entity.Article;
import com.javablog.core.entity.Comment;
import com.javablog.core.storage.ArticleDAO;
import com.javablog.core.storage.CommentsDAO;

public class CommentsActionController extends MultiActionController {

	private Logger logger = Logger.getLogger(CommentsActionController.class);

	private ArticleDAO articleDAO;

	private CommentsDAO<Integer> commentsDAO;

	private static final String ARTICLE_ID_PARAMETER = "aid";
	
	private static final String COMMENT_ID_PARAMETER = "cid";
	
	private static final String VIEW_ARTICLE_URL_PATTERN = "/sections/%s/%d/#last_comment";

	@Override
	protected ModelAndView handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("redirect:/home/");
	}
    
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)throws Exception {

		Integer articleId = ServletRequestUtils.getIntParameter(request, ARTICLE_ID_PARAMETER, -1);
		String text = ServletRequestUtils.getStringParameter(request, "comment", "");
		String author = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Article article = articleDAO.get(articleId);
		if(article == null){
			logger.error("Article not found in storage");
			return new ModelAndView("redirect:/home/");
		}
		//Create redirect url in article
		String redirectURL = String.format(VIEW_ARTICLE_URL_PATTERN, article.getSection().getUrl(), articleId);
		if(text.equals("")){
			return new ModelAndView("redirect:" + redirectURL);
		}
		//Add comment
		Comment<Integer> comment = new Comment<Integer>();
		comment.setArticleId(articleId);
		comment.setText(text);
		comment.setAuthor(author);
		
		try{
			commentsDAO.add(comment);
		}catch(Exception e){
			logger.error(e, e);
			return new ModelAndView("redirect:" + redirectURL);
		}
    	return new ModelAndView("redirect:" + redirectURL);
    }

    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	
    	Integer commentId = ServletRequestUtils.getIntParameter(request, COMMENT_ID_PARAMETER, -1);
		Comment<Integer> comment = commentsDAO.getById(commentId);
		
		if(comment == null){
			logger.error("Comment not found in storage");
			return new ModelAndView("redirect:/home/");
		}

		Article article = articleDAO.get(comment.getArticleId());
		if(article == null){
			logger.error("Article not found in storage");
			return new ModelAndView("redirect:/home/");
		}
		final ModelAndView mav = new ModelAndView("comment_editor");
		mav.addObject("article", article);
		mav.addObject("comment", comment);

		return mav;
    }

    public ModelAndView save(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	Integer articleId = ServletRequestUtils.getIntParameter(request, ARTICLE_ID_PARAMETER, -1);
    	Integer commentId = ServletRequestUtils.getIntParameter(request, COMMENT_ID_PARAMETER, -1);
		String text = ServletRequestUtils.getStringParameter(request, "comment", "");

		Article article = articleDAO.get(articleId);
		if(article == null){
			logger.error("Article not found in storage");
			return new ModelAndView("redirect:/home/");
		}
    	//Create redirect url in article
		String redirectURL = String.format(VIEW_ARTICLE_URL_PATTERN, article.getSection().getUrl(), articleId);
		try{
			Comment<Integer> comment = commentsDAO.getById(commentId);
			comment.setText(text);
			commentsDAO.save(comment);
		}catch(Exception e){
			logger.error(e, e);
		}
		return new ModelAndView("redirect:" + redirectURL);
    }

    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)throws Exception {
    	Integer commentId = ServletRequestUtils.getIntParameter(request, COMMENT_ID_PARAMETER, -1);

		Comment<Integer> comment = commentsDAO.getById(commentId);
		
		if(comment == null){
			logger.error("Comment not found in storage");
			return new ModelAndView("redirect:/home/");
		}

		Article article = articleDAO.get(comment.getArticleId());
		if(article == null){
			logger.error("Article not found in storage");
			return new ModelAndView("redirect:/home/");
		}
    	//Create redirect url in article
		String redirectURL = String.format(VIEW_ARTICLE_URL_PATTERN, article.getSection().getUrl(), article.getId());

		try{
			commentsDAO.delete(commentId);
		}catch(Exception e){
			logger.error(e, e);
		}
		return new ModelAndView("redirect:" + redirectURL);
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
