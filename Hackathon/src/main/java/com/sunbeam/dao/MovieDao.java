package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojo.Movie;
import com.sunbeam.pojo.Reviews;

public class MovieDao extends Dao {

    public MovieDao() throws Exception {
        super();
    }

    public void displayAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        try (PreparedStatement ptr = con.prepareStatement(sql)) {
            try (ResultSet resultSet = ptr.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("movie_id");
                    String title = resultSet.getString("title");
                    String release = resultSet.getString("release_date");

                    Movie movie = new Movie(id, title, release);
                    movies.add(movie);
                }
            }
        }

            System.out.println("All Movies:");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
        }
    }
    
    public void saveReview(Reviews review) {
        ReviewDao reviewDao = null;

        try {
            reviewDao = new ReviewDao();
            int count = reviewDao.saveReview(review);

            if (count > 0) {
                System.out.println("Review added successfully!");
            } else {
                System.out.println("Failed to add review.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reviewDao != null) {
                try {
                    reviewDao.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}

