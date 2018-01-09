package com.qingshixun.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "t_jurisdiction")
public class Jurisdiction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String description;

	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Transient
	private boolean roleJurisdiction;
	
	@ManyToMany(targetEntity = Role.class,mappedBy = "jurisdictions")
	private Set<Role> roles = new HashSet<Role>();
	
	public Jurisdiction() {
		super();
	}

	public Jurisdiction(Integer id, String name, String description, Date createDate, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.roles = roles;
	}

	public boolean isRoleJurisdiction() {
		return roleJurisdiction;
	}

	public void setRoleJurisdiction(boolean roleJurisdiction) {
		this.roleJurisdiction = roleJurisdiction;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
