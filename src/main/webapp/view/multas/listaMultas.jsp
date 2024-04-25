<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row">
        <!--        buscador-->
        <div class="col">
            <form action="listaMultas" method="post">
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
                    <th>Fecha de emision</th>
                    <th>Detalles</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty listaMultas}">
                    <c:forEach items="${listaMultas}" var="multa">
                        <tr>
                            <td>${multa.id}</td>
                            <td>${multa.fecha_emision}</td>
                            <td>
                                <a href="visualizarMulta?id=${multa.id}">
                                    <button class="btn btn-primary b-login mb-2">Ver</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaMultas}">
                    <tr>
                        <td colspan="3">No hay multas disponibles.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>
