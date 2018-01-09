/********************************************
 * Copyright (c) 2016, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package com.qingshixun.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.dao.IUserDao;
import com.qingshixun.model.Department;
import com.qingshixun.model.Role;
import com.qingshixun.model.User;

@Repository("userDao")
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 閫氳繃鐢ㄦ埛鍚嶆煡璇㈢敤鎴蜂俊鎭紝鍒ゆ柇鐢ㄦ埛鏄惁瀛樺湪
	 */
	@Override
	public User queryUserLogin(String username) {
		int index = 0;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where username = ?");
		query.setParameter(0, username);
		List<User> list = query.list();
		if (list.size() != 0) {
			return list.get(index);
		}
		return null;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 淇濆瓨鐢ㄦ埛淇℃伅
	 */
	@Override
	public boolean saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			user.setCreateDate(new Date());
			session.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * 閫氳繃鍙傛暟userid鏌ヨ瀵瑰簲鐢ㄦ埛淇℃伅锛屽苟鍒犻櫎鐢ㄦ埛
	 */
	@Override
	public void removeUser(int userid) {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user = (User) session.load(User.class, userid);
		session.delete(user);
	}

	/**
	 * 閫氳繃id闆嗗悎checkedId鍙傛暟锛屾煡璇㈡潈闄愪俊鎭紝瀹炵幇澶氶」鍒犻櫎
	 */
	@Override
	public void batchDeleteUser(List<Integer> checkedId) {
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < checkedId.size(); i++) {
			User user = new User();
			int id = checkedId.get(i);
			user = (User) session.get(User.class, id);
			session.delete(user);
		}
	}

	/**
	 * 閫氳繃鍙傛暟updateid鏌ヨ瀵瑰簲鐨勭敤鎴蜂俊鎭�
	 */
	@Override
	public User queryUpdateUser(int updateid) {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user = (User) session.load(User.class, updateid);
		System.out.println(user);
		return user;
	}

	/**
	 * 淇敼骞朵繚瀛樼敤鎴蜂俊鎭�
	 */
	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	/**
	 * 鏌ヨ鐢ㄦ埛淇℃伅锛屽疄鐜板垎椤�
	 */
	@Override
	public List<User> queryAllUser(int pageNow, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 鏌ヨ鐢ㄦ埛淇℃伅鏁伴噺
	 */
	@Override
	public int userSize() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User";
		int sezi = session.createQuery(hql).list().size();
		if (sezi <= 0) {
			return 0;
		}
		return sezi;
	}

	/**
	 * 閫氳繃鐢ㄦ埛鍚嶆煡璇㈢敤鎴蜂俊鎭�
	 */
	@Override
	public int usernameVerification(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User WHERE username =?";
		int flag = 0;
		try {
			Query query = session.createQuery(hql);
			query.setString(0, name);
			List<User> list = query.list();
			if (list.size() > 0) {
				flag = 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	/**
	 * 鏌ヨ瑙掕壊淇℃伅
	 */
	@Override
	public List<Role> queryRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Role> listRole = session.createQuery("FROM Role").list();
		return listRole;
	}

	/**
	 * 鏌ヨ閮ㄩ棬淇℃伅
	 */
	@Override
	public List<Department> queryDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Department> list = session.createQuery("FROM Department").list();
		return list;
	}

	/**
	 * 妯＄硦鏌ヨ鐢ㄦ埛淇℃伅
	 * @param name
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<User> queryLikeUser(String name, int pageNow, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User as user WHERE user.name like :name");
		query.setParameter("name", "%"+name+"%");
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
//		if (list.size() > 0) {
//			return list;
//		}
		return list;
  }
	
	/**
	 * 妯＄硦鏌ヨ鐨勭敤鎴蜂俊鎭暟閲�
	 */
	@Override
	public int userLikeSize(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User as user WHERE user.name like :name");
		query.setParameter("name", "%"+name+"%");
		int size = query.list().size();
		if (size <= 0) {
			return 0;
		}
		return size;
	}
}
