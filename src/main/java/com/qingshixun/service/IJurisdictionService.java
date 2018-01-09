package com.qingshixun.service;

import java.util.List;

import com.qingshixun.model.Jurisdiction;

public interface IJurisdictionService {
	
	void saveJurisdiction(Jurisdiction jurisdiction);
	
	List<Jurisdiction> queryjurisdiction(Jurisdiction jurisdiction);
	
	void removeJurisdiction(int jurisdictionId);
	
	Jurisdiction queryJurisdictions(int updateId);
	
	void updateJurisdiction(Jurisdiction jurisdiction);
	
	void BatchRemoveJurisdiction(List<Integer> checkedId);
}
