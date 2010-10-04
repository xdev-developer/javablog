package com.javablog.core.storage;

import java.sql.SQLException;
import java.util.List;

import com.javablog.core.entity.User;

public interface UserDAO {
	
	public User login(String username, String password) throws SQLException;
	
	public List<User> list() throws SQLException;
	
	public User getById(Integer id) throws SQLException;
	
	public User getByEmail(String email) throws SQLException;
	
	public User getByUsername(String username) throws SQLException;
	
	public Integer addUser(User user) throws SQLException;
	
	public void delete(Integer id) throws SQLException;
	
	public void save(User user) throws SQLException;
}
