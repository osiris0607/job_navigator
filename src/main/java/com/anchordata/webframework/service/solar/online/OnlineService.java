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
import com.anchordata.webframework.service.uploadFile.UploadFileService;
import com.anchordata.webframework.service.uploadFile.UploadFileVO;

@Service("OnlineService")
public class OnlineService {

	@Autowired
	private OnlineDao onlineDao;
	@Autowired
	private UploadFileService uploadFileService;

	/**
	 * 등록
	 */
	@Transactional
	public int registration(OnlineVO vo) throws Exception {
		// 첨부 파일 1 Binary로 DB 저장
		if (vo.getAttach_file() != null && vo.getAttach_file().getSize() > 0) {
			// 나머지 정보는 Upload File Table에 저장
			String fileName = vo.getAttach_file().getOriginalFilename();
			UploadFileVO uploadFileVO = new UploadFileVO();
			uploadFileVO.setName(fileName);
			uploadFileVO.setBinary_content(vo.getAttach_file().getBytes());
			uploadFileVO.setJob_gb(vo.getJob_gb());
			uploadFileService.registration(uploadFileVO);

			vo.setUpload_file_id(Integer.toString(uploadFileVO.getFile_id()));
		} else {
			vo.setUpload_file_id("");
		}
		return onlineDao.insertInfo(vo);
	}

	/**
	 * 수정
	 */
	@Transactional
	public int modification(OnlineVO vo) throws Exception {
		System.out.println("UPDATE vo.getUpload_file_id :::: " + vo.getUpload_file_id());
		// 첨부 파일이 있으면 변경
		if (StringUtils.isEmpty(vo.getUpload_file_id()) == false) {
			UploadFileVO uploadFileVO = new UploadFileVO();
			uploadFileVO.setFile_id(Integer.parseInt(vo.getUpload_file_id()));

			if (vo.getAttach_file() != null && vo.getAttach_file().getSize() > 0) {
				String fileName = vo.getAttach_file().getOriginalFilename();
				uploadFileVO.setName(fileName);
				uploadFileVO.setBinary_content(vo.getAttach_file().getBytes());
			}
			uploadFileVO.setJob_gb(vo.getJob_gb());
			uploadFileService.modification(uploadFileVO);
		} else {
			if (vo.getAttach_file() != null && vo.getAttach_file().getSize() > 0) {
				// 나머지 정보는 Upload File Table에 저장
				String fileName = vo.getAttach_file().getOriginalFilename();
				UploadFileVO uploadFileVO = new UploadFileVO();
				uploadFileVO.setName(fileName);
				uploadFileVO.setBinary_content(vo.getAttach_file().getBytes());
				uploadFileVO.setJob_gb(vo.getJob_gb());
				uploadFileService.registration(uploadFileVO);

				vo.setUpload_file_id(Integer.toString(uploadFileVO.getFile_id()));
			}
		}

		return onlineDao.updateInfo(vo);
	}

	/**
	 * 삭제
	 */
	@Transactional
	public int withdrawal(OnlineVO vo) throws Exception {
		// 연관된 File 삭제
		
		System.out.println("vo.getUpload_file_id :::: " + vo.getUpload_file_id());
		if (vo.getUpload_file_id() != null && vo.getUpload_file_id() != "") {
			UploadFileVO uploadFileVO = new UploadFileVO();
			uploadFileVO.setFile_id(Integer.parseInt(vo.getUpload_file_id()));
			uploadFileVO.setJob_gb(vo.getJob_gb());
			uploadFileService.withdrawal(uploadFileVO);
		}
		return onlineDao.deleteInfo(vo);
	}

	/**
	 * 검색
	 */
	@Transactional
	public List<OnlineVO> searchList(OnlineSearchVO vo) throws Exception {

		HashMap<String, Object> search = new HashMap<String, Object>();
		search.put("pageIndex", vo.getPageIndex());

		if (vo.getTitle() != null && vo.getTitle().isEmpty() != true) {
			search.put("title", vo.getTitle());
		}
		if (vo.getWriter() != null && vo.getWriter().isEmpty() != true) {
			search.put("writer", vo.getWriter());
		}
		if (vo.getReg_date() != null && vo.getReg_date().isEmpty() != true) {
			search.put("reg_date", vo.getReg_date());
		}
		if (vo.getOrderby() != null && vo.getOrderby().isEmpty() != true) {
			search.put("orderby", vo.getOrderby());
		}
		if (vo.getJob_gb() != null && vo.getJob_gb().isEmpty() != true) {
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

		if (vo.getTitle() != null && vo.getTitle().isEmpty() != true) {
			search.put("title", vo.getTitle());
		}
		if (vo.getWriter() != null && vo.getWriter().isEmpty() != true) {
			search.put("writer", vo.getWriter());
		}
		if (vo.getReg_date() != null && vo.getReg_date().isEmpty() != true) {
			search.put("reg_date", vo.getReg_date());
		}
		if (vo.getOrderby() != null && vo.getOrderby().isEmpty() != true) {
			search.put("orderby", vo.getOrderby());
		}
		if (vo.getJob_gb() != null && vo.getJob_gb().isEmpty() != true) {
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
