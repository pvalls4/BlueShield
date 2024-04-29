<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <c:if test="${not empty listaMultasVehiculo}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2><strong><u>Multas de Vehículo: ${listaMultasVehiculo[0].vehiculo.matricula}</u></strong></h2>
            </div>
        </div>

        <div class="row">
            <!--        buscador-->
            <div class="col">
                <form action="listaMultasVehiculo" method="post">
                    <div class="input-group mb-3 p-4">
                        <input type="text" class="form-control" name="id" placeholder="Buscar por REF" aria-label="Buscar por REF" aria-describedby="button-addon2">
                        <button class="btn btn-primary" type="submit" id="button-addon2">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </c:if>
    <div class="row  mb-3 px-4">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Num referencia</th>
                        <th>Fecha de emisi&oacute;n</th>
                        <th>Importe total</th>
                        <th>Estado</th>
                        <th>Fecha l&iacute;mite</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty listaMultasVehiculo}">
                        <c:forEach items="${listaMultasVehiculo}" var="multa">
                            <tr>
                                <td>${multa.id}</td>
                                <td>${multa.fecha_emision}</td>
                                <td>${multa.importe_total}&euro;</td>
                                <td>${multa.isPagado ? 'Pagada' : 'No pagada'}</td>
                                <td>${multa.fecha_limite}</td>
                                <td>
                                    <a href="visualizarMulta?id=${multa.id}">
                                        <button class="btn btn-primary b-login mb-2">Ver</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty listaMultasVehiculo}">
                        <tr>
                            <td colspan="3">No hay multas disponibles.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
