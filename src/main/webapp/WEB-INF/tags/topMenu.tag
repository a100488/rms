
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<spring:url value="/resources" var="resources" />
<spring:url value="/" var="content" />
<%
org.apache.shiro.subject.Subject subject = org.apache.shiro.SecurityUtils.getSubject();
com.anwei.rms.pojo.entity.User user = (com.anwei.rms.pojo.entity.User)subject.getPrincipal();
String name="";
if(user!=null){
 name=user.getUserName();
}else{
	 response.sendRedirect("rms/");
}
%>
<div class="row border-bottom">
	<nav class="navbar navbar-fixed-top" role="navigation"
		style="margin-bottom: 0">
		<!-- 项目名称 -->
		<div class="navbar-header">
			<h2>&nbsp;&nbsp;&nbsp;<spring:message code="system_name"/></h2>
		</div>
		<!-- 右侧men -->
		<ul class="nav navbar-top-links navbar-right">
			
			<!-- 消息 -->
			<li class="dropdown">
				<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> 
					<i class="fa fa-bell"></i> 
					<span class="label label-primary">8</span>
				</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li>
						<a href="grid_options.html">
							
								<i class="fa fa-upload fa-fw"></i> 
										<spring:message code="messages"/>
								<span class="pull-right text-muted small"><spring:message code="messages_count" arguments="4"/></span>
							
						</a>
					 </li>
					<li class="divider"></li>
					<li>
						<div class="text-center link-block">
							<a href="notifications.html"> 
							<strong><spring:message code="view_all_messages"/></strong> 
							<i class="fa fa-angle-right"></i>
							</a>
						</div>
					</li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> 
					<i class="fa fa-language"></i><spring:message code="language"/><b class="caret"></b>
				</a>
				<ul class="dropdown-menu animated fadeInLeft">

					<li>
						<a href="${content}global-index?langType=en">
								<spring:message code="language_en"/>
						</a>
					</li>
					
					<li>
						<a  href="${content}global-index?langType=zh">
								<spring:message code="language_zh"/>
						</a>
					</li>
					
				</ul>
			</li>
			<!-- 管理员名称角色 -->
			<li class="dropdown">
				<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> 
					<i class="fa fa-user fa-lg"></i><%=name%><b class="caret"></b>
				</a>
				<ul class="dropdown-menu animated fadeInLeft">

					<li>
						<a href="${content}update-password">
							<spring:message code="modify_login_password"/>
						</a>
					</li>
					
					<li>
						<a href="${content}logout" class="text-danger">
								<spring:message code="logout"/>
							<i class="fa fa-sign-out"></i>
						</a>
					</li>
				</ul>
			</li>
		</ul>

	</nav>
</div>
