package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.sunbeam.pojo.User;
import com.sunbeam.utils.DateUtil;

public class UserDao extends Dao {
	
	public UserDao() throws Exception {
	}
	
	public int save(User u) throws Exception {
		String sql = "INSERT INTO users VALUES(default, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirst_name());
			stmt.setString(2, u.getLast_name());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getMobile());
			stmt.setDate(6, DateUtil.utilToSqlDate(u.getBirth()));
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}
	
	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					String mob = rs.getString("mobile");
					
					Date uDate = DateUtil.sqlToUtilDate(rs.getDate("birth"));
					return new User(id, fname, lname, email, password, mob, uDate);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	
	public int  editProfile(User user)
    {
    	int ch=0;
        
        	
        	String str= "update users set first_name = ?, last_name=?, mobile=? where email=?";
        	try(PreparedStatement pst=con.prepareStatement(str)){
        		  pst.setString(1, user.getFirst_name());
        		  pst.setString(4, user.getEmail());
        		  pst.setString(2, user.getLast_name());
        		  pst.setString(3, user.getMobile());
        		  ch=pst.executeUpdate();
        	}catch (Exception e) {
				e.printStackTrace();
			}
       
        return ch;
    }
	
	public int editPassword(User user)
    {
   	 int ch=0;
   	 String str="UPDATE users set password=? where email=?";
   	 try(PreparedStatement ptr=con.prepareStatement(str))
   	 {
   		 ptr.setString(1, user.getPassword());
   		 ptr.setString(2, user.getEmail());
   		 ch=ptr.executeUpdate();
   		 
   		 
   	 }catch (Exception e) {
   		 e.printStackTrace();
			// TODO: handle exception
		}
   	 return ch;
    }
	
}