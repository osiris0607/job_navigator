package com.anchordata.webframework.controller.admin.notification;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.commonCode.CommonCodeService;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;
import com.anchordata.webframework.service.solar.license.LicenseSearchVO;
import com.anchordata.webframework.service.solar.license.LicenseService;
import com.anchordata.webframework.service.solar.license.LicenseVO;


@Controller("AdminLicenseController")
public class AdminLicenseController {
	
	@Autowired
	private CommonCodeService commonCodeService;
	@Autowired
	private LicenseService licenseService;
	
	/**
	 * 
	 * SOLAR LICENSE
	 * 
	 * */
	@RequestMapping("/admin/rdt/solar/notification/license/registration")
	public ModelAndView rdtLicenseRegistration(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
//		mv.addObject("headerMenuIndex", headerMenuIndex);
		mv.setViewName("solar/notification/license/registration.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/license/searchList")
	public ModelAndView rdtLicenseList(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("solar/notification/license/searchList.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/license/detail")
	public ModelAndView rdtDetail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/license/detail.admin");
		return mv;
	}
	
	/**
	 * 
	 * ESS LICENSE
	 * 
	 * */
	@RequestMapping("/admin/rdt/ess/notification/license/registration")
	public ModelAndView rdtEssLicenseRegistration(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
//		mv.addObject("headerMenuIndex", headerMenuIndex);
		mv.setViewName("ess/notification/license/registration.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/license/searchList")
	public ModelAndView rdtEssLicenseList(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.setViewName("ess/notification/license/searchList.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/license/detail")
	public ModelAndView rdtEssDetail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/license/detail.ess_admin");
		return mv;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * SOLAR TREND
	 * 
	 * */
	
	/**
	* SOLAR 등록
	*/
	@RequestMapping("/admin/api/solar/notification/license/registration")
	public ModelAndView registration(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		mv.addObject( "result", licenseService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 등록
	 */
	@RequestMapping("/admin/api/ess/notification/license/registration")
	public ModelAndView essRegistration(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		mv.addObject( "result", licenseService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 검색 List (10개씩)
	*/
	@RequestMapping("/admin/api/solar/notification/license/search/paging")
		public ModelAndView search(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<LicenseVO> resList = licenseService.searchList(vo);
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
	 * ESS 검색 List (10개씩)
	 */
	@RequestMapping("/admin/api/ess/notification/license/search/paging")
	public ModelAndView essSearch(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<LicenseVO> resList = licenseService.searchList(vo);
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
	@RequestMapping("/admin/api/solar/notification/license/all")
		public ModelAndView searchAll(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<LicenseVO> resList = licenseService.searchAllList(vo);
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 검색 List ALL
	 */
	@RequestMapping("/admin/api/ess/notification/license/all")
	public ModelAndView EssSearchAll(@ModelAttribute LicenseSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<LicenseVO> resList = licenseService.searchAllList(vo);
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	*  SOLAR 상세
	*/
	@RequestMapping("/admin/api/solar/notification/license/search/detail")
	public ModelAndView detail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		LicenseVO result = licenseService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 *  ESS 상세
	 */
	@RequestMapping("/admin/api/ess/notification/license/search/detail")
	public ModelAndView essDetail(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		LicenseVO result = licenseService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 변경
	*/
	@RequestMapping("/admin/api/solar/notification/license/modification")
	public ModelAndView modification(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", licenseService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 변경
	 */
	@RequestMapping("/admin/api/ess/notification/license/modification")
	public ModelAndView essModification(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", licenseService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * SOLAR 삭제
	 */
	@RequestMapping("/admin/api/solar/notification/license/withdrawal")
	public ModelAndView withdrawal(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", licenseService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 삭제
	 */
	@RequestMapping("/admin/api/ess/notification/license/withdrawal")
	public ModelAndView essWithdrawal(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", licenseService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	
	
}
