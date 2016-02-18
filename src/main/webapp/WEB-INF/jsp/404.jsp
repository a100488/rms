<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><spring:message code="system_name"/></title>
<spring:url value="/resources/theme/css/bootstrap.min.css" var="bootstrap"/>
		<link href="${bootstrap}" rel="stylesheet">
		<spring:url value="/resources/theme/font-awesome/css/font-awesome.css" var="awesome"/>
		<link href="${awesome}" rel="stylesheet">

   <!-- 动画 -->
		<spring:url value="/resources/theme/css/animate.css" var="animate"/>
		<link href="${animate}" rel="stylesheet">
		<!-- 皮肤样式 -->
		<spring:url value="/resources/theme/css/bootstrap.theme.min.css" var="style"/>
		<link href="${style}" rel="stylesheet">

</head>

<body class="gray-bg">


    <div class="middle-box text-center animated fadeInDown">
        <h1>404</h1>
        <h3 class="font-bold"><spring:message code="page_not_found"/> </h3>

        <div class="error-desc">
          <spring:message code="error_page_massage"/> 
          <spring:url value="/" var="home_page"/>
            <a href="${home_page}" class="btn btn-primary"><spring:message code="go_homepage"/> </a>
             
            
        </div>
    </div>

    <!-- Mainly scripts -->
    <spring:url value="/resources/theme/js/jquery-2.1.1.js" var="jquery"/>
    <script src="${jquery}" type="text/javascript" charset="UTF-8"></script>
  <spring:url value="/resources/theme/js/bootstrap.min.js" var="bootstrap"/>
    <script src="${bootstrap}" type="text/javascript" charset="UTF-8"></script>

</body>

</html>
