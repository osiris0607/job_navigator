package com.anchordata.webframework.controller.user.solar.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.commonCode.CommonCodeService;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;
import com.anchordata.webframework.service.solar.company.CompanySearchVO;
import com.anchordata.webframework.service.solar.company.CompanyService;
import com.anchordata.webframework.service.solar.company.CompanyVO;


@Controller("UserCompanyController")
public class UserCompanyController {
	
	@Autowired
	private CommonCodeService commonCodeService;
	@Autowired
	private CompanyService companyService;
	
	
	/**
	 * 
	 * SOLAR
	 * 
	 * */
	
	
	/**
	 * SOLAR Main
	 */
	@RequestMapping("/user/rdt/solar/company/main")
	public ModelAndView rdtSolarCompanyMain(@ModelAttribute CompanyVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("solar/company/main.sun_user");
		return mv;
	}
	
	/**
	 * SOLAR Main Mobile
	 */
	@RequestMapping("/user/rdt/solar/company/mainMobile")
	public ModelAndView rdtSolarCompanyMainMobile(@ModelAttribute CompanyVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("solar/company/mainMobile.userSolarMobile");
		return mv;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	/**
	* SOLAR 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/solar/company/search/paging")
		public ModelAndView search(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.searchList(vo);
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
	* SOLAR 검색 List ALL
	*/
	@RequestMapping("/user/api/solar/company/search/all")
		public ModelAndView searchAllList(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.searchAllList(vo);
		mv.addObject("totalCount", resList.size());
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR ALL
	*/
	@RequestMapping("/user/api/solar/company/all")
		public ModelAndView allList(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.allList();
		mv.addObject("totalCount", resList.size());
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 검색 : 지역별 Company 갯수
	*/
	@RequestMapping("/user/api/solar/company/search/region")
		public ModelAndView searchRegion(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.searchAllList(vo);
		List<CompanyVO> regionCountList = companyService.regionCount(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("result_region", regionCountList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	*  SOLAR 상세
	*/
	@RequestMapping("/user/api/solar/company/detail")
	public ModelAndView detail(@ModelAttribute CompanyVO vo, ModelAndView mv) throws Exception {
		CompanyVO result = companyService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	 * 
	 * ESS
	 * 
	 * */

	/**
	 * ESS Main
	 */
	@RequestMapping("/user/rdt/ess/company/main")
	public ModelAndView rdtEssCompanyMain(@ModelAttribute CompanyVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("ess/company/main.ess_user");
		return mv;
	}
	
	/**
	 * ESS Main Mobile
	 */
	@RequestMapping("/user/rdt/ess/company/mainMobile")
	public ModelAndView rdtEssCompanyMainMobile(@ModelAttribute CompanyVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("ess/company/mainMobile.userEssMobile");
		return mv;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	/**
	*  ESS 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/ess/company/search/paging")
		public ModelAndView essSearch(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.searchEssList(vo);
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
	*  ESS 검색 List ALL
	*/
	@RequestMapping("/user/api/ess/company/search/all")
		public ModelAndView essSearchAllList(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.searchEssAllList(vo);
		mv.addObject("totalCount", resList.size());
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	*  ESS ALL
	*/
	@RequestMapping("/user/api/ess/company/all")
		public ModelAndView essAllList(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.allEssList();
		mv.addObject("totalCount", resList.size());
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	*  ESS 검색 : 지역별 Company 갯수
	*/
	@RequestMapping("/user/api/ess/company/search/region")
		public ModelAndView essSearchRegion(@ModelAttribute CompanySearchVO vo, ModelAndView mv) throws Exception {
		List<CompanyVO> resList = companyService.searchEssAllList(vo);
		List<CompanyVO> regionCountList = companyService.regionEssCount(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("result_region", regionCountList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	*   ESS 상세
	*/
	@RequestMapping("/user/api/ess/company/detail")
	public ModelAndView essDetail(@ModelAttribute CompanyVO vo, ModelAndView mv) throws Exception {
		CompanyVO result = companyService.essDetail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
}
