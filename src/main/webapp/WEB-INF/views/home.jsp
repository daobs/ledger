<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
  
  <link rel="stylesheet" href="/resources/css/calendar.css" />
<title>Calendar</title>
</head>
<body>
	<div class="calendar">
	<div id="header" class="header">
	    <header>
	        <h1 class="logo">Calendar</h1>
	        <div class="header_util">
	            <a href="/">HOME</a>
	                <a href="javascript:memProdBuy();">로그인</a>
	                <a href="https://www.juvis.co.kr/member/step01.do" target="_blank" class="btn_join_set" onclick="check_device();">회원가입</a>
	                <a href="/page/cscenter/notice">공지사항</a>
	                <a href="/page/cart">설정</a>
	        </div>
	        <!--// header_util -->
	        <!-- gnb -->
	        <nav>
	            <div id="gnb" class="gnb">
	                <ul>
	                    <li><a href="/">일일</a></li>
	                    <li><a href="/">달력</a></li>
	                    <li><a href="/">주별</a></li>
	                    <li><a href="/">월별</a></li>
	                    <li><a href="/">카테고리별</a></li>
	                    <li><a href="/">요약</a></li>
	                </ul>
	            </div>
	        </nav>
	        <!--// gnb -->
	    </header>
	</div>
		<div class="top">
			<span class="topBtnLft" id="topBtnLft"> [이전] </span>
			<span class="topDt" id="topDt"></span>
			<span class="topBtnRgt" id="topBtnRgt"> [이후] </span>
		</div>
		<table class="dayList" id="dayList">

		</table> 
	</div>
</body>
</html>
<script type="text/javascript">
	//전역변수
	var clickCnt = 0;
	var nwDt = null;
	//on Load
	$( document ).ready(function() {
		getCalDayArr();
	});

	$('#topBtnLft').click(function(){
		clickCnt = -1;
		nwDt = $('#topDt').text().replace('년 ', '').replace('월', '');
		getCalDayArr();
	})
	$('#topBtnRgt').click(function(){
		clickCnt = 1;
		nwDt = $('#topDt').text().replace('년 ', '').replace('월', '');
		getCalDayArr();
	})
	
	
	function getCalDayArr() {
		 $.ajax({
		    	type: "POST",
		    	url: "./calMain",
	            async:false,
	            data : {nwDt : nwDt, clickCnt : clickCnt},
	            dataType : "json",
	            cache : false,
		    	success:function(data){
		    		var dayArr  = data.dayArr;//calendar Arr
		    		var firstDt = data.firstDt;
		    		var lastDt = data.lastDt; 
		    		var dayArrAppend = '';
		    		var idxOP = 0;
		    		
		    		dayArrAppend += '<tr class="WeekNm">';
		    		dayArrAppend += '<th>일</th>';
		    		dayArrAppend += '<th>월</th>';
		    		dayArrAppend += '<th>화</th>';
		    		dayArrAppend += '<th>수</th>';
		    		dayArrAppend += '<th>목</th>';
		    		dayArrAppend += '<th>금</th>';
		    		dayArrAppend += '<th>토</th>';
		    		dayArrAppend += '</tr>';
		    		
		    		for(var idx=0; idx<dayArr.length; idx++){
		    			
		    			if( idx % 7 == 0){
		    				dayArrAppend += '<tr>'
		    					idxOP++;
		    			}
		    			
		    			dayArrAppend += '<td>' + dayArr[idx] + '</td>';
		    			
		    			if( idxOP == 7){
		    				idxOP = 0;
		    				dayArrAppend += '</tr>';
		    			}
		    			
		    		}
		    		$('#dayList').html(dayArrAppend);
		    		
		    		for(var idx=0; idx<dayArr.length; idx++){
		    			//전월 CLASS 적용
		    			if( idx < firstDt ){
		    				$('#dayList').find('td').eq(idx).addClass('dayArrBf');
		    			}
		    			//익월 CLASS 적용
		    			else if( idx >= firstDt + lastDt ){
		    				$('#dayList').find('td').eq(idx).addClass('dayArrAf');
		    			}
		    			//현재월 CLASS 적용
		    			else{
		    				$('#dayList').find('td').eq(idx).addClass('dayArr');
		    			}
		    		}
		    		$('#topDt').text(data.curtDt);
		    	},
	            error : function (request,status,error) {
	                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            }
		    });
	}
</script>


