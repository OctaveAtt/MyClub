<head>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>


<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
        <div>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand">ProductManager</a>
        </div>

        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}\players"> Players</a></li>
            <li class="nav-item"><a class="nav-link" href="\agents"> Agents</a></li>
            <li class="nav-item"><a class="nav-link" href="\clubs">Clubs</a></li>
            <c:choose>
                <c:when test="${empty sessionScope.user}">

                    <li class="nav-item"><a class="nav-link" href="\">Connexion</a></li>

                </c:when>
                <c:otherwise>
                    <li class="nav-item"><a class="nav-link" href="\logout">Deconnexion</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </nav>
</header>