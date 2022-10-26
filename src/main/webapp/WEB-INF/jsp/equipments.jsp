<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script src="resources/js/it.equipments.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Оборудование</h3>

        <%--        <div class="ui-widget">
                    <label for="datep">Дата: </label><input id="datep"/>
                </div>--%>

        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus"></span>
            Добавить
        </button>
        <table class="table table-striped" id="datatable11">
            <thead>
            <tr>
                <th>id</th>
                <th>Инв №</th>
                <th>Модель</th>
                <%--name--%>
                <th>Описание</th>
                <th>Фирма-производитель</th>
                <th>Тип</th>
                <th>Дата принятия</th>
                <th>изменить</th>
                <th>удалить</th>
            </tr>
            </thead>
        </table>
    </div>
</div>


<%--Модальное окно--%>
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
                        <label for="name" class="col-form-label">Модель</label>
                        <input class="form-control" id="name" name="name"
                               placeholder="name">
                    </div>

                    <div class="form-group">
                        <label for="releaseDate" class="col-form-label">releaseDate</label>
                        <input class="form-control" id="releaseDate" name="releaseDate" autocomplete="off"
                               placeholder="releaseDate">
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-form-label">description</label>
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="description">
                    </div>

                    <div class="form-group">
                        <label for="inventoryNumber" class="col-form-label">inventoryNumber</label>
                        <input type="text" class="form-control" id="inventoryNumber" name="inventoryNumber"
                               placeholder="inventoryNumber">
                    </div>

                    <div class="form-group">
                        <label for="company" class="col-form-label">company</label>
                        <input type="text" class="form-control" id="company" name="company"
                               placeholder="company">
                    </div>

                    <div class="form-group">
                        <label for="responsiblePerson" class="col-form-label">Ответственный</label>
                        <input type="text" class="form-control" id="responsiblePerson" name="responsiblePerson"
                               placeholder="responsiblePerson">
                    </div>

                    <div class="form-group">

                            <%--<label for="typeOf" class="col-form-label">Тип</label>--%>
                           <input type="hidden" class="form-control" id="typeOf" name="typeOf"
                                   placeholder="typeOf">

                        <%--<jsp:useBean id="TypeOfArray" type="ru.inventarit.model.Equipment"/>--%>
                        <%--  @variable id="TypeOfArray" type="Array"--%>
                        <c:set var="TypeOfArray" value="${TypeOfArray}"/>

                        <div class="form-group">
                            <label class="col-form-label">Тип</label>

                            <p>
                                <%--<select class="col-form-label" id="typeOfArray" name="typeOfArray" onchange="alert(this.value)"> + --%>
                                <select class="col-form-label" id="typeOfArray" name="typeOfArray" onchange=onChangeTypeOfArray(this.value) >

                                        <c:forEach items="${TypeOfArray}" var="friend">
                                            <option value="<c:out value="${friend}"/>"><c:out value="${friend}"/></option>
                                        </c:forEach>

                                </select>
                            </p>
                        </div>

                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="closeNoty()">
                    <span class="fa fa-close"></span>Отмена
                </button>

                <button type="button" class="btn btn-primary" onclick="save()">
                    <span class="fa fa-check"></span>
                    save
                </button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
