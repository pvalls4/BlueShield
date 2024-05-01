<%@ include file="../header.jsp" %>

<div id="fondo" class="container rounded" style="background-color: #9acbfd">

    <c:if test="${empty ciudadano}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5;color:#0757af;">
            Ha habido un problema en la base de datos.   
        </div>

    </c:if>
    <c:if test="${not empty ciudadano}">
        <div class="row px-4">
            <div class="col-md-12 g-3 text-center">
                <h2>${ciudadano.nombre} ${ciudadano.apellidos} - ${ciudadano.dni}</h2>
            </div>
        </div>

        <div class="row p-3">
            <div class="col-md-12">
                <form action="editarCiudadano" id="editarCiudadano" method="post">
                    <div class="form-group row mx-3">
                        <label for="telefono" class="col-form-label">Tel�fono</label>
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
                            <label for="numero" class="col-form-label">N�mero</label>
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
                            <label for="codigoPostal" class="col-form-label">C�digo Postal</label>
                            <input type="text" class="form-control input-form" id="codigoPostal" name="codigoPostal" value="${ciudadano.direccion.codigoPostal}" required>
                        </div>
                    </div>
                    <input type="hidden" id="dni" name="dni" value="${ciudadano.dni}">
                    <div class="row justify-content-center text-center my-3 ">
                        <div class="col-md-6 col-lg-4">
                            <button id="toPopUp" class="boton mx-4 mt-4">Confirmar Edici�n</button>
                            <a href="ciudadano?id=${ciudadano.dni}"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                        </div>
                    </div>
                    <%@ include file="./modal_editarCiudadano.jsp" %>        
                    <script>


                        const btnToPopUp = document.querySelector("#toPopUp");
                        const btnCancelar = document.querySelector("#cancelar");
                        const confirmar = document.querySelector("#confirmar");
                        const form = document.getElementById('editarCiudadano');

                        btnToPopUp.addEventListener("click", () => {
                            if (validarCamposRequeridos()) {
                                const telefono = document.getElementById('telefono').value;
                                const email = document.getElementById('email').value;
                                const calle = document.getElementById('calle').value;
                                const municipio = document.getElementById('municipio').value;
                                const numero = document.getElementById('numero').value;
                                const piso = document.getElementById('piso').value;
                                const puerta = document.getElementById('puerta').value;
                                const codigoPostal = document.getElementById('codigoPostal').value;

                                document.getElementById('telefono_d').textContent = telefono;
                                document.getElementById('email_d').textContent = email;
                                document.getElementById('calle_d').textContent = calle;
                                document.getElementById('municipio_d').textContent = municipio;
                                document.getElementById('numero_d').textContent = numero;
                                document.getElementById('piso_d').textContent = piso;
                                document.getElementById('puerta_d').textContent = puerta;
                                document.getElementById('codigoPostal_d').textContent = codigoPostal;
                                confirmar.showModal();
                            } else {
                                alert('Por favor, completa todos los campos requeridos y marca al menos una opci�n.');
                            }
                        });

                        btnCancelar.addEventListener("click", () => {
                            confirmar.close();
                        });

                        document.querySelector('#confirmarBtn').addEventListener("click", () => {
                            if (validarCamposRequeridos()) {
                                form.submit();
                            } else {
                                alert('Por favor, completa todos los campos requeridos.');
                            }
                        });

                        form.addEventListener('submit', function (event) {
                            event.preventDefault();
                        });

                        function validarCamposRequeridos() {
                            var campos = form.querySelectorAll('[required]');
                            for (var i = 0; i < campos.length; i++) {
                                if (!campos[i].value) {
                                    return false;
                                }
                            }
                            return true;
                        }

                    </script>
                </form>
            </div>
        </div>

    </c:if>
</div>
<%@ include file="../footer.jsp" %>
