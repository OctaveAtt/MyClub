<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <h1><spring:message code="welcome.message"/> ${sessionScope.user.username}</h1>
<h2>List of releases</h2>
<ul>
    <li><a href="${pageContext.request.contextPath}/clubs">Clubs</a></li>
    <li><a href="${pageContext.request.contextPath}/players">Players</a></li>
    <li><a href="${pageContext.request.contextPath}/agents">Agents</a></li>
</ul>
<c:if test="${empty sessionScope.user}">
<form:form action="/login" method="get" modelAttribute="user">
    <div class="mb-3">
        <form:label for="username" class="form-label" path="username"></form:label>
        <form:input id="username" cssClass="form-control" path="username" value="" placeholder="Nom d'utilisateur"/>
    </div>
    <div class="mb-3">
        <form:label for="password" class="form-label" path="password"></form:label>
        <form:input type="password" id="password" cssClass="form-control" path="password" value="" placeholder="Mot de passe"/>
    </div>
    <input type="submit" value="Login"/>
</form:form>
</c:if>
</div>
</body>
</html>