package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDaoImpl;
import static com.app.utils.HibernateUtils.getFactory;

public class TeamIdnAbbr {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			
			TeamDaoImpl dao = new TeamDaoImpl();
			System.out.println("Emp List");
			dao.getAllTeamByIdAndAbbr().forEach(e -> System.out.println(e.getId()
					+" "+e.getAbbreviation()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
