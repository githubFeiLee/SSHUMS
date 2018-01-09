package com.qingshixun.dao;

import java.util.List;

import com.qingshixun.model.Department;

public interface IDepartmentDao {
	
	List<Department> queryDepartment(Department department);
	
	void saveDepartment(Department department);
	
	void deleteDepartment(int departmentId);
	
	Department querUpDepartment(int updateId);
	
	void eidtDepartment(Department department);
	
	void batchDeleteDepartment(List<Integer> checkedId);

}
