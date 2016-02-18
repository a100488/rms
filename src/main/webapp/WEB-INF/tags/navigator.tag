<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="navs" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
                <div class="row wrapper border-bottom white-bg page-heading">
                    <div class="col-lg-12">
                        <h2>${title}</h2>
                            <ol class="breadcrumb">
                            <c:forEach items="${fn:split(navs,',')}" var="item" varStatus="status">
                                	
                                <c:choose>
                                    <c:when test="${status.last}">
                                        <li class="active">
                                            <strong>${item}</strong>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                    <li>
                                    <%--
                                        	有链接的面包屑导航
                                         <a href="#">${item}</a> <span class="divider">/</span>   --%>
                                        <a>${item}</a>
                                    </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            </ol>
                        </div>
                    </div>