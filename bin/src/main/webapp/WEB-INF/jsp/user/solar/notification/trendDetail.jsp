<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
  
<script type='text/javascript'>
	$(document).ready(function() {
		getDetail();
	});

	function getDetail() {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/user/api/solar/notification/trend/search/detail'/>");
		comAjax.setCallback("getDetailCB");
		comAjax.addParam("trend_id", $("#trend_id").val());
		comAjax.ajax();
	}
	
	function getDetailCB(data){
		$("#title").text(data.result.title) ;
		$("#writer").text(data.result.writer);
		$("#reg_date").text(data.result.reg_date);
		$("#explanation").html(unescapeHtml(data.result.explanation));
		if (data.result.upload_file_name != null && data.result.upload_file_name != "") {
			$("#attach_file_name").text(data.result.upload_file_name);
			$("#attach_file_name").attr("href", "/user/api/solar/trend/download/"+ data.result.upload_file_id);
		} 

		fnSetPreNext();
	}


	function fnSetPreNext() {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/user/api/solar/trend/preNext' />");
		comAjax.setCallback("fnSetPreNextCallback");
		comAjax.addParam("trend_id", $("#trend_id").val());
		comAjax.ajax();
	}
	
	function fnSetPreNextCallback(data) {
		console.log(data.result);
		if (data.result.pre != null) {
			$("#pre").attr("href", "/user/rdt/solar/notification/trend/detail?trend_id=" + data.result.pre.trend_id);
			$("#pre").html(data.result.pre.title);
		}
		
		if (data.result.next != null) {
			$("#next").attr("href", "/user/rdt/solar/notification/trend/detail?trend_id=" + data.result.next.trend_id);
			$("#next").html(data.result.next.title);
		}
	}

</script>
 
<input type="hidden" id="trend_id" name="trend_id" value="${vo.trend_id}" />
<div id="wrap">
 <section>
    <div class="subVisual lecture">
      <div class="titleArea">
        <h2>자료실</h2>
          <span>태양광산업 및 연관산업 동향 등의 자료를 제공합니다.</span>
      </div>
    </div>
  </section>

  <section>
    <div class="subWrap">
      <ul class="breadcrumb">
        <li><img src="/assets/img/btn/breadcrumb_home.png" alt="홈"></li>
        <li>자료실&middot;게시판</li>
        <li>자료실</li>
      </ul>

      <div class="referenceWrap">
        <!-- <h3>자료실</h3> -->

        <div class="refBox">
          <p class="refTitle" id="title"></p>
          <ul>
            <li id="writer"></li>
            <li id="reg_date"></li>
          </ul>
        </div>
        <div class="refContent" id="explanation"></div>
        <div class="refBox">
          <a href="#file" id="attach_file_name"></a>
        </div>
        
        
        <ul class="refBgbox">
          <li>이전글</li>
          <li><a href="" id="pre"></a></li>
        </ul>
        <ul class="refBgbox">
          <li>다음글</li>
          <li><a href="" id="next"></a></li>
        </ul>
      </div>

      <div class="btnWrap">
        <a href="/user/rdt/solar/notification/trend" class="btn viewList">목록보기</a>
      </div>
    </div>
  </section>
</div>
