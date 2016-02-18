<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="rms" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<spring:url value="/resources" var="resources" />
<!DOCTYPE html>
<html>

<head>
<jsp:include page="../fragment/pageHeader.jsp" />

<spring:url
	value="/resources/theme/css/plugins/dataTables/dataTables.bootstrap.css"
	var="dataTablesCss" />
<link href="${dataTablesCss}" rel="stylesheet" type="text/css"
	media="screen, projection" />

<spring:url
	value="/resources/theme/css/plugins/dataTables/dataTables.responsive.css"
	var="responsiveCss" />
<link href="${responsiveCss}" rel="stylesheet" type="text/css"
	media="screen, projection" />

<spring:url
	value="/resources/theme/css/plugins/sweetalert/sweetalert.css"
	var="sweetalertCss" />
<link href="${sweetalertCss}" rel="stylesheet" type="text/css"
	media="screen, projection" />
<spring:url value="/resources/theme/css/plugins/select2/select2.css"
	var="select2Css" />
<link href="${select2Css}" rel="stylesheet" type="text/css"
	media="screen, projection" />
	<style>
.select2-container--default .select2-selection--multiple {
     
    background-color: #FFFFFF;
    background-image: none;
    border: 1px solid #e5e6e7;
    border-radius: 1px;
    color: inherit;
    display: block;
    transition: border-color 0.15s ease-in-out 0s, box-shadow 0.15s ease-in-out 0s;
    width: 100%;
    font-size: 14px;
}
.select2-container--default.select2-container--focus .select2-selection--multiple {
     
   
    border: 1px solid #1c84c6;
  
}
.select2-dropdown {
 padding-top: 5px !important;
    border: 1px solid #5897fb !important;
    margin-top: 0 !important;
    -webkit-border-radius: 0px !important;
    -moz-border-radius: 0px !important;
    border-radius: 0px !important;
   
}
.select2-results {
    max-height: 200px;
    padding: 0 0 0 4px;
    margin: 4px 4px 4px 0;
    position: relative;
    overflow-x: hidden;
    overflow-y: auto;
    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}
	</style>
</head>

