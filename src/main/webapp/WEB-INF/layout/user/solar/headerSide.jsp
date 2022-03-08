<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script>
	$(document).ready(function() {
	});
</script>

<!-- [S] Header -->
<header>
	<div class="headerWrap">
		<a href="/">
		<!-- <a href="/user/rdt/solar/main/main"> -->
			<h1><span>KETEP</span></h1>
		</a>
		<ul class="navi" id="GNB">
	       <li class="[on]"><!-- 활성화시 class="on" 추가 -->
	         <a href="/user/rdt/solar/job/main">태양광산업 일자리</a>
	       </li>
	       <li>
	         <a href="/user/rdt/solar/jobDictionary/main">태양광산업 일자리 사전</a>
	       </li>
	       <li>
	         <a href="/user/rdt/solar/jobPromising/main">태양광산업 유망 일자리</a>
	       </li>
	       <li>
	         <a href="/user/rdt/solar/company/main">태양광산업 기업지도</a>
	       </li>
	       <li tabindex="0">
	         <a href="javascript:void(0)" tabindex="-1">교육&middot;자격증 <i class="fa fa-caret-down"></i></a>
	         <div class="sub">
	           <em class="edge"></em>
	           <div class="inSub">
	             
	             <a href="/user/rdt/solar/lecture/online">온라인 강의</a>
	             <a href="/user/rdt/solar/lecture/training">훈련기관</a>
	             <a href="/user/rdt/solar/lecture/license">자격증</a>
	           </div>
	         </div>
	       </li>
	       <li tabindex="0">
	         <a href="javascript:void(0)" tabindex="-1">자료실&middot;게시판  <i class="fa fa-caret-down"></i></a>
	         <div class="sub">
	           <em class="edge"></em>
	           <div class="inSub">
	             
	             <a href="/user/rdt/solar/notification/trend">자료실</a>
	             <a href="/user/rdt/solar/notification/faq">게시판</a>
	           </div>
	         </div>
	       </li>
      </ul>
      <script>
        $(function () {
          $('#GNB li').bind('mouseenter focusin', function() {
            $(this).addClass('on');
          });
          $('#GNB li').bind('mouseleave focusout', function() {
            $(this).removeClass('on');
          });
        });
      </script>
      <!-- <button class="menu"></button> -->
	</div>
</header>
<!-- [E] Header -->