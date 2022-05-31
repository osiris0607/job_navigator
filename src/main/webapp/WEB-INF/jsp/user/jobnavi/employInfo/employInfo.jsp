<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script>
function xmlToJson(xml) {    
	var obj = $.xml2json(xml);    
	return obj;
}

$(document).ready(function() {

	
	// 해정 구역 정보 Click
 	$("#working_area1").change(function(){
 		var selector_regionId =  $("#working_area1").val();
 		selector_regionChange(selector_regionId);
	});
	
 	$("#hope_occupation1").change(function(){
 		var selector_occupationId =  $("#hope_occupation1").val();
 		console.log('id : ', selector_occupationId);
 		selector_occupationChange(selector_occupationId);
	});
	selectorInit();
	getselector_regionList();
	getselector_occupationList();
	
	
	callApi(1);
});


function getselector_regionList() {
	var comAjax = new ComAjax();
	comAjax.setUrl("<c:url value='/user/api/util/openapi/sgis/administrativeDistrict/all' />");
	comAjax.setCallback("getselector_regionListCB");
	comAjax.ajax();
}

function getselector_occupationList() {
	var comAjax = new ComAjax();
	comAjax.setUrl("<c:url value='/user/api/util/employInfo/occupation/all' />");
	comAjax.setCallback("getselector_occupationListCB");
	comAjax.ajax();
}

function getselector_regionListCB(data) {
	console.log('region data : ', data);
	
	var str = "";
	selector_regionList = data.result;
	var selector_region = $("#working_area1"); 
	selector_region.empty();

	str += "<option value=''>지역</option>";
	$.each(selector_regionList, function(key, value) {
		if (value.master_id == "D000001") {
			str += "<option value=\"" + value.code + "\">" + value.addr + "</option>";
		}
	});
	selector_region.append(str); 
}

function getselector_occupationListCB(data) {
	console.log('occupation data : ', data);
	
	var str = "";
	selector_occupationList = data.result;
	var selector_occupation = $("#hope_occupation1");
	selector_occupation.empty();

	str += "<option value=''>선택</option>";
	$.each(selector_occupationList, function(key, value) {
		if (value.master_id == "D000001") {
			str += "<option value=\"" + value.occupation_cd + "\">" + value.name + "</option>";
		}
	});
	selector_occupation.append(str); 
}

function selector_regionChange(selector_regionId){
	var str = "";
	var selector_regionDetail = $("#working_area2"); 
	selector_regionDetail.empty();

	str += "<option value=''>지역 세부</option>";
	$.each(selector_regionList, function(key, value) {
		if (value.master_id == "D000002" && value.parent_id == selector_regionId ) {
			str += "<option value=\"" + value.region_cd + "\">" + value.addr + "</option>";
		}
	});
	
	selector_regionDetail.append(str); 
}

function selector_occupationChange(selector_occupationId){
	var str = "";
	var selector_occupationDetail = $("#hope_occupation2"); 
	selector_occupationDetail.empty();
	console.log(selector_occupationId);
	str += "<option value=''>직종 세부</option>";
	$.each(selector_occupationList, function(key, value) {
		//console.log('key, value', key, value);
		if (value.master_id == "D000002" && value.category_id == selector_occupationId ) {
			str += "<option value=\"" + value.occupation_cd + "\">" + value.name + "</option>";
		}
	});
	
	selector_occupationDetail.append(str); 
}
function selectorInit() {
	str = "";
	var selector_regionDetail = $("#working_area2");
	selector_regionDetail.empty();
	str += '<option value="">지역 세부</option>';
	selector_regionDetail.append(str); 
	
	str = "";
	var selector_occupationDetail = $("#hope_occupation2");
	selector_occupationDetail.empty();
	str += '<option value="">직종 세부</option>';
	selector_occupationDetail.append(str); 
}

