package com.qingshixun.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.dao.IRoleDao;
import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;

@Repository("roleDao")
public class RoleDao implements IRoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * 添加角色信息
	 */
	@Override
	public void saveRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		role.setCreateDate(new Date());
		session.save(role);
	}

	/*
	 * 通过参数jurisdiction查询Jurisdiction实体类
	 * 
	 * @return 返回listJurisdiction
	 */
	@Override
	public List<Jurisdiction> queryJurisdiction(Jurisdiction jurisdiction) {
		Session session = sessionFactory.getCurrentSession();
		List<Jurisdiction> listJurisdiction = session.createQuery("FROM Jurisdiction").list();
		return listJurisdiction;
	}

	/*
	 * 通过参数role查询Role实体类
	 * 
	 * @return 返回listRole
	 */
	@Override
	public List<Role> queryRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		List<Role> listRole = session.createQuery("FROM Role").list();
		return listRole;
	}

	/*
	 * 通过参数roleId查询对应的角色信息，并删除
	 */
	@Override
	public void removeRole(int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, roleId);
		session.delete(role);
	}

	/*
	 * 通过参数updateRoleId查询角色信息，并修改对应的角色信息
	 */
	@Override
	public Role queryUpdateRole(int updateRoleId) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, updateRoleId);
		session.saveOrUpdate(role);
		return role;
	}

	/*
	 * 修改并保存角色信息
	 */
	@Override
	public void saveOrUpdateRole(Role role) {
		Session session = sessionFactory.getCurrentSession();
		role.setCreateDate(new Date());
		session.saveOrUpdate(role);
	}

	/*
	 * 通过id集合checkedId参数，查询权限信息，实现多项删除
	 */
	@Override
	public void batchRemoveRole(List<Integer> checkedId) {
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < checkedId.size(); i++) {
			Role role = new Role();
			int id = checkedId.get(i);
			role = (Role) session.get(Role.class, id);
			session.delete(role);
		}
	}

}
