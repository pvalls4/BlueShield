<%@ include file="../header.jsp" %>
<div id="fondo" class="container rounded" style="background-color: #9acbfd">
    <c:if test="${not empty listaMultasVehiculo}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2><strong><u>Multas de Veh�culo: ${listaMultasVehiculo[0].vehiculo.matricula}</u></strong></h2>
            </div>
        </div>
        <div class="row">
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
            <table class="table align-middle text-center">
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
                                <td>${String.format("%.2f", multa.importe_total)}&euro;</td>
                                <td>${multa.isPagado ? 'Pagada' : 'No pagada'}</td>
                                <td>${multa.fecha_limite}</td>
                                <td>
                                    <a href="visualizarMulta?id=${multa.id}">
                                        <button class="btn btn-primary b-login">Ver</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty listaMultasVehiculo}">
                        <tr class>
                            <td colspan="6">No hay multas disponibles.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
