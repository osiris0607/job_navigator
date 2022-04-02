package com.anchordata.webframework.controller.admin.notification;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.commonCode.CommonCodeService;
import com.anchordata.webframework.service.commonCode.CommonCodeVO;
import com.anchordata.webframework.service.solar.training.TrainingSearchVO;
import com.anchordata.webframework.service.solar.training.TrainingService;
import com.anchordata.webframework.service.solar.training.TrainingVO;


@Controller("AdminTrainingController")
public class AdminTrainingController {
	
	@Autowired
	private CommonCodeService commonCodeService;
	@Autowired
	private TrainingService trainingService;
	
	/**
	 * 
	 * SOLAR TRAINING
	 * 
	 * */
	@RequestMapping("/admin/rdt/solar/notification/training/registration")
	public ModelAndView rdtLicenseRegistration(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
//		mv.addObject("headerMenuIndex", headerMenuIndex);
		mv.setViewName("solar/notification/training/registration.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/training/searchList")
	public ModelAndView rdtLicenseList(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("solar/notification/training/searchList.admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/solar/notification/training/detail")
	public ModelAndView rdtDetail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/training/detail.admin");
		return mv;
	}
	
	/**
	 * 
	 * ESS TRAINING
	 * 
	 * */
	@RequestMapping("/admin/rdt/ess/notification/training/registration")
	public ModelAndView rdtEssLicenseRegistration(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		List<CommonCodeVO> result = commonCodeService.selectListAllUseYN();
		mv.addObject("commonCode", result);
//		mv.addObject("headerMenuIndex", headerMenuIndex);
		mv.setViewName("ess/notification/training/registration.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/training/searchList")
	public ModelAndView rdtEssLicenseList(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.setViewName("ess/notification/training/searchList.ess_admin");
		return mv;
	}
	
	@RequestMapping("/admin/rdt/ess/notification/training/detail")
	public ModelAndView rdtEssDetail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/training/detail.ess_admin");
		return mv;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	* SOLAR 등록
	*/
	@RequestMapping("/admin/api/solar/notification/training/registration")
	public ModelAndView registration(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		mv.addObject( "result", trainingService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 등록
	 */
	@RequestMapping("/admin/api/ess/notification/training/registration")
	public ModelAndView essRegistration(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		mv.addObject( "result", trainingService.registration(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOALR 검색 List (10개씩)
	*/
	@RequestMapping("/admin/api/solar/notification/training/search/paging")
		public ModelAndView search(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<TrainingVO> resList = trainingService.searchList(vo);
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
	@RequestMapping("/admin/api/ess/notification/training/search/paging")
	public ModelAndView essSearch(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<TrainingVO> resList = trainingService.searchList(vo);
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
	@RequestMapping("/admin/api/solar/notification/training/all")
		public ModelAndView searchAll(@ModelAttribute TrainingSearchVO vo, ModelAndView mv) throws Exception {
		List<TrainingVO> resList = trainingService.allList();
		mv.addObject("result", resList);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	*  SOALR 상세
	*/
	@RequestMapping("/admin/api/solar/notification/training/search/detail")
	public ModelAndView detail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		TrainingVO result = trainingService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 *  ESS 상세
	 */
	@RequestMapping("/admin/api/ess/notification/training/search/detail")
	public ModelAndView essDetail(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		TrainingVO result = trainingService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	* SOLAR 변경
	*/
	@RequestMapping("/admin/api/solar/notification/training/modification")
	public ModelAndView modification(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", trainingService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 변경
	 */
	@RequestMapping("/admin/api/ess/notification/training/modification")
	public ModelAndView essModification(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject( "result", trainingService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * SOLAR 삭제
	 */
	@RequestMapping("/admin/api/solar/notification/training/withdrawal")
	public ModelAndView withdrawal(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", trainingService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 삭제
	 */
	@RequestMapping("/admin/api/ess/notification/training/withdrawal")
	public ModelAndView essWithdrawal(@ModelAttribute TrainingVO vo, ModelAndView mv) throws Exception {
		mv.addObject("result", trainingService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	
	
}
