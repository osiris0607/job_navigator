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
import com.anchordata.webframework.service.solar.online.OnlineSearchVO;
import com.anchordata.webframework.service.solar.online.OnlineService;
import com.anchordata.webframework.service.solar.online.OnlineVO;


@Controller("AdminOnlineController")
public class AdminOnlineController {
	
	/**
	 * 
	 * SOLAR Online
	 * 
	 * */
	@Autowired
	private OnlineService onlineService;
	
	@RequestMapping("/admin/rdt/solar/notification/online/registration")
	public ModelAndView rdtOnlineRegistration(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/notification/online/registration.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/online/searchList")
	public ModelAndView rdtOnlineList(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/notification/online/searchList.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/online/detail")
	public ModelAndView rdtOnlineDetail(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/online/detail.admin");
		return mv;
	}
	
	/**
	 * 
	 * ESS Online
	 * 
	 * */
	@RequestMapping("/admin/rdt/ess/notification/online/registration")
	public ModelAndView rdtEssOnlineRegistration(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/notification/online/registration.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/online/searchList")
	public ModelAndView rdtEssOnlineList(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/notification/online/searchList.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/online/detail")
	public ModelAndView rdtEssOnlineDetail(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/online/detail.ess_admin");
		return mv;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	/**
	* SOLAR 등록
	*/
	@RequestMapping("/admin/api/solar/notification/online/registration")
	public ModelAndView registration(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		mv.addObject( "result", onlineService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 등록
	 */
	@RequestMapping("/admin/api/ess/notification/online/registration")
	public ModelAndView essRegistration(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		mv.addObject( "result", onlineService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	* SOLAR 검색 List (10개씩)
	*/
	@RequestMapping("/admin/api/solar/notification/online/search/paging")
		public ModelAndView search(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<OnlineVO> resList = onlineService.searchList(vo);
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
	@RequestMapping("/admin/api/ess/notification/online/search/paging")
	public ModelAndView essSearch(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<OnlineVO> resList = onlineService.searchList(vo);
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
	* SOLAR List ALL
	*/
	@RequestMapping("/admin/api/solar/notification/online/all")
		public ModelAndView searchAll(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<OnlineVO> resList = onlineService.searchAllList(vo);
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS List ALL
	 */
	@RequestMapping("/admin/api/ess/notification/online/all")
	public ModelAndView essSearchAll(@ModelAttribute OnlineSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<OnlineVO> resList = onlineService.searchAllList(vo);
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	* SOLAR 상세
	*/
	@RequestMapping("/admin/api/solar/notification/online/search/detail")
	public ModelAndView detail(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		OnlineVO result = onlineService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * ESS 상세
	*/
	@RequestMapping("/admin/api/ess/notification/online/search/detail")
	public ModelAndView essDetail(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		OnlineVO result = onlineService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	 
	
	/**
	* SOLAR 변경
	*/
	@RequestMapping("/admin/api/solar/notification/online/modification")
	public ModelAndView modification(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", onlineService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 변경
	 */
	@RequestMapping("/admin/api/ess/notification/online/modification")
	public ModelAndView essModification(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", onlineService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * SOLAR 삭제
	 */
	@RequestMapping("/admin/api/solar/notification/online/withdrawal")
	public ModelAndView withdrawal(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", onlineService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 삭제
	 */
	@RequestMapping("/admin/api/ess/notification/online/withdrawal")
	public ModelAndView essWithdrawal(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", onlineService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	
	
}