function setParam() {

	//지역
	var region = $('#working_area1 option:selected').val();
	var regionDetail = $('#working_area2 option:selected').val();
	
	//지역 세부가 없으면 지역만으로 검색 - 파라미터로 보낼 value값 변환(워크넷 코드로)
	if(regionDetail == '') {
		switch(region) {
			case '11':
				console.log('서울');
				region = '11000'
			break;
			case '21':
				console.log('부산');
				region = '26000'
			break;
			case '22':
				console.log('대구');
				region = '27000'
			break;
			case '23':
				console.log('인천');
				region = '28000'
			break;			
			case '24':
				console.log('광주');
				region = '29000'
			break;
			case '25':
				console.log('대전');
				region = '30000'
			break;
			case '26':
				console.log('울산');
				region = '31000'
			break;
			case '29':
				console.log('세종');
				region = '36110'
			break;
			case '31':
				console.log('경기도');
				region = '41000'
			break;
			case '32':
				console.log('강원도');
				region = '42000'
			break;
			case '33':
				console.log('충청북도');
				region = '43000'
				break;
			case '34':
				console.log('충청남도');
				region = '44000'
				break;
			case '35':
				console.log('전라북도');
				region = '45000'
				break;
			case '36':
				console.log('전라남도');
				region = '46000'
				break;
			case '37':
				console.log('경상북도');
				region = '47000'
				break;
			case '38':
				console.log('경상남도');
				region = '48000'
				break;
			case '39':
				console.log('제주도');
				region = '50000'
				break;
		default:
			region = '';
				
		}
		
	}else {
		region = $('#working_area2 option:selected').val();
	}
	
	/* ======================================================================= */
	//희망직종
	var occupation = $('#hope_occupation1 option:selected').val();
	var occupationDetail = $('#hope_occupation2 option:selected').val();
	
	//if(occupationDetail == '') {
	//	alert('희망직종 세부 선택 필수');
	//	return;
	//}else {
		occupation = $('#hope_occupation2 option:selected').val();
	//}
	
	//console.log('region : ', region);
	//console.log('occupation : ', occupation);

	/* ======================================================================= */
	//희망임금 salTp
	
	var hopeSal = $('input[name=Hope]:checked').val();
	//console.log('hopeSal : ', hopeSal);
	//희망임금 시급 - minPay, maxPay 
	var minPay = $('#Hope_money1').val();
	var maxPay = $('#Hope_money2').val();
	
	if(hopeSal == '') {
		//조건 미입력, 관계없음, 최소, 최대 급여 미입력
		minPay = '';
		maxPay = '';
	}else {
		if(minPay == '' && maxPay == '') {
			//둘다 입력 안하면
			alert('최소급여 또는 최대급여를 필수로 입력');
		}else {
		//30'만원' 이상 50'만원' 이하 : 300000 ~ 500000, default 0
			var plusWon = '0000';
			
			 if(minPay != '' && maxPay == '') {
				 console.log('최소만 있음')
				 minPay = minPay.concat(plusWon);
				 maxPay ='';
				 
			}else if(maxPay != '' && minPay == '') {
				console.log('최대만 있음')
				maxPay = maxPay.concat(plusWon);
				minPay = '';
			}else if(minPay != '' && maxPay != '') {
				console.log('둘다 있음')
				minPay = minPay.concat(plusWon);
				maxPay = maxPay.concat(plusWon);
			}
		}
	}
	//console.log('minPay : ', minPay);
	//console.log('maxPay : ', maxPay);
	
	
	/* ======================================================================= */
	//학력  :  전체 체크시 처리?????????????????
	//학력무관(00) 입력시 다수 항목 입력 불가
	var eduCheck = $('.education_check:checked').val();
		var chkEduList = [];
		var strEdu = "";
		var education = $('.education_check:checked').each(function() {
			var chkEdu = $(this).val();
			chkEduList.push(chkEdu);
		});
	//04|05|06|07..
	strEdu = chkEduList.join('|');
	
	/* ======================================================================= */
	//경력
	var chkCareerList = [];
	var strCareer = "";
	var career = $('input[name=history]:checked').each(function() {
		var chkCareer = $(this).val();
		chkCareerList.push(chkCareer);
	});
	
	strCareer = chkCareerList.join('|');
	
	//경력 - 최소, 최대 개월
	var minHis = $('#employment_money1').val();
	var maxHis = $('#employment_money2').val();
	
	console.log('minHis : ', minHis);
	console.log('maxHis : ', maxHis);
	/* ======================================================================= */
	//우대조건
	var prefCd = $('input[name=preferential]:checked').val();
	
	/* ======================================================================= */
	//장애인 채용희망
	//장애인 우대 ?????????????????????? value값 명시X
	var chkPrefList = [];
	var strPref = "";
	var pref = $('input[name=pref]:checked').each(function() {
		var chkPref = $(this).val();
		chkPrefList.push(chkPref);
	});
	
	strPref = chkPrefList.join('|');
	
	/* ======================================================================= */
	//등록기간
	var regDate = $('input[name=period]:checked').val();
	/* ======================================================================= */
	//검색키워드
	var keyword = $('#search_keyword').val();
	
	
	
	/* 
	희망임금	salTp minPay maxPay
	학력		education  
	경력		career
	우대조건	prefCd
	장애인 채용희망	pref
	등록기간	regDate	
	검색키워드	keyword
	*/
	
	//체크값 없으면 파라미터 value=''
	
	var sendParam = ""; //파라미터 세팅
	sendParam += "&";
	sendParam += "region=" + region;
	sendParam += "&";
	sendParam += "occupation=" + occupation;
	sendParam += "&";
	sendParam += "salTp=" + hopeSal;
	sendParam += "&";
	sendParam += "minPay=" + minPay;
	sendParam += "&";
	sendParam += "maxPay=" + maxPay;
	sendParam += "&";
	sendParam += "education=" + strEdu;
	sendParam += "&";
	sendParam += "career=" + strCareer;
	sendParam += "&";
	sendParam += "minCareerM=" + minHis;
	sendParam += "&";
	sendParam += "maxCareerM=" + maxHis;
	sendParam += "&";
	sendParam += "prefCd=" + prefCd;
	sendParam += "&";
	sendParam += "pref=" + strPref;
	sendParam += "&";
	sendParam += "regDate=" + regDate;
	sendParam += "&";
	sendParam += "keyword=" + keyword;
	
	
	
	console.log(sendParam);
	return sendParam;
}
var url;
function callApi(pageNo) {
	alert('검색버튼 클릭');
	
	var sendParam = setParam();
	console.log('callAPI set Param : ', sendParam);
	url = 'https://cors-anywhere.herokuapp.com/http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey=WNL2TXYFS6V5PWORTT5QZ2VR1HK&callTp=L&returnType=XML&startPage='+pageNo+'&display=12'+sendParam;
	
	
	$.ajax({
	    method : "GET",
	    url : url,
	    dataType : "xml",
	   	success : function(data) {
	   		var obj = xmlToJson(data);
	   		searchList(obj) //리스트 call
	   		searchCard(obj) //카드 call
	    },
	    error : function(err) {
	        alert(err.status);
	    }
	});
}	
	function searchCard(value) {
		console.log('searchCard data : ', value);
		
		var body = $("#bodyCard");
		body.empty();
		
		if(value.total == 0) {
			var str = "조회된 결과가 없습니다.";
			body.append(str);
		}else {
			//페이지 그려진 이후 call
			 var params = {
					divId : "pageNavi",
					pageIndex : "pageIndex",
					totalCount : value.total,
					eventName : "callApi"
				};

			gfnRenderPagingMain(params);
			$("#search_count").text(value.total);
			
			
			var str = "";
			var data = value.wanted;
			console.log('paging data : ', data);
			
			$.each(data, function(key, value) {
				
				console.log('to detail url : ', url);
			str +="	<li>"
			str +="	<a href='/user/rdt/jobnavi/employinfo/detail?wantedAuthNo="+value.wantedAuthNo+"'>"
			str +="		<span class='company_logo'>"+value.company+"</span>"
			str +="		<span class='company_name'>"+value.company+"</span>"
			str +="		<span class='company_detail'>"+value.title+"</span>"
			str +="		<span class='company_day clearfix'>"
			str +="			<span class='company_histroy'>"+value.career+"</span>"
			str +="			<span class='company_until'>"+value.closeDt+"</span>"
			str +="		</span>"
			str +="	</a>"
			str +="</li>"
			
			});
			body.append(str);
		}
	}
 
	
	function searchList(value) {
		console.log('searchList data : ', value);
		
		var body = $("#bodyList");
		body.empty();
		
		if(value.total == 0) {
			var str = "조회된 결과가 없습니다.";
			body.append(str);
		}else {
			//페이지 그려진 이후 call
			 var params = {
					divId : "pageNavi",
					pageIndex : "pageIndex",
					totalCount : value.total,
					eventName : "callApi"
				};

			gfnRenderPagingMain(params);
			$("#search_count").text(value.total);
			
			
			var str = "";
			var data = value.wanted;
			console.log('paging data : ', data);
			
			$.each(data, function(key, value) {
			str += "<tr>"
			str += "<td><a href='jobnavi_employinfor_view.html'><span>"+value.company+"</span></a></td>"
			str += "<td>"
			str += "	<a href='/user/rdt/jobnavi/employinfo/detail?wantedAuthNo="+value.wantedAuthNo+"'>"
			str += "		<span class='an'>"+value.title+"</span>"
			str += "		<span class='info month'>"
			str += "			<span class='week week_4'>"+value.holidayTpNm+"</span>"
			str += "			<span class='month_money'>"+value.sal+" | "+value.basicAddr+"</span>"									
			str += "		</span>"
			str += "	</a>"
			str += "</td>"
			str += "<td class='edu'><span>"+value.minEdubg+"</span><span>"+value.career+"</span></td>"
			str += "<td>"+value.regDt+"</td>"
			str += "<td>"+value.closeDt+"</td>	"					
			str += "</tr>"
			
			});
			body.append(str);
		}
	}
 
 
