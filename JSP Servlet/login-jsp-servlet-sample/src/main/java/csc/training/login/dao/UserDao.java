package csc.training.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import csc.training.login.model.User;
import csc.training.login.util.DateUtil;
import csc.training.login.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public int addUser(User user) {
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("insert into members(first_name, last_name, email, uname, pass, regdate) values (?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUserName());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setDate(6, DateUtil.getSQLDate());
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
			}
		}
		
		return result;
	}


	public boolean checkLoginUser(String username, String password) {
		boolean result = false;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("select * from members where uname=? and pass=? ");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				preparedStatement.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}
	
	public User getUserById(String userId) {
		User user = new User();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("select * from members where uname=?");
			preparedStatement.setString(1, userId);
			rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				preparedStatement.close();
			} catch (SQLException e) {
			}
		}

		return user;
	}
}
