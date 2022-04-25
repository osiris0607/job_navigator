<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">
  
  
$(document).ready(function() {
	$("#search_text").on("keydown", function(key) {
        //키의 코드가 13번일 경우 (13번은 엔터키)
        if (key.keyCode == 13) {
        	searchList(1);
        }
    });
	
	searchList(1);
	
});


  function searchList(pageNo) {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/admin/api/solar/notification/online/search/paging' />");
		comAjax.setCallback("searchListCB");
		comAjax.addParam("pageIndex", pageNo);
		comAjax.addParam("orderby", "REG_DATE DESC");
		
		
		var temp = $("#selector_choice").val();
		console.log($("#selector_choice").val());
		if ( $("#selector_choice").val() == "C001" ) {
			comAjax.addParam("title", $("#search_text").val());
		} 
		else if ( $("#selector_choice").val() == "C002" ) {
			comAjax.addParam("writer", $("#search_text").val());
		} 
		else if ( $("#selector_choice").val() == "C003" ) {
			comAjax.addParam("reg_date", $("#search_text").val());
		}
		

		comAjax.ajax();
	}

  function searchListCB(data) {
	  var total = data.totalCount;
		var body = $("#list_body");
		body.empty();
		$("#pageNavi").empty();
		if (total == 0) {
			var str = "<div>조회된 결과가 없습니다.</div>";
			body.append(str);
		} else {
			var params = {
					divId : "pageNavi",
					pageIndex : "pageIndex",
					totalCount : total,
					eventName : "searchList"
				};

			gfnRenderPagingMain(params);
			$("#search_count").text(total);
		
			var str = "";
			var videoIdList;
			var playlist;
			/* 등록된 DB count만큼 박스 출력 */
			$.each(data.result, function(key, value) { //key : index
			    				
								//console.log('*[value.video_tp_cd] : ', value.video_tp_cd);
								//console.log('*[value.upload_file_name] : ', value.upload_file_name);
								/*
									T01 : 유투브
									T02 : 파일다운로드
									
								*/
								//YOUTUBE
								if (value.video_tp_cd == 'T01') {
									
									videoIdList = value.url.split('/');
									playlist = videoIdList[videoIdList.length - 1];
									//console.log('*[playlist] ID: ', playlist);
									
									className = "videoContenttest" + "_" + playlist;
								
									/**** youtube api 호출 ****/
	                                callApiData(playlist, value);

								str += "<div class='boxWrap'>";
								str += "    <div class='videoThumb'>";
								str += "        <iframe src='https://www.youtube.com/embed/"+ playlist +"' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>";
								str += "    </div>";
								str += "    <div class='videoContent "+className+"'/>";
								str += "</div>";
                                
								} 
								else {
								//VIDEO
								
								str += "<div class='boxWrap'>";
								str += " <div class='videoThumb'>";
								str += "  <img src='data:image/png;base64,"
										+ value.upload_file_image
										+ "' alt='"
										+ unescapeHtml(value.upload_file_name)
										+ "'>";
								str += " </div>";
								str += " <div class='videoContent'>";
								str += "	<a class='videoTitle' href='/admin/rdt/solar/notification/online/detail?online_id="+value.online_id+"'>"+value.title+"</a>";

								str += "  <p class='videoSummary'></span><span class='en'>"
										+ value.reg_date + "</span></p>";
								str += "  <br>";
								str += "  <ul class='videoOwner'>  ";
								str += "   <li>" + value.writer + "</li>  ";
								str += "  </ul>  ";
								str += " </div>";
								str += "</div>";
                                
								
								}

							}); //end value

			body.append(str);
	}
  }
  
  function callApiData(playlist, value) {

		$.getJSON("https://www.googleapis.com/youtube/v3/videos", {
			part : 'snippet, statistics',
			maxResults : 50,
			id : playlist,
			key : 'AIzaSyDP37HANaDbBKYx9s95DVj7qNZMV3DJMbU'
		}, function(data) {
			
			console.log('data', data);
			/*
				title -> vTitle
				channelTitle -> vTh
				viewCount -> vCount
				publishedAt -> vDateFormat
			*/
			
			//var output;
			$.each(data.items, function(i, item) {
				
			vTitle = data.items[0].snippet.title; //제목
			vTh = data.items[0].snippet.channelTitle; //채널명
			vCnt = data.items[0].statistics.viewCount; //조회수
			vCount = vCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','); //조회수 - 천의자리 ,추가
			vDate = data.items[0].snippet.publishedAt; //등록일자
			vDateFormat = vDate.toString().replace('T', ' ').substring(0,10); //등록일자 format yyyy-mm-dd

			output = '<a class="videoTitle" href="/admin/rdt/solar/notification/online/detail?online_id='+value.online_id+'">'+value.title+'</a><p class="videoSummary">' + vCount + ' views ' + vDateFormat + '</p>' + 
					'<ul class="videoOwner"><li>' + vTh + '</li></ul>';
			className = ".videoContenttest" + "_" + playlist;
			$(className).append(output);
				
			}) //end each
		} //end function
		); //end getJSON

	}
