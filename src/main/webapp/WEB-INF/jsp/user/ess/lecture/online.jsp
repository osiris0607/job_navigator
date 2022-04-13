   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <div class="boxWrap">
          <div class="videoThumb">
            <iframe src='https://www.youtube.com/embed/jLPn1POu3mU' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen=''></iframe>
          </div>
          <div class="videoContentTest">
          </div>
        </div>
      </div>
    </section>
  </div>
  
  <script type="text/javascript">
  var playlist = 'jLPn1POu3mU';
  
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
