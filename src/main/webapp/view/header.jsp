<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <div class="d-flex justify-content-around">
                <div class="d-flex">
                    <img src="./images/logoBS.png" class="logo">
                    <div class="d-flex flex-column justify-content-center">
                        <img src="./images/blueshield.png" class="blueshield">
                    </div>
                </div>
                <h2 class="d-flex flex-column justify-content-end">Version 1.0 - <%= request.getAttribute("username") %></h2>
            </div>
            <div class="division mb-3"></div>
        </header>