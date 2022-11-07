<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ru">

<head>
<jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <div class="starter-template">
        <h1>Hello Spring Boot Web JSP</h1>
        <h2>Сообщение h2</h2>
    </div>
</div>
<div class="container">
    <div class="starter-template">
        <h1>Вода вода</h1>
        <h2>вода вода</h2>
    </div>
</div>
<div class="container">
    <spring:message code="welcome.text"/>
   <%-- "#{welcome.text}"--%>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>