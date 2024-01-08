package com.app.tester;
import org.hibernate.*;

import com.app.dao.TeamDaoImpl;
import com.app.pojos.Team;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class AddTeam {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory()){
			Scanner sc = new Scanner(System.in);
			TeamDaoImpl teamDao = new TeamDaoImpl();
			System.out.println("Team details: name, abberiviation, owner,"
					+ "maxAge, battingAvg, wicketsTaken ");
			Team newTeam = new Team(sc.next(), sc.next(),sc.next(),sc.nextInt(),
					sc.nextDouble(),sc.nextInt());
			System.out.println(teamDao.addNewTeam(newTeam));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}