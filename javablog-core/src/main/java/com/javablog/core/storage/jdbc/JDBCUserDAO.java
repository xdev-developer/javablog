package com.javablog.core.storage.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.javablog.core.entity.User;
import com.javablog.core.storage.UserDAO;

public class JDBCUserDAO implements UserDAO {

	protected SqlMapClient sqlMap = null;
	
    public JDBCUserDAO(SqlMapClient sqlMap) {
        this.sqlMap = sqlMap;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() throws SQLException {
		return sqlMap.queryForList("users.list");
	}

	@Override
	public User login(String username, String password) throws SQLException {
		
		Map<String, String> parameters = new HashMap<String, String>();
		
		parameters.put("username", username);
		parameters.put("password", password);
		
		return (User)sqlMap.queryForObject("users.loginUser", parameters);
	}

	@Override
	public Integer addUser(User user) throws SQLException {
		Integer id = (Integer)sqlMap.insert("users.add", user);
		//Add user default role
		sqlMap.insert("users.addDefaultRole", user);
		return id;
	}

	@Override
	public User getByEmail(String email) throws SQLException {
		return (User)sqlMap.queryForObject("users.getByEmail", email);
	}

	@Override
	public User getByUsername(String username) throws SQLException {
		return (User)sqlMap.queryForObject("users.getByUsername", username);
	}

	@Override
	public void delete(Integer id) throws SQLException {
		sqlMap.delete("users.delete", id);
	}

	@Override
	public void save(User user) throws SQLException {
		sqlMap.update("users.save", user);
	}

	@Override
	public User getById(Integer id) throws SQLException {
		return (User)sqlMap.queryForObject("users.getById", id);
	}
}
