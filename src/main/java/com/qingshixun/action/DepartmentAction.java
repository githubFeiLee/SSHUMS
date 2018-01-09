package com.qingshixun.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.qingshixun.model.Department;
import com.qingshixun.service.IDepartmentService;

@Controller("departmentAction")
@Namespace("/")
@ParentPackage("UMSPackage")
@Scope("prototype")
public class DepartmentAction {

	@Autowired
	private IDepartmentService departmentService;

	private List<Department> departmentmanage;

	private Department department;

	private Department updatDepartment;

	private int departmentId;

	private int updateId;

	private List<Integer> checkedId;

	public List<Integer> getCheckedId() {
		return checkedId;
	}

	public void setCheckedId(List<Integer> checkedId) {
		this.checkedId = checkedId;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public Department getUpdatDepartment() {
		return updatDepartment;
	}

	public void setUpdatDepartment(Department updatDepartment) {
		this.updatDepartment = updatDepartment;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public List<Department> getDepartmentmanage() {
		return departmentmanage;
	}

	public void setDepartmentmanage(List<Department> departmentmanage) {
		this.departmentmanage = departmentmanage;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * 查询所有部门信息成功，则页面跳转
	 */
	@Action(value = "showDepartment", results = {
			@Result(name = "success", location = "/WEB-INF/views/department/showDepartment.jsp") })
	public String queryDepartment() {
		departmentmanage = departmentService.queryDepartment(department);
		return "success";
	}

	/**
	 * 局部刷新页面
	 */
	@Action(value = "loadadd", results = {
			@Result(name = "success", location = "/WEB-INF/views/department/addDepartment.jsp") })
	public String loadadd() {
		return "success";
	}

	/**
	 * 添加部门信息
	 */
	@Action(value = "addDepartment", results = { @Result(name = "success", type = "json") })
	public String saveDepartment() {
		departmentService.saveDepartment(department);
		return "success";
	}

	/**
	 * 通过参数departmentId删除对应的部门信息
	 */
	@Action(value = "deleteDepartment", results = { @Result(name = "success", type = "json") })
	public String deleteDepartment() {
		departmentService.deleteDepartment(departmentId);
		return "success";
	}

	/**
	 * 通过集合checkedId删除对应集合的部门信息
	 */
	@Action(value = "batchDeleteDepartment", results = { @Result(name = "success", type = "json") })
	public String batchDeleteDepartment() {
		departmentService.batchDeleteDepartment(checkedId);
		return "success";

	}

	/**
	 * 通过参数updateId修改对应的部门信息
	 */
	@Action(value = "edit-Department", results = {
			@Result(name = "success", location = "/WEB-INF/views/department/editDepartment.jsp") })
	public String update() {
		updatDepartment = departmentService.querUpDepartment(updateId);
		departmentmanage = departmentService.queryDepartment(department);
		return "success";

	}

	/**
	 * 保存已修改的部门信息
	 */
	@Action(value = "update", results = { @Result(name = "success", type = "json") })
	public String editDepartment() {
		departmentService.editDepartment(department);
		return "success";
	}
}
