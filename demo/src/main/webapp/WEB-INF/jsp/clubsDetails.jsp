<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<%@include file="header.jsp" %>
    <div class="container">
    <h1>Club ${club.name}</h1>
    <h2>Details</h2>
    <h3>Date</h3>
    ${club.dateOfBirth}
    <h3>City</h3>
    ${club.city}
    <h3>Stadium</h3>
    ${club.stadium}
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
        <c:forEach var="player" items="${players}">
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
    <h2>Add new Player</h2>
    <%--@elvariable id="newPlayer" type="com.example.demo.model.Player"--%>
    <form:form action="/clubs/addPlayer/${club.id}" method="post" modelAttribute="newPlayer">
        <div class="mb-3">
            <form:label for="firstname" cssClass="form-label" path="firstname"></form:label>
            <form:input id="firstname" cssClass="form-control" path="firstname" value=""  placeholder="Prenom"/>
        </div>
        <div class="mb-3">
            <form:label for="lastname" cssClass="form-label" path="lastname"></form:label>
            <form:input id="lastname" cssClass="form-control" path="lastname" value=""  placeholder="Nom"/>
        </div>
        <div class="mb-3">
            <form:label for="age" cssClass="form-label" path="age"></form:label>
            <form:input id="age" type="number" cssClass="form-control" path="age" value=""  placeholder="Age"/>
        </div>
        <div class="mb-3">
            <form:label for="goals" cssClass="form-label" path="goals"></form:label>
            <form:input id="goals" type="number" cssClass="form-control" path="goals" value=""  placeholder="Goals"/>
        </div>
        <div class="mb-3">
            <form:label for="assists" cssClass="form-label" path="assists"></form:label>
            <form:input id="assists" type="number" cssClass="form-control" path="assists" value=""  placeholder="Assists"/>
        </div>
        <div class="mb-3">
            <form:label for="matchs" cssClass="form-label" path="matchs"></form:label>
            <form:input id="matchs" type="number" cssClass="form-control" path="matchs" value=""  placeholder="Matchs"/>
        </div>
        <div class="mb-3">
            <form:label for="injured" cssClass="form-label" path="injured"></form:label>
            <form:checkbox id="injured" path="injured"/>
        </div>
        <input type="submit" value="Save"/>
    </form:form>
    </div>
</body>
</html>