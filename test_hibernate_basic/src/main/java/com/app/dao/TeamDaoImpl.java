package com.app.dao;
import com.app.pojos.Team;
import org.hibernate.*;
import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addNewTeam(Team newTeam) {
		String mesg = "Adding team failed";
		Session session =getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable teamId = session.save(newTeam);
			tx.commit();
			mesg ="Added team details with ID= "
					+teamId;
		}catch (RuntimeException e) {
			if(tx!= null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	
	@Override
	public Team getEmpDetailsById(Integer teamId) {
		Team emp = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			emp = session.get(Team.class, teamId);// up casting
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emp;// emp : DETACHED
	}
	
	@Override
	public List<Team> getAllTeamByIdAndAbbr() {
		// TODO Auto-generated method stub
		List<Team> teams = null;
		String jpql = "select new com.app.pojos.Team(teamId,abbreviation) from Team t";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return teams ;
	}


	@Override
	public List<Team> getMaxAge(int maxAge, int wicket_taken) {
		// TODO Auto-generated method stub
		List<Team> teams = null;
		String jpql= "select t from Team t where t.maxAge < :age and t.wickets_taken > :wkts";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			teams= session.createQuery(jpql, Team.class).setParameter("age", maxAge)
					.setParameter("wkts", wicket_taken).getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		
	}
		return teams;
	}


	@Override
	public String updateMaxAge(String team_name, int max_age, double bat_avg) {
		// TODO Auto-generated method stub
		String mesg = "sal updation failed!!!!";
		String jpql = "select t from Team t where t.name=:teamName";
		Team t =null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			t = session.createQuery(jpql, Team.class)
					.setParameter("teamName", team_name)
					.getSingleResult();
			t.setBattingAvg(bat_avg);
			t.setMaxAge(max_age);
			
			tx.commit();
			mesg = "Updated age is " + t.getMaxAge() + " of team " + t.getName();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}


	@Override
	public String delTeamById(Integer teamId) {
		String mesg = "emp deletion failed !!!!";
		Team team = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			team = session.get(Team.class, teamId);
			if (team != null) {
				session.delete(team);
				mesg="deleted emp details of "+team.getName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}
	
	
	
}