</script>

<!--페이지 루트-->
<div class="page-nation container">
	<a href="/admin/rdt/solar/home/management"><i class="nav-icon fa fa-home mr5"></i>홈화면</a><span class="route_icon"></span>
	<a href="javascript:void(0)">알림/정보</a><span class="route_icon"></span>
	<a href="javascript:void(0)">온라인 강의</a>
</div>

<!--본문시작-->
<div class="sub-container container">
	<div class="sub-content">
<!--페이지 타이틀-->				
		<div class="page-header">
			<h3 class="page-title text-primary-d2 text-120">온라인 강의</h3>
		</div>
<!--리스트 검색 상단-->		
		<div class="sub-content-box bgc-white">
                  <!--리스트 상단 검색결과-->                
                  <div class="list_search_end_box clearfix">
                      <h4 class="fl">전체</h4>
                      <span class="list_search_results fl ml10" id="search_count">0</span><em class="fl mr10">건</em>
                        <div class="fr industry-trend_table_top_seach clearfix">
                            <select class="online-lecture_select w30 ace-select fl" id="selector_choice">
								<option value="C001">제목</option>
								<option value="C002">영상출처</option>
								<option value="C003">등록일</option>
                            </select>                        
							
                            <input type="text" maxlength="40" class="form-control online_search brc-on-focusd-inline-block fl ml5" placeholder="검색어를 입력하세요" id="search_text" /> 
                            <button class="blue_btn2 fl btn ml5" onclick="searchList(1);">검색</button>                            
                            <a href="/admin/rdt/solar/notification/online/registration" class="btn blue_btn fr">등록</a>
                        </div>
                      <!--리스트 상단 검색결과--> 
					<!-- Youtube openApi -->
						<div class="accodion" id="list_body"></div>
					
					
					<div class="Page_navigation">
                            <nav class="bgc-white mt-3 d-flex radius-1 position-center" aria-label="Page navigation example">
							    <ul class="pagination nav-tabs-scroll is-scrollable p-2 mb-0">
									<li class="page-item mr-2 active">
										<a class="w-5 h-5 pt-2 page-link text-center rounded-circle" href="/admin/rdt/solar/notification/online/searchList">
										1
										</a>
									</li>
								</ul>
						    </nav>   
					    </div>   
					</div>
				</div>
			</div>
		</div>
    </div><!--body-container-->
                
			</div>    
		</div>
	</div>	
</div>	
		
<style>
/* admin에서 style.css가 안먹고있어서 임시로 스타일 적용 */
.boxWrap {position: relative; overflow: hidden; width: 100%; padding: 30px; margin-bottom: 30px; border: 1px solid #d1d1d1; box-sizing: border-box;}
.boxWrap .videoThumb {float: left; margin-right: 20px;}
.boxWrap .videoThumb img, .boxWrap .videoThumb iframe, .videoThumb video {width: 300px; height: 150px; object-fit: scale-down;}
.boxWrap .videoContent {position: relative; overflow: hidden; height: 150px;}
.boxWrap .videoContent .videoSummary {color: #666666; font-size: 15px;	margin: 0;}
.boxWrap .videoContent .videoSummary span.en {padding: 0;}
.boxWrap .videoContent .videoOwner {position: absolute; bottom: 0; overflow: hidden; margin: 0;}
.boxWrap .videoContent .videoTitle {display: block; margin-bottom: 10px; font-size: 16px; font-weight: 700; line-height: 1.4;color: #333;display: -webkit-box; display: -ms-flexbox;margin-top:1px; max-height:60px; overflow:hidden; vertical-align:top; text-overflow: ellipsis; word-break:break-all; -webkit-box-orient:vertical; -webkit-line-clamp:2;padding: 0;}
.boxWrap .videoContent .videoOwner li {float: left; height: 24px; margin-right: 20px; font-size: 15px; line-height: 24px;}

.Page_navigation{position: relative;margin: 40px 0 20px 0;height: 30px;}
.Page_navigation .position-center{position: absolute;left:50%;top: 0 !important;transform: translate(-50%, -50%);}
</style>