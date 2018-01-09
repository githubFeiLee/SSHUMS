package com.qingshixun.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import com.qingshixun.model.User;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 通过用户名查询User实体类的用户信息，并返回user
	 */
	@Override
	public UserDetails findByUsername(String username) {
		User user = (User) sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username")
				.setParameter("username", username).uniqueResult();
		return (UserDetails) user;
	}

	@Override
	public List<T> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
	}
}
