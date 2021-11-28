<%@ page import="jdbc_task.model.Poll" %>
<%@ page import="java.util.List" %>
<%@ page import="jdbc_task.model.Question" %>
<%@ page import="jdbc_task.model.Answer" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poll Begin</title>
</head>
<body>
<%
    List<Question> questionList = (List<Question>) request.getAttribute("questionList");
    Poll poll = (Poll) request.getAttribute("poll");%>
<form action="/poll/result">
    <%
        for (Question question : questionList) {
    %>

    <p><%=question.getText()%></p>
    <ul>
    <input type="hidden"name="poll_id" value="<%=poll.getId()%>">
    <%
        for (Answer answer: question.getAnswers()) {
    %>
    <li><input type="radio" name="<%=question.getId()%>" value="<%=answer.getWeight()%>"><%=answer.getText()%> </li>
    <%    }
    %>



    <%}%>
    </ul>
    <input type="submit">
</form>
</body>
</html>
