<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="description" content="Aplicación de gestión interna policial">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>BlueShield</title>
        
        <link rel="stylesheet" href="./css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </head>
    
    <body>
        <header>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-12 col-md-auto text-center">
                        <img src="./images/logoBS.png" class="logo mb-3 mb-md-0" alt="Logo" onclick="redirigir('dashboard')">
                    </div>

                    <div class="col-12 col-md-auto text-center">
                        <img src="./images/blueshield.png" class="blueshield" alt="BlueShield" onclick="redirigir('dashboard')">
                    </div>

                    <script>
                        function redirigir(id) {
                            window.location.href = id
                        }
                    </script>

                    <div class="col-12 col-md text-center text-md-left">
                        <c:if test="${not empty requestScope.username}" >
                            <%@ page import="model.DTO.AgenteDTO" %>
                            <%
                            AgenteDTO agente = (AgenteDTO) request.getAttribute("username");
                            String agenteLogged = agente.getCiudadano().getNombre() + " " + agente.getCiudadano().getApellidos();
                            int placa = agente.getPlaca();
                            %>
                            <h2 class="version mb-0 text-md-right">Version 1.0 - <%= agenteLogged %> (<%= placa %>)</h2>
                        </c:if>
                        <c:if test="${empty requestScope.username}">
                            <h2 class="version mb-0 text-md-right">Version 1.0</h2>
                        </c:if>
                                    
</h2>
                    </div>
                    <div>
                        <a href='logout'>Cerrar sesión</a>
                    </div>
                </div>
            </div>
            <div class="division mb-3"></div>
        </header>






