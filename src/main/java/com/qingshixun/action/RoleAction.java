package com.qingshixun.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.qingshixun.model.Jurisdiction;
import com.qingshixun.model.Role;
import com.qingshixun.service.IJurisdictionService;
import com.qingshixun.service.IRoleService;

@Controller("roleAction")
@Namespace("/")
@ParentPackage("UMSPackage")
@Scope("prototype")
public class RoleAction {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IJurisdictionService jurisdictionService;

	private Role role;

	private Jurisdiction jurisdiction;

	private List<Jurisdiction> listJurisdiction;

	private List<Role> listRole;

	private int roleId;

	private int updateRoleId;

	private List<Integer> checkedId;
	
	public List<Integer> getCheckedId() {
		return checkedId;
	}

	public void setCheckedId(List<Integer> checkedId) {
		this.checkedId = checkedId;
	}

	public int getUpdateRoleId() {
		return updateRoleId;
	}

	public void setUpdateRoleId(int updateRoleId) {
		this.updateRoleId = updateRoleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	public List<Jurisdiction> getListJurisdiction() {
		return listJurisdiction;
	}

	public void setListJurisdiction(List<Jurisdiction> listJurisdiction) {
		this.listJurisdiction = listJurisdiction;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public IJurisdictionService getJurisdictionService() {
		return jurisdictionService;
	}

	public void setJurisdictionService(IJurisdictionService jurisdictionService) {
		this.jurisdictionService = jurisdictionService;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	/*
	 * 局部刷新，成功页面跳转
	 */
	@Action(value = "loadAdd", results = { @Result(name = "success", location = "/WEB-INF/views/role/addRole.jsp") })
	public String loadAdd() {
		listJurisdiction = roleService.queryJurisdictions(jurisdiction);
		return "success";

	}

	/*
	 * 添加角色信息
	 */
	@Action(value = "saveRole", results = { @Result(name = "success", type = "json") })
	public String saveRole() {
		roleService.saveRole(role);
		return "success";
	}

	/*
	 * 查询角色信息
	 */
	@Action(value = "queryRole", results = { @Result(name = "success", location = "/WEB-INF/views/role/showRole.jsp") })
	public String queryRole() {
		listRole = roleService.queryRole(role);
		return "success";

	}

	/*
	 * 通过参数roleId删除对应的角色信息
	 */
	@Action(value = "removeRole", results = { @Result(name = "success", type = "json") })
	public String removeRole() {
		roleService.removeRole(roleId);
		return "success";

	}

	/*
	 * 通过参数 updateRoleId查询并修改对应的角色信息
	 */
	@Action(value = "queryUpdateRole", results = {
			@Result(name = "success", location = "/WEB-INF/views/role/updateRole.jsp") })
	public String queryUpdateRole() {
		role = roleService.queryUpdateRole(updateRoleId);
		listJurisdiction = roleService.queryJurisdiction(jurisdiction, updateRoleId);
		return "success";

	}

	/*
	 * 保存已修改的角色信息
	 */
	@Action(value = "saveOrUpdateRole", results = { @Result(name = "success", type = "json") })
	public String saveOrUpdateRole() {
		roleService.saveOrUpdateRole(role);
		return "success";
	}

	/*
	 * 通过集合checkedId删除对应集合的权限信息
	 */
	@Action(value = "batchRemoveRole", results = { @Result(name = "success", type = "json") })
	public String batchRemoveRole() {
		roleService.batchRemoveRole(checkedId);
		return "success";
	}
}
