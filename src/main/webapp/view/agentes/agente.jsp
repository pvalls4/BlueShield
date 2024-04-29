<%@ include file="../header.jsp" %>

<div class="container border border-dark rounded" style="background-color: #9acbfd">

    <c:if test="${empty agente}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            No se encontró este agente.   
        </div>

    </c:if>
    <c:if test="${not empty agente}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2>${agente.ciudadano.nombre} ${agente.ciudadano.apellidos} - ${agente.placa}</h2>
            </div>
        </div>
        <!-- Segundo row con imagen y parámetros -->
        <div class="row p-3">
            <!-- Imagen a la izquierda -->
            <div class="col-md-3 border border-dark rounded m-0 p-0 d-flex align-items-center justify-content-center">
                <img src="${agente.enlaceFotografico}" class="img-fluid" alt="FotoCiudadano" style="object-fit: cover; width: 100%; height: 100%;">
            </div>

            <!-- Contenedor para otros parámetros a la derecha -->
            <div class="col-md-9">
                <!-- Nueva fila para dividir los parámetros -->
                <div class="row">
                    <div class="col-md-6 rounded px-3">
                        <div class="col p-1">
                            Número de Placa
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${agente.placa}
                        </div>
                    </div>
                    <div class="col-md-6 px-3">
                        <div class="col p-1">
                            Rango
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${agente.rango}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 rounded px-3">
                        <div class="col p-1">
                            Telefono
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${agente.ciudadano.telefono}
                        </div>
                    </div>
                    <div class="col-md-6 px-3">
                        <div class="col p-1">
                            Fecha de Nacimiento
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${agente.ciudadano.fecha_nacimiento}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col px-3">
                        <div class="col p-1">
                            Dirección
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                            ${agente.ciudadano.direccion}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col px-3">
                        <div class="col p-1">
                            E-mail
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                            ${agente.ciudadano.email}
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row  mb-3 px-4">
            <div class="row px-4">
                <div class="col-md-12 g-3 text-center">
                    <h3>Condecoraciones</h3>
                </div>
            </div>
            <table class="table-responsive">
                <thead>
                    <tr>
                        <th>Medalla</th>
                        <th>Título</th>
                        <th>Fecha</th>
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty listaCondecoracionesAgente}">
                        <c:forEach items="${listaCondecoracionesAgente}" var="condecoracionAgente">
                            <tr>
                                <td><img src="${condecoracionAgente.condecoracion.foto}"></td>
                                <td>${condecoracionAgente.condecoracion.titulo}</td>
                                <td>${condecoracionAgente.fecha_emision}</td>
                                <td>
                                <a href="condecoracion?id=${condecoracionAgente.condecoracion.id}">
                                    <button class="btn btn-primary b-login mb-2">Ver</button>
                                </a>
                            </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty listaCondecoracionesAgente}">
                        <tr>
                            <td></td>
                            <td colspan="4">No hay condecoraciones asociadas.</td>
                            <td></td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

<!--        <div class="row justify-content-center text-center">
            <div class="col-md-6 col-lg-4">  Tamaño alargado para dispositivos medianos y grandes 
                <a href="editarAgente?placa$ {agente.placa}">
                    <button class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Editar perfil</button>
                </a>
            </div>
            <div class="col-md-6 col-lg-4">  Tamaño alargado para dispositivos medianos y grandes 
                <a href="listaMultas?id=$ {ciudadano.dni}"><button class="btn btn-primary btn-block m-1 mb-3 px-5" style="background-color: #bbddf5;color:#0757af;">Ver Multas</button></a>
            </div>
        </div>-->
    </c:if>
</div>
<%@ include file="../footer.jsp" %>