<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div id="wrap">
	<section>
		<div class="subVisual essLecture">
			<div class="titleArea">
				<h2>온라인 강의</h2>
				<span> ESS산업 관련 온라인 강의를 제공합니다.</span>
			</div>
		</div>
	</section>

	<section>
		<div class="subWrap">
			<ul class="breadcrumb">
				<li><img src="/assets/img/btn/breadcrumb_home.png" alt="홈"></li>
				<li>교육&middot;자격증</li>
				<li>온라인 강의</li>
			</ul>
			<fieldset>
				<ul class="searchWrap reference">
					<li class="result">전체 <em id="search_count">0</em>건
					</li>
					<li><label for="edu_search" class="hidden">검색</label> <input
						type="text" id="edu_search" placeholder="검색할 제목을 입력하세요"></li>
					<li>
						<button type="submit" onclick="searchList(1);">검색</button>
					</li>
				</ul>

				<!-- Youtube openApi -->
				<ul class="accodion" id="ul_body"></ul>

				<input type="hidden" id="pageIndex" name="pageIndex" />
				<div class="pagination" id="pageNavi"></div>
			</fieldset>
		</div>
	</section>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		searchList(1);

	});

	function searchList(pageNo) {
		var comAjax = new ComAjax();
		comAjax
				.setUrl("<c:url value='/user/api/ess/lecture/online/search/paging' />");
		comAjax.setCallback("searchListCB");
		comAjax.addParam("pageIndex", pageNo);
		comAjax.addParam("orderby", "ONLINE_ID DESC");

		comAjax.ajax();
	}

	function searchListCB(data) {
		var videoList = data.result;
		var total = data.totalCount;
		var body = $("#ul_body");
		body.empty();
		$("#pageNavi").empty();
		if (total == 0) {
			var str = "조회된 결과가 없습니다.";
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
			    				
								console.log('*[value.video_tp_cd] : ', value.video_tp_cd);
								console.log('*[value.upload_file_name] : ', value.upload_file_name);
								/*
									T01 : 유투브
									T02 : 파일다운로드
									
								*/
								//YOUTUBE
								if (value.video_tp_cd == 'T01') {
									
									videoIdList = value.url.split('/');
									playlist = videoIdList[videoIdList.length - 1];
									console.log('*[playlist] ID: ', playlist);
									
									className = "videoContenttest" + "_" + playlist;
								
									/**** youtube api 호출 ****/
	                                callApiData(playlist);

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
								str += "  <p class='videoTitle'>"
										+ value.title + "</p>";
								str += "  <p class='videoSummary'></span><span class='en'>"
										+ value.reg_date + "</span></p>"
								str += "  <br>"
								str += "  <a href='' download class='moviedown_btn'>다운로드</a> ";
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

	function callApiData(playlist) {

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

			output = '<p class="videoTitle">' + vTitle + '</p><p class="videoSummary">' + vCount + ' views ' + vDateFormat + '</p>' + 
					'<ul class="videoOwner"><li>' + vTh + '</li></ul>';
			className = ".videoContenttest" + "_" + playlist;
			$(className).append(output);
				
			}) //end each
		} //end function
		); //end getJSON

	}
</script>

