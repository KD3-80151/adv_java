package com.app.tester;
import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;

public class GetTeamDetailsById {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			TeamDaoImpl dao = new TeamDaoImpl();
			System.out.println("Enter Team id");
			System.out.println(dao.getEmpDetailsById(sc.nextInt()));// auto boxing
		} // JVM : sc.close , sf.close=> DBCP is clened up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
