    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <!-- ================== BEGIN BASE JS ================== -->
    
   <!-- Mainly scripts -->
   <spring:url value="/resources/theme/js/jquery-2.1.1.js" var="jquery"/>
    <script src="${jquery}" type="text/javascript" charset="UTF-8"></script>
    
    <spring:url value="/resources/theme/js/bootstrap.min.js" var="bootstrap"/>
    <script src="${bootstrap}" type="text/javascript" charset="UTF-8"></script>
    
  <spring:url value="/resources/theme/js/plugins/metisMenu/jquery.metisMenu.js" var="metisMenu"/>
    <script src="${metisMenu}" type="text/javascript" charset="UTF-8"></script>

	<spring:url value="/resources/theme/js/plugins/slimscroll/jquery.slimscroll.min.js" var="slimscroll"/>
    <script src="${slimscroll}" type="text/javascript" charset="UTF-8"></script>


	<!-- Flot -->
	<spring:url value="/resources/theme/js/plugins/flot/jquery.flot.js" var="jqueryFlot"/>
    <script src="${jqueryFlot}" type="text/javascript" charset="UTF-8"></script>
	
	<spring:url value="/resources/theme/js/plugins/flot/jquery.flot.tooltip.min.js" var="tooltip"/>
    <script src="${tooltip}" type="text/javascript" charset="UTF-8"></script>
	
	<spring:url value="/resources/theme/js/plugins/flot/jquery.flot.spline.js" var="spline"/>
    <script src="${spline}" type="text/javascript" charset="UTF-8"></script>
   
    <spring:url value="/resources/theme/js/plugins/flot/jquery.flot.resize.js" var="resize"/>
    <script src="${resize}" type="text/javascript" charset="UTF-8"></script>
    
    <spring:url value="/resources/theme/js/plugins/flot/jquery.flot.pie.js" var="pie"/>
    <script src="${pie}" type="text/javascript" charset="UTF-8"></script>
	
  	<spring:url value="/resources/theme/js/plugins/blockui/jquery.blockUI.min.js" var="blockUI"/>
    <script src="${blockUI}" type="text/javascript" charset="UTF-8"></script>
	<!-- Peity -->
	<spring:url value="/resources/theme/js/plugins/peity/jquery.peity.min.js" var="peity"/>
    <script src="${peity}" type="text/javascript" charset="UTF-8"></script>
    

    
	

	<!-- Custom and plugin javascript -->
	<spring:url value="/resources/theme/js/inspinia.js" var="inspinia"/>
    <script src="${inspinia}" type="text/javascript" charset="UTF-8"></script>
    
	<spring:url value="/resources/theme/js/plugins/pace/pace.min.js" var="pace"/>
    <script src="${pace}" type="text/javascript" charset="UTF-8"></script>
    

	<!-- jQuery UI -->
	<spring:url value="/resources/theme/js/plugins/jquery-ui/jquery-ui.min.js" var="jqueryUi"/>
    <script src="${jqueryUi}" type="text/javascript" charset="UTF-8"></script>
    
	

	<!-- GITTER -->
	<spring:url value="/resources/theme/js/plugins/gritter/jquery.gritter.min.js" var="gritter"/>
    <script src="${gritter}" type="text/javascript" charset="UTF-8"></script>
    
	

	<!-- Sparkline -->
	<spring:url value="/resources/theme/js/plugins/sparkline/jquery.sparkline.min.js" var="sparkline"/>
    <script src="${sparkline}" type="text/javascript" charset="UTF-8"></script>
    




	<!-- ChartJS-->
	<spring:url value="/resources/theme/js/plugins/chartJs/Chart.min.js" var="chartJs"/>
    <script src="${chartJs}" type="text/javascript" charset="UTF-8"></script>
    

	<!-- Toastr -->
	<spring:url value="/resources/theme/js/plugins/toastr/toastr.min.js" var="toastr"/>
    <script src="${toastr}" type="text/javascript" charset="UTF-8"></script>
	
    <!-- ================== END BASE JS ================== -->
    <!-- ================== START MY JS ================== -->
    <spring:url value="/resources/js/rms.js" var="rms"/>
    <script src="${rms}" type="text/javascript" charset="UTF-8"></script>
    <spring:url value="/resources/js/" var="rmsLocale"/>
    <script src="${rmsLocale}<spring:message code="rms.locale"/>" type="text/javascript" charset="UTF-8"></script>
    <spring:url value="/resources/js/rms.theme.min.js" var="rmsTheme"/>
    <script src="${rmsTheme}" type="text/javascript" charset="UTF-8"></script>
    <!-- ================== END MY JS ================== -->