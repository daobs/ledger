<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Calendar</title>
</head>
<body>
<div class="calendar">
		<div class="top">
			<span class="topBtnLft" id="topBtnLft"> [이전] </span>
			<span class="topDt" id="topDt"></span>
			<span class="topBtnRgt" id="topBtnRgt"> [이후] </span>
		</div>
		<table class="dayList" id="dayList">
	
		</table> 
</div>
<script type="text/javascript">
	//전역변수
	var clickCnt = 0;
	var nwDt = null;
	//on Load
	$( document ).ready(function() {
		getCalDayArr();
	});
	
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
		    			//ID 적용
		    			var _dayArr_txt =  $('#dayList').find('td').eq(idx).text();
		    			$('#dayList').find('td').eq(idx).attr('id', 'dayArr' + _dayArr_txt);
		    		}
		    		$('#topDt').text(data.curtDt);
		    	},
	            error : function (request,status,error) {
	                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            }
		    });
		 
		 eventCall();
	}
	
	function eventCall() {
		$('#topBtnLft').click(function(){
			clickCnt = -1;
			nwDt = $('#topDt').text().replace('년 ', '').replace('월', '');
			getCalDayArr();
		});
		
		$('#topBtnRgt').click(function(){
			clickCnt = 1;
			nwDt = $('#topDt').text().replace('년 ', '').replace('월', '');
			getCalDayArr();
		});
		
		$('#dayList').find('td').click(function() {
			alert( $(this).text() );
		});
	}
</script>
		
</body>
</html>

