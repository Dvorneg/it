<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="ru">
    <jsp:include page="fragments/headTag.jsp"/>
<body>
<script src="resources/js/it.equipments.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Оборудование</h3>
        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus"></span>
            Добавить
        </button>
        <table class="table table-striped" id="datatable11">
            <thead>
            <tr>
                <th>id</th>
                <th>Инв №</th>
                <th>Модель</th> <%--name--%>
                <th>Описание</th>
                <th>Фирма-производитель</th>
                <th>Тип</th>
                <th>Дата принятия</th>

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
                <button type="button" class="btn-close"  data-bs-dismiss="modal" onclick="closeNoty()"></button>
            </div>
            <div class="modal-body">
               <form id="detailsForm">

                    <%--<input type="hidden" id="id" name="id">--%>
                    <input  id="id" name="id">

                   <div class="form-group">
                       <label for="release_date" class="col-form-label">release_date</label>
                       <input class="form-control" id="release_date" name="release_date" autocomplete="off"
                              placeholder="release_date">
                   </div>

                    <div class="form-group">
                        <label for="name" class="col-form-label">Модель</label>
                        <input class="form-control" id="name" name="name"
                               placeholder="name">
                    </div>

                   <div class="form-group">
                        <label for="description" class="col-form-label">description</label>
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="description">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <%--<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="closeNoty()">--%>
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