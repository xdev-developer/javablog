package com.javablog.core.storage.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.javablog.core.entity.Comment;
import com.javablog.core.storage.CommentsDAO;

public class JDBCCommentsDAO implements CommentsDAO<Integer> {

	protected SqlMapClient sqlMap = null;
	
	public JDBCCommentsDAO(SqlMapClient sqlMap) {
        this.sqlMap = sqlMap;
	}
	
	@Override
	public Integer add(Comment<Integer> comment) throws SQLException {
		return (Integer)sqlMap.insert("comments.add", comment);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		sqlMap.delete("comments.delete", id);
	}

	@Override
	public Comment<Integer> getById(Integer id) throws SQLException {
		return (Comment<Integer>)sqlMap.queryForObject("comments.getById", id);
	}

	@Override
	public List<Comment<Integer>> getByArticleId(Integer id) throws SQLException {
		return (List<Comment<Integer>>)sqlMap.queryForList("comments.getByArticleId", id);
	}

	@Override
	public List<Comment<Integer>> list() throws SQLException {
		return sqlMap.queryForList("comments.list");
	}

	@Override
	public void save(Comment<Integer> comment) throws SQLException {
		sqlMap.update("comments.save", comment);
	}

}
