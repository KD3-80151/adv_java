package com.sunbeam.tester;

import java.util.List;
import java.util.Scanner;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.User;
import com.sunbeam.utils.DateUtil;


public class Main {
	public static Scanner sc;
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		userOperations();
		sc.close();
	}
	
	public static void userOperations() throws Exception {
		User curUser = null;
		int choice;
		do {
			System.out.print("\n1. Sign Up\n2. Sign In\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 0: // Exit
				System.out.println("Bye!");
				break;
			case 1: // Sign Up	
				signUp();
				break;
			case 2: 
				curUser = signIn();
				if(curUser != null) {
					if(curUser.getEmail().equals(curUser));
						adminOperations(curUser);
				}
				break;
			}
		}while(choice != 0);
	}

	public static void signUp() {
	    System.out.print("First Name: ");
	    String fname = sc.next();
	    System.out.print("Last Name: ");
	    String lname = sc.next();
	    System.out.print("Email: ");
	    String email = sc.next();
	    System.out.print("Password: ");
	    String passwd = sc.next();
	    System.out.print("Mobile Number: ");
	    String mob = sc.next();
	    System.out.print("Birth Date (dd-MM-yyyy): ");
	    String dateStr = sc.next();

	    User voter = new User(0, fname, lname, email, passwd, mob, DateUtil.parse(dateStr));
	    try (UserDao dao = new UserDao()) {
	        int count = dao.save(voter);
	        System.out.println("Voter registered: " + count);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }		
	}
	
	public static User signIn() {
		String email;
		String password;
		System.out.print("Enter email: ");
		email = sc.next();
		System.out.print("Enter password: ");
		password = sc.next();
		try(UserDao dao = new UserDao()) {
			User user = dao.findByEmail(email);
			if(user != null && password.equals(user.getPassword()))
				return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void adminOperations(User curUser) throws Exception {
		int choice;
		do {
			System.out.print("\n0. Log out\n1. Edit Profile\n2. Change Password"
					+ "\n3. Write a Review \n4. Edit Review\n5. Display all Movies"
					+ "\n6. Dis6paly all Review\n7 Display my review\n8. display review share with me"
					+ "\n9. Share a review \n10.delete a review  \nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 0: // Log out
				System.out.println("Bye!");
				break;
			case 1: //TODO Edit profiles
				System.out.println("1. update the 1st Name");
				String st= sc.next();
				System.out.println("2. update the  last Name");
				String st2=sc.next();
				System.out.println("3 update mobile number");
				String st3=sc.next();
				curUser.setLast_name(st2);
				curUser.setFirst_name(st);
				curUser.setMobile(st3);
				try {
					UserDao d= new UserDao();
					d.editProfile(curUser);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				break;
			case 2: 
				System.out.println("Update password");
				String st1= sc.next();
				curUser.setPassword(st1);
				try {
					UserDao d1= new UserDao();
					d1.editPassword(curUser);
					System.out.println("Password updated Successfully");
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
				break;
			case 3:
				try (MovieDao movieDao = new MovieDao()) {
                    movieDao.displayAllMovies();
                } catch (Exception e) {
                    e.printStackTrace();
                }
			    System.out.println("Enter movie_id: ");
			    int movieId = sc.nextInt();
			    System.out.println("Enter review: ");
			    String reviewText = sc.next();
			    System.out.println("Enter rating: ");
			    int rating = sc.nextInt();
			    System.out.println("Enter modified date (yyyy-MM-dd): ");
			    String modifiedDate = sc.next();

			    Reviews review = new Reviews(0, movieId, reviewText, rating, curUser.getId(), modifiedDate);

			    try (MovieDao movieDao = new MovieDao()) {
			        movieDao.saveReview(review);
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    break;

			case 4: 
				try (ReviewDao rD = new ReviewDao()) {
			        List<Reviews> reviews = rD.getAllReviews();
			        for (Reviews r : reviews) {
			            System.out.println("Review ID: " + r.getId() + ", Movie ID: " + r.getMovie_id() +
			                    ", Rating: " + r.getRating() + ", Review: " + r.getReview());
			        }
			        System.out.println("Enter the review ID you want to edit: ");
			        int reviewIdToEdit = sc.nextInt();
			        
			        Reviews eR = rD.getReviewById(reviewIdToEdit);

			        if (eR != null) {
			            System.out.println("Existing Review: " + eR);

			            System.out.println("Enter new review: ");
			            String nRt = sc.next();
			            System.out.println("Enter new rating: ");
			            int nR = sc.nextInt();
			            System.out.println("Enter new modified date (yyyy-MM-dd): ");
			            String newModifiedDate = sc.next();

			            eR.setReview(nRt);
			            eR.setRating(nR);
			            eR.setModified(newModifiedDate);

			            int updateCount = rD.updateReview(eR);

			            if (updateCount > 0) {
			                System.out.println("Review updated successfully!");
			            } else {
			                System.out.println("Failed to update review.");
			            }
			        } else {
			            System.out.println("Review not found with the given ID.");
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
				
				break;
			case 5:
				try (MovieDao movieDao = new MovieDao()) {
                    movieDao.displayAllMovies();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
			case 6:
			    try (ReviewDao rd = new ReviewDao()) {
			        List<Reviews> reviews = rd.allReviews();
			        for (Reviews r : reviews) {
			            System.out.println(r);
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    break;

			case 7:
				try (ReviewDao rd= new ReviewDao()){
					rd.myReview(curUser);
				}catch (Exception e) {
					e.printStackTrace();
				}		
				break;

			case 8:
			    try (ReviewDao rd = new ReviewDao()) {
			        List<Reviews> sharedReviews = rd.getSharedReviews(curUser.getId());
			        for (Reviews r : sharedReviews) {
			            System.out.println("Shared Review ID: " + r.getId() + ", Movie ID: " + r.getMovie_id() +
			                    ", Rating: " + r.getRating() + ", Review: " + r.getReview());
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    break;

			case 9:
			    try (ReviewDao rd = new ReviewDao()) {
			        System.out.println("Enter the review ID you want to share: ");
			        int reviewIdToShare = sc.nextInt();

			        int shareCount = rd.shareReview(reviewIdToShare, curUser.getId());

			        if (shareCount > 0) {
			            System.out.println("Review shared successfully!");
			        } else {
			            System.out.println("Failed to share review.");
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    break;

			

			case 10: 
				ReviewDao rd = new ReviewDao();
					System.out.println("Enter the Review_id  you want to delete");
					int review_id = sc.nextInt();
					rd.deleteById(review_id);
					System.out.println("successfully deleted");
					
					
				
				break;
			}
		}while(choice != 0);		
	}
}