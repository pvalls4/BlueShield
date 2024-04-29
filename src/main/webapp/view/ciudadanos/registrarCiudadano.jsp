<%@ include file="../header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center">
            <h2><u><strong>REGISTRO DE CIUDADANO</strong></u></h2>
        </div>
    </div>

    <div class="row p-3">
        <div class="col-md-12">
            <form action="registrarCiudadano" method="post">
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
                        <!--<button type="submit" class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Confirmar Registro</button>-->
                        <button type="submit" class="boton mx-4 mt-4">Confirmar Registro</button>
                        <a href="ciudadanos"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                    </div>
                </div>
            </form>
            <script>
                function generarDNI() {
                    var dniGenerado = generarDNIUnico();
                    document.getElementById("dni").value = dniGenerado;
                }
                function generarDNIUnico() {
                    var dni;
                    do {
                        var numeroAleatorio = Math.floor(Math.random() * 100000000);
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

