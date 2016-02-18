<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

        <!--
            rms :: a Framework production
        -->

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta name="keywords" content="">

        <title><spring:message code="system_name"/></title>



        <!-- ================== BEGIN BASE CSS STYLE ================== -->
		<spring:url value="/resources/theme/css/bootstrap.min.css" var="bootstrap"/>
		<link href="${bootstrap}" rel="stylesheet">
		 <spring:url value="/resources/theme/font-awesome/css/font-awesome.min.css" var="fontAwesomeCss"/>
        <link href="${fontAwesomeCss}" rel="stylesheet" type="text/css" media="screen, projection"/>
		<!-- 动画 -->
		<spring:url value="/resources/theme/css/animate.css" var="animate"/>
		<link href="${animate}" rel="stylesheet">
		<!-- Toastr style -->
		<spring:url value="/resources/theme/css/plugins/toastr/toastr.min.css" var="toastr"/>
		<link href="${toastr}" rel="stylesheet">
		
		<!-- Gritter -->
		<spring:url value="/resources/theme/js/plugins/gritter/jquery.gritter.css" var="gritter"/>
		<link href="${gritter}" rel="stylesheet">
		<!-- 动画 -->
		<spring:url value="/resources/theme/css/animate.css" var="animate"/>
		<link href="${animate}" rel="stylesheet">
		<!-- 皮肤样式 -->
		 <spring:url value="/resources/theme/css/bootstrap.theme.min.css" var="bootstrapThemeCss"/>
        <link href="${bootstrapThemeCss}" rel="stylesheet" type="text/css" media="screen, projection"/>

		 <spring:url value="/resources/css/rms.min.css" var="rmsCss"/>
        <link href="${rmsCss}" rel="stylesheet" type="text/css" media="screen, projection"/>

        <spring:url value="/resources/theme/css/rms.theme.min.css" var="rmsThemeCss"/>
        <link href="${rmsThemeCss}" rel="stylesheet" type="text/css" media="screen, projection"/>
		<!-- ================== END BASE CSS STYLE ================== -->