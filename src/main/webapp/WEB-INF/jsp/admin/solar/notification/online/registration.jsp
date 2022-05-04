<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal.username" var="member_id" />
  
<script type='text/javascript'>
	
	$(document).ready(function() {
		
		//상세페이지 오픈 시 발생
		 if($(".youtube_check").is(":checked")) {
	            $(".custom-file-input").attr("disabled", true);
	            $("#url").attr("disabled", false);
	            // radio 버튼의 value 값이 유뷰트라면 파일 비활성화
	 
	        }else if($(".video_check").is(":checked")) {
	        	$(".custom-file-input").attr("disabled", false);
	        	$("#url").attr("disabled", true);
	              // radio 버튼의 value 값이 비디오라면 파일 활성화
	        }
		
		//버튼 클릭 이벤트 발생 - ++썸네일, 동영상 파일 name 저장되도록
		$("input:radio[name=online-lecture_class]").click(function(){
	        if($(".youtube_check").is(":checked")){
	            // radio 버튼의 value 값이 유뷰트라면 파일 비활성화
	            $(".custom-file-input").attr("disabled", true);
	            $("#url").attr("disabled", false);
	 
	        }else if($(".video_check").is(":checked")) {
	            // radio 버튼의 value 값이 비디오라면 파일 활성화
	        	$(".custom-file-input").attr("disabled", false);
	        	$("#url").attr("disabled", true);
	        	$("#url").val('');
	        }
	    });
	});
	
	/* VIDEO 등록 */
	function registrationVideo() {
		 
		var formData = new FormData();
		var fileData = new FormData();
		var inputFile = $("input[name='attach_file_video']");
		var files = inputFile[0].files;
		
		/* 필수체크 유효성 검사 */
		var chkVal = ["video_tp_cd", "title", "writer"];
		for (var i = 0; i < chkVal.length; i++) 
		{
			if ($("#" + chkVal[i]).val() == "" ) {
				console.log(chkVal[i]);
				alert($("#" + chkVal[i]).attr("title") + "은(는) 필수입력입니다.");
				$("#" + chkVal[i]).focus();
				return false;
			}
		}
		
		formData.append("video_tp_cd", $("#video_tp_cd:checked").val());
		formData.append("title", $("#title").val());
		formData.append("writer", $("#writer").val());
		formData.append("url", $("#url").val());
		formData.append("file_name", files[0].name);

		if ( $("#attach_file")[0].files[0] != undefined && $("#attach_file")[0].files[0] != "") {
			formData.append("attach_file", $("#attach_file")[0].files[0]);
		}
		
		for(var i = 0; i < files.length; i++) {
			fileData.append("uploadFile", files[i]);
		}
		
		if (confirm('등록 하시겠습니까?')) {
			/* 파일 폴더에 저장 */
			$.ajax({
			    type : "POST",
			    url : "/uploadAjaxAction",
			    data : fileData,
			    processData: false,
			    contentType: false,
			    success : function(data) {
			    	var jsonData = JSON.parse(data);
			        if (jsonData.result == 1) {
			            alert("파일 저장 되었습니다.");
			        } else {
			            alert("저장에 실패하였습니다. 다시 시도해 주시기 바랍니다.");
			        }
			    },
			});
			
			/* DB에 온라인강의 정보 저장 */
			$.ajax({
			    type : "POST",
			    url : "/admin/api/solar/notification/online/registration",
			    data : formData,
			    processData: false,
			    contentType: false,
			    mimeType: 'multipart/form-data',
			    success : function(data) {
			    	var jsonData = JSON.parse(data);
			        if (jsonData.result == 1) {
			            alert("등록 되었습니다.");
			            location.href = "/admin/rdt/solar/notification/online/searchList";
			        } else {
			            alert("등록에 실패하였습니다. 다시 시도해 주시기 바랍니다.");
			        }
			    },
			    error : function(err) {
			        alert(err.status);
			    }
			});
		}
		
		
	}
	/* YOUTUBE 등록 */
	function registrationYoutube() {
        var formData = new FormData();
        
        /* 필수체크 유효성 검사 */
		var chkVal = ["video_tp_cd", "title", "writer"];
		for (var i = 0; i < chkVal.length; i++) 
		{
			if ($("#" + chkVal[i]).val() == "" ) {
				console.log(chkVal[i]);
				alert($("#" + chkVal[i]).attr("title") + "은(는) 필수입력입니다.");
				$("#" + chkVal[i]).focus();
				return false;
			}
		}
	
		formData.append("video_tp_cd", $("#video_tp_cd").val());
		formData.append("title", $("#title").val());
		formData.append("writer", $("#writer").val());
		formData.append("url", $("#url").val());
		
		if ( $("#attach_file")[0].files[0] != undefined && $("#attach_file")[0].files[0] != "") {
			formData.append("attach_file", $("#attach_file")[0].files[0]);
		}
		
		
		if (confirm('등록 하시겠습니까?')) {
			$.ajax({
			    type : "POST",
			    url : "/admin/api/solar/notification/online/registration",
			    data : formData,
			    processData: false,
			    contentType: false,
			    mimeType: 'multipart/form-data',
			    success : function(data) {
			    	var jsonData = JSON.parse(data);
			        if (jsonData.result == 1) {
			            alert("등록 되었습니다.");
			            location.href = "/admin/rdt/solar/notification/online/searchList";
			        } else {
			            alert("등록에 실패하였습니다. 다시 시도해 주시기 바랍니다.");
			        }
			    },
			    error : function(err) {
			        alert(err.status);
			    }
			});
		}
	}



