<%@ include file="../header.jsp" %>

<div class="container border border-dark rounded" style="background-color: #9acbfd">

    <c:if test="${empty ciudadano}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            Ha habido un problema en la base de datos.   
        </div>

    </c:if>
    <c:if test="${not empty ciudadano}">
        <div class="row px-4">
            <div class="col-md-12 g-3">
                <h2 style="padding-left: 20%;">${ciudadano.nombre} ${ciudadano.apellidos} - ${ciudadano.dni}</h2>
            </div>
        </div>

        <div class="row p-3">
            <div class="col-md-12">
                <form action="editarCiudadano" method="post">
                    <div class="form-group row mx-3">
                        <label for="telefono" class="col-form-label">Teléfono</label>
                        <div class="col">
                            <input type="number" class="form-control input-form"  id="telefono" name="telefono" value="${ciudadano.telefono}" required>
                        </div>
                    </div>
                    <div class="form-group row mx-3">
                        <label for="imagen" class="col-form-label">Imagen</label>
                        <div class="col">
                            <input type="text" class="form-control input-form"  id="imagen" name="imagen" value="${ciudadano.enlaceFotografico}" required>
                        </div>
                    </div>
                    <div class="form-group row mx-3">
                        <label for="email" class="col-form-label">E-mail</label>
                        <div class="col">
                            <input type="email" class="form-control input-form"  id="email" name="email" value="${ciudadano.email}" required>
                        </div>
                    </div>

                    <div class="form-group row mx-3">
                        <div class="col-md-6">
                            <label for="calle" class="col-form-label">Calle</label>
                            <input type="text" class="form-control input-form"  id="calle" name="calle" value="${ciudadano.direccion.calle}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="municipio" class="col-form-label">Municipio</label>
                            <input type="text" class="form-control input-form"  id="municipio" name="municipio" value="${ciudadano.direccion.municipio}" required>
                        </div>
                    </div>


                    <div class="form-group row mx-3">
                        <div class="col-sm-3">
                            <label for="numero" class="col-form-label">Número</label>
                            <input type="number" class="form-control input-form" id="numero" name="numero" value="${ciudadano.direccion.numero}" required>
                        </div>
                        <div class="col-sm-3">
                            <label for="piso" class="col-form-label">Piso</label>
                            <input type="text" class="form-control input-form" id="piso" name="piso" value="${ciudadano.direccion.piso}" required>
                        </div>
                        <div class="col-sm-3">
                            <label for="puerta" class="col-form-label">Puerta</label>
                            <input type="text" class="form-control input-form" id="puerta" name="puerta" value="${ciudadano.direccion.puerta}" required>
                        </div>
                        <div class="col-sm-3">
                            <label for="codigoPostal" class="col-form-label">Código Postal</label>
                            <input type="text" class="form-control input-form" id="codigoPostal" name="codigoPostal" value="${ciudadano.direccion.codigoPostal}" required>
                        </div>
                    </div>
                    <input type="hidden" name="dni" value="${ciudadano.dni}">
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
