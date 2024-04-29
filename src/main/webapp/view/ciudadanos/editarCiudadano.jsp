<%@ include file="../header.jsp" %>

<div class="container border border-dark rounded" style="background-color: #9acbfd">

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
                    <input type="hidden" id="dni" name="dni" value="${ciudadano.dni}">
                    <input type="hidden" id="nombreCompleto" name="nombreCompleto" value="${ciudadano.nombre} ${ciudadano.apellidos}">
                    <div class="row justify-content-center text-center my-3 ">
                        <div class="col-md-6 col-lg-4">
                            <button id="toPopUp" class="boton mx-4 mt-4">Confirmar Edición</button>
                            <a href="ciudadano?id=${ciudadano.dni}"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                        </div>
                    </div>
                    <dialog class="boton" id="confirmar"> 
                        <p class="text-center">¿Confirmar edición de ciudadano?</p>
                        <div class="row">
                            <div class="col" style="color:black">
                                Ciudadano: 
                            </div>
                            <div class="col" style="color:black">
                                DNI: 
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <strong id="nombreCompleto_d" style="color: #1e549f;"></strong>
                            </div>
                            <div class="col">
                                <span id="dni_d"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col" style="color:black">
                                Teléfono:
                            </div>
                            <div class="col" style="color:black">
                                E-mail:
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <strong id="telefono_d" style="color: #1e549f;"></strong>
                            </div>
                            <div class="col">
                                <span id="email_d"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col" style="color:black">
                                Municipio:
                            </div>
                            <div class="col" style="color:black">
                                Calle:
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <strong id="municipio_d" style="color: #1e549f;"></strong>
                            </div>
                            <div class="col">
                                <span id="calle_d"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col" style="color:black">
                                Código Postal:
                            </div>
                            <div class="col" style="color:black">
                                Número:
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <strong id="codigoPostal_d" style="color: #1e549f;"></strong>
                            </div>
                            <div class="col">
                                <span id="numero_d"></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col" style="color:black">
                                Piso:
                            </div>
                            <div class="col" style="color:black">
                                Puerta:
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <strong id="piso_d" style="color: #1e549f;"></strong>
                            </div>
                            <div class="col">
                                <span id="puerta_d"></span>
                            </div>
                        </div>
                        <button id="confirmarBtn" class="boton mx-4 mt-4">Confirmar</button>
                        <button id="cancelar" class="boton mx-4 mt-4">Cancelar</button>
                    </dialog>
                    <script>
                        const btnToPopUp = document.querySelector("#toPopUp");
                        const btnCancelar = document.querySelector("#cancelar");
                        const confirmar = document.querySelector("#confirmar");
                        const form = document.getElementById('editarCiudadano');

                        btnToPopUp.addEventListener("click", () => {
                            // Verificar si todos los campos requeridos están llenos antes de mostrar el diálogo de confirmación
                            if (validarCamposRequeridos()) {
                                // Obtener los valores del form
                                const dni = document.getElementById('dni').value;
                                const nombreCompleto = document.getElementById('nombreCompleto').value;
                                const telefono = document.getElementById('telefono').value;
                                //const imagen = document.getElementById('imagen').value;
                                const email = document.getElementById('email').value;
                                const calle = document.getElementById('calle').value;
                                const municipio = document.getElementById('municipio').value;
                                const numero = document.getElementById('numero').value;
                                const piso = document.getElementById('piso').value;
                                const puerta = document.getElementById('puerta').value;
                                const codigoPostal = document.getElementById('codigoPostal').value;

                                // Establecer los valores en el diálogo de confirmación
                                document.getElementById('dni_d').textContent = dni;
                                document.getElementById('nombreCompleto_d').textContent = nombreCompleto;
                                document.getElementById('telefono_d').textContent = telefono;
                                //document.getElementById('imagen_d').textContent = imagen;
                                document.getElementById('email_d').textContent = email;
                                document.getElementById('calle_d').textContent = calle;
                                document.getElementById('municipio_d').textContent = municipio;
                                document.getElementById('numero_d').textContent = numero;
                                document.getElementById('piso_d').textContent = piso;
                                document.getElementById('puerta_d').textContent = puerta;
                                document.getElementById('codigoPostal_d').textContent = codigoPostal;

                                confirmar.showModal();
                            } else {
                                alert('Por favor, completa todos los campos requeridos y marca al menos una opción.');
                            }
                        });

                        btnCancelar.addEventListener("click", () => {
                            confirmar.close();
                        });

                        document.querySelector('#confirmarBtn').addEventListener("click", () => {
                            // Verificar nuevamente si todos los campos requeridos están llenos antes de enviar el formulario
                            if (validarCamposRequeridos()) {
                                // Formulario será enviado al servlet nuevaMulta
                                form.submit(); // Enviar el formulario
                            } else {
                                alert('Por favor, completa todos los campos requeridos.');
                            }
                        });

                        // Prevenir envío del formulario
                        form.addEventListener('submit', function (event) {
                            event.preventDefault();
                        });

                        // Función para validar que todos los campos requeridos estén llenos
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
