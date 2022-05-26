package com.anchordata.webframework.controller.admin.notification;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
		vo.setJob_gb("D000004");
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
		vo.setJob_gb("D000003");
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
		vo.setJob_gb("D000004");
		mv.addObject( "result", onlineService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 변경
	 */
	@RequestMapping("/admin/api/ess/notification/online/modification")
	public ModelAndView essModification(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		mv.addObject( "result", onlineService.modification(vo) );
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * SOLAR 삭제
	 */
	@RequestMapping("/admin/api/solar/notification/online/withdrawal")
	public ModelAndView withdrawal(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000004");
		mv.addObject("result", onlineService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * ESS 삭제
	 */
	@RequestMapping("/admin/api/ess/notification/online/withdrawal")
	public ModelAndView essWithdrawal(@ModelAttribute OnlineVO vo, ModelAndView mv) throws Exception {
		vo.setJob_gb("D000003");
		System.out.println("Controller upload_file_id :: " + vo.getUpload_file_id());
		mv.addObject("result", onlineService.withdrawal(vo));
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * 
	 * 첨부파일 upload
	 * 
	 * */
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		System.out.println(":: [uploadAjax] :: ");
	}
	
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile, HttpServletRequest request) {
		System.out.println("update ajax post......");
		
		
		String uploadFolder = request.getSession().getServletContext().getRealPath("/files");
		
		//String uploadFolder = "//files";
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("=====================");
			System.out.println("Upload File Name :: " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size :: " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			//IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			System.out.println("only file name :: " + uploadFileName);
			
			File saveFile = new File(uploadFolder, uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		}
	}
	
	/**
	 * 
	 * 첨부파일 수정
	 * 
	 * */
	@PostMapping("/updateAjaxAction")
	public ResponseEntity<String> updateAjaxPost(HttpServletRequest request, String fileName, String oldFileName, MultipartFile[] uploadFile) {
		System.out.println("old ajax post......" + oldFileName);
		System.out.println("new ajax post......" + fileName);
		
		//기존 파일 삭제
		File oldFile;
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/files/");
			oldFile = new File(realPath+URLDecoder.decode(oldFileName, "UTF-8"));
			
			System.out.println("deleteFile :;: " + oldFile);
			
			if (oldFile.exists()) {
				oldFile.delete();
				System.out.println("파일삭제성공");
			}else {
				System.out.println("삭제실패");
			}
			
			oldFile.delete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//oldFile 삭제 후 newFile 업로드
		
		
		//파일 저장 폴더
		String uploadFolder = request.getSession().getServletContext().getRealPath("/files");
		
		for(MultipartFile multipartFile : uploadFile) {
			
			
			System.out.println("=====================");
			System.out.println("Upload File Name :: " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size :: " + multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			//IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			System.out.println("only file name :: " + uploadFileName);
			
			File saveFile = new File(uploadFolder, uploadFileName);
			System.out.println("saveFile ::: " + saveFile);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
			}
		}
		
		
		/*
		 * File deleteFile;
		 * 
		 * //기존 파일 삭제 후 새로 저장 try { deleteFile = new
		 * File("d:\\UPLOAD_FILE\\"+URLDecoder.decode(fileName, "UTF-8"));
		 * 
		 * System.out.println("deleteFile :;: " + deleteFile);
		 * 
		 * if (deleteFile.exists()) { deleteFile.delete(); System.out.println("파일삭제성공");
		 * }else { System.out.println("삭제실패"); }
		 * 
		 * 
		 * //deleteFile.delete(); } catch (Exception e) { // TODO: handle exception
		 * e.printStackTrace(); }
		 */
		
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
		
	}
	
	
	
	/**
	 * 
	 * 첨부파일 삭제
	 * 
	 * */
	@PostMapping("/deleteAjaxAction")
	public ResponseEntity<String> deleteAjaxPost(String fileName, HttpServletRequest request) {
		System.out.println("delete ajax post......" + fileName);
		
		File deleteFile;
		try {
			String realPath = request.getSession().getServletContext().getRealPath("/files/");
			deleteFile = new File(realPath+URLDecoder.decode(fileName, "UTF-8"));
			System.out.println("realPath : " + realPath);
			
			if (deleteFile.exists()) {
				deleteFile.delete();
				System.out.println("파일삭제성공");
			}else {
				System.out.println("삭제실패");
			}
			
			
			//deleteFile.delete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
		
	}
	
	//파일다운로드
	@RequestMapping(value="/user/rdt/lecture/fileDown", method=RequestMethod.POST)
	public String fileDown(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("fileDown api");
	    //업로드한 파일이 있는 경로
		String realPath = request.getSession().getServletContext().getRealPath("/files/");
	     
	    // 파일 이름이 파라미터로 넘어오지 않으면 리다이렉트 시킨다.
	    if(request.getParameter("fileName") == null || "".equals(request.getParameter("fileName"))){
	       // response.sendRedirect("/uploadResult");
	    	System.out.println("파일 이름 파라미터로 안넘어옴!!!!!!!!");
	    }else{
	        // 파라미터로 받은 파일 이름.
	        String requestFileNameAndPath = request.getParameter("fileName");
	        System.out.println("fileName :: " + requestFileNameAndPath);
	         
	        // 서버에서 파일찾기 위해 필요한 파일이름(경로를 포함하고 있음)
	        // 한글 이름의 파일도 찾을 수 있도록 하기 위해서 문자셋 지정해서 한글로 바꾼다.
	        String UTF8FileNameAndPath = new String(requestFileNameAndPath.getBytes("8859_1"), "UTF-8");
	         
	        // 파일이름에서 path는 잘라내고 파일명만 추출한다.
//	            String UTF8FileName = UTF8FileNameAndPath.substring(UTF8FileNameAndPath.lastIndexOf("/") + 1).substring(UTF8FileNameAndPath.lastIndexOf(File.separator) + 1);
	         
	        // 브라우저가 IE인지 확인할 플래그.
//	            boolean MSIE = request.getHeader("user-agent").indexOf("MSIE") != -1;
	         
	        // 파일 다운로드 시 받을 때 저장될 파일명
	        String fileNameToSave = requestFileNameAndPath;
	        System.out.println("저장될 파일명 : " + fileNameToSave);
	     
	        // IE,FF 각각 다르게 파일이름을 적용해서 구분해주어야 한다.
	       /*if(MSIE){
	            // 브라우저가 IE일 경우 저장될 파일 이름
	            // 공백이 '+'로 인코딩된것을 다시 공백으로 바꿔준다.
	            fileNameToSave = URLEncoder.encode(UTF8FileName, "UTF8").replaceAll("\\+", " ");
	        }else{
	            // 브라우저가 IE가 아닐 경우 저장될 파일 이름
	            fileNameToSave = new String(UTF8FileName.getBytes("UTF-8"), "8859_1");
	        }*/
	     
	        // 파일이 바로 실행되지 않고 다운로드가 되게 하기 위해서 컨텐트 타입을 8비트 바이너리로 설정한다.
	        response.setContentType("application/octet-stream");
	         
	        // 저장될 파일명을 지정한다.
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameToSave + "\";");
	         
	        // 파일패스 및 파일명을 지정한다.
	        //  String filePathAndName = pageContext.getServletContext().getRealPath("/") + UTF8FileNameAndPath;
	        String filePathAndName = realPath + UTF8FileNameAndPath;
	        
	        File file = new File(filePathAndName);
	         
	        // 버퍼 크기 설정
	        byte bytestream[] = new byte[2048000];
	     
	        // response out에 파일 내용을 출력한다.
	        if (file.isFile() && file.length() > 0){
	             
	            FileInputStream fis = new FileInputStream(file);
	            BufferedInputStream bis = new BufferedInputStream(fis);
	            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	                 
	            int read = 0;
	                 
	            while ((read = bis.read(bytestream)) != -1){
	                bos.write(bytestream , 0, read);
	            }
	             
	            bos.close();
	            bis.close();
	            
	        }
	    }
	    return null;
	}

	
}
