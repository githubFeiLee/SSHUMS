package com.qingshixun.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.dao.IDepartmentDao;
import com.qingshixun.model.Department;

@Repository("departmentDao")
public class DepartmentDao implements IDepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 查询部门中的所有部门信息
	 * @return list
	 */
	@Override
	public List<Department> queryDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		List<Department> list = session.createQuery("FROM Department").list();
		return list;
	}

	/**
	 * 添加部门信息
	 * 
	 * @return
	 */
	@Override
	public void saveDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		department.setCreateDate(new Date());
		session.save(department);
	}

	/**
	 * 通过参数departmentId，查询此id的对应部门信息，并删除
	 */
	@Override
	public void deleteDepartment(int departmentId) {
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.load(Department.class, departmentId);
		session.delete(department);
	}

	/**
	 * 通过id集合checkedId参数，查询部门信息，实现多项删除
	 */
	@Override
	public void batchDeleteDepartment(List<Integer> checkedId) {
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < checkedId.size(); i++) {
			int id = checkedId.get(i);
			Department department = (Department) session.get(Department.class, id);
			session.delete(department);
		}
	}

	/**
	 * 通过参数updateId查询对应部门信息，并修改信息
	 * @return department
	 */
	@Override
	public Department querUpDepartment(int updateId) {
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.get(Department.class, updateId);
		session.saveOrUpdate(department);
		return department;

	}

	/**
	 * 保存修改之后的部门信息
	 */
	@Override
	public void eidtDepartment(Department department) {
		Session session = sessionFactory.getCurrentSession();
		department.setCreateDate(new Date());
		session.saveOrUpdate(department);
	}
}
