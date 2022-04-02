package com.anchordata.webframework.controller.admin.notification;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.solar.suggest.SuggestService;
import com.anchordata.webframework.service.solar.suggest.SuggestVO;
import com.anchordata.webframework.service.solar.license.LicenseVO;


@Controller("AdminSuggestController")
public class AdminSuggestController {
	
	@Autowired
	private SuggestService suggestService;
	
	/**
	 * 
	 * SOLAR SUGGEST
	 * 
	 * */
	@RequestMapping("/admin/rdt/solar/notification/suggest/management")
	public ModelAndView rdtManagement(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/notification/suggest/management.admin");
		return mv;
	}
	
	
	/**
	 * 
	 * ESS SUGGEST
	 * 
	 * */
	@RequestMapping("/admin/rdt/ess/notification/suggest/management")
	public ModelAndView rdtEssManagement(@ModelAttribute LicenseVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/notification/suggest/management.ess_admin");
		return mv;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	/**
	* SOLAR 등록
	*/
	@RequestMapping("/admin/api/solar/notification/suggest/registration")
	public ModelAndView registration(@ModelAttribute SuggestVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", suggestService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}

	
	/**
	* 검색 List ALL
	*/
	@RequestMapping("/admin/api/solar/notification/suggest/all")
		public ModelAndView searchAll(@ModelAttribute SuggestVO vo, ModelAndView mv) throws Exception {
		List<SuggestVO> resList = suggestService.allList();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* 변경
	*/
	@RequestMapping("/admin/api/solar/notification/suggest/modification")
	public ModelAndView modification(@ModelAttribute SuggestVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", suggestService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * 삭제
	 */
	@RequestMapping("/admin/api/solar/notification/suggest/withdrawal")
	public ModelAndView withdrawal(@ModelAttribute SuggestVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", suggestService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* 사용 여부 변경
	*/
	@RequestMapping("/admin/api/solar/notification/suggest/useYN")
		public ModelAndView categoryUseYN(@ModelAttribute SuggestVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", suggestService.updateUseYN(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
}
