/*******************************************************************************
 *
 * Copyright �뱬 2019 namu C&D corp. All rights reserved.
 *
 * This is a proprietary software of namu C&D corp, and you may not use this file except in
 * compliance with license agreement with namu C&D corp. Any redistribution or use of this
 * software, with or without modification shall be strictly prohibited without prior written
 * approval of namu C&D corp, and the copyright notice above does not evidence any actual or
 * intended publication of such software.
 *
 *******************************************************************************/
package com.anchordata.webframework.service.solar.online;


import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anchordata.webframework.base.util.DataMap;
import com.anchordata.webframework.service.solar.faq.FAQSearchVO;
import com.anchordata.webframework.service.solar.faq.FAQVO;
import com.anchordata.webframework.service.solar.license.LicenseSearchVO;
import com.anchordata.webframework.service.solar.training.TrainingSearchVO;
import com.anchordata.webframework.service.solar.training.TrainingVO;


@Service("OnlineService")
public class OnlineService {
	
	@Autowired
	private OnlineDao onlineDao;
	
	/**
	 * 등록
	 */
	@Transactional
	public int registration(OnlineVO vo) throws Exception {
		return onlineDao.insertInfo(vo);
	}
	
	/**
	 * 수정
	 */
	@Transactional
	public int modification(OnlineVO vo) throws Exception {
		return onlineDao.updateInfo(vo);
	}
	
	/**
	 * 삭제
	 */
	@Transactional
	public int withdrawal(OnlineVO vo) throws Exception {
		// 실제 데이터 삭제가 아니라 Flag만 바꾼다.
		return onlineDao.deleteInfo(vo);
	}
	
	
	/**
	 * 검색
	 */
	@Transactional
	public List<OnlineVO> searchList(OnlineSearchVO vo) throws Exception {
		
		HashMap<String, Object> search = new HashMap<String, Object>();
		search.put("pageIndex", vo.getPageIndex());
		
		if (  vo.getTitle() != null && vo.getTitle().isEmpty() != true ) {
			search.put("title", vo.getTitle());	
		}
		if (  vo.getReg_date() != null && vo.getReg_date().isEmpty() != true ) {
			search.put("reg_date", vo.getReg_date());	
		}
		if (  vo.getOrderby() != null && vo.getOrderby().isEmpty() != true ) {
			search.put("orderby", vo.getOrderby());	
		}
		if (  vo.getJob_gb() != null && vo.getJob_gb().isEmpty() != true ) {
			search.put("job_gb", vo.getJob_gb());	
		}
		
		return onlineDao.selectSearchList(new DataMap(search));
	}
	
	
	/**
	 * Search List  
	 */
	@Transactional
	public List<OnlineVO> searchList(OnlineSearchVO vo, int pageRow) throws Exception {
		
		HashMap<String, Object> search = new HashMap<String, Object>();
		search.put("pageIndex", vo.getPageIndex());
		
		if (  vo.getTitle() != null && vo.getTitle().isEmpty() != true ) {
			search.put("title", vo.getTitle());	
		}
		if (  vo.getReg_date() != null && vo.getReg_date().isEmpty() != true ) {
			search.put("reg_date", vo.getReg_date());	
		}
		if (  vo.getOrderby() != null && vo.getOrderby().isEmpty() != true ) {
			search.put("orderby", vo.getOrderby());	
		}
		if (  vo.getJob_gb() != null && vo.getJob_gb().isEmpty() != true ) {
			search.put("job_gb", vo.getJob_gb());	
		}
		
		return onlineDao.selectSearchList(new DataMap(search), pageRow);
	}
	
	
	
	/**
	 * all List  
	 */
	@Transactional
	public List<OnlineVO> allList() throws Exception {
		return onlineDao.selectAllList();
	}
	
	/**
	 * Search List All
	 */
	@Transactional
	public List<OnlineVO> searchAllList(OnlineSearchVO vo) throws Exception {
		return onlineDao.selectSearchAllList(vo);
	}
	
	
	/**
	 * 상세
	 */
	@Transactional
	public OnlineVO detail(OnlineVO vo) throws Exception {
		OnlineVO result = onlineDao.selectDetail(vo);
		return result;
	}
	
}
