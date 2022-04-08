package com.anchordata.webframework.controller.user.solar.main;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.base.common.auth.service.AuthService;
import com.anchordata.webframework.service.main.MainService;


@Controller("UserMainController")
public class UserMainController {
	@Autowired
	public AuthService authService;
	@Autowired
	public MainService mainService;
	
	/**
	 * SOLAR Main
	 */
	@RequestMapping("/user/rdt/solar/main/main")
	public ModelAndView rdtSolarMain(Authentication auth, HttpSession session, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		System.out.println("solar main !!!!");
		// 방문자 수 계산
				// Cookie를 이용하여 최대한 중복 방문자를 막는다.
				Cookie[] cookies = request.getCookies();
				
				
				// 비교하기 위해 새로운 쿠키
		        Cookie viewCookie = null;
		 
		        // 쿠키가 있을 경우 
		        if (cookies != null && cookies.length > 0) {
		            for (int i = 0; i < cookies.length; i++) {
		                // Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌 
		                if (cookies[i].getName().equals("cookie_solar_starter")) { 
		                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
		                    viewCookie = cookies[i];
		                    
		                }
		            }
		        }
		                
		        // gate쿠키와 ess쿠키를 별도로 둠
		        if (viewCookie == null) {    
		            System.out.println("cookie 없음");
		            
		            // 쿠키 값 - 오늘 날짜.
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 쿠키 생성(이름, 값)
		            Cookie newCookie = new Cookie("cookie_solar_starter", toDate );
		            // 쿠키 추가
		            response.addCookie(newCookie);
		            //조회수 증가
		            mainService.addSolarVisitCounter();
		        }
		        // viewCookie가 null이 아닐경우 쿠키 값인 날짜비교. 날짜가 지났으면 Counter 증가. 
		        else {
		            // 쿠키 값 받아옴.
		            String value = viewCookie.getValue();
		            // 오늘 날짜
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 날짜 비교
		            // 날짜가 다르면 Couter 증가.
		            // 오늘 날짜를 새로운 쿠키 값으로 저장 후 전송
		            if (StringUtils.equals(value, toDate) == false ) {
		            	// 쿠키 생성(이름, 값)
		                Cookie newCookie = new Cookie("cookie_solar_starter", toDate );
		                // 쿠키 추가
		                response.addCookie(newCookie);
		                //조회수 증가
		                mainService.addSolarVisitCounter();
		            }
		        }
		mv.setViewName("solar/main/main.sun_user");
		return mv;
	}
	
	/**
	 * Ess Main 
	 */
	@RequestMapping("/user/rdt/ess/main/main")
	public ModelAndView rdtEssMain(Authentication auth, HttpSession session, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		System.out.println("ess main !!!!");
		// 방문자 수 계산
				// Cookie를 이용하여 최대한 중복 방문자를 막는다.
				Cookie[] cookies = request.getCookies();
				
				
				// 비교하기 위해 새로운 쿠키
		        Cookie viewCookie = null;
		 
		        // 쿠키가 있을 경우 
		        if (cookies != null && cookies.length > 0) {
		            for (int i = 0; i < cookies.length; i++) {
		                // Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌 
		                if (cookies[i].getName().equals("cookie_ess_starter")) { 
		                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
		                    viewCookie = cookies[i];
		                    
		                }
		            }
		        }
		                
		        // gate쿠키와 ess쿠키를 별도로 둠
		        if (viewCookie == null) {    
		            System.out.println("cookie 없음");
		            
		            // 쿠키 값 - 오늘 날짜.
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 쿠키 생성(이름, 값)
		            Cookie newCookie = new Cookie("cookie_ess_starter", toDate );
		            // 쿠키 추가
		            response.addCookie(newCookie);
		            //조회수 증가
		            mainService.addEssVisitCounter();
		        }
		        // viewCookie가 null이 아닐경우 쿠키 값인 날짜비교. 날짜가 지났으면 Counter 증가. 
		        else {
		            // 쿠키 값 받아옴.
		            String value = viewCookie.getValue();
		            // 오늘 날짜
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 날짜 비교
		            // 날짜가 다르면 Couter 증가.
		            // 오늘 날짜를 새로운 쿠키 값으로 저장 후 전송
		            if (StringUtils.equals(value, toDate) == false ) {
		            	// 쿠키 생성(이름, 값)
		                Cookie newCookie = new Cookie("cookie_ess_starter", toDate );
		                // 쿠키 추가
		                response.addCookie(newCookie);
		                //조회수 증가
		                mainService.addEssVisitCounter();
		            }
		        }
		mv.setViewName("ess/main/main.ess_user");
		return mv;
	}
	
