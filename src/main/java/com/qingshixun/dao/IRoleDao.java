package com.qingshixun.dao;

import java.util.List;

import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;

public interface IRoleDao {
	
	void saveRole(Role role);
	
	List<Jurisdiction> queryJurisdiction(Jurisdiction jurisdiction);
	
	List<Role> queryRole(Role role);
	
	void removeRole(int roleId);
	
	Role queryUpdateRole(int updateRoleId);
	
	void saveOrUpdateRole(Role role);
	
	void batchRemoveRole(List<Integer> checkedId);
}
