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

<body id="gate_body">
  <!-- skip list -->
  <div id="skip_navi" role="navigation">
    <a href="#navi_index_menu"><span>주메뉴로 바로가기</span></a>
  </div>
  <!-- //skip list -->

  <div id="wrap">
    <header id="gate_header">
		<div class="headerWrap">
		  <a href="/admin/rdt/gate/gate">
			<h1 class="energy_main_logo"><span>KETEP</span></h1>
		  </a>		  		  
		</div>
	</header>  
    <section class="navi_index_box_area" id="navi_index_menu">
		<h2 class="hidden">energyclassmenu</h2>
		<div class="txt">
			<h3>에너지산업<br /><span class="fw_7">일자리 내비게이터</span></h3>
			<p>관리자 페이지입니다.<br />산업영역을 선택해 주세요.</p>
		</div>
		<div class="navi_index_box">
			<ul class="navi_index clearfix">
				<!--지능형 전략망-->
				<li class="energyclass_menu_power"><span>&nbsp;</span>지능형 전력망 바로가기</li>
				
				<!--에너지 효율-->
				<li class="energyclass_menu_efficiency"><span>&nbsp;</span>에너지 효율 바로가기</li>

				<!--ess-->
				<li><a href="/admin/rdt/ess/home/management" class="energyclass_menu_ess" title="Ess 바로가기" target="_self">&nbsp;<span>&nbsp;</span>Ess 바로가기</a></li>
				
				<!--태양광-->
				<li><a href="/admin/rdt/solar/home/management" class="energyclass_menu_sun" title="태양광 바로가기" target="_self">&nbsp;<span>&nbsp;</span>태양광 바로가기</a></li>
				
				<!--풍력-->
				<li class="energyclass_menu_wind"><span>&nbsp;</span>풍력 바로가기</li>
				
				<!--수소·연료전지-->
				<li class="energyclass_menu_battery"><span>&nbsp;</span>수소&middot;연료전지</li>
			</ul>
		 </div>
    </section>
	
  </div>


</body>
</html>