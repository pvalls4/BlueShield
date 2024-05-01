<%@ include file="../header.jsp" %>

<div id="fondo" class="container rounded" style="background-color: #9acbfd">

    <c:if test="${empty ciudadano}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            No se encontr� este ciudadano.   
        </div>

    </c:if>
    <c:if test="${not empty ciudadano}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2><strong><u>${ciudadano.nombre} ${ciudadano.apellidos} - ${ciudadano.dni}</u></strong></h2>
            </div>
        </div>
        <div class="row p-3">
            <div class="col-md-3 border border-dark rounded m-0 p-0 d-flex align-items-center justify-content-center">
                <div class="position-relative d-inline-block">
                    <img src="${ciudadano.enlaceFotografico}" class="img-fluid" alt="FotoCiudadano" style="object-fit: cover; width: 100%; height: 100%;">
                    <c:if test="${ciudadano.isDeceased}">
                        <div class="position-absolute top-0 start-0">
                            <img src="./images/fallecido.png" alt="FALLECIDO" class="img-fluid">
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-6 px-3">
                        <div class="col p-1">
                            Fecha de Nacimiento
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${ciudadano.fecha_nacimiento}
                        </div>
                    </div>
                    <div class="col-md-6 rounded px-3">
                        <div class="col p-1">
                            Tel�fono
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${ciudadano.telefono}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col px-3">
                        <div class="col p-1">
                            Direcci�n
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                            ${ciudadano.direccion}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col px-3">
                        <div class="col p-1">
                            E-mail
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                            ${ciudadano.email}
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row  mb-3 px-4">
            <div class="row px-4">
                <div class="col-md-12 g-3 text-center">
                    <h3><strong>Veh�culos asociados</strong></h3>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Bastidor</th>
                        <th>Matricula</th>
                        <th>Modelo</th>                  
                        <th>Detalles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${not empty listaVehiculos}">
                        <c:forEach items="${listaVehiculos}" var="vehiculo">
                            <tr>
                                <td>${vehiculo.bastidor}</td>
                                <td>${vehiculo.matricula}</td>
                                <td>${vehiculo.modelo.modelo}</td>
                                <td>
                                    <a href="vehiculo?id=${vehiculo.matricula}">
                                        <button class="btn btn-primary b-login mb-2">Ver</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty listaVehiculos}">
                        <tr>
                            <td colspan="4">No hay vehiculos asociados.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <div class="row justify-content-center text-center">
            <div class="col-md-6 col-lg-4"> <!-- Tama�o alargado para dispositivos medianos y grandes -->
                <a href="editarCiudadano?id=${ciudadano.dni}">
                    <button class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Editar perfil</button>
                </a>
            </div>
            <div class="col-md-6 col-lg-4"> <!-- Tama�o alargado para dispositivos medianos y grandes -->
                <a href="listaMultas?id=${ciudadano.dni}"><button class="btn btn-primary btn-block m-1 mb-3 px-5" style="background-color: #bbddf5;color:#0757af;">Ver Multas</button></a>
            </div>
        </div>
    </c:if>
</div>
<%@ include file="../footer.jsp" %>
