<script>
function callApi() {
	alert('검색버튼 클릭');
	
	$.ajax({
	    method : "GET",
	    url : "https://cors-anywhere.herokuapp.com/http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey=WNL2TXYFS6V5PWORTT5QZ2VR1HK&callTp=L&returnType=XML&startPage=1&display=10",
	    dataType : "xml",
	   	success : function(data) {
		   	console.log('data : ', data);
		   	//$.each(data.documentElement, function(key, value) {
		   	//	console.log(key, value);
		   	//});
		   	
		   	$(data).find('wanted').each(function() {
		   		console.log($(this));
		   	});
	    },
	    error : function(err) {
	        alert(err.status);
	    }
	});
	
	
 
 
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
								<select name="working_area1" id="working_area1" class="job_class">
									<option value="선택">선택</option>
									<option value="서울">서울</option>
								</select>
								<label for="working_area2" class="hidden">근무지역</label>
								<select name="working_area2" id="working_area2" class="job_class">
									<option value="">선택</option>
									<option value="종로구">종로구</option>
								</select>
							</td>						
						</tr>
						<tr>
							<th scope="row">희망직종</th>
							<td>
								<label for="hope_occupation1" class="hidden">근무지역</label>
								<select name="hope_occupation1" id="hope_occupation1" class="job_class">
									<option value="선택">선택</option>
									<option value="경영·사무·금융·보험">경영·사무·금융·보험</option>
								</select>
								<label for="hope_occupation2" class="hidden">근무지역</label>
								<select name="hope_occupation2" id="hope_occupation2" class="job_class">
									<option value="">선택</option>
									<option value="행정·경영·금융·보험 관리직">행정·경영·금융·보험 관리직</option>
								</select>
							</td>
						</tr>
						<tr>
							<th scope="row">희망임금</th>
							<td>	
								<input type="radio" id="Hope_all" name="Hope" checked /><label for="Hope_all">관계없음</label>
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
								<input type="checkbox" class="allCheck" id="allCheck" /><label for="allCheck">전체</label>
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
								<input type="radio" name="preferential" id="preferential_all" checked /><label for="preferential_all">전체</label>
								<input type="radio" name="preferential" id="preferential1" /><label for="preferential1">청년층</label>
								<input type="radio" name="preferential" id="preferential2" /><label for="preferential2">고령자</label>
								<input type="radio" name="preferential" id="preferential3" /><label for="preferential3">여성</label>
							</td>
						</tr>
						<tr>
							<th scope="row">장애인 채용희망</th>
							<td>
								<input type="checkbox" id="disabled1" value="Y" /><label for="disabled1">장애인 병행채용</label>
								<input type="checkbox" id="disabled2" /><label for="disabled2">장애인 우대</label>
								<input type="checkbox" id="disabled3" value="D" /><label for="disabled3">장애인만 채용</label>
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
								<input type="radio" name="period" id="period_all" checked /><label for="period_all">전체</label>
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
					<div class="button_area"><button type="submit" class="serach_btn" onclick="callApi();">검색</button></div>
					
					<ul class="result_number clearfix">
						<li class="result fl">검색건수 : 총 <em>9,999</em>건</li>
						<li class="fr list_btn_area">
							<button type="button" class="card_other list_btn card_on"><span>다른 리스트 형식으로 보기</span></button>
							<button type="button" class="list_other list_btn"><span>다른 리스트 형식으로 보기</span></button>							
						</li>
					</ul>
					<div class="list_search_card_area">
						<ul class="clearfix list_search_card">
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/gpfmc_logo.gif" alt="가평군시설관리공단" /></span>
									<span class="company_name">가평군시설관리공단가평군시설관리공단가평군시설관리공단가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">&nbsp;</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/cj_jedang.png" alt="cj제일제당" /></span>
									<span class="company_name">가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/gpfmc_logo.gif" alt="가평군시설관리공단" /></span>
									<span class="company_name">가평군시설관리공단가평군시설관리공단가평군시설관리공단가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/cj_jedang.png" alt="cj제일제당" /></span>
									<span class="company_name">가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/gpfmc_logo.gif" alt="가평군시설관리공단" /></span>
									<span class="company_name">가평군시설관리공단가평군시설관리공단가평군시설관리공단가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/cj_jedang.png" alt="cj제일제당" /></span>
									<span class="company_name">가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/gpfmc_logo.gif" alt="가평군시설관리공단" /></span>
									<span class="company_name">가평군시설관리공단가평군시설관리공단가평군시설관리공단가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">&nbsp;</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/cj_jedang.png" alt="cj제일제당" /></span>
									<span class="company_name">가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/gpfmc_logo.gif" alt="가평군시설관리공단" /></span>
									<span class="company_name">가평군시설관리공단가평군시설관리공단가평군시설관리공단가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/cj_jedang.png" alt="cj제일제당" /></span>
									<span class="company_name">가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/gpfmc_logo.gif" alt="가평군시설관리공단" /></span>
									<span class="company_name">가평군시설관리공단가평군시설관리공단가평군시설관리공단가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
							<li>
								<a href="jobnavi_employinfor_view.html">
									<span class="company_logo"><img src="/assets/images/jobnavi_employinfor/list_logo/cj_jedang.png" alt="cj제일제당" /></span>
									<span class="company_name">가평군시설관리공단</span>
									<span class="company_detail">2022년 일반직[사무기술] 및 계약직 채용 공고</span>
									<span class="company_day clearfix">
										<span class="company_histroy">신입, 경력</span>
										<span class="company_until">(~05.30)</span>
									</span>
								</a>
							</li>
						</ul>

						<div class="pagination">
							<ul>
								<li><button class="prev [no]"><i class="fa fa-angle-left" aria-hidden="true"></i></button></li>
								<li><a href="" class="loca">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">99</a></li>
								<li><a href="">999</a></li>
								<li><button class="next [no]"><i class="fa fa-angle-right" aria-hidden="true"></i></button></li>
							</ul>
						</div>
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
								<th>최사명</th>
								<th>채용제목/임금/근무지역/근무형태</th>
								<th>학력/경력</th>
								<th>등록일</th>
								<th>마감일</th>
							</tr>
							</thead>
							<tbody>
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>㈜앵커데이터</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집즐겁게 일할 수 있는 IT 개발자 모집</span>
											<span class="info month">
												<span class="week week_4">주 4일</span>
												<span class="month_money">500만원 | 서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길샛길서울시 금천구 서부샛길서울시 금천구 서부샛길서울시 금천구 서부샛길</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>학력무관</span><span>경력 5년</span></td>
									<td>22-04-21</td>
									<td>채용시까지</td>							
								</tr>
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>㈜이노싱크컨설팅</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">공공사업 기획자 모집</span>
											<span class="info year">
												<span class="week week_5">주 5일</span>
												<span class="year_money">9,000만원 | 서울시 금천구 서부샛길</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(4년)</span><span>경력무관</span></td>
									<td>22-04-21</td>
									<td>22-05-31</td>							
								</tr>
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>	
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>	
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>	
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>	
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
										<span class="info year">
											<span class="week week_4">주 4일</span>
											<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
										</span>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>
								<tr>
									<td><a href="jobnavi_employinfor_view.html"><span>OCI</span></a></td>
									<td>
										<a href="jobnavi_employinfor_view.html">
											<span class="an">OCI 창원 공장 태양광 부품 생산직 직원 모집..</span>
											<span class="info year">
												<span class="week week_4">주 4일</span>
												<span class="year_money">4,500만원 | 경상남도 창원시 공장…</span>									
											</span>
										</a>
									</td>
									<td class="edu"><span>대졸(2~3년)</span><span>경력무관</span></td>
									<td>22-05-21</td>
									<td>채용시까지<span class="day">(22-05-21)</span></td>							
								</tr>
							</tbody>
						</table>

						<div class="no_result">조회된 내용이 없습니다.</div>

						<div class="pagination">
							<ul>
								<li><button class="prev [no]"><i class="fa fa-angle-left" aria-hidden="true"></i></button></li>
								<li><a href="" class="loca">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">99</a></li>
								<li><a href="">999</a></li>
								<li><button class="next [no]"><i class="fa fa-angle-right" aria-hidden="true"></i></button></li>
							</ul>
						</div>
					</div>
				</article>
			</section>
		</article>
		<!--//서브 컨텐츠-->
	</section>
	
  </div>

