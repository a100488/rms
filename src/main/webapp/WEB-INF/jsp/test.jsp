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
							
							
							
							
							
							 <a href="javascript:;" id="add" class="btn btn-primary" >添加</a>
							 <a href="javascript:;" id="edit" class="btn btn-primary" >修改</a>
							 
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
						</div>
					</div>
				</div>
			</div>
			 <rms:bottomFooter />
		</div>
	</div>
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
          <div id="editModel" class="modal fade">
            <form id="editForm">
                <div class="modal-dialog">
                    <div class="modal-content">
                       <div class="modal-header">
                            <h4 class="modal-title"  id="header-modal">修改</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*修改:</label>
                                            <div class="col-lg-8">
                                                <input id="validCode" name="validCode" type="password" data-rule-requiredEx="true" maxlength="50 " data-rule-maxlength="50" class="form-control">
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="javascript:;" id="editConfirm" class="btn btn-primary" ><spring:message code="determine" /></a>
                            
                            <a href="javascript:;" class="btn btn-white" data-dismiss="modal"><spring:message code="cancel" /></a>
                       
                        </div>
                    </div>
                </div>
            </form>
        </div>
          <div id="addModel" class="modal fade" >
            <form id="addForm">
                <div class="modal-dialog">
                    <div class="modal-content">
                       <div class="modal-header">
                            <h4 class="modal-title"  id="header-modal">添加</h4>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-lg-3 control-label">*添加:</label>
                                            <div class="col-lg-8">
                                                <input id="validCode" name="validCode" type="password" data-rule-requiredEx="true" maxlength="50 " data-rule-maxlength="50" class="form-control">
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="javascript:;" id="editConfirm" class="btn btn-primary" ><spring:message code="determine" /></a>
                            
                            <a href="javascript:;" class="btn btn-white" data-dismiss="modal"><spring:message code="cancel" /></a>
                       
                        </div>
                    </div>
                </div>
            </form>
        </div>
	
     <jsp:include page="fragment/pageFooter.jsp"/>
<script>


</script>
</body>
</html>
