package com.app.pojos;
import java.util.ArrayList;

import javax.persistence.*;


import java.util.List;


@Entity
@Table(name="teams")
public class Team extends BaseEntity{	
	
	@Column(length =100, unique = true)
	private String name;
	private String abbreviation;
	@Column(length=20)
	private String owner;
	private int maxAge;
	@Column(name="batting_avg")
	private double battingAvg;
	private int wickets_taken;
	
	@OneToMany(mappedBy = "myTeam" , cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER)
	private List<Player> player = new ArrayList<>();
	
	@JoinColumn(name = "owner_id", nullable = false)
	@OneToOne
	@MapsId
	private Owner teamOwner;
	
	public Team() {
	
		// TODO Auto-generated constructor stub
		}
	//why teamId constructor parameter is not taken

	public Team(String name, String abbreviation, String owner, int maxAge, double battingAvg, int wickets_taken) {
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wickets_taken = wickets_taken;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWickets_taken() {
		return wickets_taken;
	}

	public void setWickets_taken(int wickets_taken) {
		this.wickets_taken = wickets_taken;
	}
	
	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}
	
	public void addPlayer(Player ply)
	{
		player.add(ply);
		ply.setMyTeam(this);
	}

	@Override
	public String toString() {
		return "Team"+getId()+ "[ name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wickets_taken=" + wickets_taken + "]";
	}

	
	
}
