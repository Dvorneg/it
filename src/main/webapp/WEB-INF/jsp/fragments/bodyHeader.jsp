<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Навигация:</a>
    <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
        <li class="nav-item active">
            <a class="nav-link" href="#">Главная <span class="sr-only">()</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="equipments">Оборудование</a>
        </li>
    </ul>
</nav>

<%--
<script type="text/javascript">
    var localeCode = "${pageContext.response.locale}";
</script>--%>
