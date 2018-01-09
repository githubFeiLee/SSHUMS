package com.qingshixun.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qingshixun.dao.IJurisdictionDao;
import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;

@Repository("jurisdictionDao")
public class JurisdictionDao implements IJurisdictionDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 添加权限信息
	 */
	@Override
	public void saveJurisdiction(Jurisdiction jurisdiction) {
		Session session = sessionFactory.getCurrentSession();
		jurisdiction.setCreateDate(new Date());
		session.save(jurisdiction);

	}

	/**
	 * 通过参数jurisdiction查询Jurisdiction实体类
	 * 
	 * @return 返回list
	 */
	@Override
	public List<Jurisdiction> queryjurisdiction(Jurisdiction jurisdiction) {
		Session session = sessionFactory.getCurrentSession();
		List<Jurisdiction> list = session.createQuery("FROM Jurisdiction").list();
		return list;
	}

	/**
	 * 通过jurisdictionId查询对应权限信息，并删除
	 * 
	 * @param jurisdictionId
	 */
	@Override
	public void removeJurisdiction(int jurisdictionId) {
		Session session = sessionFactory.getCurrentSession();
		Jurisdiction jurisdiction = (Jurisdiction) session.get(Jurisdiction.class, jurisdictionId);
		session.delete(jurisdiction);
	}

	/**
	 * 通过updateId查询对应权限信息，并返回jurisdiction
	 */
	@Override
	public Jurisdiction queryJurisdictions(int updateId) {
		Session session = sessionFactory.getCurrentSession();
		Jurisdiction jurisdiction = (Jurisdiction) session.get(Jurisdiction.class, updateId);
		return jurisdiction;

	}

	/**
	 * 保存修改之后的权限信息
	 */
	@Override
	public void updateJurisdiction(Jurisdiction jurisdiction) {
		Session session = sessionFactory.getCurrentSession();
		jurisdiction.setCreateDate(new Date());
		session.saveOrUpdate(jurisdiction);

	}

	/**
	 * 通过id集合checkedId参数，查询权限信息，实现多项删除
	 */
	@Override
	public void BatchRemoveJurisdiction(List<Integer> checkedId) {
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < checkedId.size(); i++) {
			Jurisdiction jurisdiction = new Jurisdiction();
			int id = checkedId.get(i);
			jurisdiction = (Jurisdiction) session.get(Jurisdiction.class, id);
			session.delete(jurisdiction);
		}
	}

	@Override
	public List<Role> queryAllRole() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> list = session.createQuery("FROM Role").list();
		return list;
	}

	@Override
	public List<Jurisdiction> queryjurisdiction() {
		Session session = sessionFactory.getCurrentSession();
		List<Jurisdiction> list = session.createQuery("FROM Jurisdiction").list();
		return list;
	}
}
