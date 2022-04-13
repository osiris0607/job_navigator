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


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
	 * all List  
	 */
	@Transactional
	public List<OnlineVO> allList() throws Exception {
		return onlineDao.selectAllList();
	}
	
	
}
