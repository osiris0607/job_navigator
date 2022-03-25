package com.anchordata.webframework.controller.user.solar.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.commonCode.CommonCodeService;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;
import com.anchordata.webframework.service.solar.job.JobSearchVO;
import com.anchordata.webframework.service.solar.job.JobService;
import com.anchordata.webframework.service.solar.job.JobVO;


@Controller("UserJobController")
public class UserJobController {
	
	@Autowired
	private CommonCodeService commonCodeService;
	@Autowired
	private JobService jobService;
	
	/**
	 * 
	 * SOLAR
	 * 
	 * */
	
	/**
	 * SOLAR 일자리 Main
	 */
	@RequestMapping("/user/rdt/solar/job/main")
	public ModelAndView rdtSolarJobMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("solar/job/main.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR 일자리 Mobile Main
	 */
	@RequestMapping("/user/rdt/solar/mobile/job/mainMobile")
	public ModelAndView rdtSolarMobileJobMain(ModelAndView mv) throws Exception {
		mv.setViewName("solar/job/mainMobile.userSolarMobile");
		return mv;
	}
	
	
	/**
	 * SOLAR 일자리 사전  Main
	 */
	@RequestMapping("/user/rdt/solar/jobDictionary/main")
	public ModelAndView rdtSearchList(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("solar/jobDictionary/main.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR 일자리 사전 Mobile Main
	 */
	@RequestMapping("/user/rdt/solar/mobile/jobDictionary/mainMobile")
	public ModelAndView rdtSolarMobileJobDicMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("solar/jobDictionary/mainMobile.userSolarMobile");
		return mv;
	}
	
	/**
	 * SOLAR 일자리 사전 상세
	 */
	@RequestMapping("/user/rdt/solar/jobDictionary/detail")
	public ModelAndView rdtSolarJobDictionaryDetail(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/jobDictionary/detail.sun_user");
		return mv;
	}
	
	
	/**
	 * SOLAR 유망 일자리
	 */
	@RequestMapping("/user/rdt/solar/jobPromising/main")
	public ModelAndView rdtSolarMobileJobPromisingMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/jobPromising/main.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR 유망 일자리 모바일
	 */
	@RequestMapping("/user/rdt/solar/jobPromising/mainMobile")
	public ModelAndView rdtSolarMobileJobPromisingMobileMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/jobPromising/mainMobile.userSolarMobile");
		return mv;
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	* SOLAR All List. not paging
	*/
	@RequestMapping("/user/api/solar/job/all")
		public ModelAndView allList(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.allList();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}	
	
	
	/**
	* SOLAR All Search List. not paging
	*/
	@RequestMapping("/user/api/solar/job/search/all")
		public ModelAndView allSearchList(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.searchAllList(vo);
		mv.addObject("totalCount", resList.size());
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 검색 List (9개씩)
	*/
	@RequestMapping("/user/api/solar/job/search/paging")
		public ModelAndView search(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.searchList(vo, 9);
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
	*  SOLAR 상세
	*/
	@RequestMapping("/user/api/solar/job/detail")
	public ModelAndView detail(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		JobVO result = jobService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 유망 일자리 All List
	*/
	@RequestMapping("/user/api/solar/jobTop/all")
		public ModelAndView allJobTopSearchList(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.allListRank();
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
	 * ESS 일자리 Main
	 */
	@RequestMapping("/user/rdt/ess/job/main")
	public ModelAndView rdtEssJobMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("ess/job/main.ess_user");
		return mv;
	}
	
	/**
	 * ESS 일자리 Mobile Main
	 */
	@RequestMapping("/user/rdt/ess/mobile/job/mainMobile")
	public ModelAndView rdtEssMobileJobMain(ModelAndView mv) throws Exception {
		mv.setViewName("ess/job/mainMobile.userEssMobile");
		return mv;
	}
	
	
	/**
	 * ESS 일자리 사전  Main
	 */
	@RequestMapping("/user/rdt/ess/jobDictionary/main")
	public ModelAndView essSearchList(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("ess/jobDictionary/main.ess_user");
		return mv;
	}
	
	/**
	 * ESS 일자리 사전 Mobile Main
	 */
	@RequestMapping("/user/rdt/ess/mobile/jobDictionary/mainMobile")
	public ModelAndView rdtEssMobileJobDicMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("ess/jobDictionary/mainMobile.userEssMobile");
		return mv;
	}
	
	/**
	 * ESS 일자리 사전 상세
	 */
	@RequestMapping("/user/rdt/ess/jobDictionary/detail")
	public ModelAndView rdtEssJobDictionaryDetail(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/jobDictionary/detail.ess_user");
		return mv;
	}
	
	
	/**
	 * ESS 유망 일자리
	 */
	@RequestMapping("/user/rdt/ess/jobPromising/main")
	public ModelAndView rdtEssMobileJobPromisingMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/jobPromising/main.ess_user");
		return mv;
	}
	
	/**
	 * ESS 유망 일자리 모바일
	 */
	@RequestMapping("/user/rdt/ess/jobPromising/mainMobile")
	public ModelAndView rdtEssMobileJobPromisingMobileMain(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/jobPromising/mainMobile.userEssMobile");
		return mv;
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	* All List. not paging
	*/
	@RequestMapping("/user/api/ess/job/all")
		public ModelAndView essAllList(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.allEssList();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}	
	
	
	/**
	* All Search List. not paging
	*/
	@RequestMapping("/user/api/ess/job/search/all")
		public ModelAndView essAllSearchList(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.searchEssAllList(vo);
		mv.addObject("totalCount", resList.size());
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* ESS 검색 List (9개씩)
	*/
	@RequestMapping("/user/api/ess/job/search/paging")
		public ModelAndView essSearch(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.searchEssList(vo, 9);
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
	*  상세
	*/
	@RequestMapping("/user/api/ess/job/detail")
	public ModelAndView essDetail(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		JobVO result = jobService.essDetail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* 유망 일자리 All List
	*/
	@RequestMapping("/user/api/ess/jobTop/all")
		public ModelAndView essAllJobTopSearchList(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.allEssListRank();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
}
