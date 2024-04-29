<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center mt-4">
            <h2><strong><u>REGISTRO CIVIL DE VEHÍCULOS</u></strong></h2>
        </div>
    </div>
    <div class="row">
        <!--        buscador-->
        <div class="col">
            <form action="vehiculos" method="post">
                <div class="input-group mb-3 p-4">
                    <input type="text" class="form-control" name="matricula" list="vehiculosOptions" placeholder="Buscar Veh&iacute;culo" aria-label="Buscar por Matricula" aria-describedby="button-addon2">
                    <datalist id="vehiculosOptions">
                        <c:if test="${not empty listaVehiculos}">
                            <c:forEach items="${listaVehiculos}" var="vehiculo">
                                <option value="${vehiculo.matricula}">${vehiculo.matricula} - ${vehiculo.modelo.modelo} (${vehiculo.ciudadano.nombre} ${vehiculo.ciudadano.apellidos})</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty listaVehiculos}">
                            <option value="Error en la base de datos">
                        </c:if>
                    </datalist>
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
                                    <a href="vehiculo?id=${vehiculo.matricula}">
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
</div>
<%@ include file="../footer.jsp" %>
