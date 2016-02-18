<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="rms" tagdir="/WEB-INF/tags"%>
<spring:url value="/resources" var="resources" />
<!DOCTYPE html>
<html>

<head>
<jsp:include page="../fragment/pageHeader.jsp" />
 <spring:url value="/resources/theme/css/plugins/sweetalert/sweetalert.css" var="sweetalertCss"/>
 <link href="${sweetalertCss}" rel="stylesheet" type="text/css" media="screen, projection"/>

<style type="text/css">
.permission {
	height: 40px;
	line-height: 40px;
}

.permission .box {
	display: inline-block;
	height: 40px;
	line-height: 40px;
}

.permission .box .current {
	color: #333;
}

.permission .box .a-link {
	display: inline-block;
	float: left;
	max-width: 250px;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

.permission .span-tab {
	display: inline-block;
	width: 37px;
	height: 40px;
	line-height: 40px;
	float: left;
}
/* TASK#166 BY ZHANGLL START */
.div-btn-first {
	height: 40px;
	line-height: 40px;
	float: left;
	margin-left: 20px;
}
/* TASK#166 BY ZHANGLL END */
.div-btn {
	display: none;
	height: 40px;
	line-height: 40px;
	float: left;
	margin-left: 20px;
}

.permission:hover .box .div-btn {
	display: inline-block;
}
</style>

</head>

<body class="mini-navbar fixed-nav">
	<div id="wrapper">
		<rms:sideBar />

		<div id="page-wrapper" class="gray-bg dashbard-1">
			<rms:topMenu />
			<!-- 面包屑开始 -->
			<%-- <rms:navigator title="企业初始化设置" navs="首页,系统设置,企业设置" /> --%>
			
			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-lg-12">
					<h2>
						<spring:message code="function_list" />
					</h2>
					<ol class="breadcrumb">
						<li class="active"><strong><spring:message code="homepage"/></strong></li>
						<li class="active"><strong><spring:message code="function_management"/></strong></li>
						<li><a><spring:message code="function_list" /></a></li>
					</ol>
				</div>
			</div>
			<!-- 面包屑结束 -->
			
			<div class="wrapper wrapper-content animated fadeInRight" id="main">
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox m-b-none">
							<div class="ibox-content">
								<div class="row">
									<div class="col-lg-12" id="div-link"></div>
									
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>
			<rms:bottomFooter />
		</div>
	</div>
 <!-- start modal -->
        <!-- 编辑、添加模态 -->
        <div id="editModal" class="modal fade" >
            <form id="editForm">
                <div class="modal-dialog">
                    <div class="modal-content">
                       <div class="modal-header">
                            <h4 class="modal-title"  id="header-modal"><spring:message code="edit" /></h4>
                        </div>
                        <div class="modal-body">
                            <input id="uuid" name="uuid" type="hidden" />
                              <input id="parentUuid" name="parentUuid" type="hidden" />
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*<spring:message code="function_name" /></label>
                                            <div class="col-lg-8">
                                                <input id="permissionName" name="permissionName" type="text" data-rule-requiredEx="true" maxlength="50 " data-rule-maxlength="50" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*<spring:message code="control_code" /></label>
                                            <div class="col-lg-8">
                                                <input id="permission" name="permission" type="text" maxlength="255 " data-rule-requiredEx="true" data-rule-maxlength="255" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="javascript:;" id="editConfirm-add" class="btn btn-primary" data-dismiss="modal"><spring:message code="determine" /></a>
                             <a href="javascript:;" id="editConfirm-edit" class="btn btn-primary" data-dismiss="modal"><spring:message code="determine" /></a>
                            <a href="javascript:;" class="btn btn-white" data-dismiss="modal"><spring:message code="cancel" /></a>
                       
                        </div>
                    </div>
                </div>
            </form>
        </div>
    <!-- end modal -->
     <!-- 编辑、添加模态 -->
        <div id="validModel" class="modal fade" style="z-index: 100000">
            <form id="validForm">
                <div class="modal-dialog">
                    <div class="modal-content">
                       <div class="modal-header">
                            <h4 class="modal-title"  id="header-modal">开发人员验证</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*开发人员密码:</label>
                                            <div class="col-lg-8">
                                                <input id="validCode" name="validCode" type="password" data-rule-requiredEx="true" maxlength="50 " data-rule-maxlength="50" class="form-control">
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="javascript:;" id="validConfirm" class="btn btn-primary" ><spring:message code="determine" /></a>
                            
                            <a href="javascript:;" class="btn btn-white" data-dismiss="modal"><spring:message code="cancel" /></a>
                       
                        </div>
                    </div>
                </div>
            </form>
        </div>
    <!-- end modal -->
	<jsp:include page="../fragment/pageFooter.jsp" />
	<!-- validate 验证逻辑 -->
	<spring:url value="/resources/theme/js/plugins/validate/jquery.validate.min.js" var="validate"/>
    <script src="${validate}" type="text/javascript" charset="UTF-8"></script>
    <spring:url value="/resources/theme/js/plugins/validate/messages_zh.min.js" var="validateMessages"/>
    <script src="${validateMessages}" type="text/javascript" charset="UTF-8"></script>
 	<spring:url value="/resources/theme/js/plugins/validate/additional-methods.min.js" var="validateAddition"/>
    <script src="${validateAddition}" type="text/javascript" charset="UTF-8"></script>
	<!-- 提示框逻辑 -->
	<spring:url value="/resources/theme/js/plugins/sweetalert/sweetalert.min.js" var="sweetalert"/>
    <script src="${sweetalert}" type="text/javascript" charset="UTF-8"></script>
    <!-- 本页面的js -->
	<spring:url value="/resources/js/permission/permission.min.js" var="permission"/>
    <script src="${permission}" type="text/javascript" charset="UTF-8"></script>
</body>
</html>
