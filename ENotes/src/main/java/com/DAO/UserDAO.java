package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Bean.UserBean;
import com.Db.DBConnection;

public class UserDAO {

	public boolean addUser(UserBean ub) {
		boolean f = false;
		try {
			Connection con = DBConnection.getCon();
			String query = "insert into ENotes (User_Name,User_Email,User_Password) values(?,?,?)";
			// Using Database Connection
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getPassword());
			int k = ps.executeUpdate();
			if (k == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public UserBean loginUser(UserBean ub) {
		
		UserBean user = null;
		
		try {
			Connection con = DBConnection.getCon();
			String query = "Select * from ENotes where USER_EMAIL = ? and USER_PASSWORD = ?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ub.getEmail());
			ps.setString(2, ub.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new UserBean();
				user.setId(rs.getInt("USER_ID"));
				user.setName(rs.getString("USER_NAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setPassword(rs.getString("USER_PASSWORD"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
