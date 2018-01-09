package com.qingshixun.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.qingshixun.model.Department;
import com.qingshixun.model.Role;
import com.qingshixun.model.User;
import com.qingshixun.model.page.PageUser;
import com.qingshixun.service.IUserService;

@Controller("userAction")
@Namespace("/")
@ParentPackage("UMSPackage")
@Scope("prototype")
public class UserAction {

	@Autowired
	private IUserService userService;
	
	private Department department;
	
	private List<Role> listRole;
	
	private List<Department> listDepartment;
	
	private User user;
	
	// ajax验证用户名是否存在时接收管理员输入的账号
	private String name;
	
	private String message;
	
	// 接收批量删除用户的id
	private List<Integer> checkedId;
	
	private Role role;
	
	private int pageNow = 1;
	
	// 每页显示的信息数
	private int pageSize = 10;
	
	private List<User> listUser;
	
	
	// 页面提交的用户id
	private int userid;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getCheckedId() {
		return checkedId;
	}

	public void setCheckedId(List<Integer> checkedId) {
		this.checkedId = checkedId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

	private static final String list = "list";

	public String list() {
		List list1 = userService.findAll();
		ActionContext.getContext().put("list", list1);
		return list;
	}

	/**
	 * 访问登录页面
	 * @return
	 */
	@Action(value = "toLogin", results = { @Result(name = "success", location = "/WEB-INF/views/login.jsp") })
	public String toLogin() {
		return "success";
	}
	
	/**
	 * 退出系统，回到登录页面
	 * @return
	 */
	@Action(value = "toLogout", results = { @Result(name = "success", location = "/WEB-INF/views/login.jsp") })
	public String toLogout() {
		return "success";
	}

	/**
	 * 访问忘记密码页面
	 * @return
	 */
	@Action(value = "toFindPassword", results = {
			@Result(name = "success", location = "/WEB-INF/views/findPassword.jsp") })
	public String toFindPassword() {
		return "success";
	}

	/**
	 * 登陆成功之后页面跳转到系统首页
	 * @return
	 */
	@Action(value = "login", results = { @Result(name = "success", location = "/WEB-INF/views/userManage.jsp")})
	public String login() {
		listUser = userService.queryAllUser(pageNow, pageSize);
		if (listUser.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			session.put("list", list);
			PageUser page = new PageUser(pageNow, userService.userSize(), pageSize);
			request.put("page", page);
			return "success";
		}
		return "error";
	}

	/**
	 * 找回密码，成功之后页面显示密码信息
	 * 输入错误页面会给出相应的提示
	 * @return
	 */
	@Action(value = "findPassword", results = { @Result(name = "success", location = "/WEB-INF/views/findPassword.jsp")})
	public String findPassword() {
		if (user != null) {
			if (userService.queryUserPassword(user.getUsername(), user.getPhone()) == -1) {
				User user1 = userService.queryUserLogin(user.getUsername());
				message = "您的密码是：" + user1.getPassword();
				return "success";
			}
			if (userService.queryUserPassword(user.getUsername(), user.getPhone()) == -2) {
				message = "用户名或手机号码不正确！";
				return "success";
			}
		}
		message = "用户名或手机号码不正确！";
		return "success";
	}
	
	/**
	 * 模糊查询用户信息
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Action(value = "queryLikeUser", results = {
			@Result(name = "success", location = "/WEB-INF/views/user/likeQueryUser.jsp") })
	public String queryLikeUser() {
		listUser = userService.queryLikeUser(name, pageNow, pageSize);
		if (listUser.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			session.put("lists", list);
			PageUser page = new PageUser(pageNow, userService.userLikeSize(name), pageSize);
			request.put("pages", page);
			return "success";
		}
		return "success";
	}
	
	/**
	 * 查询出角色和部门名称，添加用户时直接选择
	 * 
	 * @return
	 */
	@Action(value = "queryRoleAndDepartment", results = {
			@Result(name = "success", location = "/WEB-INF/views/user/addUser.jsp") })
	public String roleAndDepartment() {
		listRole = userService.queryRoles(role);
		listDepartment = userService.queryDepartments(department);
		return "success";
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@Action(value = "save", results = { @Result(name = "success", type = "json") })
	public String saveUser() {
		if (userService.saveUser(user)) {
			return "success";
		}
		return "error";
	}

	/**
	 * 分页之后的分页面查询对应的用户信息
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Action(value = "pageUser", results = { @Result(name = "success", location = "/WEB-INF/views/user/queryUser.jsp") })
	public String queryAllUser() {
		listUser = userService.queryAllUser(pageNow, pageSize);
		if (listUser.size() > 0) {
			Map session = ActionContext.getContext().getSession();
			Map request = (Map) ActionContext.getContext().get("request");
			session.put("list", list);
			PageUser page = new PageUser(pageNow, userService.userSize(), pageSize);
			request.put("page", page);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 获取对应用户信息并从数据库中删除
	 * 
	 * @return
	 */
	@Action(value = "removeUser", results = { @Result(name = "success", type = "json") })
	public String removeUser() {
		userService.removeUser(userid);
		return "success";
	}

	/**
	 * 查询要修改的用户信息
	 * 
	 * @return
	 */
	@Action(value = "queryUpdateUser", results = {
			@Result(name = "success", location = "/WEB-INF/views/user/updateUser.jsp") })
	public String updateUser() {
		user = userService.queryUserUpdate(userid);
		listRole = userService.queryRole(role, userid);
		listDepartment = userService.queryDepartment(department, userid);
		return "success";
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	@Action(value = "saveOrUpdateUser", results = { @Result(name = "success", type = "json") })
	public String saveOrUpdateUser() {
		userService.updateUser(user);
		return "success";
	}

	/**
	 * 批量删除用户信息
	 * 
	 * @return
	 */
	@Action(value = "deleteAllUser", results = { @Result(name = "success", type = "json") })
	public String batchDeleteUser() {
		userService.batchDeleteUser(checkedId);
		return "success";
	}

	/**
	 * 校验用户名是否存在
	 * 
	 * @return
	 */
	@Action(value = "verification", results = { @Result(name = "success", type = "json") })
	public String usernameVerification() {
		userid = userService.usernameVerification(name);
		return "success";
	}

}
