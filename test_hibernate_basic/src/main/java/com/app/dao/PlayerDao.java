package com.app.dao;

import com.app.pojos.Team;

public interface PlayerDao {
	String addPlayerDetails(Long teamId, Team newPlayer);
	
}
