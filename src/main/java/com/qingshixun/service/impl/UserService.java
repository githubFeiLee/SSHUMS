package com.qingshixun.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingshixun.dao.IUserDao;
import com.qingshixun.dao.impl.BaseDaoImpl;
import com.qingshixun.service.IUserService;
import com.qingshixun.model.Department;
import com.qingshixun.model.Role;
import com.qingshixun.model.User;

@Service("userService")
@Transactional
public class UserService extends BaseDaoImpl<User> implements IUserService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> findAll() {
		System.out.println("debug");
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	/**
	 * 通过用户名查询用户信息，并根据参数username、phone与用户信息比较，返回int型数值
	 */
	@Override
	public int queryUserPassword(String username, String phone) {
		User user = userDao.queryUserLogin(username);
		if (user != null) {
			if (phone.equals(user.getPhone())) {
				return -1;
			} else {
				return -2;
			}
		}
		return 0;
	}

	/**
	 * 通过用户名查询用户的登录信息
	 */
	@Override
	public User queryUserLogin(String username) {
		return userDao.queryUserLogin(username);
	}

	/**
	 * 添加用户信息
	 */
	@Override
	public boolean saveUser(User user) {
		if (user.equals(null)) {
			return false;
		}
		return userDao.saveUser(user);

	}

	/**
	 * 通过参数userid查询并删除对应用户信息
	 */
	@Override
	public void removeUser(int userid) {

		userDao.removeUser(userid);
	}

	/**
	 * 通过参数updateid查询对应的用户信息
	 */
	@Override
	public User queryUserUpdate(int updateid) {
		User updateuser = userDao.queryUpdateUser(updateid);
		return updateuser;
	}

	/**
	 * 修改并保存用户信息
	 */
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	/**
	 * 通过checkedId集合查询并删除对应集合的用户信息
	 */
	@Override
	public void batchDeleteUser(List<Integer> checkedId) {
		userDao.batchDeleteUser(checkedId);
	}

	/**
	 * 查询所有用户信息，实现分页
	 */
	@Override
	public List<User> queryAllUser(int page, int pageSize) {
		List<User> list = userDao.queryAllUser(page, pageSize);
		return list;
	}

	/**
	 * 查询用户数量
	 */
	@Override
	public int userSize() {
		return userDao.userSize();
	}

	/**
	 * 验证用户是否存在
	 */
	@Override
	public int usernameVerification(String name) {
		return userDao.usernameVerification(name);
	}

	/**
	 * 查询要修改的所有部门
	 */
	@Override
	public List<Department> queryDepartment(Department department, int updateid) {
		User updateUser = userDao.queryUpdateUser(updateid);
		List<Department> list = userDao.queryDepartment(department);
		for (Department department2 : list) {
			if (department2.getId() == updateUser.getDepartment().getId()) {
				department2.setUserDepartment(true);
				break;
			}
		}
		return list;
	}
	
	/**
	 * 查询所有部门
	 */
	@Override
	public List<Department> queryDepartments(Department department) {
		List<Department> list = userDao.queryDepartment(department);
		return list;
	}

	/**
	 * 查询要修改的所有角色
	 */
	@Override
	public List<Role> queryRole(Role role, int updateid) {
		User updateUser = userDao.queryUpdateUser(updateid);
		List<Role> listRole = userDao.queryRole(role);
		for (Role role2 : listRole) {
			if (role2.getId() == updateUser.getRole().getId()) {
				role2.setUserRole(true);
				break;
			}
		}
		return listRole;
	}
	
	/**
	 * 查询所有角色
	 */
	@Override
	public List<Role> queryRoles(Role role) {
		List<Role> listRole = userDao.queryRole(role);
		return listRole;
	}

	@Override
	public List<User> queryLikeUser(String name, int pageNow, int pageSize) {
		return userDao.queryLikeUser(name, pageNow, pageSize);
	}
	
	/**
	 * 模糊查询的用户数量
	 */
	@Override
	public int userLikeSize(String name) {
		return userDao.userLikeSize(name);
	}
}
