<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div>
        <img src="${condecoracion.foto}">
        <p>${condecoracion.titulo}</p>
        <p>${condecoracion.descripcion}</p>
    </div>
    <div class="row  mb-3 px-4">
        <table class="table">
            <thead>
                <tr>
                    <th>Agente</th>
                    <th>Fecha Emisión</th>
                    <td>Acciones</td>
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
<%@ include file="../footer.jsp" %>
