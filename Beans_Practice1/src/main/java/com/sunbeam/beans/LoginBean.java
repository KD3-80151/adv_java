package com.sunbeam.beans;

import org.apache.jasper.JasperException;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;

public class LoginBean {
	private String email;
	private String password;
	private boolean status;
	
	public LoginBean() {
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
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", password=" + password + ", status=" + status + "]";
	}

	public LoginBean(String email, String password, boolean status) {
		this.email = email;
		this.password = password;
		this.status = status;
	}
	
	public boolean authenticate() throws Exception{
		try(UserDaoInterface ud = new UserDao()){
			User u = ud.findByEmail(email);
			if (u != null && u.getPassword().equals(password)) {
				this.status = true;
			}
			return status;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new JasperException(e);
		}
	}
	
	
	
	
	
}
