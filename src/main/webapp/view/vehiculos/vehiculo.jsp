<%@ include file="../header.jsp" %>

<div class="container border border-dark rounded" style="background-color: #9acbfd">

    <c:if test="${empty vehiculo}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            No se encontró este Vehiculo.   
        </div>

    </c:if>
    <c:if test="${not empty vehiculo}">
        <div class="row px-4">
            <div class="col-md-12 g-3">
                <h2 style="padding-left: 20%;">${vehiculo.matricula}</h2>
            </div>
        </div>
        <!-- Segundo row con imagen y parámetros -->
        <div class="row p-3">
            <!-- Imagen a la izquierda -->
            <div class="col-md-3 border border-dark rounded m-0 p-0">
                <img src="${vehiculo.modelo.imagen}" class="img-fluid" alt="FotoVehiculo">
            </div>
            <!-- Contenedor para otros parámetros a la derecha -->
            <div class="col-md-9">
                <!-- Nueva fila para dividir los parámetros -->
                <div class="row">
                    <div class="col-md-6 px-3">
                        <div class="col p-1">
                            Marca
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${vehiculo.modelo.marca}
                        </div>
                    </div>
                    <div class="col-md-6 rounded px-3">
                        <div class="col p-1">
                            Modelo
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                            ${vehiculo.modelo.modelo}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col px-3">
                        <div class="col p-1">
                            Propietario
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5; color: #0757af; overflow-wrap: break-word;">
                            ${vehiculo.ciudadano.nombre} ${vehiculo.ciudadano.apellidos}
                            <a href="ciudadano?id=${vehiculo.ciudadano.dni}" style="float: right; padding-right: 5%;">
                                ver más
                            </a>
                        </div>


                    </div>
                </div>
                <div class="row">
                    <div class="col px-3">
                        <div class="col p-1">
                            Matricula
                        </div>
                        <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                            ${vehiculo.matricula}
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row justify-content-center text-center">
            <div class="col-md-6 col-lg-4"> <!-- Tamaño alargado para dispositivos medianos y grandes -->
                <button class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Editar Vehiculo</button>
            </div>
            <div class="col-md-6 col-lg-4"> <!-- Tamaño alargado para dispositivos medianos y grandes -->
                <button class="btn btn-primary btn-block m-1 mb-3 px-5" style="background-color: #bbddf5;color:#0757af;">Ver Multas</button>
            </div>
        </div>
    </c:if>
</div>
<%@ include file="../footer.jsp" %>

