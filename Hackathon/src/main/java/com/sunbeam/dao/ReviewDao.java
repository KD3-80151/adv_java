package com.sunbeam.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;

public class ReviewDao extends Dao {

    public ReviewDao() throws Exception {
        super();
    }
    
    
    //10
    
    public int deleteById(int reviewId) throws Exception {
		String sql = "DELETE FROM reviews WHERE review_id=?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, reviewId);
			int count = stmt.executeUpdate();
			return count;
		}
	}
    //1.
    public int saveReview(Reviews review) {
        String sql = "INSERT INTO reviews (movie_id, review, rating, id, modified) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, review.getMovie_id());
            pstmt.setString(2, review.getReview());
            pstmt.setInt(3, review.getRating());
            pstmt.setInt(4, review.getUser_id());
            pstmt.setString(5, review.getModified());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int updateReview(Reviews review) {
        String sql = "UPDATE reviews SET review=?, rating=?, modified=? WHERE review_id=?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, review.getReview());
            pstmt.setInt(2, review.getRating());
            pstmt.setString(3, review.getModified());
            pstmt.setInt(4, review.getId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // 
    }
    //4.
    public List<Reviews> getAllReviews() {
        List<Reviews> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews";

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Reviews review = new Reviews(
                        rs.getInt("id"),
                        rs.getInt("movie_id"),
                        rs.getString("review"),
                        rs.getInt("rating"),
                        rs.getInt("id"),
                        rs.getString("modified")
                );
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }
//5.
    public Reviews getReviewById(int reviewId) {
        String sql = "SELECT * FROM reviews WHERE review_id = ?";
        Reviews review = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, reviewId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    review = new Reviews(
                            rs.getInt("id"),
                            rs.getInt("movie_id"),
                            rs.getString("review"),
                            rs.getInt("rating"),
                            rs.getInt("id"),
                            rs.getString("modified")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return review;
    }
    
    //6.
    public List<Reviews> allReviews() throws SQLException {
        List<Reviews> rev = new ArrayList<>();

        String sql = "SELECT * FROM reviews";
        try (PreparedStatement ptr = con.prepareStatement(sql)) {
            try (ResultSet rs = ptr.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int movieId = rs.getInt("movie_id");
                    String reviewText = rs.getString("review");
                    int rating = rs.getInt("rating");
                    int userId = rs.getInt("id");
                    Date modifiedDate = rs.getDate("modified");

                    java.util.Date r = new java.util.Date(modifiedDate.getTime());
                    SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                    String st = sd.format(r);

                    Reviews r2 = new Reviews(id, movieId, reviewText, rating, userId, st);
                    rev.add(r2);
                }
            }
        }
        return rev;
    }

    
    public List<Reviews> myReview(User user)
    {
   	 List<Reviews> list=new ArrayList<>();
   	 String str="Select * from reviews where id=?";
   	 try(PreparedStatement ptr=con.prepareStatement(str))
   	 {
   		  try(ResultSet rs=ptr.executeQuery()){
   			  while(rs.next())
   			  {
   				 int id =rs.getInt("review_id");
   				 int Movies_id=rs.getInt("movie_id");
   				 String review=rs.getString("review");
   				 int rating=rs.getInt("rating");
   				 int user_id=rs.getInt("id");
   				 Date sdate=rs.getDate("modified");
   				 java.util.Date uDate = new java.util.Date(sdate.getTime());
   				 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   				 String str7 = sdf.format(uDate);
   				 Reviews re=new Reviews(id, Movies_id, review, rating, user_id, str7);
   				 list.add(re);	
   			  }
   		  }	 
   	 }catch (Exception e) {
   		 e.printStackTrace();
			// TODO: handle exception
		}
   	 return list;
    }
    
        public int shareReview(int reviewId, int userId) {
            String sql = "INSERT INTO shares (review_id, user_id) VALUES (?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, reviewId);
                pstmt.setInt(2, userId);

                return pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return 0;
        }
        
        

        public List<Reviews> getSharedReviews(int userId) {
            List<Reviews> sharedReviews = new ArrayList<>();
            String sql = "SELECT r.* FROM reviews r " +
                         "JOIN shares s ON r.id = s.review_id " +
                         "WHERE s.user_id = ?";

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, userId);

                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Reviews review = new Reviews(
                                rs.getInt("review_id"),
                                rs.getInt("movie_id"),
                                rs.getString("review"),
                                rs.getInt("rating"),
                                rs.getInt("id"),
                                rs.getString("modified")
                        );
                        sharedReviews.add(review);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return sharedReviews;
        } 
}