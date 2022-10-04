<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">

<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
   <script src="webjars/jquery/3.6.1/jquery.min.js"></script>
   <script src="webjars/datatables/1.12.1/js/jquery.dataTables.min.js" defer></script>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script src="resources/js/it.equipments.js" defer></script>
<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Оборудование</h3>
<%--        <button class="btn btn-primary" onclick="add()">
            <span class="fa fa-plus"></span>
            Добавить
        </button>--%>
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
<%--<script>
    $(document).ready(function() {
        var table = $('#datatable').DataTable( {
            lengthChange: false,
            buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
        } );

        table.buttons().container()
            .appendTo( '#example_wrapper .col-md-6:eq(0)' );
    } );
</script>--%>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
