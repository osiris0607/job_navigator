<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal.username" var="member_id" />
<script type="text/javascript" src="${ctx }/assets/SE2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

  
<script type='text/javascript'>
	var oEditors = [];
	
	$(document).ready(function() {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "explanation", //textarea에서 지정한 id와 일치해야 합니다. 
			//SmartEditor2Skin.html 파일이 존재하는 경로
			sSkinURI : "${ctx }/assets/SE2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
				fOnBeforeUnload : function() {

				}
			},
			fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				//oEditors.getById["explanation"].exec("PASTE_HTML",[ "기존 DB에 저장된 내용을 에디터에 적용할 문구" ]);
			},
			fCreator : "createSEditor2"
		});
	});

	function registration() {
        var formData = new FormData();

		var chkVal = ["title"];
		for (var i = 0; i < chkVal.length; i++) 
		{
			if ($("#" + chkVal[i]).val() == "" ) {
				alert($("#" + chkVal[i]).attr("title") + "은(는) 필수입력입니다.");
				$("#" + chkVal[i]).focus();
				return false;
			}
		}
		
		formData.append("title", $("#title").val());
		if ( $("#writer").val() == null || $("#writer").val() == "" ) {
			formData.append("writer",'${member_id}');
		}
		else {
			formData.append("writer",$("#writer").val());
		}
		formData.append("explanation", oEditors.getById["explanation"].getIR());
		if ( $("#attach_file")[0].files[0] != undefined && $("#attach_file")[0].files[0] != "") {
			formData.append("attach_file", $("#attach_file")[0].files[0]);
		}
		
		if (confirm('등록 하시겠습니까?')) {
			$.ajax({
			    type : "POST",
			    url : "/admin/api/solar/notification/trend/registration",
			    data : formData,
			    processData: false,
			    contentType: false,
			    mimeType: 'multipart/form-data',
			    success : function(data) {
			    	var jsonData = JSON.parse(data);
			        if (jsonData.result == 1) {
			            alert("등록 되었습니다.");
			            location.href = "/admin/rdt/solar/notification/trend/searchList";
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
    <a href="javascript:void(0);">태양광산업 동향</a>
</div>

<!--본문시작-->
<div class="sub-container container">
	<div class="sub-content">
<!--페이지 타이틀-->				
<div class="page-header">
	<h3 class="page-title text-primary-d2 text-120">태양광산업 동향</h3>
</div>
<!--view-->				
<div class="sub-content-box bgc-white">             
               <table class="job_write">
                    <caption>제목</caption>
                <tr>							
                    <th class="w20 jop_write_table_title">제목</th>
                    <td class="w80">
                        <input type="text" class="form-control brc-on-focusd-inline-block w90" id="title" title="제목">                              
                    </td>									
                </tr>
            </table>
            <table class="job_write">
                <caption>작성자</caption>

                <tr>
                    <th class="w20 jop_write_table_title">작성자</th>
                    <td class="w80">
                        <input type="text" class="form-control brc-on-focusd-inline-block w30" id="writer" title="작성자">
                    </td>
                </tr>
            </table>
            <table class="job_write">
                <caption>내용</caption>
					<tr>
                   	  	<th class="w20 jop_write_table_title">내용</th>
                      	<td class="w80">
                      		<textarea name="explanation" id="explanation" cols="105" rows="20" title="내용"></textarea>
                      	</td>
                  	</tr>					
              </table>
              <table class="job_write">
                  	<caption>첨부파일</caption>
					<tr>
                   	    <th class="w20 jop_write_table_title">첨부파일</th>
                      	<td class="w80">
							<div class="job_file_upload w87"> 
                                 <div class="custom-file w100">
                                     <input type="file" class="industry-trend-view-file-input-view-company" id="attach_file" name="attach_file">
                                     <label class="custom-file-label industry-trend-view-label" for="attach_file" id="attach_file_name">선택된 파일 없음</label>
                                 </div>
                             </div>
                    	</td>
                	</tr>					
            </table> 
            <div class="industry-trend-view_btns">
                <a href="javascript:void(0);" class="blue_btn ok_back_btn btn" onclick="registration();">등록</a>
                <div class="fr">
                    <a href="/admin/rdt/solar/notification/trend/searchList" class="gray_btn btn list_back_btn">목록</a>
                </div>
            </div>                 
        </div>
    </div>
</div>
