package com.app.dao;

import java.util.List;

import com.app.pojos.Team;


public interface TeamDao {
//add a method to add new team
	String addNewTeam(Team newTeam);
	
	List<Team> getAllTeamByIdAndAbbr();
	//2
	Team getEmpDetailsById(Integer teamId);
	
	List<Team> getMaxAge(int maxAge, int wicket_taken);
	
	String updateMaxAge (String team_name, int max_age, double bat_avg);
	
	String delTeamById (Integer teamId);
	
}