</script>
  
<!--페이지 루트-->
<div class="page-nation container">
	<a href="/admin/rdt/solar/home/management"><i class="nav-icon fa fa-home mr5"></i>홈화면</a><span class="route_icon"></span>
	<a href="/admin/rdt/solar/notification/trend/searchList">알림/정보</a><span class="route_icon"></span>
	<a href="javascript:void(0);">온라인 강의</a>
</div>

<!--본문시작-->
<div class="sub-container container">
	<div class="sub-content">
<!--페이지 타이틀-->				
	<div class="page-header">
		<h3 class="page-title text-primary-d2 text-120">온라인 강의</h3>
	</div>
<!--리스트 검색 상단-->				
	<div class="sub-content-box bgc-white online-lecture online-lecture-write">             
                    <table class="job_write">
                        <caption>강의 자료 유형</caption>
                        <tr>							
                            <th class="w20 jop_write_table_title">강의 자료 유형</th>
                            <td class="w80">								
								<input type="radio" name="online-lecture_class" class="ml10 youtube_check" id="video_tp_cd" value="T01" title="강의 자료 유형" checked/>YOUTUBE
								<input type="radio" name="online-lecture_class" class="ml10 video_check" id="video_tp_cd" value="T02" title="강의 자료 유형" />VIDEO								
                            </td>									
                        </tr>
                    </table>
					
					<table class="job_write common_table">
						<caption>제목</caption>				
						<tr>
							<th class="w20 jop_write_table_title"><span class="icon_box"><span class="necessary_icon">*</span>제목</span></th>								
							<td class="w80">
								<input type="text" class="form-control brc-on-focusd-inline-block w90" id="title" title="제목">
							</td>
						</tr>
					</table>

					<table class="job_write common_table">
						<caption>영상출처</caption>				
						<tr>
							<th class="w20 jop_write_table_writer"><span class="icon_box"><span class="necessary_icon">*</span>영상출처</span></th>								
							<td class="w80">
								<input type="text" class="form-control brc-on-focusd-inline-block w30" id="writer" title="영상출처">
							</td>
						</tr>
					</table>

					<table class="job_write youtube_table common_table">
						<caption>URL</caption>				
						<tr>
							<th class="w20 jop_write_table_url">URL</th>								
							<td class="w80">
								<input type="text" class="form-control brc-on-focusd-inline-block w90" id="url">
							</td>
						</tr>
					</table>
					
                    <table class="job_write video_table img_table">
						<caption>썸네일 이미지</caption>				
						<tr>
							<th class="w20 jop_write_table_url">썸네일 이미지<br/>(jpg, png만 가능)</th>								
							<td class="w80 txt_r">                
                            <div class="job_file_upload w87"> 
                                <div class="custom-file w100">
                                    <input type="file" class="custom-file-input custom-file-input-write-company" id="attach_file" name="attach_file" accept=".jpg, .png">
                                    <label class="custom-file-label custom-control-label-write-company" for="attach_file" id="attach_file_name">선택된 파일 없음</label>
                                </div>
                            </div>                               
                     	 	</td>	
						</tr>
					</table>

					<table class="job_write video_table mp_table">
						<caption>동영상 파일</caption>				
						<tr>
							<th class="w20 jop_write_table_url">동영상 파일<br />(mp4)</th>								
							<td class="w80 txt_r">                
                            <div class="job_file_upload w87"> 
                                <div class="custom-file w100">
                                    <input type="file" class="custom-file-input custom-file-input-write-company" id="attach_file_video"  name="attach_file_video" accept=".mp4">
                                    <label class="custom-file-label custom-control-label-write-company" for="attach_file_video" id="attach_file_video_name">선택된 파일 없음</label>
                                </div>
                            </div>                               
                     	 	</td>	
						</tr>
					</table>
                    
                    
                    <div class="industry-trend-view_btns">
                        <a href="javascript:void(0);" class="blue_btn ok_back_btn btn" onclick='$(".youtube_check").is(":checked") ? registrationYoutube() : registrationVideo()'>등록</a>
                        <div class="fr">
                            <a href="/admin/rdt/solar/notification/online/searchList" class="gray_btn btn list_back_btn">목록</a>
                        </div>
                    </div>                 
                </div>
	</div>
</div>
