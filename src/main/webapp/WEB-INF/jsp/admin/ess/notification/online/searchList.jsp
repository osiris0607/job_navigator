<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript">
  
  
  $(document).ready(function () {
	 searchList(1);
	 

  });

  function searchList(pageNo) {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/admin/api/ess/notification/online/search/paging' />");
		comAjax.setCallback("searchListCB");
		comAjax.addParam("pageIndex", pageNo);
		comAjax.addParam("orderby", "ONLINE_ID DESC");

		comAjax.ajax();
	}

  function searchListCB(data) {
		console.log('total --> ', total)
	  var total = data.totalCount;
		var body = $("#list_body");
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
			$.each(data.result, function(key, value) {
				console.log(value);
				var videoIdList = value.url.split('/');
				var playlist = videoIdList[videoIdList.length-1];
				
				str += "<div class='boxWrap'>";
				str += "	<div class='videoThumb'>";
				str += "		<iframe src='https://www.youtube.com/embed/"+ playlist +"' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>";
				str += "	</div>";
				str += 		"<div class='videoContent'>";
				str += "	</div>";
				str += "</div>";
				
				
				$.get(
				  "https://www.googleapis.com/youtube/v3/videos", { 
					  part: 'snippet, statistics',
					  maxResults: 50, 
					  id: playlist, 
					  key: 'AIzaSyDP37HANaDbBKYx9s95DVj7qNZMV3DJMbU' 
				},
				
				function (data) {
					var output;
					$.each(data.items, function (i, item) {
						console.log(i);
						console.log(item);
						
						vTitle = item.snippet.title; 
						vDate = item.snippet.publishedAt; 
						vDe = item.snippet.description; 
						vTh = item.snippet.channelTitle; 
						vCnt = item.statistics.viewCount;
						vCount = vCnt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');  //천의자리 ,추가


						
						var vDateFormat = vDate.toString().replace('T', ' ').substring(0, 10);  //date format yyyy-mm-dd
						
						output = '<a class="videoTitle" href="/admin/rdt/ess/notification/online/detail?online_id=' + value.online_id + '">' + vTitle + '</a><p class="videoSummary"><span class="en">' +vCount+' views ' + vDateFormat +  '</span></p><ul class="videoOwner"><li>' + vTh + '</li></ul>'; 

						/*output= '<li>'+vTitle+'<iframe src=\"//www.youtube.com/embed/'+vId+'\"></iframe></li>';*/ 
						$(".videoContent").append(output);

						
						
					})
				}
			);
		  
			});
			body.append(str);
	}
  }
</script>

<!--페이지 루트-->
<div class="page-nation container">
	<a href="/admin/rdt/ess/home/management"><i class="nav-icon fa fa-home mr5"></i>홈화면</a><span class="route_icon"></span>
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
                            <select class="online-lecture_select w30 ace-select fl">
								<option value="제목">제목</option>
								<option value="작성자">작성자</option>
								<option value="등록일">등록일</option>
                            </select>                        
							
                            <input type="text" maxlength="40" class="form-control online_search brc-on-focusd-inline-block fl ml5" placeholder="검색어를 입력하세요"  /> 
                            <button class="blue_btn2 fl btn ml5">검색</button>                            
                            <a href="/admin/rdt/ess/notification/online/registration" class="btn blue_btn fr">등록</a>
                        </div>
                      <!--리스트 상단 검색결과--> 
					<!-- Youtube openApi -->
						<div class="accodion" id="list_body"></div>
					
					
					<div class="Page_navigation">
						<div id="pageNavi"></div>
						<input type="hidden" id="pageIndex" name="pageIndex"/>
					</div>  
                
			</div>    
		</div>
	</div>	
</div>	
		

