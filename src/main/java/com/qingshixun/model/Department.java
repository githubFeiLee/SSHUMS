package com.qingshixun.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "t_department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Transient
	private boolean userDepartment;
	
	@OneToMany(targetEntity = User.class,mappedBy = "department",fetch = FetchType.EAGER)
	private Set<User> users = new HashSet<User>();
	
	public Department() {
		super();
	}
	
	public Department(Integer id, String name, String description, Date createDate, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.users = users;
	}

	public boolean isUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(boolean userDepartment) {
		this.userDepartment = userDepartment;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
