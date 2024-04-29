<%@ include file="../header.jsp" %>

<div class="container border border-dark rounded" style="background-color: #9acbfd">

    <c:if test="${empty vehiculo}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            Ha habido un problema en la base de datos.   
        </div>

    </c:if>
    <c:if test="${not empty vehiculo}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2><u><Strong>${vehiculo.modelo.modelo} - ${vehiculo.matricula}</Strong></u></h2>
            </div>
        </div>

        <div class="row p-3">
            <div class="col-md-12">
                <form action="editarVehiculo" method="post">
                    <div class="form-group row mx-3">
                        <label for="matricula" class="col-form-label">Matricula</label>
                        <div class="col">
                            <input type="text" class="form-control input-form"  id="matricula" name="matricula" value="${vehiculo.matricula}" required>
                        </div>
                    </div>
                        
<!--                        añadir autocompletar y funcionalidad en el servlet-->
                    <div class="form-group row mx-3">
                        <label for="propietario" class="col-form-label">Propietario Propietario</label>
                        <div class="col">
                            <input type="text" class="form-control input-form"  id="matricula" name="matricula" value="${vehiculo.ciudadano.nombre} ${vehiculo.ciudadano.apellidos}" required>
                        </div>
                    </div>
                    <div class="form-group row mx-3">
                        <label for="dni" class="col-form-label">DNI Propietario</label>
                        <div class="col">
                            <input type="text" class="form-control input-form"  id="matricula" name="matricula" value="${vehiculo.ciudadano.dni}" required>
                        </div>
                    </div>
                    <input type="hidden" name="bastidor" value="${vehiculo.bastidor}">
                    <div class="row justify-content-center text-center my-3 ">
                        <div class="col-md-6 col-lg-4">
                            <!--<button type="submit" class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Confirmar Edición</button>-->
                            <button type="submit" class="boton mx-4 mt-4">Confirmar Edición</button>
                            <a href="vehiculos"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </c:if>
</div>
<%@ include file="../footer.jsp" %>
