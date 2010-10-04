package com.javablog.core.storage.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.javablog.core.entity.Article;
import com.javablog.core.storage.ArticleDAO;

public class JDBCArticleDAO implements ArticleDAO{

	protected SqlMapClient sqlMap = null;
	
	public JDBCArticleDAO(SqlMapClient sqlMap) {
        this.sqlMap = sqlMap;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> list(Integer sectionId) throws SQLException {
		return sqlMap.queryForList("article.getBySectionId", sectionId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> list() throws SQLException{
        return sqlMap.queryForList("article.list");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listLastCreated() throws SQLException{
		return sqlMap.queryForList("article.list");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listMostCommented() throws SQLException{
		return sqlMap.queryForList("article.listMostCommented");
	}

	@Override
	public Article get(Integer id) throws SQLException{
        return (Article)sqlMap.queryForObject("article.getById", id);
	}

	@Override
	public Integer add(Article article) throws SQLException {
        return (Integer)sqlMap.insert("article.add", article);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		sqlMap.delete("article.delete", id);
	}

	@Override
	public void save(Article article) throws SQLException {
		sqlMap.update("article.save", article);
	}
}
