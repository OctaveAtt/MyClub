<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clubs</title>
    <link rel="stylesheet" href="/css/bugtracking.css"/>
</head>
<body>

<%@include file="header.jsp" %>
<div class="container">
<h1>Clubs</h1>
<h2>List</h2>
<table class="table">
    <tr>
        <td>Nom</td>
        <td>Date</td>
        <td>Ville</td>
        <td>Stadium</td>
    </tr>
    <c:forEach var="club" items="${clubs}">
        <tr>
            <td><a href="/clubs/${club.id}">${club.name}</a></td>
            <td>${club.dateOfBirth}</td>
            <td>${club.city}</td>
            <td>${club.stadium}</td>
        </tr>
    </c:forEach>
</table>
<h2>Add new club</h2>

<form:form action="/clubs/register" method="post" modelAttribute="newClub">
    <div class="mb-3">
        <form:label for="name" cssClass="form-label" path="name"></form:label>
        <form:input id="name" cssClass="form-control" path="name" value=""  placeholder="Prenom"/>
    </div>
    <div class="mb-3">
        <form:label for="date" cssClass="form-label" path="dateOfBirth"></form:label>
        <form:input id="date" cssClass="form-control" path="dateOfBirth" value="" type="date"  placeholder="Date"/>
    </div>
    <div class="mb-3">
        <form:label for="ville" cssClass="form-label" path="city"></form:label>
        <form:input id="ville" cssClass="form-control" path="city" value=""  placeholder="Ville"/>
    </div>
    <div class="mb-3">
        <form:label for="stadium" cssClass="form-label" path="stadium"></form:label>
        <form:input id="stadium" cssClass="form-control" path="stadium" value=""  placeholder="Prenom"/>
    </div>
    <input type="submit" class="btn btn-success" value="Save"/>
</form:form>
</div>
</body>
</html>