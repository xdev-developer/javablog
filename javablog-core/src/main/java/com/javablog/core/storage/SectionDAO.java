package com.javablog.core.storage;

import java.util.List;

import com.javablog.core.entity.Section;
import java.sql.SQLException;

public interface SectionDAO {
	
	public List<Section> list() throws SQLException;
	
	public List<Section> listWithArticles() throws SQLException;
	
	public Section get(Integer id) throws SQLException;
	
	public Section get(String name) throws SQLException;

	public Integer add(Section section) throws SQLException;

	public void save(Section section) throws SQLException;

	public void delete(Integer id) throws SQLException;
	
	public Section getByUrl(String url) throws SQLException;
}
