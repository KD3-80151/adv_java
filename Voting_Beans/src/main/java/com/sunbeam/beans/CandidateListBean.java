package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> candList;

	public CandidateListBean() {
		// TODO Auto-generated constructor stub
		this.candList = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidateList() {
		// TODO Auto-generated method stub
		try(CandidateDao canDao = new CandidateDaoImpl()){
			candList = canDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
}
