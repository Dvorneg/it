<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>

<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
<script src="resources/js/it.company.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <div class="starter-template">
        <h1><spring:message code="company.description"/></h1>
    </div>
</div>


<div class="container">
<form name="formCompany" id="formCompany"></form>
<div class="parent">
    <div class="child">
        <label class="btn btn-default"  for="selectCompany" > <spring:message code="company.label"/> :</label>
        <select id="selectCompany" name="hero" >
            <%--<option value="comapany 1">Strong company</option>--%>
        </select>
        <button type="button" onclick="selectCompany()" id="btn_select_hero"> <spring:message code="common.select"/></button>
    </div>

    <div class="child">

    </div>
</div>
</form>
</div>
<%--<div class="container">
    <a class="btn btn-primary btn-info" href="/equipments" role="button">Перейти к оборудованию > </a>
</div>--%>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
