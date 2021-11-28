<%@ page import="jdbc_task.model.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poll Resulte</title>
</head>
<body>
<% Result result = (Result) request.getAttribute("result");
%>
<%  if (result!=null){    %>

<h4><%=result.getExplanation()%></h4>
<%
    }%>
<% if (result==null){%>
<h4>Your result does not match the norm.</h4>
<%}%>
<a href="/poll" >Poll Page</a>
</body>
</html>
