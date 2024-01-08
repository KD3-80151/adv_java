package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBean {
private List<Candidate> candList;

public ResultBean() {
	this.candList= new ArrayList<Candidate>();
	// TODO Auto-generated constructor stub
}

public List<Candidate> getCandList() {
	return candList;
}

public void setCandList(List<Candidate> candList) {
	this.candList = candList;
}

public void fetchResult() {
	// TODO Auto-generated method stub
	try(CandidateDao candDao = new CandidateDaoImpl()){
		candList = candDao.getCandidatewiseVotes();
	}catch(Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	}
}
