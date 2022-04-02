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
package com.anchordata.webframework.service.solar.job;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anchordata.webframework.base.common.Constants;
import com.anchordata.webframework.base.core.BaseDao;
import com.anchordata.webframework.base.util.DataMap;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;


@Repository("JobDao")
public class JobDao extends BaseDao {
	
	private String mapper	= Constants.NAMESPACE.concat("job.");
	

	public int insertInfo(JobVO params) throws Exception{
		return update(mapper.concat("insertInfo"), params);
	}
	public int insertEssInfo(JobVO params) throws Exception{
		return update(mapper.concat("insertEssInfo"), params);
	}
	
	public int updateInfo(JobVO params) throws Exception{
		return update(mapper.concat("updateInfo"), params);
	}
	public int updateEssInfo(JobVO params) throws Exception{
		return update(mapper.concat("updateEssInfo"), params);
	}
	
	public int deleteInfo(JobVO params) throws Exception{
		return update(mapper.concat("deleteInfo"), params);
	}
	public int deleteEssInfo(JobVO params) throws Exception{
		return update(mapper.concat("deleteEssInfo"), params);
	}
	
	public JobVO selectDetailView(JobVO vo) throws Exception{
		return selectOne(mapper.concat("selectDetailView"), vo);
	}
	
	public List<JobVO> selectSearchList(DataMap param) throws Exception{
		return selectPagingList(mapper.concat("selectSearchList"), param);
	}
	
	public List<JobVO> selectSearchList(DataMap param, int pageRow) throws Exception{
		return selectPagingList(mapper.concat("selectSearchList"), param, pageRow);
	}
	
	//ESS
	public List<JobVO> selectEssSearchList(DataMap param) throws Exception{
		return selectPagingList(mapper.concat("selectEssSearchList"), param);
	}
	
	public List<JobVO> selectEssSearchList(DataMap param, int pageRow) throws Exception{
		return selectPagingList(mapper.concat("selectEssSearchList"), param, pageRow);
	}
	
	public int insertRelativeInfo(JobRelativeVO params) throws Exception{
		return update(mapper.concat("insertRelativeInfo"), params);
	}
	public int insertEssRelativeInfo(JobRelativeVO params) throws Exception{
		return update(mapper.concat("insertEssRelativeInfo"), params);
	}
	
	public int deleteRelativeInfo(JobRelativeVO params) throws Exception{
		return update(mapper.concat("deleteRelativeInfo"), params);
	}
	public int deleteEssRelativeInfo(JobRelativeVO params) throws Exception{
		return update(mapper.concat("deleteEssRelativeInfo"), params);
	}
	
	public List<JobVO> selectAllList() throws Exception{
		return selectList(mapper.concat("selectAllList"));
	}
	
	public List<JobVO> selectEssAllList() throws Exception{
		return selectList(mapper.concat("selectEssAllList"));
	}
	
	
	public List<JobVO> selectSearchAllList(JobVO param) throws Exception{
		return selectList(mapper.concat("selectSearchAllList"), param);
	}
	
	public List<JobVO> selectEssSearchAllList(JobVO param) throws Exception{
		return selectList(mapper.concat("selectEssSearchAllList"), param);
	}
	
	public JobVO selectDetail(JobVO vo) throws Exception{
		return selectOne(mapper.concat("selectDetail"), vo);
	}

	public JobVO selectEssDetail(JobVO vo) throws Exception{
		return selectOne(mapper.concat("selectEssDetail"), vo);
	}
	
	
	public List<CommonCodeVO> selectMajorList(JobVO param) throws Exception{
		return selectList(mapper.concat("selectMajorList"), param);
	}
	
	public List<CommonCodeVO> selectEssMajorList(JobVO param) throws Exception{
		return selectList(mapper.concat("selectEssMajorList"), param);
	}
	
	///////////////////////////////////////////////////////////////////////////
	// JOB RANK 관련
	///////////////////////////////////////////////////////////////////////////
	public int updateRank(JobVO params) throws Exception{
		return update(mapper.concat("updateRank"), params);
	}
	public int essUpdateRank(JobVO params) throws Exception{
		return update(mapper.concat("essUpdateRank"), params);
	}
	
	public List<JobVO> allListRank() throws Exception{
		return selectList(mapper.concat("allListRank"));
	}
	
	public List<JobVO> allEssListRank() throws Exception{
		return selectList(mapper.concat("allEssListRank"));
	}
	
	
}
