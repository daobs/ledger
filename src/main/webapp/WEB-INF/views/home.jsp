<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
  
  <link rel="stylesheet" href="/resources/css/calendar.css" />
<title>Home</title>
</head>
<body>
	<div class="calendar">
		<div class="top">
			<div class="topBtn"><<<</div>
			<div class="topDt">${curtDt}</div>
			<div class="topBtn">>>>></div>
		</div>
		<table id="dayList">
			<tr >
				<th>일
				</th>
				<th>월
				</th>
				<th>화
				</th>
				<th>수
				</th>
				<th>목
				</th>
				<th>금
				</th>
				<th>토
				</th>
			</tr>
		</table> 
	</div>
</body>
</html>
<script type="text/javascript">
	$( document ).ready(function() {
	    $.ajax({
	    	type: "POST",
	    	url: "./calMain",
            async:false,
            dataType : "json",
            cache : false,
	    	success:function(data){
	    		var dayArr  = data.dayArr;//calendar Arr
	    		var firstDt = data.firstDt;
	    		var lastDt = data.lastDt; 
	    		var dayArrAppend = '';
	    		var idxOP = 0;
	    		
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
	    		$('#dayList').append(dayArrAppend);
	    		
	    		for(var idx=0; idx<dayArr.length; idx++){
	    			//전월 CSS 적용
	    			if( idx < firstDt ){
	    				$('#dayList').find('td').eq(idx).css('color','gray');
	    			}
	    			//익월 CSS 적용
	    			if( idx >= firstDt + lastDt ){
	    				$('#dayList').find('td').eq(idx).css('color','gray');
	    			}
	    		}
	    	},
            error : function (request,status,error) {
                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
	    });
	});
</script>


