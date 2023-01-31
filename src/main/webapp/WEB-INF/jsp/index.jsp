<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>

<head>
<jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <div class="starter-template">
        <h1><spring:message code="index.description"/></h1>
        <h2><spring:message code="index.description2"/></h2>
    </div>
</div>

<div class="container">
    <spring:message code="welcome.text"/>
   <%-- "#{welcome.text}"--%>
</div>

<div class="container">
    <a class="btn btn-primary btn-info" href="/company" role="button"> <spring:message code="index.start"/>  </a>
</div>

<%--<% out.println("<script> alert ('Зарегистрировано успешно'); window.location.href ('index.jsp'); </script>"); %>--%>
<%--<script>alert("ru")</script>--%>
<%--<script>alert('${pageContext.response.locale.toString()}')</script>--%>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>