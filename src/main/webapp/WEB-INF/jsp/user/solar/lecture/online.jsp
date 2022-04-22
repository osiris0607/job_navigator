<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <div id="wrap">
    <section>
      <div class="subVisual lecture">
        <div class="titleArea">
          <h2>온라인 강의</h2>
          <span> 태양광산업 관련 온라인 강의를 제공합니다.</span>
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
					<li><label for="edu_search" class="hidden">검색</label> 
					<input type="text" id="edu_search" placeholder="검색어"></li>
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
  
  
  $(document).ready(function () {
	 searchList(1);
	 

  });

  function searchList(pageNo) {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/user/api/solar/lecture/online/search/paging' />");
		comAjax.setCallback("searchListCB");
		comAjax.addParam("pageIndex", pageNo);
		comAjax.addParam("orderby", "ONLINE_ID DESC");

		comAjax.ajax();
	}

  function searchListCB(data) {
	 // console.log('####', data);
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
			$.each(data.result, function(key, value) {   //key : index
				videoIdList = value.url.split('/');
				playlist = videoIdList[videoIdList.length-1];
				
				/* 등록된 DB count만큼 박스 출력 */
				str += "<div class='boxWrap'>";
				str += "	<div class='videoThumb'>";
				if(playlist != null && playlist != '') {
					str += "	<iframe src='https://www.youtube.com/embed/"+ playlist +"' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>";
				}else {
					//유튜브가 아닌 파일 다운로드
					str += "<img src='/assets/img/no_image.jpg'>";
				}
				str += "	</div>";
				str += 		"<div class='videoContenttest' id='videoContent' value='"+value.online_id+"'>";
				str += "	</div>";
				str += "</div>";
			
			
				/* Youtube API 호출 */
					$.getJSON(
							  "https://www.googleapis.com/youtube/v3/videos", { 
								  part: 'snippet, statistics',
								  maxResults: 50, 
								  id: playlist,
								  key: 'AIzaSyDP37HANaDbBKYx9s95DVj7qNZMV3DJMbU' 
							},
				
				
				
				function (data) {
					//if(data.items.length > 0) {
					var output;
						$.each(data.items, function (i, item) {
							var a = value.url.split('/');
							var b = a[a.length-1];
							var c = value.online_id;
							console.log(b);
							if(item.id == b) {
								console.log(item.id, c);
								item.online_id = c;
							
							}
							console.log(item);
							var valueCd =  $("#videoContent").val();
							console.log('value -----> ', $("#videoContent").val());
							if(valueCd == '2') {
								console.log('ddddddddddddddddd');
							}
							console.log('value ', value);
							
							if(value.online_id == item.online_id) {
								console.log('999999999999999999');
								vTitle = item.snippet.title; 
								vDate = item.snippet.publishedAt; 
								vDe = item.snippet.description; 
								vTh = item.snippet.channelTitle; 
								vCnt = item.statistics.viewCount;
								vCount = vCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');  //천의자리 ,추가
								vDateFormat = vDate.toString().replace('T', ' ').substring(0, 10);  //date format yyyy-mm-dd
								output = '<p class="videoTitle">' + vTitle + '</p><p class="videoSummary">' +vCount+' views ' + vDateFormat +  '</p><ul class="videoOwner"><li>' + vTh + '</li></ul>'; 
								
								if(playlist != null && playlist != '') {
									$(".videoContenttest").append(output);
								}
							}	
								
								/*output= '<li>'+vTitle+'<iframe src=\"//www.youtube.com/embed/'+vId+'\"></iframe></li>';*/ 
								
								
								
						}) //end each
					//}  //end if
				}   //end function
			); //end getJSON
			});
			
			body.append(str);
	}
  }
</script>