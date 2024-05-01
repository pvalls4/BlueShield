<%@ include file="../header.jsp" %>
<div id="fondo" class="container rounded" style="background-color: #9acbfd">
    <div class="d-flex container-fluid justify-content-center m-5">
        <div class="d-flex flex-column justify-content-center m-3">
            <img class="img-fluid" src="${condecoracion.foto}">
        </div>
        <h1 class="m-3"><strong>${condecoracion.titulo}</strong></h1>
    </div>
    <div class="d-flex container-fluid justify-content-center m-3">
        <p><strong>Descripción:</strong> ${condecoracion.descripcion}</p>
    </div>

    <div class="row mb-3 px-4">
        <c:if test="${isAdmin}">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr class="text-center">
                            <th>Agente</th>
                            <th>Fecha Emisión</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty agentesCondecoracion}">
                            <c:forEach items="${agentesCondecoracion}" var="condecoracionAgente">
                                <tr class="text-center">
                                    <td><strong>${condecoracionAgente.agente.ciudadano.nombre} ${condecoracionAgente.agente.ciudadano.apellidos}</strong></td>
                                    <td>${condecoracionAgente.fecha_emision}</td>
                                    <td>
                                        <button type="button" class="btn btn-primary b-login mb-2"  data-bs-toggle="modal" data-bs-target="#deleteModal" id="condecoracionAgente">Eliminar</button>
                                        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Confirmar eliminación</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>¿Estás seguro de querer eliminar la condecoración seleccionada?</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                                        <form id="condecoracionDetalles" action="condecoracionDetalles" method="post">
                                                            <button  class="btn btn-primary" value="${condecoracionAgente.condecoracion.id} ${condecoracionAgente.agente.placa}" name="condecoracionAgente"">Confirmar</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
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
        </c:if>
        <c:if test="${not isAdmin}">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr class="text-center">
                            <th>Agente</th>
                            <th>Fecha Emisión</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${not empty agentesCondecoracion}">
                            <c:forEach items="${agentesCondecoracion}" var="condecoracionAgente">
                                <tr class="text-center"> 
                                    <td><strong>${condecoracionAgente.agente.ciudadano.nombre} ${condecoracionAgente.agente.ciudadano.apellidos}</strong></td>
                                    <td>${condecoracionAgente.fecha_emision}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty agentesCondecoracion}">
                            <tr class="text-center">
                                <td colspan="3">No hay condecoraciones disponibles.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</div>
<%@ include file="../footer.jsp" %>