	/**
	 * SOLAR Mobile Main
	 */
	@RequestMapping("/user/rdt/solar/mobile/main/mainMobile")
	public ModelAndView rdtMobileSolarMain(Authentication auth, HttpSession session, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		System.out.println("solar main !!!!");
		// 방문자 수 계산
				// Cookie를 이용하여 최대한 중복 방문자를 막는다.
				Cookie[] cookies = request.getCookies();
				
				
				// 비교하기 위해 새로운 쿠키
		        Cookie viewCookie = null;
		 
		        // 쿠키가 있을 경우 
		        if (cookies != null && cookies.length > 0) {
		            for (int i = 0; i < cookies.length; i++) {
		                // Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌 
		                if (cookies[i].getName().equals("cookie_solar_starter")) { 
		                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
		                    viewCookie = cookies[i];
		                    
		                }
		            }
		        }
		                
		        // gate쿠키와 ess쿠키를 별도로 둠
		        if (viewCookie == null) {    
		            System.out.println("cookie 없음");
		            
		            // 쿠키 값 - 오늘 날짜.
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 쿠키 생성(이름, 값)
		            Cookie newCookie = new Cookie("cookie_solar_starter", toDate );
		            // 쿠키 추가
		            response.addCookie(newCookie);
		            //조회수 증가
		            mainService.addSolarVisitCounter();
		        }
		        // viewCookie가 null이 아닐경우 쿠키 값인 날짜비교. 날짜가 지났으면 Counter 증가. 
		        else {
		            // 쿠키 값 받아옴.
		            String value = viewCookie.getValue();
		            // 오늘 날짜
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 날짜 비교
		            // 날짜가 다르면 Couter 증가.
		            // 오늘 날짜를 새로운 쿠키 값으로 저장 후 전송
		            if (StringUtils.equals(value, toDate) == false ) {
		            	// 쿠키 생성(이름, 값)
		                Cookie newCookie = new Cookie("cookie_solar_starter", toDate );
		                // 쿠키 추가
		                response.addCookie(newCookie);
		                //조회수 증가
		                mainService.addSolarVisitCounter();
		            }
		        }
		mv.setViewName("solar/main/mainMobile.userSolarMobile");
		return mv;
	}
	
	/**
	 * Ess Mobile Main 
	 */
	@RequestMapping("/user/rdt/ess/mobile/main/mainMobile")
	public ModelAndView rdtMobileEssMain(Authentication auth, HttpSession session, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		System.out.println("ess main !!!!");
		// 방문자 수 계산
				// Cookie를 이용하여 최대한 중복 방문자를 막는다.
				Cookie[] cookies = request.getCookies();
				
				
				// 비교하기 위해 새로운 쿠키
		        Cookie viewCookie = null;
		 
		        // 쿠키가 있을 경우 
		        if (cookies != null && cookies.length > 0) {
		            for (int i = 0; i < cookies.length; i++) {
		                // Cookie의 name이 cookie + reviewNo와 일치하는 쿠키를 viewCookie에 넣어줌 
		                if (cookies[i].getName().equals("cookie_ess_starter")) { 
		                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
		                    viewCookie = cookies[i];
		                    
		                }
		            }
		        }
		                
		        // gate쿠키와 ess쿠키를 별도로 둠
		        if (viewCookie == null) {    
		            System.out.println("cookie 없음");
		            
		            // 쿠키 값 - 오늘 날짜.
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 쿠키 생성(이름, 값)
		            Cookie newCookie = new Cookie("cookie_ess_starter", toDate );
		            // 쿠키 추가
		            response.addCookie(newCookie);
		            //조회수 증가
		            mainService.addEssVisitCounter();
		        }
		        // viewCookie가 null이 아닐경우 쿠키 값인 날짜비교. 날짜가 지났으면 Counter 증가. 
		        else {
		            // 쿠키 값 받아옴.
		            String value = viewCookie.getValue();
		            // 오늘 날짜
		            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		            Date toDay = new Date();
		            String toDate = mSimpleDateFormat.format( toDay );
		            // 날짜 비교
		            // 날짜가 다르면 Couter 증가.
		            // 오늘 날짜를 새로운 쿠키 값으로 저장 후 전송
		            if (StringUtils.equals(value, toDate) == false ) {
		            	// 쿠키 생성(이름, 값)
		                Cookie newCookie = new Cookie("cookie_ess_starter", toDate );
		                // 쿠키 추가
		                response.addCookie(newCookie);
		                //조회수 증가
		                mainService.addEssVisitCounter();
		            }
		        }
		mv.setViewName("ess/main/mainMobile.userEssMobile");
		return mv;
	}
}
