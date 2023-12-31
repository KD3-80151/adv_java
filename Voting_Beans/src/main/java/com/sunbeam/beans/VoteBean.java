package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

public class VoteBean {
	private int candId;
	private int userId;
	private String message;
	public VoteBean() {
		// TODO Auto-generated constructor stub
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void registerVote() {
		// TODO Auto-generated method stub
		try(UserDao userDao = new UserDaoImpl()){
			User user = userDao.findById(userId);
			if(user.getStatus()!=0) {
				this.message="Already Voted";
				return;
			}
			try (CandidateDao candDao = new CandidateDaoImpl()){
				int count = candDao.incrementVote(candId);
				if(count==1) {
					count = userDao.updateStatus(userId, true);
					if(count ==1)
						this.message = "successfully voted";
				}
				if(count==0) {
					this.message = "Failed";
				}
			}			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}