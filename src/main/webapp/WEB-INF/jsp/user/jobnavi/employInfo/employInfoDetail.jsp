<script>
function xmlToJson(xml) {    
	var obj = $.xml2json(xml);    
	return obj;
}

$(document).ready(function() {
	callApiDetail();
});

function callApiDetail() {
	var detailUrl = $(location).attr('search');
	var param = detailUrl.split('=');
	var id = param[1];
	
	
	console.log('id key :', id);
	$.ajax({
	    method : "GET",
	    url : "https://cors-anywhere.herokuapp.com/http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey=WNL2TXYFS6V5PWORTT5QZ2VR1HK&callTp=D&returnType=XML&wantedAuthNo="+id+"&infoSvc=VALIDATION",
	    dataType : "xml",
	   	success : function(data) {
	   		console.log(data);
	   		var obj = xmlToJson(data);
	   		detailInfo(obj)
	    },
	    error : function(err) {
	        alert(err.status);
	    }
	});
}	

function detailInfo(value) {
	console.log('detail value : ', value);
	var corpInfo = value.corpInfo;
	
	$("#corpNm").text(unescapeHtml(corpInfo.corpNm));
	$("#reperNm").text(unescapeHtml(corpInfo.reperNm));
	$("#capitalAmt").text(unescapeHtml(corpInfo.capitalAmt));
	$("#yrSalesAmt").text(unescapeHtml(corpInfo.yrSalesAmt));
	$("#indTpCdNm").text(unescapeHtml(corpInfo.indTpCdNm));
	$("#busiCont").text(unescapeHtml(corpInfo.busiCont));
	$("#totPsncnt").text(unescapeHtml(corpInfo.totPsncnt));
	$("#corpAddr").text(unescapeHtml(corpInfo.corpAddr));
	$("#homePg").text(unescapeHtml(corpInfo.homePg));
	
	
	
	
	
	
	
	
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
					<li><a href="./jobnavi_employinfor.html" title="채용정보 바로가기" class="on">채용정보</a></li>
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
				<article class="sub_contents_table">
					<table class="Jobs_table list2">
						<caption>채용정보</caption>
						<colgroup>
							<col style="width:20%;">
							<col style="width:30%;">
							<col style="width:20%;">
							<col style="width:30%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">회사명</th>
								<td colspan="3"><span class="b_f" id="corpNm"></span></td>						
							</tr>
							<tr>
								<th scope="col">대표자명</th>
								<td><span id="reperNm"></span></td>						
								<th scope="row">근로자수</th>
								<td><span id="totPsncnt"></span></td>
							</tr>
							<tr>
								<th scope="col">자본금</th>
								<td><span id="capitalAmt"></span></td>						
								<th scope="row">연매출</th>
								<td><span id="yrSalesAmt"></span></td>
							</tr>
							<tr>											
								<th scope="row">업종</th>
								<td colspan="3"><span id="indTpCdNm"></span></td>
							</tr>
							<tr>											
								<th scope="row">주요사업내용</th>
								<td colspan="3"><span id="busiCont"></span></td>
							</tr>
							<tr>											
								<th scope="row">회사주소</th>
								<td colspan="3"><span id="corpAddr"></span></td>
							</tr>
							<tr>											
								<th scope="row">홈페이지</th>
								<td colspan="3"><span id="homePg"></span></td>
							</tr>
						</tbody>
					</table>				
					
					<h3>모집요강</h3>
					<table class="list2 recruitmentguide_table">
						<caption><span>모집요강</span></caption>
						<colgroup>
							<col style="width:30%;">
							<col style="width:70%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">모집요강</th>
								<td><span class="b_f">건축안전, 환경 및 품질 기술자(141106)</span></td>	
							</tr>				
							<tr>
								<th scope="row">관련직종</th>
								<td><span>-</span></td>	
							</tr>
							<tr>
								<th scope="row">직무내용</th>
								<td><span>건설현장 안전관리자 구함</span></td>	
							</tr>
							<tr>
								<th scope="row">접수마감일</th>
								<td><span>2022년 6월 8일</span><span class="d-day">D-15</span></td>	
							</tr>
							<tr>
								<th scope="row">고용경력조건태</th>
								<td><span>기간의 정함이 없는 구로계약 / 파견근로 비희망</span></td>	
							</tr>
							<tr>
								<th scope="row">모집인원</th>
								<td><span>1</span>명 <span class="b_f ml10">지원현황 : 총<span>3</span>명 (고용센터 알선 : <span>0</span>명, 이메일 입사지원 <span>3</span>명)</span></td>	
							</tr>
							<tr>
								<th scope="row">임금조건</th>
								<td>
									<span>연봉 3000만원 이상</span>
									<span>상여금 : 0% (미포함)</span>
									<span>면접 후 재조정 가능</span>
								</td>	
							</tr>
							<tr>
								<th scope="row">경력조건</th>
								<td><span>관계없음</span></td>	
							</tr>
							<tr>
								<th scope="row">학력</th>
								<td><span>대졸(2~3년)</span></td>	
							</tr>
							<tr>
								<th scope="row">키워드</th>
								<td><span>-</span></td>	
							</tr>
						</tbody>
					</table>

					<h3>우대사항</h3>
					<table class="list2 preferential_table">
						<caption><span>우대사항</span></caption>
						<colgroup>
							<col style="width:30%;">
							<col style="width:70%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">외국어능력</th>
								<td><span>-</span></td>	
							</tr>				
							<tr>
								<th scope="row">전공</th>
								<td><span>-</span></td>	
							</tr>
							<tr>
								<th scope="row">자격면허</th>
								<td class="d_b">
									<span>건설안전기사</span>
									<span>건설안전산업기사</span>
									<span>기타 : 산업안전기사, 산업안전산업기사</span>
								</td>	
							</tr>
							<tr>
								<th scope="row">병역특례채용희망</th>
								<td><span>비희망</span></td>	
							</tr>
							<tr>
								<th scope="row">컴퓨터활용능력</th>
								<td><span>문서작성, 프리젠테이션</span></td>	
							</tr>						
							<tr>
								<th scope="row">우대조건</th>
								<td><span>-</span></td>	
							</tr>
							<tr>
								<th scope="row">장애인 채용희망</th>
								<td><span>비희망</span></td>	
							</tr>
							<tr>
								<th scope="row">기타 우대사항</th>
								<td><span>건설안전, 산업안전 기사 또는 산업기사 자격증 소지자</span></td>	
							</tr>
						</tbody>
					</table>

					<h3>전형방법</h3>
					<table class="list2 how_table">
						<caption><span>전형방법</span></caption>
						<colgroup>
							<col style="width:30%;">
							<col style="width:70%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row">전형방법</th>
								<td><span class="b_f">서류, 면접</span></td>	
							</tr>				
							<tr>
								<th scope="row">접수방법</th>
								<td><span>방문, 우편, 팩스, E-mail</span></td>	
							</tr>
							<tr>
								<th scope="row">제출서류양식첨부</th>
								<td><span>등록된 파일이 없습니다.</span></td>	
							</tr>
							<tr>
								<th scope="row">제출서류 준비물</th>
								<td><span>이력서, 자기소개서<br />※ 정부민원포털<span class="b_f"><a href="https://www.gov.kr/portal/main" target="_blank">(www.minwon.go.kr)</a></span>에서 주민등록등초본 등 각종 제증명 발급 가능</span></td>	
							</tr>
						</tbody>
					</table>

					<h3>근무환경 및 복리후생</h3>
					<table class="list2 how_table">
						<caption><span>근무환경 및 복리후생</span></caption>
						<colgroup>
							<col style="width:8%;">
							<col style="width:22%;">
							<col style="width:70%;">
						</colgroup>
						<tbody>
							<tr>
								<th scope="row" colspan="2">근무예정지</th>
								<td><span class="b_f">서울시 영등포구 문래동 20길 56</span></td>	
							</tr>				
							<tr>
								<th scope="row" colspan="2">소속산업단지</th>
								<td><span>-</span></td>	
							</tr>
							<tr>
								<th scope="row" colspan="2">인근전철역</th>
								<td><span>-</span></td>	
							</tr>
							<tr>
								<th scope="row" colspan="2">근무시간/형태</th>
								<td class="d_b">
									<span>평일 : 0700~1600</span>
									<span>기타 (월 6일 휴무)</span>
									<span>주소정근로시간 : 40시간</span>
								</td>	
							</tr>
							<tr>
								<th scope="col" rowspan="4">복리후생</th>
								<th>연금4대보험</th>
								<td><span>국민연금, 산재보험, 건강보험</span></td>	
							</tr>
							<tr>							
								<th>퇴직금</th>
								<td><span>퇴직금</span></td>	
							</tr>
							<tr>							
								<th>기타복리후생</th>
								<td><span>기숙사, 중식제공(또는 중식비 지원), 기타(4대보험)</span></td>	
							</tr>
							<tr>							
								<th>장애인편의시설</th>
								<td><span>-</span></td>	
							</tr>
						</tbody>
					</table>

					<div class="button_area list_btn_area"><button type="button" class="listback_btn" onClick="history.back()">목록</button></div>

				</article>
			</section>
		</article>
		<!--//서브 컨텐츠-->
	</section>
	
  </div>

