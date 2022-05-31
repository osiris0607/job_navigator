(function(w, $){
  $('#skip_navi a').each(function(){
    $(this).click(function(){
      var thishref = $(this).attr('href');
      $(thishref).attr('tabindex','-1');
      $(thishref).focus();
    });
  });


  
  // tab
  var tabMenu = $(".tabIntab");
  tabMenu.find("ul > li > div").hide();
  tabMenu.find("li.active > div").show();
  function tabList(e){
    e.preventDefault();
    var target = $(this);
    target.next().show().parent("li").addClass("active").siblings("li").removeClass("active").find("div").hide();
  }
  tabMenu.find("ul > li > a").click(tabList).focus(tabList);

  //요소별 :last-child 적용
  $('.coWrap').last().css({'margin-right':'0'});
}) (window, jQuery);  




/*-------------------------------------------------------------jobnavigator page-------------------------------------------------------------*/
$(function(){
	// gnb
	$(document).ready(function (e) {
		$(".jobnavigatorsubMenu, #subMenuBg").hide();
		$(".jobnavigatorMenu > li").mouseover(function (e) {			
			$(".jobnavigatorsubMenu, #subMenuBg").show();
			$(this).children('.jobnavigatorsubMenu').addClass('selected');
			$(this).siblings().children('.jobnavigatorsubMenu').removeClass('selected');		
		}),		
		$("#gnb").mouseleave(function (e) {				
			$(".jobnavigatorsubMenu, #subMenuBg").hide();			
			$(this).children().find('.selected').removeClass('selected');
		});		   
	});
	$(".jobnavigatorMenu .jobnavigatorsubMenu").mouseover(function (e) {			
		$(this).parent().children('a').addClass('on');
	}),	
	$(".jobnavigatorMenu .jobnavigatorsubMenu").mouseleave(function (e) {				
		$(this).parent().children('a').removeClass('on');
	});
	$('.jobnavigatorMenu>li>a').on('mouseover focus',function(){
		$('.jobnavigatorsubMenu, #subMenuBg').show();					
		$(this).siblings('ul').addClass('selected');		
		$(this).parent().siblings('li').children('ul').removeClass('selected');
	});	
	$('.jobnavigatorMenu>li .jobnavigatorsubMenu a').on('mouseover focus',function(){					
		$(this).parent().parent().siblings('a').addClass('on');
	});	
	$('.jobnavigatorMenu>li .jobnavigatorsubMenu a').blur(function () {			
		$(this).parent().parent().siblings('a').removeClass('on');
	});	
	$('.jobnavigatorMenu>li:last-child .jobnavigatorsubMenu li a').blur(function () {
		$('.jobnavigatorsubMenu, #subMenuBg').hide();
	});
	
	/*$(".jobnavigatorsubMenu, #subMenuBg").hide();
		$(".jobnavigatorMenu > li").mouseover(function (e) {
			//$(".subMenu").not($(this).children(".subMenu")).hide();
			
			var n = $(this).index()+1;
			$("#subMenuBg").slideDown().removeClass().addClass("bg" + n);
			$(this).children('.jobnavigatorsubMenu').addClass('selected');
			$(this).siblings().children('.jobnavigatorsubMenu').removeClass('selected');
			$(".jobnavigatorsubMenu, #subMenuBg").slideDown();
		}),		
		$("#gnb").mouseleave(function (e) {				
			$(".jobnavigatorsubMenu").hide();
			$("#subMenuBg").slideUp(300);
			$(this).children().find('.selected').removeClass('selected');
		});		   
	});

	$(".jobnavigatorMenu .jobnavigatorsubMenu a").mouseover(function (e) {			
		$(this).parent().parent().parent().children('a').addClass('on');
	}),	
	$(".jobnavigatorMenu .jobnavigatorsubMenu a").mouseleave(function (e) {				
		$(this).parent().parent().parent().children('a').removeClass('on');
	});

	$('.jobnavigatorMenu>li>a').on('mouseover focus',function(){
		$('.jobnavigatorsubMenu:visible').hide();
		$(".jobnavigatorsubMenu, #subMenuBg").slideDown().stop();
		$(this).next(':hidden').show();
		if($(this).hasClass('sub')){
			$('#subMenuBg').slideDown().removeClass().addClass("bg" + n);
		}
		
		$(this).siblings('.jobnavigatorsubMenu').addClass('selected');
		$(this).siblings('.jobnavigatorsubMenu').removeClass('selected');
	});

	
	$('.jobnavigatorMenu>li:last-child .jobnavigatorsubMenu li a').blur(function () {
		$('.jobnavigatorsubMenu, #subMenuBg').slideUp();
	});*/
	
	//money
	$(".money, .number").on("keyup", function(){
	   $(this).val($(this).val().replace(/\,/g, '').replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,'));
	});
	
	//all_checked
	$("#allCheck").click(function(){ 
		if($("#allCheck").prop("checked")) { 
			$(".employinfor_table .education_check").prop("checked", true); 
		} else { 
			$(".employinfor_table .education_check").prop("checked", false); 
		} 
	});
	
	//희망임금-시급
	$("input[name='Hope']").on('click',function(){		
		if($('input:radio[id="Hope_all"]').is(":checked") == false){
			$('#Hope_money1, #Hope_money2').attr('disabled', false);	
		}else{            		
			$('#Hope_money1, #Hope_money2').attr('disabled', true);
			$('#Hope_money1, #Hope_money2').val('');
		 }		
	});

	//학력 - 학력무관(00) 입력시 다수 항목 입력 불가
	$('#education6').on('click',function(){		
		if($('#education6').is(":checked") == true){
			//체크박스 비활성화
			$("input#education1").attr("disabled", true);
			$("input#education2").attr("disabled", true);
			$("input#education3").attr("disabled", true);
			$("input#education4").attr("disabled", true);
			$("input#education5").attr("disabled", true);
			
			//체크박스 초기화
			$("input#education1").prop("checked", false); 
			$("input#education2").prop("checked", false); 
			$("input#education3").prop("checked", false); 
			$("input#education4").prop("checked", false); 
			$("input#education5").prop("checked", false); 
		}else {
			$("input#education1").attr("disabled", false);
			$("input#education2").attr("disabled", false);
			$("input#education3").attr("disabled", false);
			$("input#education4").attr("disabled", false);
			$("input#education5").attr("disabled", false);
			
			
			
		}
	});

	//경력 - 개월 디세이블 해제	
	$("input[name='history']").on('click',function(){		
		if($('input:checkbox[id="history3"]').is(":checked") == true){
			$('#employment_money1, #employment_money2').attr('disabled', false);	
		}else{            		
			$('#employment_money1, #employment_money2').attr('disabled', true);		 
			$('#employment_money1, #employment_money2').val('');
		 }		
	});

	//리스트 형식 - 체인지
	$(".list_other").on('click',function(){		
		$(this).addClass("list_on");
		$(this).siblings().removeClass("card_on");
		$(".list_search_card_area").hide();
		$(".list_search_table").show();
			 
		
	});
	$(".card_other").on('click',function(){	
		$(this).addClass("card_on");
		$(this).siblings().removeClass("list_on");
		$(".list_search_table").hide();
		$(".list_search_card_area").show();
	});
	

	// 달력
	$(".datepicker").datepicker({  
		  showOn: "both", // 버튼과 텍스트 필드 모두 캘린더를 보여준다.
		  //buttonImage: "/application/db/jquery/images/calendar.gif", 버튼 이미지
		  buttonText : false, 
		  buttonImageOnly: false, // 버튼에 있는 이미지만 표시한다.
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
		  nextText: '다음 달', // next 아이콘의 툴팁.
		  prevText: '이전 달', // prev 아이콘의 툴팁.
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
		  stepMonths: 1, // next, prev 버튼을 클릭했을때 얼마나 많은 월을 이동하여 표시하는가. 
		  yearRange: 'c-100:c+10', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
		  //showButtonPanel: true,  캘린더 하단에 버튼 패널을 표시한다. ( ...으로 표시되는부분이다.) 
		  //currentText: '오늘 날짜' ,  오늘 날짜로 이동하는 버튼 패널
		  closeText: '닫기',  // 닫기 버튼 패널
		  dateFormat: "yy-mm-dd", // 텍스트 필드에 입력되는 날짜 형식.
		  showAnim: "slide", //애니메이션을 적용한다.  
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
		  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], // 요일의 한글 형식.
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 월의 한글 형식.
	  
	});
})


