<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="inputF" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <%--@elvariable id="userTo" type="ru.inventarit.to.UserTo"--%>
        <div class="row">
            <div class="col-5 offset-3">
                <h3>${userTo.name} <spring:message code="${register ? 'app.register' : 'app.profile'}"/></h3>
                <form:form class="form-group" modelAttribute="userTo" method="post" action="${register ? 'profile/register' : 'profile'}"
                           charset="utf-8" accept-charset="UTF-8">

                    <input name="id" value="${userTo.id}" type="hidden">

                    <inputF:inputField labelCode="user.name" name="name"/>
                    <inputF:inputField labelCode="user.email" name="email"/>
                    <inputF:inputField labelCode="user.password" name="password" inputType="password"/>

                    <div class="text-center">
                        <a class="btn btn-secondary" href="#" onclick="window.history.back()">
                            <span class="fa fa-close"></span>
                            <spring:message code="common.cancel"/>
                        </a>
                        <button type="submit" class="btn btn-primary">
                            <span class="fa fa-check"></span>
                            <spring:message code="common.save"/>
                        </button>
                    </div>
                </form:form>
                <br/>
            <%--    <sec:authorize access="hasRole('USER')">--%>
                    <div class="text-center">
                        <button class="btn btn-info" onclick="window.location.href = '/feedback'"><spring:message code="profile.feedback"/></button>
                    </div>
            <%--    </sec:authorize>--%>

            </div>
        </div>
    </div>
</div>
<br/>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
