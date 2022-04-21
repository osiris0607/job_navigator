package com.anchordata.webframework.controller.user.solar.lecture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.commonCode.CommonCodeService;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;
import com.anchordata.webframework.service.solar.job.JobSearchVO;
import com.anchordata.webframework.service.solar.job.JobVO;
import com.anchordata.webframework.service.solar.license.LicenseSearchVO;
import com.anchordata.webframework.service.solar.license.LicenseService;
import com.anchordata.webframework.service.solar.license.LicenseVO;
import com.anchordata.webframework.service.solar.online.OnlineSearchVO;
import com.anchordata.webframework.service.solar.online.OnlineService;
import com.anchordata.webframework.service.solar.online.OnlineVO;
import com.anchordata.webframework.service.notice.NoticeVO;
import com.anchordata.webframework.service.solar.training.TrainingSearchVO;
import com.anchordata.webframework.service.solar.training.TrainingService;
import com.anchordata.webframework.service.solar.training.TrainingVO;


@Controller("UserLectureController")
public class UserLectureController {
	
	
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private CommonCodeService commonCodeService;
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private OnlineService onlineService;
	
	/**
	 * 
	 * SOLAR
	 * 
	 * */
	
	/**
	 * SOLAR 온라인 강의
	 */
	@RequestMapping("/user/rdt/solar/lecture/online")
	public ModelAndView rdtOnline(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/lecture/online.sun_user");
		return mv;
	}
	
	
	/**
	 * SOLAR 온라인 강의 Mobile
	 */
	@RequestMapping("/user/rdt/solar/lecture/onlineMobile")
	public ModelAndView rdtOnlineMobile(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/lecture/onlineMobile.userSolarMobile");
		return mv;
	}
	
