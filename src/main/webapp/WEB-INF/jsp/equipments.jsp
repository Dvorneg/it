<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">

<head>
    <title>IT2</title>

    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
    <link rel="stylesheet" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.12.1/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/>

    <script src="webjars/jquery/3.6.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js" defer></script>
   <script src="webjars/datatables/1.12.1/js/jquery.dataTables.min.js" defer></script>
    <script src="webjars/datatables/1.12.1/js/dataTables.bootstrap5.min.js" defer></script>
    <script src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>
    <%--<script src="webjars/datetimepicker/2.5.20-1/build/jquery.datetimepicker.full.min.js" defer></script>--%>

</head>
<body>
<%--<script src="${pageContext.request.contextPath}/resources/js/topjava.common.js" defer></script>--%>
<script src="${pageContext.request.contextPath}/resources/js/it.equipments.js" defer></script>
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
</body>
</html>
