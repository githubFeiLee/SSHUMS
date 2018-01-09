package com.qingshixun.dao;

import java.util.List;

import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;

public interface IJurisdictionDao {
	
	void saveJurisdiction(Jurisdiction jurisdiction);
	
	List<Jurisdiction> queryjurisdiction(Jurisdiction jurisdiction);
	
	List<Jurisdiction> queryjurisdiction();
	
	List<Role> queryAllRole();
	
	void removeJurisdiction(int jurisdictionId);
	
	Jurisdiction queryJurisdictions(int updateId);
	
	void updateJurisdiction(Jurisdiction jurisdiction);
	
	void BatchRemoveJurisdiction(List<Integer> checkedId);
}
