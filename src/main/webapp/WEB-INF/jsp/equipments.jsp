<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script src="resources/js/it.equipments.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center"><spring:message code="equipments.header"/></h3>

        <%--        <div class="ui-widget">
                    <label for="datep">Дата: </label><input id="datep"/>
                </div>--%>

        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus"></span>
            <spring:message code="common.add"/>
        </button>
        <table class="table table-striped" id="datatable11">
            <thead>
            <tr>
                <th>id</th>
                <th><spring:message code="equipments.inventoryNumber"/></th>
                <th><spring:message code="equipments.model"/></th>
                <%--name--%>
                <th><spring:message code="equipments.description"/></th>
                <th><spring:message code="equipments.company"/> </th> <%--Фирма-производитель--%>
                <th><spring:message code="equipments.type"/> </th>
                <th><spring:message code="equipments.releaseDate"/></th>
                <th><spring:message code="common.change"/> </th>
                <th><spring:message code="common.delete"/> </th>
            </tr>
            </thead>
        </table>
    </div>
</div>


<%--modal window--%>
<div class="modal fade" tabindex="-1" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle"></h4>
                <%--<button type="button" class="btn-close"  data-bs-dismiss="modal" onclick="closeNoty()">&times;</button>--%>
                <button type="button" class="btn-close" data-bs-dismiss="modal" onclick="closeNoty()"></button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">

                    <input type="hidden" id="id" name="id">
                    <%--<input id="id" name="id">--%>

                    <div class="form-group">
                        <label for="name" class="col-form-label"><spring:message code="equipments.model"/> </label>
                        <input class="form-control" id="name" name="name"
                               placeholder="<spring:message code="equipments.model"/>">
                    </div>

                    <div class="form-group">
                        <label for="releaseDate" class="col-form-label"> <spring:message code="equipments.releaseDate"/> </label>
                        <input class="form-control" id="releaseDate" name="releaseDate" autocomplete="off"
                               placeholder="<spring:message code="equipments.releaseDate"/>">
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-form-label"><spring:message code="equipments.description"/> </label>
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="<spring:message code="equipments.description"/>">
                    </div>

                    <div class="form-group">
                        <label for="inventoryNumber" class="col-form-label"><spring:message code="equipments.inventoryNumber"/></label>
                        <input type="text" class="form-control" id="inventoryNumber" name="inventoryNumber"
                               placeholder="<spring:message code="equipments.inventoryNumber"/>">
                    </div>

                    <div class="form-group">
                        <label for="company" class="col-form-label"> <spring:message code="equipments.company"/> </label>
                        <input type="text" class="form-control" id="company" name="company"
                               placeholder="<spring:message code="equipments.company"/>">
                    </div>

                    <div class="form-group">
                        <label for="responsiblePerson" class="col-form-label"><spring:message code="equipments.responsiblePerson"/></label>
                        <input type="text" class="form-control" id="responsiblePerson" name="responsiblePerson"
                               placeholder="<spring:message code="equipments.responsiblePerson"/>">
                    </div>

                    <div class="form-group">

                        <%--<label for="typeOf" class="col-form-label">Тип</label>--%>
                        <input type="hidden" class="form-control" id="typeOf" name="typeOf"
                               placeholder="typeOf">

                        <%--<jsp:useBean id="TypeOfArray" type="ru.inventarit.model.Equipment"/>--%>
                        <%--  @variable id="TypeOfArray" type="Array"--%>
                        <c:set var="TypeOfArray" value="${TypeOfArray}"/>

                        <div class="form-group">
                            <label class="col-form-label"> <spring:message code="equipments.type"/>  </label>

                            <p>
                                <%--<select class="col-form-label" id="typeOfArray" name="typeOfArray" onchange="alert(this.value)"> + --%>
                                <select class="col-form-label" id="typeOfArray" name="typeOfArray"
                                        onchange=onChangeTypeOfArray(this.value)>

                                    <c:forEach items="${TypeOfArray}" var="field">
                                        <%--<option value="<c:out value="${field.toString()}"/>">--%>
                                        <%--    <c:set var="locale" value="${pageContext.response.locale}"/>--%>
                                        <option value="<c:out value="${field.toString()}"/>"><c:out value="${field.getTitle()}"/></option>
                                    </c:forEach>

                                </select>
                            </p>
                        </div>

                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="closeNoty()">
                    <span class="fa fa-close"></span> <spring:message code="common.cancel"/>
                </button>

                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    <spring:message code="common.save"/>
                </button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>

<%--<script>alert('${page language}')</script>--%>
<%--<script defer>setLocale('${pageContext.response.locale.toString()}')</script>--%>
</html>
