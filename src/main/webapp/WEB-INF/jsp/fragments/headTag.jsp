<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>--%>
    <title>InventarIT</title>
    <base href="${pageContext.request.contextPath}/"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
    <link rel="stylesheet" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">    <%--Красивый плюс--%>
    <link rel="stylesheet" href="webjars/popper.js/2.9.3/umd/popper.min.js"> <%--Выпадающее меню--%>
    <link rel="stylesheet" href="webjars/datatables/1.12.1/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/> <%--всплывающие подсказки--%>
    <link rel="stylesheet" href="webjars/datetimepicker/2.5.20-1/jquery.datetimepicker.css"> <%--календарь--%>
    <link rel="shortcut icon" href="resources/images/favicon.png">

    <%--Только для таблиц--%>
    <script src="webjars/popper.js/2.9.3/umd/popper.min.js" defer></script>
    <script src="webjars/jquery/3.6.1/jquery.min.js" defer></script>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js" defer></script>
    <script src="webjars/datatables/1.12.1/js/jquery.dataTables.min.js" defer></script>
    <script src="webjars/datatables/1.12.1/js/dataTables.bootstrap5.min.js" defer></script>
    <script src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>
    <script src="webjars/datetimepicker/2.5.20-1/build/jquery.datetimepicker.full.min.js" defer></script>

</head>
