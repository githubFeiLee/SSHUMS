package com.qingshixun.service;

import java.util.List;
import com.qingshixun.dao.impl.BaseDao;
import com.qingshixun.model.Department;
import com.qingshixun.model.Role;
import com.qingshixun.model.User;

public interface IUserService extends BaseDao<User>{
	
    List<User> findAll();
    
	int queryUserPassword(String username, String phone);
	
	User queryUserLogin(String username);
	
	List<User> queryLikeUser(String name, int pageNow, int pageSize);
	
	int userLikeSize(String name);
	
	boolean saveUser(User user);

	void removeUser(int userid);

	User queryUserUpdate(int updateid);

	void batchDeleteUser(List<Integer> checkedId);

	void updateUser(User user);

	List<User> queryAllUser(int page, int pageSize);
	
	List<Department> queryDepartment(Department department, int updateid);
	
	List<Role> queryRole(Role role, int updateid);
	
    List<Department> queryDepartments(Department department);
	
	List<Role> queryRoles(Role role);
	
	int userSize();
	
	int usernameVerification(String name);
}
