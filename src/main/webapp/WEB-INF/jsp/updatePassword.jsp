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
			 <rms:navigator title="修改登录密码" navs="首页,修改登录密码" />
			 <div class="wrapper wrapper-content animated fadeInRight">
                    <form>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox m-b-none">
                                    <div class="ibox-content">
                                        <div class="alert alert-warning fade in">
                                             <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span></button>
                                             请尽量输入复杂的密码，包含字母、数字和特殊符号，以免密码泄露。
                                         </div>
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-md-1 control-label">*原密码</label>
                                                <div class="col-md-3">
                                                    <input id="oldpassword" name="oldPassowrd" type="password" class="form-control" data-parsley-trigger="change" required="required" data-parsley-type="alphanum" data-parsley-maxlength="20" maxlength="20" data-parsley-trim-value="true" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-1 control-label">*新密码</label>
                                                <div class="col-md-3">
                                                    <input id="password1" name="password1" type="password" class="form-control" data-parsley-trigger="change" required="required" data-parsley-type="alphanum" data-parsley-maxlength="20" maxlength="20" data-parsley-trim-value="true"  onpaste="return false" onselectstart="return false"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-md-offset-1 col-md-4">
                                                    <div id="passwordStrengthDiv" class="is0 m-t-5"></div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-1 control-label">*确认密码</label>
                                                <div class="col-md-3">
                                                    <input id="password2" name="password2" type="password" class="form-control" data-parsley-trigger="change" required="required" data-parsley-type="alphanum" data-parsley-maxlength="20" maxlength="20" data-parsley-trim-value="true" data-parsley-equalto="#password1" data-parsley-equalto-message="确认密码与新密码不一致" onpaste="return false" onselectstart="return false" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox">
                                    <div class="ibox-content">
                                        <div class="form-horizontal">
                                            <div class="form-group m-b-none">
                                                <div class="col-lg-10 col-lg-offset-2">
                                                    <a href="javascript:;" id="confirm" class="btn btn-primary">确定</a>
                                                    <fns2:url value="/overviews" var="overviews"/>
                                                    <a href="${overviews}" id="backward" class="btn btn-white">返回</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
			 <rms:bottomFooter />
		</div>
	</div>

	
     <jsp:include page="fragment/pageFooter.jsp"/>
<script>


</script>
</body>
</html>
