package com.javablog.test;


import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.javablog.core.storage.jdbc.JDBCArticleDAO;
import com.javablog.core.storage.jdbc.JDBCWebsiteConfigurationDAO;


public class TestDAO extends AbstractDependencyInjectionSpringContextTests{

	protected JDBCArticleDAO articleDAO;
	
	protected JDBCWebsiteConfigurationDAO configurationDAO;
	
    public TestDAO() {
        // switch on field level injection
        setPopulateProtectedVariables(true);
    }

	protected String[] getConfigLocations() {
        return new String[] { "classpath:spring/applicationContext.xml" };
    }
	
	@Test	
	public void testArticlesDAO() throws Exception {
		System.out.println("List articles");
		System.out.println(articleDAO.get(1));
		Assert.assertNotNull(articleDAO.list());
	}
	
	@Test	
	public void testWebsiteConfiguratonDAO() throws Exception {
	}
	
}
