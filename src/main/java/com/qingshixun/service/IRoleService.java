package com.qingshixun.service;

import java.util.List;

import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;

public interface IRoleService {
	
	void saveRole(Role role);
	
	List<Jurisdiction> queryJurisdiction(Jurisdiction jurisdiction, int updateRoleId);
	
	List<Jurisdiction> queryJurisdictions(Jurisdiction jurisdiction);
	
	List<Role> queryRole(Role role);
		
	void removeRole(int roleId);
	
	Role queryUpdateRole(int updateRoleId);
	
	void saveOrUpdateRole(Role role);
	
	void batchRemoveRole(List<Integer> checkedId);
}
