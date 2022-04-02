package com.anchordata.webframework.controller.admin.notification;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.solar.faq.FAQSearchVO;
import com.anchordata.webframework.service.solar.faq.FAQService;
import com.anchordata.webframework.service.solar.faq.FAQVO;


@Controller("AdminFAQController")
public class AdminFAQController {
	
	/**
	 * 
	 * SOLAR FAQ
	 * 
	 * */
	@Autowired
	private FAQService faqService;
	
	@RequestMapping("/admin/rdt/solar/notification/faq/registration")
	public ModelAndView rdtLicenseRegistration(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/notification/faq/registration.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/faq/searchList")
	public ModelAndView rdtLicenseList(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/notification/faq/searchList.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/faq/detail")
	public ModelAndView rdtDetail(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/faq/detail.admin");
		return mv;
	}
	
	/**
	 * 
	 * ESS FAQ
	 * 
	 * */
	@RequestMapping("/admin/rdt/ess/notification/faq/registration")
	public ModelAndView rdtEssLicenseRegistration(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/notification/faq/registration.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/faq/searchList")
	public ModelAndView rdtEssLicenseList(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/notification/faq/searchList.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/faq/detail")
	public ModelAndView rdtEssDetail(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/faq/detail.ess_admin");
		return mv;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	/**
	* SOLAR 등록
	*/
	@RequestMapping("/admin/api/solar/notification/faq/registration")
	public ModelAndView registration(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		mv.addObject( "result", faqService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 등록
	 */
	@RequestMapping("/admin/api/ess/notification/faq/registration")
	public ModelAndView essRegistration(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		mv.addObject( "result", faqService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 검색 List (10개씩)
	*/
	@RequestMapping("/admin/api/solar/notification/faq/search/paging")
		public ModelAndView search(@ModelAttribute FAQSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<FAQVO> resList = faqService.searchList(vo);
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
	@RequestMapping("/admin/api/ess/notification/faq/search/paging")
	public ModelAndView essSearch(@ModelAttribute FAQSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<FAQVO> resList = faqService.searchList(vo);
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
	* 검색 List ALL
	*/
	@RequestMapping("/admin/api/solar/notification/faq/all")
		public ModelAndView searchAll(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<FAQVO> resList = faqService.allList();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	* SOLAR 상세
	*/
	@RequestMapping("/admin/api/solar/notification/faq/search/detail")
	public ModelAndView detail(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		FAQVO result = faqService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 상세
	 */
	@RequestMapping("/admin/api/ess/notification/faq/search/detail")
	public ModelAndView essDetail(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		FAQVO result = faqService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 변경
	*/
	@RequestMapping("/admin/api/solar/notification/faq/modification")
	public ModelAndView modification(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", faqService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 변경
	 */
	@RequestMapping("/admin/api/ess/notification/faq/modification")
	public ModelAndView essModification(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", faqService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * SOLAR 삭제
	 */
	@RequestMapping("/admin/api/solar/notification/faq/withdrawal")
	public ModelAndView withdrawal(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", faqService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 삭제
	 */
	@RequestMapping("/admin/api/ess/notification/faq/withdrawal")
	public ModelAndView essWithdrawal(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", faqService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	
	
}
