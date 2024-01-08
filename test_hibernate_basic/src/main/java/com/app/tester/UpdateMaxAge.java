package com.app.tester;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;

public class UpdateMaxAge {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			TeamDaoImpl dao = new TeamDaoImpl();
			
			System.out.println("Enter Team name"+ dao.updateMaxAge(sc.next(), 
					sc.nextInt(), sc.nextDouble()));

		}
		catch (Exception e) {
			e.printStackTrace();

}
}
}
