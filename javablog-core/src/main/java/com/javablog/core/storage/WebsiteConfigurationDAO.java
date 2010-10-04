package com.javablog.core.storage;

import java.sql.SQLException;

import com.javablog.core.entity.WebsiteConfiguration;

public interface WebsiteConfigurationDAO {
	
	public WebsiteConfiguration getDefault() throws SQLException;
	
	public WebsiteConfiguration get(String configurationSetName) throws SQLException;
	
	public void save(WebsiteConfiguration websiteConfiguration) throws SQLException;
}
