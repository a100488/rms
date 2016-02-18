<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="rms" tagdir="/WEB-INF/tags"%>
<spring:url value="/resources" var="resources" />
<spring:url value="/" var="content" />
<!DOCTYPE html>
<html>

<head>
<jsp:include page="fragment/pageHeader.jsp"/>

</head>

<body class="mini-navbar fixed-nav">
	<div id="wrapper">
		<rms:sideBar/>
 
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<rms:topMenu/>
			
			<div class="wrapper wrapper-content animated fadeInRight" id="main">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-body">
							<h1>welcome_language</h1>
							<div id="test">

 <spring:message code="welcome_language"/><br/>



							</div>
							
						</div>
					</div>
				</div>
			</div>
			 <rms:bottomFooter />
		</div>
	</div>

	
     <jsp:include page="fragment/pageFooter.jsp"/>
<script>


</script>
</body>
</html>
