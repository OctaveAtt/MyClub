<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agents</title>
    <link rel="stylesheet" href="/css/bugtracking.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="container">
<h1>Clubs</h1>
<h2>List</h2>
<table class="table">
    <tr>
        <td>Nom</td>
        <td>Salaire</td>
        <td>Agence</td>
    </tr>

    <c:forEach var="agent" items="${agents}">
        <tr>
            <td><a href="/clubs/${agent.id}">${agent.name}</a></td>
            <td>${agent.salary}</td>
            <td>${agent.agency}</td>
        </tr>
    </c:forEach>
</table>
<h2>Add new agent</h2>
<form:form action="/agents/register" method="post" modelAttribute="newAgent">
    <div class="mb-3">
        <form:label for="agentName" class="form-label" path="name"/>
        <form:input id="agentName" cssClass="form-control" path="name" value="" placeholder="Nom"/>
    </div>
    <div class="mb-3">
        <form:label for="agentSalary" class="form-label" path="salary"/>
        <form:input id="agentSalary" type="number" path="salary" cssClass="form-control" placeholder="Salaire"/>
    </div>
    <div class="mb-3">
    <label for="agentAgency" class="form-label"></label>
    <form:input id="agentAgency" path="agency" cssClass="form-control" value="" placeholder="Ville"/>
    </div>
    <input type="submit" class="btn btn-primary" value="Save"/>
</form:form>
</div>
</div>
</body>
</html>