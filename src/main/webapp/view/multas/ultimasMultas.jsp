<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center mt-4">
            <h2><strong><u>Últimas multas de ${ultimasMultas[0].agente.ciudadano.nombre} ${ultimasMultas[0].agente.ciudadano.apellidos} (${ultimasMultas[0].agente.placa})</u></strong></h2>
        </div>
    </div>
    <div class="row">
        <!--        buscador-->
        <div class="col">
            <form action="ultimasMultas" method="post">
                <div class="input-group mb-3 p-4">
                    <input type="text" class="form-control" name="id" placeholder="Buscar por REF" aria-label="Buscar por REF" aria-describedby="button-addon2">
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
                    <th>Num referencia</th>
                    <th>Ciudadano denunciado</th>
                    <th>Fecha de emision</th>
                    <th>Importe total</th>
                    <th>Estado</th>
                    <th>Fecha l&iacute;mite</th>
                    <th>Detalles</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty ultimasMultas}">
                    <c:forEach items="${ultimasMultas}" var="multa">
                        <tr>
                            <td>${multa.id}</td>
                            <td>${multa.ciudadano.nombre} ${multa.ciudadano.apellidos}</td>
                            <td>${multa.fecha_emision}</td>
                            <td>${String.format("%.2f", multa.importe_total)}&euro;</td>
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
                <c:if test="${empty ultimasMultas}">
                    <tr>
                        <td colspan="3">No hay multas disponibles.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>
