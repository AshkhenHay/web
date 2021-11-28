<%@ page import="jdbc_task.model.Poll" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Poll</title>
</head>
<body>
<%List<Poll> pollList  = (List<Poll>) request.getAttribute("pollList"); %>
<ul>
<%
    for (Poll poll : pollList) {%>
<li><a href="/poll/beginPoll?poll_id="<%=poll.getId()%>><%=poll.getName()%></a><br>
    </li>
<%

    }%>
</ul>
</body>
</html>
