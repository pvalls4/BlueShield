<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="description" content="Aplicación de gestión interna policial">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <c:if test="${not empty title}">
            <title>${title}</title>
        </c:if>
        <c:if test="${empty title}">
            <title>BlueShield - LogIn</title>
        </c:if>
        <link rel="stylesheet" href="./css/style.css">
        <link rel="icon" type="image/png" href="./images/logoBStrazo.ico">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>

    <script>
        function redirigir(id) {
            window.location.href = id;
        }
    </script>
    <body>
        <header>
            <div class="container-fluid">
                <div class="row align-items-center mx-0 px-0">
                    <div class="col-sm-12 col-md-6 text-center">
                        <img src="./images/logoBS.png" class="img-fluid logo" alt="Logo" onclick="redirigir('dashboard')">
                        <img src="./images/blueshield.png" class="img-fluid blueshield" alt="BlueShield" onclick="redirigir('dashboard')">
                    </div>
                    <div class="col-sm-12 col-md-2 text-center"></div>
                    <div class="col-sm-12 col-md-3 text-center">
                        <div class="row align-items-center">
                            <%@ page import="model.DTO.AgenteDTO" %>
                            <c:set var="agente" value="${username}"/>
                            <c:if test="${not empty username}">
                                <div class="d-flex flex-column mx-1 pb-2">
                                    <c:if test="${agente.isAdmin()}">
                                        <p class="version mb-0 text-md-right">Versi&oacute;n 1.0 - <a href="admin">ADMIN</a></p>
                                    </c:if>
                                    <c:if test="${!agente.isAdmin()}">
                                        <p class="version mb-0 text-md-right">Versi&oacute;n 1.0</p>
                                    </c:if>
                                    <a href="agente?placa=${agente.placa}">${agente.ciudadano.nombre} ${agente.ciudadano.apellidos} (${agente.placa})</a>
                                </div>

                                <a href='logout' class="mx-1">
                                    <button type="submit" class="btn btn-primary b-login mb-1">Cerrar Sesi&oacute;n</button>
                                </a>
                            </c:if>
                            <c:if test="${empty username}">
                                <h2 class="version mb-0 text-md-right">Versi&oacute;n 1.0</h2>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div class="division mb-3">
            </div>
        </header>