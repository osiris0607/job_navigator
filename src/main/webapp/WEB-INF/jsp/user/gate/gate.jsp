 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1">
<title>KETEP</title>
<link rel="shortcut icon" href="/assets/img/favicon.ico" type="image/x-icon">
<link rel="Stylesheet" href="/assets/css/font-awesome.css" media="all" type="text/css" />
<link rel="Stylesheet" href="/assets/css/swiper.css" media="all" type="text/css" />
<script>
  var ver = Math.floor((Math.random() * 1000));
  document.write('<link rel="stylesheet" href="/assets/css/style.css?V=' + ver + '" type="text/css" />');
</script>
<script src="/assets/js/jquery-3.3.1.min.js"></script>
<script src="/assets/js/swiper.js"></script>

</head>

<body>
  <!-- skip list -->
  <div id="skip_navi" role="navigation">
    <a href="#navi_index_menu"><span>주메뉴로 바로가기</span></a>
  </div>
  <!-- //skip list -->

  <div id="wrap">
    <header>
    	<div class="headerWrap">		 
			<h1 class="energy_main_logo"><a href="https://www.ketep.re.kr/" target="_blank" title="KETEP 바로가기"><img src="/assets/images/logo_red.png" alt="ketep 로고이미지"></a>
			<a href="/" target="_self" title="jobnavigator"><img src="/assets/images/jobnavigator_logo.png" alt="jobnavigator 로고이미지"></a></h1>		
		</div>
	</header>  
	<nav id="gnb">		
		<ul class="jobnavigatorMenu clearfix">
			<li>
				<a href="javascript:void(0);" title="내비게이터 소개 바로가기">내비게이터 소개</a>				
				<ul class="jobnavigatorsubMenu sub">
					<li><a href="" title="소개 바로가기">소개</a></li>
					<li><a href="" title="인사말 바로가기">인사말</a></li>
				</ul>				
			</li>
			<li>
				<a href="javascript:void(0);" title="기술인력 통계 바로가기">기술인력 통계</a>					
				<ul class="jobnavigatorsubMenu sub">
					<li><a href="" title="수요현황 바로가기">수요현황</a></li>
					<li><a href="" title="공급현황 바로가기">공급현황</a></li>
					<li><a href="" title="인력수급 전망 바로가기">인력수급 전망</a></li>
				</ul>				
			</li>
			<li>
				<a href="javascript:void(0);" title="채용정보 바로가기">채용정보</a>				
				<ul class="jobnavigatorsubMenu sub">
					<li><a href="/user/rdt/jobnavi/employinfo" title="채용정보 바로가기">채용정보</a></li>
					<li><a href="" title="직업정보 바로가기">직업정보</a></li>
					<li><a href="" title="학과정보 바로가기">학과정보</a></li>
					<li><a href="" title="강소기업 바로가기">강소기업</a></li>
					<li><a href="" title="직업전망 바로가기">직업전망</a></li>
					<li><a href="" title="채용행사 바로가기">채용행사</a></li>
					<li><a href="" title="직업사전 바로가기">직업사전</a></li>
					<li><a href="" title="표준직무기술서 바로가기">표준직무기술서</a></li>
					<li><a href="" title="직무데이터사전 바로가기">직무데이터사전</a></li>
				</ul>				
			</li>
			<li>    
				<a href="javascript:void(0);" title="채용박람회 바로가기">채용박람회</a>					
				<ul class="jobnavigatorsubMenu sub">
					<li><a href="" title="메타버스 바로가기">메타버스</a></li>
				</ul>				
			</li>
			<li>
				<a href="javascript:void(0);" title="알림 바로가기">알림</a>				
				<ul class="jobnavigatorsubMenu sub">
					<li><a href="" title="공지사항 바로기">공지사항</a></li>
					<li><a href="" title="보도자료 바로기">보도자료</a></li>
				</ul>				
			</li>
		</ul>		
		<div id="subMenuBg"></div> 		
	</nav>  
    <section class="navi_index_box_area" id="navi_index_menu">
		<h2 class="hidden">energyclassmenu</h2>
		<div class="txt">
			<h3>에너지산업<br /><span class="fw_7">일자리 내비게이터</span></h3>
			<p>에너지 분야로의 취업&middot;경력개발을 위해<br />에너지산업의 종합적인 일자리 정보를 제공하는 플랫폼</p>
		</div>
		<div class="navi_index_box">
			<ul class="navi_index clearfix">
				<li><a href="javascript:alert('개발중입니다. 현재는 ESS와 태양광 산업 일자리 내비게이터만 이용이 가능합니다.');" onfocus="this.blur()" class="energyclass_menu_power" title="지능형 전력망 바로가기" target="_self">&nbsp;<span>&nbsp;</span>지능형 전력망 바로가기</a></li>
				<li><a href="javascript:alert('개발중입니다. 현재는 ESS와 태양광 산업 일자리 내비게이터만 이용이 가능합니다.');" class="energyclass_menu_efficiency" title="에너지 효율 바로가기" target="_self">&nbsp;<span>&nbsp;</span>에너지 효율 바로가기</a></li>
				<li><a href="/user/rdt/ess/main/main" class="energyclass_menu_ess" title="ESS 바로가기" target="_self">&nbsp;<span>&nbsp;</span>Ess 바로가기</a></li>
				<li><a href="/user/rdt/solar/main/main" class="energyclass_menu_sun" title="태양광 바로가기" target="_self">&nbsp;<span>&nbsp;</span>태양광 바로가기</a></li>
				<li><a href="javascript:alert('개발중입니다. 현재는 ESS와 태양광 산업 일자리 내비게이터만 이용이 가능합니다.');" class="energyclass_menu_wind" title="풍력 바로가기" target="_self">&nbsp;<span>&nbsp;</span>풍력 바로가기</a></li>
				<li><a href="javascript:alert('개발중입니다. 현재는 ESS와 태양광 산업 일자리 내비게이터만 이용이 가능합니다.');" class="energyclass_menu_battery" title="수소&middot;연료전지" target="_self">&nbsp;<span>&nbsp;</span>수소&middot;연료전지</a></li>
			</ul>
		 </div>
    </section>
	<section>
		<div class="energy_job_navi_box clearfix">
			<h2 class="fl mr24">energy <span class="yellow_txt">job-navi</span></h2>
			<div class="s fl mr10">
				<label for="energy_job_class" class="hidden">에너지 분야 선택</label>			
				<select name="energy_job_class" id="energy_job_class" class="fl">
					<option value="에너지 분야 선택" selected="">에너지 분야 선택</option>
					<option value="지능형 전력망">지능형 전력망</option>
					<option value="에너지 효율">에너지 효율</option>
					<option value="Ess">Ess</option>
					<option value="태양광">태양광</option>
					<option value="풍력">풍력</option>
					<option value="수소&middot;연료전지">수소&middot;연료전지</option>
				</select>
			</div>
			<div class="search_box fl">
				<label for="energy_job_search" class="hidden">에너지 분야 검색</label>
				<input type="text" id="energy_job_search" class="fl" placeholder="키워드 검색" />
				<button type="submit"  title="검색" class="energy_job_search_btn">검색</button>
			</div>
		</div>
	  </section>
  </div>


</body>
</html>