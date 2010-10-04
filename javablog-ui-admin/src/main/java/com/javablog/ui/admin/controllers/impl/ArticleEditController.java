package com.javablog.ui.admin.controllers.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.javablog.core.entity.Article;
import com.javablog.core.entity.Section;
import com.javablog.core.entity.WebsiteConfiguration;
import com.javablog.core.storage.ArticleDAO;
import com.javablog.core.storage.SectionDAO;
import com.javablog.core.storage.WebsiteConfigurationDAO;

public class ArticleEditController extends SimpleFormController{

    private Logger logger = Logger.getLogger(ArticleEditController.class);
    
    private SectionDAO sectionsDAO;

	private ArticleDAO articleDAO;
	
	private WebsiteConfigurationDAO websiteConfigurationDAO;

	private static final String SECTION_ID_PARAMETER = "sid";
	
    private static final String ARTICLE_ID_PARAMETER = "id";

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

    	Integer articleId = ServletRequestUtils.getIntParameter(request, ARTICLE_ID_PARAMETER, -1);
        if (articleId != -1) {
            return articleDAO.get(articleId);
        }
        
    	Integer sectionId = ServletRequestUtils.getIntParameter(request, SECTION_ID_PARAMETER, -1);
    	Section section = sectionsDAO.get(sectionId);

    	if(section == null){
    		throw new Exception("Section not found in storage!");
    	}
    	
    	return new Article(-1, sectionId);

    }

    @Override
    protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception {

    	Integer sectionId = ServletRequestUtils.getIntParameter(request, SECTION_ID_PARAMETER, -1);
    	Section section = sectionsDAO.get(sectionId);

    	if(section == null){
    		throw new Exception("Section not found in storage!");
    	}
    	
    	Map<String, Object>  attributes = new HashMap<String, Object>(1);
    	attributes.put("section", section);
    	return attributes;
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        Article article = (Article) command;
        logger.info("Submit article " + article);
        if (article.getId() > 0) {
        	logger.info("Save article");
        	articleDAO.save(article);
        } else {
        	logger.info("Add article");
        	WebsiteConfiguration websiteConfiguration = websiteConfigurationDAO.getDefault();
        	article.setAuthor(websiteConfiguration.getDefaultArticleAuthor());
        	articleDAO.add(article);
        }
        return new ModelAndView(getSuccessView());
    }	
    
	public void setSectionsDAO(SectionDAO sectionsDAO) {
		this.sectionsDAO = sectionsDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
    public void setWebsiteConfigurationDAO(
			WebsiteConfigurationDAO websiteConfigurationDAO) {
		this.websiteConfigurationDAO = websiteConfigurationDAO;
	}
	
}
