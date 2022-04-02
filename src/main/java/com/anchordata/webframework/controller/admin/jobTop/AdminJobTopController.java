package com.anchordata.webframework.controller.admin.jobTop;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.solar.job.JobSearchVO;
import com.anchordata.webframework.service.solar.job.JobService;
import com.anchordata.webframework.service.solar.job.JobVO;


@Controller("AdminJobTopController")
public class AdminJobTopController {
	
	@Autowired
	private JobService jobService;
	
	/**
	 * 
	 * SOLAR JOBTOP
	 * 
	 * */
	@RequestMapping("/admin/rdt/solar/jobTop/management")
	public ModelAndView rdtManagement(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/jobTop/management.admin");
		return mv;
	}
	
	/**
	 * 
	 * ESS JOBTOP
	 * 
	 * */
	@RequestMapping("/admin/rdt/ess/jobTop/management")
	public ModelAndView rdtEssManagement(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/jobTop/management.ess_admin");
		return mv;
	}
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * SOLAR JOBTOP
	 * 
	 * */
	
	/**
	* 등록
	*/
	@RequestMapping("/admin/api/solar/jobTop/useYN")
	public ModelAndView updateRank(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", jobService.updateRank(vo) );
		mv.setViewName("jsonView");
		return mv;
	}	
	
	/**
	* All List
	*/
	@RequestMapping("/admin/api/solar/jobTop/all")
		public ModelAndView allSearchList(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.allListRank();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 
	 * ESS JOBTOP
	 * 
	 * */
	
	/**
	 * 등록
	 */
	@RequestMapping("/admin/api/ess/jobTop/useYN")
	public ModelAndView essUpdateRank(@ModelAttribute JobVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", jobService.essUpdateRank(vo) );
		mv.setViewName("jsonView");
		return mv;
	}	
	
	/**
	 * All List
	 */
	@RequestMapping("/admin/api/ess/jobTop/all")
	public ModelAndView allEssSearchList(@ModelAttribute JobSearchVO vo, ModelAndView mv) throws Exception {
		List<JobVO> resList = jobService.allEssListRank();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
}
