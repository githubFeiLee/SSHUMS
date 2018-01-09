package com.qingshixun.service;

import java.util.List;

import com.qingshixun.model.Department;

public interface IDepartmentService {
	
	List<Department> queryDepartment(Department department);
	
	void saveDepartment(Department department);
	
	void deleteDepartment(int departmentId);
	
	Department querUpDepartment(int updateId);
	
	void editDepartment(Department department);
	
	void batchDeleteDepartment(List<Integer> checkedId);
}
