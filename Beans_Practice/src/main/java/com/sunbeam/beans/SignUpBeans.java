package com.sunbeam.beans;

import java.util.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.User;
import com.sunbeam.util.DateUtill;

public class SignUpBeans {
	private String fname;
	private String lname;
	private String email;
	private String passwd;
	private String bday;
	private String mobile;
	 
	public SignUpBeans() {
		// TODO Auto-generated constructor stub
	}	
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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


	public String getBday() {
		return bday;
	}


	public void setBday(String bday) {
		this.bday = bday;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public void register() throws Exception {
	    // TODO Auto-generated method stub
		System.out.println("upto here");
	    try(UserDaoInterface userDao = new UserDao()) {
	    	Date udate= DateUtill.parse(this.bday);
	    	User user = new User();
	    	System.out.println(bday);
	    	System.out.println(fname);
	        user.setFirstName(fname);
	        user.setLastName(lname);
	        user.setEmail(email);
	        user.setMobile(mobile);
	        user.setBirth(udate);
	        user.setPassword(passwd);
	        
	        userDao.signUp(user);   
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
