package com.javablog.core.storage;

import java.sql.SQLException;
import java.util.List;

import com.javablog.core.entity.Comment;

public interface CommentsDAO<AbstractID> {

	public Comment<AbstractID> getById(AbstractID id) throws SQLException;
	
	public List<Comment<AbstractID>> getByArticleId(AbstractID id) throws SQLException;
	
	public List<Comment<AbstractID>> list() throws SQLException;
	
	public AbstractID add(Comment<AbstractID> comment) throws SQLException;
	
	public void save(Comment<AbstractID> comment) throws SQLException;

	public void delete(AbstractID id) throws SQLException;
	
}
