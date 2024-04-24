<%@ include file="../header.jsp" %>

<div class="container border border-dark rounded" style="background-color: #9acbfd">

    <c:if test="${empty vehiculo}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            Ha habido un problema en la base de datos.   
        </div>

    </c:if>
    <c:if test="${not empty vehiculo}">
        <div class="row px-4">
            <div class="col-md-12 g-3">
                <h2 style="padding-left: 20%;">${vehiculo.bastidor}</h2>
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

                    <div class="form-group row mx-3">
                        <label for="imagen" class="col-form-label">Imagen</label>
                        <div class="col">
                            <input type="text" class="form-control input-form"  id="imagen" name="imagen" value="${vehiculo.modelo.imagen}" required>
                        </div>
                    </div>

                    <div class="form-group row mx-3">
                        <div class="col-md-6">
                            <label for="marca" class="col-form-label">Marca</label>
                            <input type="text" class="form-control input-form"  id="marca" name="marca" value="${vehiculo.modelo.marca}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="modelo" class="col-form-label">Modelo</label>
                            <input type="text" class="form-control input-form"  id="modelo" name="modelo" value="${verhiculo.modelo.modelo}" required>
                        </div>
                    </div>

                    <input type="hidden" name="bastidor" value="${vehiculo.bastidor}">
                    <div class="row justify-content-center text-center my-3 ">
                        <div class="col-md-6 col-lg-4">
                            <button type="submit" class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Confirmar Edición</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </c:if>
</div>
<%@ include file="../footer.jsp" %>
