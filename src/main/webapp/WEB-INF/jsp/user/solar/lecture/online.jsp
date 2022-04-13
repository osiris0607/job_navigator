   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/od5yWB5aE0c' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContentTest">
          </div>
        </div>
      </div>
    </section>
  </div>
  
  
  <script type="text/javascript">
  var playlist = 'od5yWB5aE0c';
  
  $(document).ready(function () {
	  $.get(
			  "https://www.googleapis.com/youtube/v3/videos", { 
				  part: 'snippet', 
				  maxResults: 50, 
				  id: playlist, 
				  key: 'AIzaSyDP37HANaDbBKYx9s95DVj7qNZMV3DJMbU' 
			},
			
			function (data) {
				var output;
				$.each(data.items, function (i, item) {
					console.log('item ---> ', item);
					vTitle = item.snippet.title; 
					vDate = item.snippet.publishedAt; 
					vDe = item.snippet.description; 
					vTh = item.snippet.channelTitle; 
					
					var vDateFormat = vDate.toString().replace('T', ' ').substring(0, 10);  //date format yyyy-mm-dd
					console.log(vDateFormat);
					output = '<li>' + vTitle + '<br>--vDate: ' + vDateFormat + '<br>--videodescription: ' + vDe + '<br>--videoTitles: ' + vTh + '"</li>'; 
					/*output= '<li>'+vTitle+'<iframe src=\"//www.youtube.com/embed/'+vId+'\"></iframe></li>';*/ 
					$(".videoContentTest").append(output);

					
					
				})
			}
		);

  });

  
</script>
