<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<html>
<head>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" />
  
  <link rel="stylesheet" href="/resources/css/calendar.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>
      <decorator:title default="traveler" />
  </title>
  <style>
  </style>
  <decorator:head />
</head>
<body>
	<%@ include file="/WEB-INF/views/topMenu.jsp" %>
	<decorator:body />
</body>
</html>
<script type="text/javascript">
</script>


