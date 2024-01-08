package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;

public class LoginBean {
	private String email;
	private String password;
	private boolean status;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void Login() {
		try(UserDaoInterface userDao = new UserDao()){
			User user = userDao.signIn(email);
			if(user != null && user.getPassword().equals(password))
				setStatus(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
