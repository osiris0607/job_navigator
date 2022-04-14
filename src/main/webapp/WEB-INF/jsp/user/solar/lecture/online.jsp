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

        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/CJrKMml6Yw4' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContent">
            <p class="videoTitle">Solar Everywhere: NREL Pioneers the Future of Photovoltaics</p>
            <p class="videoSummary">1,585 views•Jan 14, 2021</p>
            <ul class="videoOwner">
              <li>National Renewable Energy Laboratory - NREL</li>
              <li>5.9K subscribers</li>
            </ul>
          </div>
        </div>
        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/xKxrkht7CpY' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContent">
            <p class="videoTitle">How do solar panels work? - Richard Komp</p>
            <p class="videoSummary">4,336,425 views•Jan 6, 2016</p>
            <ul class="videoOwner">
              <li>TED-Ed</li>
              <li>13.3M subscribers</li>
            </ul>
          </div>
        </div>
        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/XwFB22r9zRo' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContent">
            <p class="videoTitle">5 Inventions Showing Us the Future of Solar Energy</p>
            <p class="videoSummary">605,837 views•May 25, 2020</p>
            <ul class="videoOwner">
              <li>SciShow</li>
              <li>6.51M subscribers</li>
            </ul>
          </div>
        </div>
        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/od5yWB5aE0c' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContent">
            <p class="videoTitle">The Rise Of Solar Power</p>
            <p class="videoSummary">1,084,804 views•Sep 22, 2019</p>
            <ul class="videoOwner">
              <li>CNBC</li>
              <li>2.09M subscribers</li>
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
		comAjax.setUrl("<c:url value='/user/api/solar/lecture/online/all' />");
		comAjax.setCallback("searchListCB");
		comAjax.ajax();
	}

  function searchListCB(data) {
		var body = $("#ul_body");
		body.empty();
			var str = "";
			$.each(data.result, function(key, value) {
				console.log(key);
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
					  part: 'snippet', 
					  maxResults: 50, 
					  id: playlist, 
					  key: 'AIzaSyDP37HANaDbBKYx9s95DVj7qNZMV3DJMbU' 
				},
				
				function (data) {
					console.log('data ---> ', data);
					var output;
					$.each(data.items, function (i, item) {
						
						vTitle = item.snippet.title; 
						vDate = item.snippet.publishedAt; 
						vDe = item.snippet.description; 
						vTh = item.snippet.channelTitle; 
						
						var vDateFormat = vDate.toString().replace('T', ' ').substring(0, 10);  //date format yyyy-mm-dd
						console.log(playlist, item.id);
						if(playlist == item.id){
						output = '<p>' + vTitle + '</p><p>--vDate: ' + vDateFormat + '</p><p class="scroll_de">--videodescription: ' + vDe + '</p><p>--videoTitles: ' + vTh + '"</p>'; 
						/* 영상 : output= '<li>'+vTitle+'<iframe src=\"//www.youtube.com/embed/'+vId+'\"></iframe></li>';*/ 
						$(".videoContentTest").append(output);
						}
						
						
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