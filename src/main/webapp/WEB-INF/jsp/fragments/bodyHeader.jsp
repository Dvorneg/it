<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-center">
    <a class="navbar-brand" href="#"> <spring:message code="bodyHeader.menu"/>:</a>
    <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
        <li class="nav-item active">
            <a class="nav-link" href="#">  <spring:message code="bodyHeader.main"/> <span class="sr-only">()</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="company"> <spring:message code="bodyHeader.company"/> </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="equipments"> <spring:message code="bodyHeader.equipments"/> </a>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAuthenticated()">
                <form:form class="form-inline my-2" action="logout" method="post">
                    <%--                                    <a class="btn btn-info mr-1" href="profile">${userTo.name} <spring:message code="app.profile"/></a>--%>
                <a class="btn btn-info mr-1" href="profile"><sec:authentication property="principal.userTo.name"/> <spring:message code="app.profile"/></a>
                    <button class="btn btn-primary my-1" type="submit">
                        <span class="fa fa-sign-out"></span>
                    </button>
                </form:form>
            </sec:authorize>
        </li>
        <li class="nav-item">
            <sec:authorize access="isAnonymous()">
                <form:form class="login_form my-1 " id="login_form" action="spring_security_check" method="post">
                <div class="col-auto">

                    <input class="login_form mr-1" type="text" placeholder="Email" name="username">
                    <input class="login_form mr-1" type="password" placeholder="Password" name="password">

                    <button class="btn btn-success" type="submit">
                        <span class="fa fa-sign-in"></span>
                    </button>
                </div>
                </form:form>
            </sec:authorize>
        </li>

        <li class="nav-item dropdown">

            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">${pageContext.response.locale}</a>
            <ul class="dropdown-menu">
                <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}?lang=en">English</a>
                <a class="dropdown-item" href="${requestScope['javax.servlet.forward.request_uri']}?lang=ru">Русский</a>
            </ul>

        </li>

    </ul>
</nav>

<%--
<script type="text/javascript">
    var localeCode = "${pageContext.response.locale}";
</script>--%>