<body class="mini-navbar fixed-nav">
	<div id="wrapper">
		<rms:sideBar/>
 
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<rms:topMenu/>
			<!-- 面包屑开始 -->
			
			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-lg-12">
					<h2>
						<spring:message code="role_list" />
					</h2>
					<ol class="breadcrumb">
						<li class="active"><strong><spring:message code="homepage"/></strong></li>
						<li class="active"><strong><spring:message code="role_management"/></strong></li>
						<li><a><spring:message code="role_list" /></a></li>
					</ol>
				</div>
			</div>
			<!-- 面包屑结束 -->
		     <div class="wrapper wrapper-content animated fadeInRight">
	                  <form>
	                      <div class="row">
	                          <div class="col-lg-8">
	                              <div class="ibox m-b-none">
	                                  <div class="ibox-content">
	                                      <div class="table-responsive">
	                                          <table id="roleTable" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
	                                              <thead>
	                                                  <tr>
	                                                      <th style="width: 20%;">角色名称</th>
	                                                      <th style="width: 40%;">备注</th>
	                                                      <th style="width: 20%;">状态</th>
	                                                      <th style="width: 20%;"></th>
	                                                  </tr>
	                                              </thead>
	                                              <tbody>
	                                              </tbody>
	                                          </table>
	                                      </div>
	                                  </div>
	                              </div>
	                              <shiro:hasPermission name="addRole">
	                              <div class="ibox">
	                                  <div class="ibox-content">
	                                      <div class="form-horizontal">
	                                          <div class="form-group m-b-none">
	                                              <div class="col-lg-12">
	                                                  <a id="add" href="javascript:;" class="btn btn-primary btn-info"><spring:message code="new_roles"/></a>
	                                                   
	                                              </div>
	                                          </div>
	                                      </div>
	                                  </div>
	                              </div></shiro:hasPermission>
	                          </div>
	                      </div>
	                  </form>
	              </div>
			
			<rms:bottomFooter />
		</div>
	</div>
 <!-- start modal -->
      <!-- 过虑模态 -->
        <div id="filterModal" class="modal fade">
            <form id="filterForm">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title"><spring:message code="screen"/></h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-horizontal">
                                       <div class="form-group">
                                            <label class="col-lg-3 control-label"><spring:message code="query_state"/>：</label>
                                            <div class="col-lg-4">
                                                <select id="deleteFlag" name="deleteFlag" class="form-control">
                                                    <option value=''><spring:message code="whole"/></option>
                                                     
                                                        <option value="0"><spring:message code="enable"/></option>
                                                    
                                                        <option value="1"><spring:message code="disable"/></option>
                                                    
                                                </select>
                                            </div>
                                        </div>
                                       
                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="javascript:;"  id="filterConfirm" class="btn btn-primary" data-dismiss="modal">确定</a>
                            <a href="javascript:;"  class="btn btn-white" data-dismiss="modal">取消</a>
                             <a href="javascript:;" id="filterClear" class="btn btn-white" >清空</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!-- end Model -->
	<!-- start edit Model -->
	 <div id="editModal" class="modal fade">
            <form id="editForm">
                <div class="modal-dialog">
                    <div class="modal-content">
                       <div class="modal-header">
                            <h4 class="modal-title"  id="header-modal"><spring:message code="edit" /></h4>
                        </div>
                        <div class="modal-body">
                            <input id="uuid" name="uuid" type="hidden" />
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-horizontal">
                                    	<input type="hidden" name="uuid" id="uuid">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*<spring:message code="role_name" /></label>
                                            <div class="col-lg-8">
                                                <input id="roleName" name="roleName" type="text" data-rule-requiredEx="true" maxlength="50 " data-rule-maxlength="50" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*<spring:message code="memo" /></label>
                                            <div class="col-lg-8">
                                                <input id="memo" name="memo" type="text" maxlength="255 " data-rule-requiredEx="true" data-rule-maxlength="255" class="form-control">
                                            </div>
                                        </div>
                                         <shiro:hasPermission name="addRolePermission">
                                        <div class="form-group">
                                                <label class="col-lg-3 control-label">*权限分配：</label>
                                                <div class="col-lg-8">
                                                   <select id="permission" style="width: 100%;" name="permissionIds" multiple="multiple" class="form-control" >
                                                    </select>
                                                </div>
                                            </div>
                                            </shiro:hasPermission>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                             <a href="javascript:;" id="editConfirm-edit" class="btn btn-primary" ><spring:message code="determine" /></a>
                            <a href="javascript:;" class="btn btn-white" data-dismiss="modal"><spring:message code="cancel" /></a>
                       
                        </div>
                    </div>
                </div>
            </form>
        </div>
	<!-- end edit Model -->
     <jsp:include page="../fragment/pageFooter.jsp"/>
    <spring:url
		value="/resources/theme/js/plugins/dataTables/jquery.dataTables.js"
		var="jquerydataTables" />
	<script src="${jquerydataTables}" type="text/javascript"
		charset="UTF-8"></script>

	<spring:url
		value="/resources/theme/js/plugins/dataTables/dataTables.bootstrap.js"
		var="dataTablesBootstrap" />
	<script src="${dataTablesBootstrap}" type="text/javascript"
		charset="UTF-8"></script>
 <spring:url value="/resources/theme/js/plugins/dataTables/dataTables.custom.min.js" var="dataTablesCustom"/>
  <script src="${dataTablesCustom}" type="text/javascript" charset="UTF-8"></script>
  
	<spring:url
		value="/resources/theme/js/plugins/validate/jquery.validate.min.js"
		var="validate" />
	<script src="${validate}" type="text/javascript" charset="UTF-8"></script>

	<spring:url
		value="/resources/theme/js/plugins/validate/messages_zh.min.js"
		var="validateMessages" />
	<script src="${validateMessages}" type="text/javascript"
		charset="UTF-8"></script>

	<spring:url
		value="/resources/theme/js/plugins/validate/additional-methods.min.js"
		var="validateAddition" />
	<script src="${validateAddition}" type="text/javascript"
		charset="UTF-8"></script>

	<spring:url
		value="/resources/theme/js/plugins/sweetalert/sweetalert.min.js"
		var="sweetalert" />
	<script src="${sweetalert}" type="text/javascript" charset="UTF-8"></script>
	<spring:url
		value="/resources/theme/js/plugins/select2/select2.min.js"
		var="select2JS" />
	 <script src="${select2JS}" type="text/javascript" charset="utf8"></script>
	

	

	
     <spring:url value="/resources/js/role/role.min.js" var="roleJs"/>
    <script src="${roleJs}" type="text/javascript" charset="UTF-8"></script>
</body>
</html>
