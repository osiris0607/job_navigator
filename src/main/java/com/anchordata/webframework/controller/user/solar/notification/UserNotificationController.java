package com.anchordata.webframework.controller.user.solar.notification;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchordata.webframework.service.solar.faq.FAQSearchVO;
import com.anchordata.webframework.service.solar.faq.FAQService;
import com.anchordata.webframework.service.solar.faq.FAQVO;
import com.anchordata.webframework.service.solar.training.TrainingSearchVO;
import com.anchordata.webframework.service.solar.training.TrainingVO;
import com.anchordata.webframework.service.notice.NoticeVO;
import com.anchordata.webframework.service.solar.trend.TrendSearchVO;
import com.anchordata.webframework.service.solar.trend.TrendService;
import com.anchordata.webframework.service.solar.trend.TrendVO;
import com.anchordata.webframework.service.uploadFile.UploadFileService;
import com.anchordata.webframework.service.uploadFile.UploadFileVO;


@Controller("UserNotificationController")
public class UserNotificationController {
	
	
	@Autowired
	private TrendService trendService;
	@Autowired
	private UploadFileService uploadFileService;
	@Autowired
	private FAQService faqService;
	
	/**
	 * 
	 * SOLAR
	 * 
	 * */
	
	
	/**
	 * SOLAR 태양광산업 동향 리스트
	 */
	@RequestMapping("/user/rdt/solar/notification/trend")
	public ModelAndView rdtTrend(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/trend.sun_user");
		return mv;
	}
	
	
	/**
	 * SOLAR 태양광산업 동향 리스트 Mobile
	 */
	@RequestMapping("/user/rdt/solar/notification/trendMobile")
	public ModelAndView rdtTrendMobile(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/trendMobile.userSolarMobile");
		return mv;
	}
	
	
	/**
	 * SOLAR 태양광산업 동향 상세
	 */
	@RequestMapping("/user/rdt/solar/notification/trend/detail")
	public ModelAndView rdtTrendDetail(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/trendDetail.sun_user");
		return mv;
	}
	
	
	/**
	 * SOLAR 태양광산업 동향 상세 모바일
	 */
	@RequestMapping("/user/rdt/solar/notification/trend/detailMobile")
	public ModelAndView rdtTrendDetailMobile(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/trendDetailMobile.userSolarMobile");
		return mv;
	}
	
	
	/**
	 * SOLAR FAQ
	 */
	@RequestMapping("/user/rdt/solar/notification/faq")
	public ModelAndView rdtFaq(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/faq.sun_user");
		return mv;
	}
	
	
	/**
	 * SOLAR FAQ Mobile
	 */
	@RequestMapping("/user/rdt/solar/notification/faqMobile")
	public ModelAndView rdtFaqMobile(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("solar/notification/faqMobile.userSolarMobile");
		return mv;
	}
	
	
	/**
	 * SOLAR 건의사항
	 */
	@RequestMapping("/user/rdt/solar/notification/suggest")
	public ModelAndView rdtSuggest(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("notification/suggest.sun_user");
		return mv;
	}

	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	* SOLAR 태양광산업 동향 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/solar/notification/trend/search/paging")
		public ModelAndView search(@ModelAttribute TrendSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<TrendVO> resList = trendService.searchList(vo);
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
	* SOLAR 태양광산업 동향 검색 List All
	*/
	@RequestMapping("/user/api/solar/notification/trend/search/all")
		public ModelAndView searchAll(@ModelAttribute TrendSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<TrendVO> resList = trendService.searchAllList(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  SOLAR 태양광산업 동향 검색 상세
	*/
	@RequestMapping("/user/api/solar/notification/trend/search/detail")
	public ModelAndView detail(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		TrendVO result = trendService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 *  SOLAR 태양광산업 동향 이전글 다음글 검색
	 * @return
	 */
	@RequestMapping(value = "/user/api/solar/trend/preNext")
	public ModelAndView previousNext(@ModelAttribute TrendSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<TrendVO> resList	= trendService.preNextList(vo); 
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		
		if ( resList.size() == 0 ) 
		{
			returnMap.put("pre", null);
			returnMap.put("next", null);
		}
		else if (resList.size() >= 2 ) {
			returnMap.put("next", resList.get(0));
			returnMap.put("pre", resList.get(1));
		}
		else {
			if ( Integer.parseInt(resList.get(0).getTrend_id()) < Integer.parseInt(vo.getTrend_id()) ) {
				returnMap.put("pre", null);
				returnMap.put("next", resList.get(0));
			}
			else {
				returnMap.put("pre", resList.get(0));
				returnMap.put("next", null);
			}
		}

		mv.addObject("result", returnMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  SOLAR 태양광산업 동향 검색 첨부파일 다운로드
	* @return
	*/
	@RequestMapping(value = "/user/api/solar/trend/download/{file_id}")
	public void downloadFile (@PathVariable("file_id") String fileId, HttpSession session, HttpServletResponse response) throws Exception {
		UploadFileVO UploadFileVO = new UploadFileVO();
		UploadFileVO.setFile_id(Integer.parseInt(fileId));
		UploadFileVO = uploadFileService.selectUploadFileContent(UploadFileVO);
		
		response.setContentType("application/octet-stream"); 
		response.setContentLength(UploadFileVO.getBinary_content().length); 
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(UploadFileVO.getName(),"UTF-8")+"\";"); 
		response.setHeader("Content-Transfer-Encoding", "binary"); 
		response.getOutputStream().write(UploadFileVO.getBinary_content()); 
		response.getOutputStream().flush(); 
		response.getOutputStream().close(); 
	}
	
	
	/**
	* SOLAR FAQ 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/solar/notification/faq/search/paging")
		public ModelAndView search(@ModelAttribute FAQSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<FAQVO> resList = faqService.searchList(vo);
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
	* SOLAR FAQ 검색 List All
	*/
	@RequestMapping("/user/api/solar/notification/faq/search/all")
		public ModelAndView searchAllList(@ModelAttribute FAQSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		List<FAQVO> resList = faqService.searchAllList(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  SOLAR FAQ 상세
	*/
	@RequestMapping("/user/api/solar/notification/faq/search/detail")
	public ModelAndView detail(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		FAQVO result = faqService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * 
	 * ESS
	 * 
	 */
	
	
	/**
	 * ESS 산업 동향 리스트
	 */
	@RequestMapping("/user/rdt/ess/notification/trend")
	public ModelAndView essTrend(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/trend.ess_user");
		return mv;
	}
	
	
	/**
	 * ESS 산업 동향 리스트 Mobile
	 */
	@RequestMapping("/user/rdt/ess/notification/trendMobile")
	public ModelAndView essTrendMobile(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/trendMobile.userEssMobile");
		return mv;
	}
	
	
	/**
	 * ESS 산업 동향 상세
	 */
	@RequestMapping("/user/rdt/ess/notification/trend/detail")
	public ModelAndView essTrendDetail(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/trendDetail.ess_user");
		return mv;
	}
	
	
	/**
	 * ESS 산업 동향 상세 모바일
	 */
	@RequestMapping("/user/rdt/ess/notification/trend/detailMobile")
	public ModelAndView essTrendDetailMobile(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/trendDetailMobile.userEssMobile");
		return mv;
	}
	
	
	/**
	 * ESS FAQ
	 */
	@RequestMapping("/user/rdt/ess/notification/faq")
	public ModelAndView essFaq(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/faq.ess_user");
		return mv;
	}
	
	
	/**
	 * ESS FAQ Mobile
	 */
	@RequestMapping("/user/rdt/ess/notification/faqMobile")
	public ModelAndView essFaqMobile(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("ess/notification/faqMobile.userEssMobile");
		return mv;
	}
	
	
	/**
	 * ESS 건의사항
	 */
	@RequestMapping("/user/rdt/ess/notification/suggest")
	public ModelAndView essSuggest(@ModelAttribute NoticeVO vo, ModelAndView mv) throws Exception {
		mv.addObject("vo", vo);
		mv.setViewName("notification/suggest.ess_user");
		return mv;
	}

	
	///////////////////////////////////////////////////////////////////////////
	// OPEN API 호출
	///////////////////////////////////////////////////////////////////////////
	
	/**
	* ESS 산업 동향 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/ess/notification/trend/search/paging")
		public ModelAndView essSearch(@ModelAttribute TrendSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<TrendVO> resList = trendService.searchList(vo);
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
	* ESS 산업 동향 검색 List All
	*/
	@RequestMapping("/user/api/ess/notification/trend/search/all")
		public ModelAndView essSearchAll(@ModelAttribute TrendSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<TrendVO> resList = trendService.searchAllList(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  ESS 산업 동향 검색 상세
	*/
	@RequestMapping("/user/api/ess/notification/trend/search/detail")
	public ModelAndView essDetail(@ModelAttribute TrendVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		TrendVO result = trendService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 *  ESS 산업 동향 이전글 다음글 검색
	 * @return
	 */
	@RequestMapping(value = "/user/api/ess/trend/preNext")
	public ModelAndView essPreviousNext(@ModelAttribute TrendSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<TrendVO> resList	= trendService.preNextList(vo); 
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		
		if ( resList.size() == 0 ) 
		{
			returnMap.put("pre", null);
			returnMap.put("next", null);
		}
		else if (resList.size() >= 2 ) {
			returnMap.put("next", resList.get(0));
			returnMap.put("pre", resList.get(1));
		}
		else {
			if ( Integer.parseInt(resList.get(0).getTrend_id()) < Integer.parseInt(vo.getTrend_id()) ) {
				returnMap.put("pre", null);
				returnMap.put("next", resList.get(0));
			}
			else {
				returnMap.put("pre", resList.get(0));
				returnMap.put("next", null);
			}
		}

		mv.addObject("result", returnMap);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  ESS 산업 동향 검색 첨부파일 다운로드
	* @return
	*/
	@RequestMapping(value = "/user/api/ess/trend/download/{file_id}")
	public void essDownloadFile (@PathVariable("file_id") String fileId, HttpSession session, HttpServletResponse response) throws Exception {
		UploadFileVO UploadFileVO = new UploadFileVO();
		UploadFileVO.setFile_id(Integer.parseInt(fileId));
		UploadFileVO = uploadFileService.selectUploadFileContent(UploadFileVO);
		
		response.setContentType("application/octet-stream"); 
		response.setContentLength(UploadFileVO.getBinary_content().length); 
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(UploadFileVO.getName(),"UTF-8")+"\";"); 
		response.setHeader("Content-Transfer-Encoding", "binary"); 
		response.getOutputStream().write(UploadFileVO.getBinary_content()); 
		response.getOutputStream().flush(); 
		response.getOutputStream().close(); 
	}
	
	
	/**
	* ESS FAQ 검색 List (10개씩)
	*/
	@RequestMapping("/user/api/ess/notification/faq/search/paging")
		public ModelAndView essSearch(@ModelAttribute FAQSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<FAQVO> resList = faqService.searchList(vo);
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
	* FAQ 검색 List All
	*/
	@RequestMapping("/user/api/ess/notification/faq/search/all")
		public ModelAndView essSearchAllList(@ModelAttribute FAQSearchVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		List<FAQVO> resList = faqService.searchAllList(vo);
		if (resList.size() > 0) {
			mv.addObject("result", resList);
			mv.addObject("totalCount", resList.size());
		} else {
			mv.addObject("totalCount", 0);
		}
		
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	*  FAQ 상세
	*/
	@RequestMapping("/user/api/notification/faq/search/detail")
	public ModelAndView essDetail(@ModelAttribute FAQVO vo, ModelAndView mv) throws Exception {
		FAQVO result = faqService.detail(vo);
		mv.addObject("result", result);
		mv.setViewName("jsonView");
		return mv;
	}
	
	
}
