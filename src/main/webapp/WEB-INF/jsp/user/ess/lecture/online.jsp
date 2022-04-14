<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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

        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/jLPn1POu3mU' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContent">
            <p class="videoTitle">Gamechangers: How Energy Storage Transforms the Power System</p>
            <p class="videoSummary">31,297 views Feb 23, 2016</p>
            <ul class="videoOwner">
              <li>Energy Storage North America</li>
              <li>231 subscribers</li>
            </ul>
          </div>
        </div>
        
        <!-- Youtube openApi -->
          <div class="accodion" id="ul_body"></div>
          </div>
      </div>
    </section>
  </div>
  
  <script type="text/javascript">
  
  
  $(document).ready(function () {
	  searchList(1);
	 

  });

  function searchList(pageNo) {
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/user/api/ess/lecture/online/all' />");
		comAjax.setCallback("searchListCB");
		comAjax.ajax();
	}

  function searchListCB(data) {
		var body = $("#ul_body");
		body.empty();
			var str = "";
			$.each(data.result, function(key, value) {
				console.log(value);
				var videoIdList = value.url.split('/');
				var playlist = videoIdList[videoIdList.length-1];
				
				str += "<div class='boxWrap'>";
				str += "	<div class='videoThumb'>";
				str += "		<iframe src='https://www.youtube.com/embed/"+ playlist +"' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>";
				str += "	</div>";
				str += 		"<div class='videoContentTest'>";
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
						
						output = '<p>' + vTitle + '</p><p>' +vCount+'views ' + vDateFormat +  '</p><p>' + vTh + '</p>'; 

						/*output= '<li>'+vTitle+'<iframe src=\"//www.youtube.com/embed/'+vId+'\"></iframe></li>';*/ 
						$(".videoContentTest").append(output);

						
						
					})
				}
			);
		  
			});
			body.append(str);
	}
  
</script>
<style>
.scroll_de {
	overflow-y: auto; max-height: 80px; border:1px solid black;
}
</style>
