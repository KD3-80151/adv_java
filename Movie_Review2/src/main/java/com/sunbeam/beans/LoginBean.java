package com.sunbeam.beans;


import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	private int status;
	
	public LoginBean() {
		this.user=null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void authenticate() {
		// TODO Auto-generated method stub
		try(UserDaoInterface userDao = new UserDao()){
			User u = userDao.signIn(email);
			System.out.println("Email "+ email + "Password "+ passwd);
			if(u != null && u.getPassword().equals(passwd))
				this.user=u;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}



	
}
