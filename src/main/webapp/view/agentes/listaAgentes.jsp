<%@ include file="../header.jsp" %>
<div id="fondo" class="container rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center mt-4">
            <h2><strong><u>LISTADO DE AGENTES</u></strong></h2>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form action="agentes" method="post">
                <div class="input-group mb-3 p-4">
                    <input type="text" autocomplete="off" class="form-control" list="agentesOptions" name="placa" placeholder="Buscar por Placa" aria-label="Buscar por Placa" aria-describedby="button-addon2">
                    <datalist id="agentesOptions">
                        <c:if test="${not empty listaAgentes}">
                            <c:forEach items="${listaAgentes}" var="agente">
                                <option value="${agente.placa}">${agente.ciudadano.nombre} ${agente.ciudadano.apellidos} (${agente.placa})</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty listaCiudadanos}">
                            <option value="Error en base de datos">
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
            <table class="table align-middle text-center">
                <thead>
                    <tr>
                        <th>Placa</th>
                        <th>Rango</th>
                        <th>Agente</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty listaAgentes}">
                        <c:forEach items="${listaAgentes}" var="agente">
                            <tr>
                                <td>${agente.placa}</td>
                                <td>${agente.rango}</td>
                                <td>${agente.ciudadano.nombre} ${agente.ciudadano.apellidos}</td>
                                <td>
                                    <a href="agente?placa=${agente.placa}">
                                        <button class="btn btn-primary b-login">Ver</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty listaAgentes}">
                        <tr>
                            <td colspan="4">No hay agentes disponibles.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>