</script>
  <div id="wrap" class="jobnavigator_page">
<!--컨텐츠 시작-->
	<!--서브 탑-->
	<section class="sub_contents" id="navi_index_menu">
		<article class="sub_top_area">
			<section class="sub_route_area">
				<article class="sub_title_area">
					<h2 class="sub_title">채용정보</h2>
				</article>	
				<article class="sub_route">
					<ul>
						<li><a href="./index.html" title="home" class="home"><img src="/assets/images/btn/breadcrumb_home.png" alt="홈"></a></li>
						<li><a href="./jobnavi_employinfor.html" title="채용정보">채용정보</a></li>
						<li><a href="./jobnavi_employinfor.html" title="채용목록">채용목록</a></li>
					</ul>
				</article>			
			</section>
			<section class="tab_submenu">
				<ul class="clearfix">
					<li><a href="/user/rdt/jobnavi/employinfo" title="채용정보 바로가기" class="on">채용정보</a></li>
					<li><a href="" title="직업정보 바로가기">직업정보</a></li>
					<li><a href="" title="학과정보 바로가기">학과정보</a></li>
					<li><a href="" title="강소기업 바로가기">강소기업</a></li>
					<li><a href="" title="직업전망 바로가기">직업전망</a></li>
					<li><a href="" title="채용행사 바로가기">채용행사</a></li>
					<li><a href="" title="직업사전 바로가기">직업사전</a></li>
					<li><a href="" title="표준직무기술서 바로가기">표준직무기술서</a></li>
					<li><a href="" title="직무데이터사전 바로가기">직무데이터사전</a></li>
				</ul>			
			</section>
		</article>		
		<!--//서브 탑-->
		
		<!--//서브 컨텐츠-->
		<article class="sub_contents_main_area">
			<section class="sub_contents_main">
				<article class="sub_top_infotext">
					<ul>
						<li>원하는 조건을 설정하여 간편하게 채용정보를 검색하실 수 있습니다.</li>
						<li>키워드를 입력하시면 더욱 정확한 검색결과를 확인하실 수 있습니다.</li>
					</ul>
				</article>
				<article class="sub_contents_table">
					<table class="employinfor_table list2">
						<caption>채용정보 목록</caption>
						<colgroup>
							<col style="width:30%;">
							<col style="width:70%;">
						</colgroup>
						<tbody>
						<tr>
							<th scope="row">근무지역</th>
							<td>
								<label for="working_area1" class="hidden">근무지역</label>
								<select name="working_area1" id="working_area1" class="job_class"></select>
								<label for="working_area2" class="hidden">근무지역</label>
								<select name="working_area2" id="working_area2" class="job_class"></select>
							</td>						
						</tr>
						<tr>
							<th scope="row">희망직종</th>
							<td>
								<label for="hope_occupation1" class="hidden">근무지역</label>
								<select name="hope_occupation1" id="hope_occupation1" class="job_class"></select>
								<label for="hope_occupation2" class="hidden">근무지역</label>
								<select name="hope_occupation2" id="hope_occupation2" class="job_class"></select>
							</td>
						</tr>
						<tr>
							<th scope="row">희망임금</th>
							<td>	
								<input type="radio" id="Hope_all" name="Hope" value="" checked /><label for="Hope_all">관계없음</label>
								<input type="radio" id="Hope_radio1" name="Hope" value="Y"/><label for="Hope_radio1">연봉</label>
								<input type="radio" id="Hope_radio2" name="Hope" value="M" /><label for="Hope_radio2">월급</label>
								<input type="radio" id="Hope_radio3" name="Hope" value="D" /><label for="Hope_radio3">일급</label>
								<input type="radio" id="Hope_radio4" name="Hope" value="H" /><label for="Hope_radio4">시급</label>
								<span>
									( <input type="text" id="Hope_money1" class="w_100 money" onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" disabled /> <label for="Hope_money1" class="mr10">만원이상</label>
									<input type="text" id="Hope_money2" class="w_100 money" onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" disabled /> <label for="Hope_money2">만원이하</label> )
								</span>
							</td>
						</tr>
						<tr>
							<th scope="row">학력</th>
							<td>
								<input type="checkbox" class="education_check" id="education0" value="" /><label for="education0">전체</label>
								<input type="checkbox" id="education1" class="education_check" value="03"/><label for="education1">고졸</label>
								<input type="checkbox" id="education2" class="education_check" value="04" /><label for="education2">대졸(2~3년)</label>
								<input type="checkbox" id="education3" class="education_check" value="05" /><label for="education3">대졸(4년)</label>
								<input type="checkbox" id="education4" class="education_check" value="06" /><label for="education4">석사</label>
								<input type="checkbox" id="education5" class="education_check" value="07" /><label for="education5">박사</label>
								<input type="checkbox" id="education6" class="education_check" value="00" /><label for="education6">학력무관</label>
							</td>
						</tr>
						<tr>
							<th scope="row">경력</th>
							<td>
								<input type="checkbox" id="history1" name="history" value="Z" /><label for="history1">무관</label>
								<input type="checkbox" id="history2" name="history" value="N" /><label for="history2">신입</label>
								<input type="checkbox" id="history3" name="history" value="E" /><label for="history3">경력</label>
								<span>
									( <input type="text" id="employment_money1" class="w_60" maxlength='2'  onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" disabled /> <label for="employment_money1">개월</label> ~ <input type="text" id="employment_money2" class="w_60" maxlength='2'  onKeyup="this.value=this.value.replace(/[^-0-9]/g,'');" disabled /> <label for="employment_money2">개월</label> )
								</span>
							</td>
						</tr>
						<tr>
							<th scope="row">우대조건</th>
							<td>
								<input type="radio" name="preferential" id="preferential_all" value="" checked /><label for="preferential_all">전체</label>
								<input type="radio" name="preferential" id="preferential1" value="13" /><label for="preferential1">청년층</label>
								<input type="radio" name="preferential" id="preferential2" value="B" /><label for="preferential2">고령자</label>
								<input type="radio" name="preferential" id="preferential3" value="12" /><label for="preferential3">여성</label>
							</td>
						</tr>
						<tr>
							<th scope="row">장애인 채용희망</th>
							<td>
								<input type="checkbox" id="disabled1" name="pref" value="Y" /><label for="disabled1">장애인 병행채용</label>
								<input type="checkbox" id="disabled2" name="pref" value="" /><label for="disabled2">장애인 우대</label>
								<input type="checkbox" id="disabled3" name="pref" value="D" /><label for="disabled3">장애인만 채용</label>
							</td>
						</tr>
						<tr>
							<th scope="row">등록기간</th>
							<td>							
								<div class="datepicker_area">
									<input type="text" id="join_datepicker1" class="datepicker w_140" placeholder="시작일" disabled />	
									<label for="join_datepicker1" class="hidden">시작일</label>
									<span>~</span>
									<input type="text" id="join_datepicker2" class="datepicker w_140" placeholder="종료일" disabled />
									<label for="join_datepicker2" class="hidden">종료일</label>
								</div>	
								<input type="radio" name="period" id="period_all" value="" checked /><label for="period_all">전체</label>
								<input type="radio" name="period" id="period1" value="D-0" /><label for="period1">오늘</label>
								<input type="radio" name="period" id="period2" value="D-3" /><label for="period2">3일</label>
								<input type="radio" name="period" id="period3" value="W-1" /><label for="period3">1주 이내</label>
								<input type="radio" name="period" id="period4" value="W-2" /><label for="period4">2주 이내</label>
								<input type="radio" name="period" id="period5" value="M-1" /><label for="period5">한달</label>
							</td>
						</tr>
						<tr>
							<th scope="row">검색키워드</th>
							<td>
								<input type="text" id="search_keyword" /> <label for="search_keyword"> 예) 태양광, 전력변환</label>
							</td>
						</tr>					
						</tbody>
					</table>
					<div class="button_area"><button type="submit" class="serach_btn" onclick="callApi(1);">검색</button></div>
					<div class="button_area"><button type="submit" class="serach_btn" onclick="setParam();">파라미터세팅</button></div>
					
					<ul class="result_number clearfix">
						<li class="result fl">검색건수 <em id="search_count">0</em>건</li>
						<li class="fr list_btn_area">
							<button type="button" class="card_other list_btn card_on"><span>다른 리스트 형식으로 보기</span></button>
							<button type="button" class="list_other list_btn"><span>다른 리스트 형식으로 보기</span></button>							
						</li>
					</ul>
					<div class="list_search_card_area">
						<ul class="clearfix list_search_card" id="bodyCard"></ul>

					<!-- pagination -->
					</div>
					<div class="list_search_table">
						<table class="list search_result">
							<caption><span>태양광산업 동향 자료 목록</span></caption>
							<colgroup>
								<col style="width:17%;">
								<col style="width:46%;">
								<col style="width:14%;">
								<col style="width:8%;">
								<col style="width:15%;">
							</colgroup>
							<thead>
							<tr>
								<th>회사명</th>
								<th>채용제목/임금/근무지역/근무형태</th>
								<th>학력/경력</th>
								<th>등록일</th>
								<th>마감일</th>
							</tr>
							</thead>
							<tbody id="bodyList"></tbody>
							
						</table>
						
						<!-- pagination -->
					</div>
					<!-- pagination -->
					<input type="hidden" id="pageIndex" name="pageIndex" />
						<div class="pagination" id="pageNavi"></div>
				</article>
			</section>
		</article>
		<!--//서브 컨텐츠-->
	</section>
	
  </div>

