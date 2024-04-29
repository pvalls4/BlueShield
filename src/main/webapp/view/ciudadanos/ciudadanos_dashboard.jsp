<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center mt-4">
            <h2><strong><u>REGISTRO CIVIL DE CIUDADANOS</u></strong></h2>
        </div>
    </div>
    <div class="row text-center ms-3">
        <div class="col-md-12 d-flex justify-content-start">
            <a href="registrarCiudadano">
                <button class="btn btn-primary b-login">+ Registrar Ciudadano</button>
            </a>
        </div>
    </div>
    <div class="row">
        <!--        buscador-->
        <div class="col">
            <form action="ciudadanos" method="post">
                <div class="input-group mb-3 p-4">
                    <input type="text" class="form-control" name="dni" placeholder="Buscar por DNI" aria-label="Buscar por DNI" aria-describedby="button-addon2">
                    <button class="btn btn-primary" type="submit" id="button-addon2">
                        <i class="bi bi-search"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>
    <div class="row  mb-3 px-4">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty listaCiudadanos}">
                        <c:forEach items="${listaCiudadanos}" var="ciudadano">
                            <tr>
                                <td>${ciudadano.nombre} ${ciudadano.apellidos}</td>
                                <td>${ciudadano.dni}</td>
                                <td>
                                    <a href="ciudadano?id=${ciudadano.dni}">
                                        <button class="btn btn-primary b-login mb-2">Ver</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty listaCiudadanos}">
                        <tr>
                            <td colspan="3">No hay ciudadanos disponibles.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
