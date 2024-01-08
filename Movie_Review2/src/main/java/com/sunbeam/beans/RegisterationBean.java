package com.sunbeam.beans;

import java.util.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtill;

public class RegisterationBean {
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;

	private String birth;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RegisterationBean() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addUser() {
	    try (UserDaoInterface userDao = new UserDao()) {
	    	System.out.println(this.birth);
	    	Date uDate = DateUtill.parse(birth);
	    	
	        User newUser = new User(0, firstName,lastName, email, password, uDate, mobile);
	        userDao.signUp(newUser);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}

	
}

