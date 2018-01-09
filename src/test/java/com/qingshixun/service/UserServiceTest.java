/********************************************
 * Copyright (c) 2016, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package com.qingshixun.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingshixun.model.Department;
import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;
import com.qingshixun.model.User;

@RunWith(SpringJUnit4ClassRunner.class) // spring 整合 JUnit4
@ContextConfiguration(locations = "classpath:applicationContext.xml") // 指定
																		// spring
																		// 配置文件的位置
public class UserServiceTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void testSave() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		Role role = new Role();
		Department department = new Department();
		Jurisdiction jurisdiction = new Jurisdiction();
		
		user.setUsername("2017001");
		user.setName("panshuai");
		user.setPassword("123456");
		user.setPhone("18798379755");
		user.setStatus("启用 ");
		user.setSex("男");
		user.setCreateDate(new Date());
		
		role.setCreateDate(new Date());
		role.setDescription("管理一切的角色！");
		role.setName("管理员");
		
		department.setCreateDate(new Date());
		department.setDescription("管理用户的部门");
		department.setName("管理部");
		
		jurisdiction.setCreateDate(new Date());
		jurisdiction.setName("所有权限");
		jurisdiction.setDescription("所有的都能操作");
		
		user.setDepartment(department);
		user.setRole(role);
		role.getUsers().add(user);
		role.getJurisdictions().add(jurisdiction);
		department.getUsers().add(user);
		jurisdiction.getRoles().add(role);
		
		session.save(jurisdiction);
		session.save(department);
		session.save(user);
		session.save(role);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void get() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where username = ? and password = ?");
		query.setParameter(0, "2017001");
		query.setParameter(1, "123456");
		List<User> list = query.list();
		System.out.println(list);
//		for (User user : list) {
//			System.out.println(user);
//		}
		session.getTransaction().commit();
		session.close();
	}
}
