<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>--%>
    <title>InventarIT</title>
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
    <link rel="stylesheet" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
<%-- <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/>--%>
    <script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js" defer></script>
<%--    <script src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>--%>
    <link rel="shortcut icon" href="resources/images/favicon.png">

</head>
