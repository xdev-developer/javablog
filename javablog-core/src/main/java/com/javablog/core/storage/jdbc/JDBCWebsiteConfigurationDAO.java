package com.javablog.core.storage.jdbc;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.javablog.core.entity.WebsiteConfiguration;
import com.javablog.core.storage.WebsiteConfigurationDAO;

public class JDBCWebsiteConfigurationDAO implements WebsiteConfigurationDAO {

	protected SqlMapClient sqlMap = null;

	public static final String DEFAULT_SET = "DEFAULT";

	public JDBCWebsiteConfigurationDAO(SqlMapClient sqlMap) {
		this.sqlMap = sqlMap;
	}

	@Override
	public WebsiteConfiguration get(String configurationSetName)
			throws SQLException {
		return (WebsiteConfiguration) sqlMap.queryForObject(
				"websiteConfiguration.getBySetName", configurationSetName);
	}

	@Override
	public WebsiteConfiguration getDefault() throws SQLException {
		return (WebsiteConfiguration) sqlMap.queryForObject(
				"websiteConfiguration.getBySetName", DEFAULT_SET);
	}

	@Override
	public void save(WebsiteConfiguration websiteConfiguration)
			throws SQLException {
		sqlMap.update("websiteConfiguration.save", websiteConfiguration);
	}
}
