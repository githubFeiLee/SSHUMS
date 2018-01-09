package com.qingshixun.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "t_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private String description;

	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Transient
	private boolean userRole;
	
	@OneToMany(targetEntity = User.class,mappedBy = "role",fetch = FetchType.EAGER)
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany(targetEntity = Jurisdiction.class)
    @JoinTable(name = "t_role_jurisdiction", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "jurisdiction_id", referencedColumnName = "id") })
	private Set<Jurisdiction> jurisdictions = new HashSet<Jurisdiction>();
	
	public Role() {
		super();
	}

	public Role(Integer id, String name, String description, Date createDate, Set<User> users,
			Set<Jurisdiction> jurisdictions) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.users = users;
		this.jurisdictions = jurisdictions;
	}

	public boolean isUserRole() {
		return userRole;
	}

	public void setUserRole(boolean userRole) {
		this.userRole = userRole;
	}

	public Set<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(Set<Jurisdiction> jurisdictions) {
		this.jurisdictions = jurisdictions;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
