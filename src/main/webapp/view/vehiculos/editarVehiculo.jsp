<%@ include file="../header.jsp" %>

<div id="fondo" class="container rounded" style="background-color: #9acbfd">

    <c:if test="${empty vehiculo}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            Ha habido un problema en la base de datos.   
        </div>

    </c:if>
    <c:if test="${not empty vehiculo}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2><u><Strong>${vehiculo.modelo.modelo} - ${vehiculo.matricula} - ${vehiculo.bastidor}</Strong></u></h2>
            </div>
        </div>

        <div class="row p-3">
            <div class="col-md-12">
                <form action="editarVehiculo" id="editarVehiculo" method="post">
                    <div class="form-group row mx-3">
                        <label for="dni" class="col-form-label">DNI Propietario</label>
                        <div class="col">
                            <input autocomplete="off" list="ciudadanosOptions" class="form-control input-form"  id="dni" name="dni" placeholder="${vehiculo.ciudadano.dni}" onblur="buscarCiudadano()" required >
                        </div>
                        <datalist id="ciudadanosOptions">
                            <c:if test="${not empty listaCiudadanos}">
                                <c:forEach items="${listaCiudadanos}" var="ciudadano">
                                    <option value="${ciudadano.dni}">${ciudadano.dni} - ${ciudadano.nombre} ${ciudadano.apellidos}</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty listaCiudadanos}">
                                <option value="Error en base de datos">
                                </c:if>
                        </datalist>
                    </div>

                    <div class="form-group row mx-3">
                        <label for="nombreCiudadano" class="col-form-label">Propietario Propietario</label>
                        <div class="col">
                            <input class="form-control input-form" autocomplete="off" id="nombreCiudadano" name="nombreCiudadano" placeholder="${vehiculo.ciudadano.nombre} ${vehiculo.ciudadano.apellidos}" required>
                        </div>
                    </div>

                    <div class="form-group row mx-3">
                        <label for="modelo" class="col-form-label">Modelo</label>
                        <div class="col">
                            <input type="text" autocomplete="off" list="modeloOptions" class="form-control input-form"  id="modelo" name="modelo" placeholder="${vehiculo.modelo.modelo}" required >
                            <input type="hidden" name="idModelo" id="idModelo">
                        </div>
                        <datalist id="modeloOptions">
                            <c:if test="${not empty listaModelos}">
                                <c:forEach items="${listaModelos}" var="modelod">
                                    <option value="${modelod.modelo} - ${modelod.marca}" data-id="${modelod.id}"</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty listaModelos}">
                                <option value="Error en base de datos">
                                </c:if>
                        </datalist>
                    </div>    
                    <input type="hidden" name="bastidor" value="${vehiculo.bastidor}">
                    <div class="row justify-content-center text-center my-3 ">
                        <div class="col-md-6 col-lg-4">
                            <button id="toPopUp" class="boton mx-4 mt-4">Confirmar Edici�n</button>
                            <a href="vehiculos?id=${vehiculo.matricula}"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                        </div>
                    </div>
                    <%@ include file="./modal_editarVehiculo.jsp" %>
                    <script src="../../js/modal_editarVehiculo.js"></script>
                </form>
            </div>
        </div>

    </c:if>
</div>
<%@ include file="../footer.jsp" %>
