package com.anchordata.webframework.controller.user.solar.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller("UserMainController")
public class UserMainController {
	
	
	/**
	 * SOLAR Main
	 */
	@RequestMapping("/user/rdt/solar/main/main")
	public ModelAndView rdtSolarMain(ModelAndView mv) throws Exception {
		mv.setViewName("solar/main/main.sun_user");
		return mv;
	}
	
	/**
	 * Ess Main 
	 */
	@RequestMapping("/user/rdt/ess/main/main")
	public ModelAndView rdtEssMain(ModelAndView mv) throws Exception {
		mv.setViewName("ess/main/main.ess_user");
		return mv;
	}
	
	/**
	 * SOLAR Main
	 */
	@RequestMapping("/user/rdt/solar/mobile/main/mainMobile")
	public ModelAndView rdtMobileSolarMain(ModelAndView mv) throws Exception {
		mv.setViewName("solar/main/mainMobile.userSolarMobile");
		return mv;
	}
	
	/**
	 * Ess Mobile Main 
	 */
	@RequestMapping("/user/rdt/ess/mobile/main/mainMobile")
	public ModelAndView rdtMobileEssMain(ModelAndView mv) throws Exception {
		mv.setViewName("ess/main/mainMobile.userEssMobile");
		return mv;
	}
}
