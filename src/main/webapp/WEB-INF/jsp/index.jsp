<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ru">
<head>
    <title>IT</title>

    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">

<%--    <link rel="stylesheet" href="resources/css/style.css?v=2">--%>
    <link rel="stylesheet" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/>
<%--    <link rel="shortcut icon" href="resources/images/icon-.png">--%>
<%--    <script src="webjars/jquery/3.6.1/jquery.min.js"></script>--%>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js" defer></script>
    <script src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>

</head>
<body>

<%--<nav class="navbar navbar-dark bg-dark">--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar scroll</a>

        <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile/equipment">Оборудование</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Link
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">Link</a>
            </li>
        </ul>

<%--        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Главная</a></li>
                <li><a href="profile/equipment">Оборудование</a></li>&ndash;%&gt;
            </ul>
        </div>--%>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Hello Spring Boot Web JSP</h1>
        <h2>Сообщение h2</h2>
    </div>

</div>
<%--<script type="text/javascript" src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>--%>
</body>
</html>