<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row">
        <!--        buscador-->
        <div class="col">
            <form action="vehiculos" method="post">
                <div class="input-group mb-3 p-4">
                    <input type="text" class="form-control" name="matricula" placeholder="Buscar por Matricula" aria-label="Buscar por Matricula" aria-describedby="button-addon2">
                    <button class="btn btn-primary" type="submit" id="button-addon2">
                        <i class="bi bi-search"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>
    <div class="row  mb-3 px-4">
        <table class="table">
            <thead>
                <tr>
                    <th>Bastidor</th>
                    <th>Matricula</th>
                    <th>Modelo</th>                  
                    <th>Propietario</th>                  
                    <th>Detalles</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty listaVehiculos}">
                    <c:forEach items="${listaVehiculos}" var="vehiculo">
                        <tr>
                            <td>${vehiculo.bastidor}</td>
                            <td>${vehiculo.matricula}</td>
                            <td>${vehiculo.modelo.modelo}</td>
                            <td>${vehiculo.ciudadano.nombre} ${vehiculo.ciudadano.apellidos}</td>

                            <td>
                                <a href="vehiculo?id=${vehiculo.bastidor}">
                                    <button class="btn btn-primary b-login mb-2">Ver</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaVehiculos}">
                    <tr>
                        <td colspan="5">No hay vehiculos disponibles.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>