	/**
	 * SOLAR 훈련 기관
	 */
	@RequestMapping("/user/rdt/solar/lecture/training")
	public ModelAndView rdtTraining(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/lecture/training.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR 훈련 기관  Mobile
	 */
	@RequestMapping("/user/rdt/solar/lecture/trainingMobile")
	public ModelAndView rdttrainingMobile(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/lecture/trainingMobile.userSolarMobile");
		return mv;
	}
	
	/**
	 * SOLAR 훈련 기관 상세
	 */
	@RequestMapping("/user/rdt/lecture/training/detail")
	public ModelAndView rdtDetail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("lecture/trainingDetail.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR 자격증
	 */
	@RequestMapping("/user/rdt/solar/lecture/license")
	public ModelAndView rdtLicense(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("solar/lecture/license.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR 자격증 Mobile
	 */
	@RequestMapping("/user/rdt/solar/lecture/licenseMobile")
	public ModelAndView rdtLicenseMobie(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("solar/lecture/licenseMobile.userSolarMobile");
		return mv;
	}
	
	/**
	 * SOLAR 자격증 상세
	 */
	@RequestMapping("/user/rdt/solar/lecture/license/detail")
	public ModelAndView rdtLicenseDetail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("lecture/licenseDetail.user");
		return mv;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	/**
	* SOLAR 훈련 기관 검색 List (9개씩)
	*/
	@RequestMapping("/user/api/solar/lecture/training/search/paging")
		public ModelAndView search(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<TrainingVO> resList = trainingService.searchList(vo, 9);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.get(0).getTotal_count());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* ESS 훈련 기관 검색 List (9개씩)
	*/
	@RequestMapping("/user/api/ess/lecture/training/search/paging")
		public ModelAndView essSearch(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<TrainingVO> resList = trainingService.searchList(vo, 9);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.get(0).getTotal_count());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 훈련 기관 검색 List All
	*/
	@RequestMapping("/user/api/solar/lecture/training/search/all")
		public ModelAndView searchAll(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<TrainingVO> resList = trainingService.searchAllList(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 훈련 기관 검색 List All
	 */
	@RequestMapping("/user/api/ess/lecture/training/search/all")
	public ModelAndView searchEssAll(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<TrainingVO> resList = trainingService.searchAllList(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 훈련 기관 상세
	*/
	@RequestMapping("/user/api/solar/lecture/training/search/detail")
	public ModelAndView solarTrainingeDtail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		TrainingVO result = trainingService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* ESS 훈련 기관 상세
	*/
	@RequestMapping("/user/api/ess/lecture/training/search/detail")
	public ModelAndView essTrainingDetail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		TrainingVO result = trainingService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 자격증 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/solar/lecture/license/search/paging")
		public ModelAndView search(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<LicenseVO> resList = licenseService.searchList(vo, 9);
		
		// 검색된 Data Row의 갯수와 검색된 Data Row의 License Type별 갯수 전달해야 한다.
		int countByDataRow = licenseService.countByDataRow(vo);
		int countBylicenseType = licenseService.countBylicenseType(vo);
		
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", countByDataRow);
			mv.addObject("totalCountByLicenseType", countBylicenseType);
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 자격증 검색 List (10개씩)
	 */
	@RequestMapping("/user/api/ess/lecture/license/search/paging")
	public ModelAndView essSearch(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<LicenseVO> resList = licenseService.searchList(vo, 9);
		
		// 검색된 Data Row의 갯수와 검색된 Data Row의 License Type별 갯수 전달해야 한다.
		int countByDataRow = licenseService.countByDataRow(vo);
		int countBylicenseType = licenseService.countBylicenseType(vo);
		
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", countByDataRow);
			mv.addObject("totalCountByLicenseType", countBylicenseType);
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 자격증 검색 List All
	*/
	@RequestMapping("/user/api/solar/lecture/license/search/all")
		public ModelAndView searchAllList(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<LicenseVO> resList = licenseService.searchAllList(vo);
		
		// 검색된 Data Row의 갯수와 검색된 Data Row의 License Type별 갯수 전달해야 한다.
		int countByDataRow = licenseService.countByDataRow(vo);
		int countBylicenseType = licenseService.countBylicenseType(vo);
		
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", countByDataRow);
			mv.addObject("totalCountByLicenseType", countBylicenseType);
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 자격증 검색 List All
	 */
	@RequestMapping("/user/api/ess/lecture/license/search/all")
	public ModelAndView searchEssAllList(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<LicenseVO> resList = licenseService.searchAllList(vo);
		
		// 검색된 Data Row의 갯수와 검색된 Data Row의 License Type별 갯수 전달해야 한다.
		int countByDataRow = licenseService.countByDataRow(vo);
		int countBylicenseType = licenseService.countBylicenseType(vo);
		
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", countByDataRow);
			mv.addObject("totalCountByLicenseType", countBylicenseType);
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  SOLAR 자격증  상세
	*/
	@RequestMapping("/user/api/solar/lecture/license/search/detail")
	public ModelAndView detail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		LicenseVO result = licenseService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 *SOLAR 온라인강의 검색 List (10개씩)
	 */
	@RequestMapping("/user/api/solar/lecture/online/search/paging")
	public ModelAndView onlineSearch(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<OnlineVO> resList = onlineService.searchList(vo, 9);
		
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.get(0).getTotal_count());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 *ESS 온라인강의 검색 List (10개씩)
	 */
	@RequestMapping("/user/api/ess/lecture/online/search/paging")
	public ModelAndView essOnlineSearch(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<OnlineVO> resList = onlineService.searchList(vo, 9);
		
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.get(0).getTotal_count());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 온라인강의 All List
	*/
	@RequestMapping("/user/api/solar/lecture/online/all")
		public ModelAndView allOnlineSearchList(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<OnlineVO> resList = onlineService.searchAllList(vo);
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	/**
	 * ESS 온라인강의 All List
	 */
	@RequestMapping("/user/api/ess/lecture/online/all")
	public ModelAndView allEssOnlineSearchList(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<OnlineVO> resList = onlineService.searchAllList(vo);
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * ESS
	 * 
	 * */
	
	/**
	 * ESS 온라인 강의
	 */
	@RequestMapping("/user/rdt/ess/lecture/online")
	public ModelAndView essOnline(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/online.ess_user");
		return mv;
	}
	
	
	/**
	 * ESS 온라인 강의 Mobile
	 */
	@RequestMapping("/user/rdt/ess/lecture/onlineMobile")
	public ModelAndView essOnlineMobile(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/onlineMobile.userEssMobile");
		return mv;
	}
	
	/**
	 * ESS 훈련 기관
	 */
	@RequestMapping("/user/rdt/ess/lecture/training")
	public ModelAndView essTraining(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/training.ess_user");
		return mv;
	}
	
	/**
	 * ESS 훈련 기관  Mobile
	 */
	@RequestMapping("/user/rdt/ess/lecture/trainingMobile")
	public ModelAndView esstrainingMobile(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/trainingMobile.userEssMobile");
		return mv;
	}
	
	/**
	 * ESS 훈련 기관 상세
	 */
	@RequestMapping("/user/rdt/ess/lecture/training/detail")
	public ModelAndView essDetail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/trainingDetail.ess_user");
		return mv;
	}
	
	/**
	 * ESS 자격증
	 */
	@RequestMapping("/user/rdt/ess/lecture/license")
	public ModelAndView essLicense(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/license.ess_user");
		return mv;
	}
	
	/**
	 * ESS 자격증 Mobile
	 */
	@RequestMapping("/user/rdt/ess/lecture/licenseMobile")
	public ModelAndView essLicenseMobie(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("ess/lecture/licenseMobile.userEssMobile");
		return mv;
	}
	
	/**
	 * ESS 자격증 상세
	 */
	@RequestMapping("/user/rdt/ess/lecture/license/detail")
	public ModelAndView essLicenseDetail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("lecture/licenseDetail.ess_user");
		return mv;
	}
	
}
