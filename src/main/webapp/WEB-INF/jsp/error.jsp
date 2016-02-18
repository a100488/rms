<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
{"error":"<%
if (exception != null) {
    out.print(exception.getMessage());}%>"}