<%@ include file="../header.jsp" %>
<div id="fondo" class="container rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center">
            <h2><u><strong>REGISTRO DE CIUDADANO</strong></u></h2>
        </div>
    </div>
    <div class="row p-3">
        <div class="col-md-12">
            <form action="registrarCiudadano" id="registrarCiudadano" method="post">
                <div class="form-group row mx-3">
                    <label for="dni" class="col-form-label">DNI</label>
                </div>
                <div class="form-group row mx-3">
                    <div class="col-md-6">
                        <input type="text" class="form-control input-form"  id="dni" name="dni" readonly style="background-color: #bbddf5;color: #0757af;">
                    </div>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-primary b-login mb-2" onclick="generarDNI()" Style="width:100%;">Generar DNI</button>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <div class="col-md-6">
                        <label for="nombre" class="col-form-label">Nombre</label>
                        <input type="text" class="form-control input-form"  id="nombre" name="nombre"  required>
                    </div>
                    <div class="col-md-6">
                        <label for="apellidos" class="col-form-label">Apellidos</label>
                        <input type="text" class="form-control input-form"  id="apellidos" name="apellidos" required>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <div class="col-md-6">
                        <label for="telefono" class="col-form-label">Teléfono</label>
                        <input type="number" class="form-control input-form"  id="telefono" name="telefono" required>
                    </div>
                    <div class="col-md-6">
                        <label for="fechaNacimiento" class="col-form-label">Fecha de Nacimiento</label>
                        <input type="date" class="form-control input-form"  id="fechaNacimiento" name="fechaNacimiento" required>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <label for="imagen" class="col-form-label">Imagen</label>
                    <div class="col">
                        <input type="text" class="form-control input-form"  id="imagen" name="imagen" required>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <label for="email" class="col-form-label">E-mail</label>
                    <div class="col">
                        <input type="email" class="form-control input-form"  id="email" name="email" required>
                    </div>
                </div>

                <div class="form-group row mx-3">
                    <div class="col-md-6">
                        <label for="calle" class="col-form-label">Calle</label>
                        <input type="text" class="form-control input-form"  id="calle" name="calle"  required>
                    </div>
                    <div class="col-md-6">
                        <label for="municipio" class="col-form-label">Municipio</label>
                        <input type="text" class="form-control input-form"  id="municipio" name="municipio" required>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <div class="col-sm-3">
                        <label for="numero" class="col-form-label">Número</label>
                        <input type="number" class="form-control input-form" id="numero" name="numero" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="piso" class="col-form-label">Piso</label>
                        <input type="text" class="form-control input-form" id="piso" name="piso" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="puerta" class="col-form-label">Puerta</label>
                        <input type="text" class="form-control input-form" id="puerta" name="puerta" required>
                    </div>
                    <div class="col-sm-3">
                        <label for="codigoPostal" class="col-form-label">Código Postal</label>
                        <input type="text" class="form-control input-form" id="codigoPostal" name="codigoPostal" required>
                    </div>
                </div>
                <div class="row justify-content-center text-center my-3 ">
                    <div class="col-md-6 col-lg-4">
                        <button id="toPopUp" class="boton mx-4 mt-4">Confirmar Registro</button>
                        <a href="ciudadanos"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                    </div>
                </div>
            </form>
            <%@ include file="./modal_registroCiudadano.jsp" %>  
            <script>
                const btnToPopUp = document.querySelector("#toPopUp");
                const btnCancelar = document.querySelector("#cancelar");
                const confirmar = document.querySelector("#confirmar");
                const form = document.getElementById('registrarCiudadano');

                btnToPopUp.addEventListener("click", () => {
                    if (validarCamposRequeridos()) {
                        const dni = document.getElementById('dni').value;
                        const nombre = document.getElementById('nombre').value;
                        const apellidos = document.getElementById('apellidos').value;
                        const fechaNacimiento = document.getElementById('fechaNacimiento').value;
                        const telefono = document.getElementById('telefono').value;
                        const email = document.getElementById('email').value;
                        const calle = document.getElementById('calle').value;
                        const municipio = document.getElementById('municipio').value;
                        const numero = document.getElementById('numero').value;
                        const piso = document.getElementById('piso').value;
                        const puerta = document.getElementById('puerta').value;
                        const codigoPostal = document.getElementById('codigoPostal').value;

                        document.getElementById('dni_d').textContent = dni;
                        document.getElementById('nombre_d').textContent = nombre;
                        document.getElementById('apellidos_d').textContent = apellidos;
                        document.getElementById('fechaNacimiento_d').textContent = fechaNacimiento;
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
                        alert('Por favor, completa todos los campos requeridos y marca al menos una opción.');
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

                function generarDNI() {
                    var dniGenerado = generarDNIUnico();
                    document.getElementById("dni").value = dniGenerado;
                }
                function generarDNIUnico() {
                    var dni;
                    do {
                        var numeroAleatorio = Math.floor(10000000 + Math.random() * 90000000);
                        var letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
                        var residuo = numeroAleatorio % 23;
                        dni = numeroAleatorio.toString() + letras.charAt(residuo);
                    } while (existeDNI(dni));
                    return dni;
                }
                function existeDNI(dni) {
                    var xhr = new XMLHttpRequest();
                    xhr.open("GET", "existeDNI?id=" + dni, false); // Solicitud sincrónica
                    xhr.send();
                    return xhr.responseText === "1";
                }
            </script>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>

