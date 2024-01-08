package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoInterface;
import com.sunbeam.pojo.Movies;

public class MovieListBean {
	private int movie_id; 
	private int rating;
	private String title;
	private String review;
	public MovieListBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public void save() {
		// TODO Auto-generated method stub
		try(UserDaoInterface uid = new UserDao()){
			Movies movie = new Movies(movie_id, title, review);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
