/********************************************
 * Copyright (c) 2016, www.qingshixun.com
 *
 * All rights reserved
 *
*********************************************/
package com.qingshixun.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "t_user")
// User实现该接口后将可以转换成UserDetails类型
public class User implements UserDetails {

	/**
	 * 序列号，类的唯一标识，在将数据持久化成文件，或文件按照类格式生成数据时候会用上
	 * 如果持久化的文件格式未变，而bean类结构发生变化，这个号就会有作用了
	 */
	private static final long serialVersionUID = -2790587574312673083L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;

	private String name;

	private String password;

	private String phone;

	private String sex;

	private String status;

	@ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(Integer id, String username, String name, String password, String phone, Department department,
			Role role, String status) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.department = department;
		this.role = role;
		this.status = status;
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", sex=" + sex + ", status=" + status + ", department=" + department + ", role=" + role
				+ ", createDate=" + createDate + "]";
	}

	/**
	 * 为“ROLE_USER”设置权限，将其添加到集合中 
	 * 将用户名添加到集合中
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> gas = new ArrayList<GrantedAuthority>();
		GrantedAuthority ga = new SimpleGrantedAuthority(username);
		GrantedAuthority usr = new SimpleGrantedAuthority("ROLE_USER");
		gas.add(ga);
		gas.add(usr);
		return gas;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
