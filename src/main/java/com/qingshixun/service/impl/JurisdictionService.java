package com.qingshixun.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qingshixun.dao.IJurisdictionDao;
import com.qingshixun.service.IJurisdictionService;
import com.qingshixun.model.Jurisdiction;

@Service("jurisdictionService")
@Transactional
public class JurisdictionService implements IJurisdictionService {

	@Autowired
	private IJurisdictionDao jurisdictionDao;

	/**
	 * 娣诲姞鏉冮檺淇℃伅
	 */
	@Override
	public void saveJurisdiction(Jurisdiction jurisdiction) {
		jurisdictionDao.saveJurisdiction(jurisdiction);

	}

	/**
	 * 鏌ヨ鎵�鏈夋潈闄愪俊鎭�
	 */
	@Override
	public List<Jurisdiction> queryjurisdiction(Jurisdiction jurisdiction) {
		List<Jurisdiction> list = jurisdictionDao.queryjurisdiction(jurisdiction);
		return list;
	}

	/**
	 * 閫氳繃鍙傛暟jurisdictionId鏌ヨ骞跺垹闄ゅ搴旂殑鏉冮檺淇℃伅
	 */
	@Override
	public void removeJurisdiction(int jurisdictionId) {
		jurisdictionDao.removeJurisdiction(jurisdictionId);
	}

	/**
	 * 閫氳繃鍙傛暟updateId鏌ヨ瀵瑰簲鏉冮檺淇℃伅
	 */
	@Override
	public Jurisdiction queryJurisdictions(int updateId) {
		return jurisdictionDao.queryJurisdictions(updateId);
	}

	/**
	 * 淇敼骞朵繚瀛樻潈闄愪俊鎭�
	 */
	@Override
	public void updateJurisdiction(Jurisdiction jurisdiction) {
		jurisdictionDao.updateJurisdiction(jurisdiction);

	}

	/**
	 * 閫氳繃checkedId闆嗗悎鏌ヨ骞跺垹闄ゅ搴旂殑鏉冮檺闆嗗悎淇℃伅
	 */
	@Override
	public void BatchRemoveJurisdiction(List<Integer> checkedId) {
		jurisdictionDao.BatchRemoveJurisdiction(checkedId);

	}

}
