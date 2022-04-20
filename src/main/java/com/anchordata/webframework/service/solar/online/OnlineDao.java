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

import org.springframework.stereotype.Repository;

import com.anchordata.webframework.base.common.Constants;
import com.anchordata.webframework.base.core.BaseDao;
import com.anchordata.webframework.base.util.DataMap;
import com.anchordata.webframework.service.solar.faq.FAQSearchVO;
import com.anchordata.webframework.service.solar.faq.FAQVO;
import com.anchordata.webframework.service.solar.license.LicenseSearchVO;
import com.anchordata.webframework.service.solar.training.TrainingVO;


@Repository("OnlineDao")
public class OnlineDao extends BaseDao {
	
	private String mapper	= Constants.NAMESPACE.concat("online.");
	
	public int insertInfo(OnlineVO params) throws Exception{
		return update(mapper.concat("insertInfo"), params);
	}
	
	public int updateInfo(OnlineVO params) throws Exception{
		return update(mapper.concat("updateInfo"), params);
	}
	
	public int deleteInfo(OnlineVO params) throws Exception{
		return delete(mapper.concat("deleteInfo"), params);
	}
	
	public List<OnlineVO> selectSearchList(DataMap param) throws Exception{
		return selectPagingList(mapper.concat("selectSearchList"), param);
	}
	
	public List<OnlineVO> selectSearchList(DataMap param, int pageRow) throws Exception{
		return selectPagingList(mapper.concat("selectSearchList"), param, pageRow);
	}
	
	public List<OnlineVO> selectAllList() throws Exception{
		return selectList(mapper.concat("selectAllList"));
	}
	
	public List<OnlineVO> selectSearchAllList(OnlineSearchVO param) throws Exception{
		return selectList(mapper.concat("selectSearchAllList"), param);
	}
	public OnlineVO selectDetail(OnlineVO vo) throws Exception{
		return selectOne(mapper.concat("selectDetail"), vo);
	}
	
}
