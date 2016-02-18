<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<spring:url value="/" var="first" />
<nav class="navbar-default navbar-static-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav metismenu" id="side-menu">
			<li class="nav-header" style="height: 52px;"></li>
			<li ><a href="${first}"><i class="fa fa-home fa-lg"></i> <span
					class="nav-label"><spring:message code="homepage"/></span></a></li>
			<shiro:hasPermission name="userManagement">
			<li><a href="#"><i class="fa fa-user fa-lg"></i>
					<span class="nav-label"><spring:message code="user_management"/></span></a>
				<ul class="nav nav-second-level">
					<spring:url value="/user/user-list" var="userList" />
					<li><a href="${userList}"><spring:message code="user_management"/></a></li>
				</ul>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="roleManagement">
			<li><a href="#"><i class="fa fa-users"></i> <span
					class="nav-label"><spring:message code="role_management"/></span> </a>
				<ul class="nav nav-second-level" >
					<spring:url value="/role/role-list" var="roleList" />
					<li><a href="${roleList}"><spring:message code="role_management"/></a></li>
				</ul>
			</li>
			</shiro:hasPermission>
			<shiro:hasPermission name="permissionManagement">
			<li><a href="#"><i class="fa fa-sliders"></i> <span
					class="nav-label"><spring:message code="authority_management"/></span><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<spring:url value="/permission/permission" var="permissionQuery" />
					<li><a href="${permissionQuery}"><spring:message code="function_management"/></a></li>
				</ul>
		   </li>
</shiro:hasPermission>


		</ul>
	</div>
</nav>