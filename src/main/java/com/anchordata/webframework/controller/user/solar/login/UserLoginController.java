package com.anchordata.webframework.controller.user.solar.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller("UserLoginController")
public class UserLoginController {
	
	@RequestMapping("/user/rdt/login/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws Exception {
		mv.setViewName("login/adminLogin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/gate/gate")
	public ModelAndView adminGate(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws Exception {
		mv.setViewName("admin/gate");
		return mv;
	}
	
	
	/**
	 *  로그인 Success
	 */
	@RequestMapping("/user/rdt/login/success")
	public String loginSuccess() {
		return "member/loginSuccess.user";
	}
	
	/**
	 * 로그인 Fail
	 * 
	 * @return
	 */
	@RequestMapping("/user/rdt/login/fail")
	public String loginFail() {
		return "member/loginFail.user";
	}
	
	
}
