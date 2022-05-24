package com.anchordata.webframework.controller.user.solar.jobnavi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.commonCode.CommonCodeService;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;
import com.anchordata.webframework.service.solar.job.JobVO;


@Controller("UserJobNaviController")
public class UserJobNaviController {
	
	@Autowired
	private CommonCodeService commonCodeService;
	
	/**
	 * jobnavigator_채용정보
	 */
	@RequestMapping("/user/rdt/jobnavi/employinfo")
	public ModelAndView rdtEmployInfo(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("jobnavi/employInfo/employInfo.jobnavi_user");
		return mv;
	}
	
	
}
