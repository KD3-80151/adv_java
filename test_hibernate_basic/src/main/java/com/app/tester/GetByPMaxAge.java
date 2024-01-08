package com.app.tester;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;


public class GetByPMaxAge {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			TeamDaoImpl dao = new TeamDaoImpl();
			System.out.println("Enter max age and wickets taken");
			dao.getMaxAge(sc.nextInt(), sc.nextInt())
				.forEach(System.out::println);
					
		} // JVM : sc.close , sf.close=> DBCP is clened up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
