package com.qingshixun.dao;

import java.util.List;

import com.qingshixun.model.Department;
import com.qingshixun.model.Role;
import com.qingshixun.model.User;

public interface IUserDao {
	
	User queryUserLogin(String username);
	
	List<User> queryLikeUser(String name, int pageNow, int pageSize);
	
	int userLikeSize(String name);
	
	boolean saveUser(User user);
	
	List<Role> queryRole(Role role);
	
	void removeUser(int userid);
	
	void batchDeleteUser(List<Integer> checkedId);
	
	User queryUpdateUser(int updateid);
	
	void updateUser(User user);
	
	List<User> queryAllUser(int pageNow, int pageSize);
	
	int userSize();
	
	int usernameVerification(String name);
	
	List<Department> queryDepartment(Department department);
}
