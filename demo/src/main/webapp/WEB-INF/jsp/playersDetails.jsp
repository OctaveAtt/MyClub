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
<h1>Player ${player.firstname} ${player.lastname}</h1>
<h2>Details</h2>
<h3>Age</h3>
${player.age}
<h3>Club</h3>
${player.club.name}
<h3>Goals</h3>
${player.goals}
<h3>Assists</h3>
${player.assists}
<h3>Matchs</h3>
${player.matchs}

<h2> Sign a new contract</h2>
<form:form action="players/addContract/${player.id}" method="post" modelAttribute="newContract">
    <div class="mb-3">
        <form:label path="signatureDate" for="Sgndate"></form:label>
        <form:input id="Sgndate" path="signatureDate" value="" type="date"  placeholder="Signature Date"/><br/>
    </div>
    <div class="mb-3">
        <form:label path="expirationDate" for="Expdate"></form:label>
        <form:input path="expirationDate" id="ExpDate" value=""  type="date" placeholder="Expiration Date"/><br/>
    </div>

    <div class="mb-3">
        <form:label path="value" for="contractValue"></form:label>
        <form:input path="value" id="contractValue" value="" type="number" placeholder="Salary"/><br/>
    </div>
    <div class="mb-3">
        <form:label path="playersNumber" for="pNumber"></form:label>
        <form:input path="playersNumber" id="pNumber" value="" type="number" placeholder="Player N°"/><br/>
    </div>
    <input type="submit" value="Save"/>
</form:form>
</div>
</body>
</html>