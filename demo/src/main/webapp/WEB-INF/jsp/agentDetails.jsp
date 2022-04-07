<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1><spring:message code="welcome.message"/></h1>
<h1>Agent ${agent.name}</h1>
<h2>Details</h2>
<h3>Salary</h3>
${agent.salary}
<h3>Agency</h3>
${agent.agency}
<h3>Joueurs</h3>
<table>
    <tr>
        <td>Nom</td>
        <td>Age</td>
        <td>Buts</td>
        <td>Passe dé</td>
        <td>Matchs</td>
        <td>Blessé</td>
    </tr>
    <c:forEach var="player" items="${agents.clients}">
        <tr>
            <td><a href="/players/${player.id}">${player.firstname}</a></td>
            <td>${player.age}</td>
            <td>${player.goals}</td>
            <td>${player.assists}</td>
            <td>${player.matchs}</td>
            <td>${player.injured}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>