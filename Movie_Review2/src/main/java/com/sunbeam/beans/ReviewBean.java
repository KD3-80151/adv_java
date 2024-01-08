package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Review_Movie;

public class ReviewBean {
	private List <Review_Movie> revMov;
	public ReviewBean() {
		// TODO Auto-generated constructor stub
	}
	public List<Review_Movie> getRevMov() {
		return revMov;
	}
	public void setRevMov(List<Review_Movie> revMov) {
		this.revMov = revMov;
	}
	
	public void fetchReview() {
		// TODO Auto-generated method stub
		try(UserDaoInterface revDao = new UserDao()){
			revMov=revDao.displayAllReviews();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
