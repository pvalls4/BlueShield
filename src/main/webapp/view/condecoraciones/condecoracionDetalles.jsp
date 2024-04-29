<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="d-flex container-fluid justify-content-center m-5">
        <div class="d-flex flex-column justify-content-center m-3">
            <img class="img-fluid" src="${condecoracion.foto}">
        </div>
        <h1 class="m-3"><strong>${condecoracion.titulo}</strong></h1>
    </div>
    <div class="d-flex container-fluid justify-content-center m-3">
        <p>Descripción: ${condecoracion.descripcion}</p>
    </div>
    <div class="row  mb-3 px-4">
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Agente</th>
                        <th>Fecha Emisión</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty agentesCondecoracion}">
                        <c:forEach items="${agentesCondecoracion}" var="condecoracionAgente">
                            <tr>
                                <td><strong>${condecoracionAgente.agente.ciudadano.nombre} ${condecoracionAgente.agente.ciudadano.apellidos}</strong></td>
                                <td>${condecoracionAgente.fecha_emision}</td>
                                <td>
                                    <a href="condecoracion?id=">
                                        <button class="btn btn-primary b-login mb-2">Eliminar</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty agentesCondecoracion}">
                        <tr>
                            <td colspan="3">No hay condecoraciones disponibles.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
