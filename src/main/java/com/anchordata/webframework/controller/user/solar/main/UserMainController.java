package com.anchordata.webframework.controller.user.solar.main;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller("UserMainController")
public class UserMainController {
	
	
	/**
	 * Main
	 */
	@RequestMapping("/user/rdt/solar/main/main")
	public ModelAndView rdtSolarMain(ModelAndView mv) throws Exception {
		mv.setViewName("solar/main/main.user");
		return mv;
	}
	
	
	/**
	 * Main
	 */
	@RequestMapping("/user/rdt/solar/mobile/main/mainMobile")
	public ModelAndView rdtMobileSolarMain(ModelAndView mv) throws Exception {
		mv.setViewName("solar/main/mainMobile.userSolarMobile");
		return mv;
	}
}
