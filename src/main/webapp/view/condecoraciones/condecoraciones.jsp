<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row  mb-3 px-4">
        <table class="table">
            <thead>
                <tr>
                    <th>Medalla</th>
                    <th>Titulo</th>
                    <th>Descripción</th>
                    <th>Detalles</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty listaCondecoraciones}">
                    <c:forEach items="${listaCondecoraciones}" var="condecoracion">
                        <tr>
                            <td><img src="${condecoracion.foto}"></td>
                            <td><strong>${condecoracion.titulo}</strong></td>
                            <td>${condecoracion.descripcion}</td>
                            <td>
                                <a href="condecoracion?id=${condecoracion.id}">
                                    <button class="btn btn-primary b-login mb-2">Ver</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty listaCondecoraciones}">
                    <tr>
                        <td colspan="3">No hay condecoraciones disponibles.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../footer.jsp" %>
