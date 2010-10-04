package com.javablog.core.storage;

import java.sql.SQLException;
import java.util.List;

import com.javablog.core.entity.Article;

public interface ArticleDAO {

	public List<Article> list() throws SQLException;
	
	public List<Article> listLastCreated() throws SQLException;

	public List<Article> list(Integer sectionId) throws SQLException;
	
	public List<Article> listMostCommented() throws SQLException;
	
	public Article get(Integer id) throws SQLException;
	
	public Integer add(Article article) throws SQLException;

	public void save(Article article) throws SQLException;

	public void delete(Integer id) throws SQLException;

}
