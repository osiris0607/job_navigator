package com.anchordata.webframework.controller.admin.home;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.solar.job.JobVO;



@Controller("AdminHomeController")
public class AdminHomeController {
	
	/**
	 * 
	 * SOLAR HOME
	 *
	 * */
	@RequestMapping("/admin/rdt/solar/home/management")
	public ModelAndView rdtManagement(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/home/management.admin");
		return mv;
	}
	
	/**
	 * 
	 * ESS HOME
	 *
	 * */
	@RequestMapping("/admin/rdt/ess/home/management")
	public ModelAndView rdtEssManagement(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/home/management.ess_admin");
		return mv;
	}
	
}
