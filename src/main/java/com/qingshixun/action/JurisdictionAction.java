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
import com.qingshixun.service.IJurisdictionService;

@Controller("jurisdictionAction")
@Namespace("/")
@ParentPackage("UMSPackage")
@Scope("prototype")
public class JurisdictionAction {

	@Autowired
	private IJurisdictionService jurisdictionService;

	private Jurisdiction jurisdiction;

	private int jurisdictionId;

	private List<Jurisdiction> jurisdictions;

	private int updateId;

	private Jurisdiction updatejurisdiction;

	private List<Integer> checkedId;

	private int jurisdictionid;

	/**
	 * 页面跳转
	 */
	@Action(value = "tojurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdiction/jurisdictionindex.jsp") })
	public String start() {
		return "success";
	}

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@Action(value = "addjurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdiction/addjurisdiction.jsp") })
	public String add() {
		return "success";
	}

	/**
	 * 添加权限信息
	 * 
	 * @return
	 */
	@Action(value = "savejurisdiction", results = { @Result(name = "success", type = "json") })
	public String savejurisdiction() {
		jurisdictionService.saveJurisdiction(jurisdiction);
		return "success";
	}

	/**
	 * 查询权限信息，成功后页面跳转
	 * 
	 * @return
	 */
	@Action(value = "queryjurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdiction/jurisdictionmanage.jsp") })
	public String queryjurisdiction() {
		jurisdictions = jurisdictionService.queryjurisdiction(jurisdiction);
		return "success";
	}

	/**
	 * 通过参数jurisdictionId删除对应的权限信息
	 * 
	 * @return
	 */
	@Action(value = "removejurisdiction", results = { @Result(name = "success", type = "json") })
	public String removejurisdiction() {
		jurisdictionService.removeJurisdiction(jurisdictionId);
		return "success";
	}

	/**
	 * 通过参数updateId修改对应的权限信息，并实现页面跳转
	 * 
	 * @return
	 */
	@Action(value = "compilejurisdiction", results = {
			@Result(name = "success", location = "/WEB-INF/views/jurisdiction/compilejurisdiction.jsp") })
	public String compile() {
		updatejurisdiction = jurisdictionService.queryJurisdictions(updateId);
		return "success";
	}

	/**
	 * 修改并保存权限信息
	 * 
	 * @return
	 */
	@Action(value = "updatejurisdiction", results = { @Result(name = "success", type = "json") })
	public String saveOrUpdate() {
		jurisdictionService.updateJurisdiction(jurisdiction);
		return "success";
	}

	/**
	 * 通过集合checkedId删除对应集合的权限信息
	 * 
	 * @return
	 */
	@Action(value = "BatchRemoveJurisdiction", results = { @Result(name = "success", type = "json") })
	public String BatchRemoveJurisdiction() {
		jurisdictionService.BatchRemoveJurisdiction(checkedId);
		return "success";
	}

	public IJurisdictionService getJurisdictionService() {
		return jurisdictionService;
	}

	public void setJurisdictionService(IJurisdictionService jurisdictionService) {
		this.jurisdictionService = jurisdictionService;
	}

	public Jurisdiction getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Jurisdiction jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public int getJurisdictionId() {
		return jurisdictionId;
	}

	public void setJurisdictionId(int jurisdictionId) {
		this.jurisdictionId = jurisdictionId;
	}

	public List<Jurisdiction> getJurisdictions() {
		return jurisdictions;
	}

	public void setJurisdictions(List<Jurisdiction> jurisdictions) {
		this.jurisdictions = jurisdictions;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public Jurisdiction getUpdatejurisdiction() {
		return updatejurisdiction;
	}

	public void setUpdatejurisdiction(Jurisdiction updatejurisdiction) {
		this.updatejurisdiction = updatejurisdiction;
	}

	public List<Integer> getCheckedId() {
		return checkedId;
	}

	public void setCheckedId(List<Integer> checkedId) {
		this.checkedId = checkedId;
	}

	public int getJurisdictionid() {
		return jurisdictionid;
	}

	public void setJurisdictionid(int jurisdictionid) {
		this.jurisdictionid = jurisdictionid;
	}

}
