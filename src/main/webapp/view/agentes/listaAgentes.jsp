<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row">
        <!--        buscador-->
        <div class="col">
            <form action="agentes" method="post">
                <div class="input-group mb-3 p-4">
                    <input type="text" class="form-control" name="placa" placeholder="Buscar por Placa" aria-label="Buscar por Placa" aria-describedby="button-addon2">
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
                    <th>Placa</th>
                    <th>Agente</th>
                    <th>Detalles</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty listaAgentes}">
                    <c:forEach items="${listaAgentes}" var="agente">
                        <tr>
                            <td>${agente.placa}</td>
                            <td>${agente.ciudadano.nombre} ${agente.ciudadano.apellidos}</td>
                            <td>
                                <a href="agente?placa=${agente.placa}">
                                    <button class="btn btn-primary b-login mb-2">Ver</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaAgentes}">
                    <tr>
                        <td colspan="3">No hay agentes disponibles.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>