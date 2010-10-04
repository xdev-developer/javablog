package com.javablog.core.storage.jdbc;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.util.List;

import com.javablog.core.entity.Section;
import com.javablog.core.storage.SectionDAO;
import java.sql.SQLException;

public class JDBCSectionDAO implements SectionDAO {

    protected SqlMapClient sqlMap = null;

    public JDBCSectionDAO(SqlMapClient sqlMap) {
        this.sqlMap = sqlMap;
    }

    @Override
    public Section get(Integer id) throws SQLException {
        return (Section)sqlMap.queryForObject("section.getById", id);
    }

    @Override
    public Section get(String name) throws SQLException {
        return (Section)sqlMap.queryForObject("section.getByName", name);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Section> list() throws SQLException {
        return sqlMap.queryForList("section.list");
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Section> listWithArticles() throws SQLException {
        return sqlMap.queryForList("section.listWithArticles");
    }
    
    @Override
    public Integer add(Section section) throws SQLException{
        return (Integer)sqlMap.insert("section.add", section);
    }

    @Override
    public void save(Section section) throws SQLException {
        sqlMap.update("section.save", section);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        sqlMap.delete("section.delete", id);
    }

	@Override
	public Section getByUrl(String url) throws SQLException {
		return (Section)sqlMap.queryForObject("section.getByUrl", url);
	}
}
