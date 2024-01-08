package com.app.dao;

import com.app.pojos.Player;
import com.app.pojos.Team;
import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addPlayerDetails(Long teamId, Team newPlayer) {
		
		String mesg = "Adding emp failed!!!!";
		Session session = getFactory().getCurrentSession();
	
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			if (team != null) {
				//?????????? here is the error
				team.addPlayer(null);
				
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
//newEmp : DETACHED => from L1 cache.
		return mesg;
	}
	

}
