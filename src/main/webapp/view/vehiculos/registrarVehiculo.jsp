<%@ include file="../header.jsp" %>
<div id="fondo" class="container rounded" style="background-color: #9acbfd">
    <div class="row px-4">
        <div class="col-md-12 g-3 text-center">
            <h2><u><strong>REGISTRO DE VEH&Iacute;CULO</strong></u></h2>
        </div>
    </div>
    <div class="row p-3">
        <div class="col-md-12">
            <form action="registrarVehiculo" id="registrarVehiculo" method="post">
                <div class="form-group row mx-3">
                    <div class="col-md-6">
                        <label for="bastidor" class="col-form-label">Bastidor</label>
                        <input type="text" autocomplete="off" class="form-control input-form"  id="bastidor" name="bastidor" placeholder="Bastidor" required>
                    </div>
                    <div class="col-md-6">
                        <label for="matricula" class="col-form-label">Matr&iacute;cula</label>
                        <input type="text" autocomplete="off" class="form-control input-form"  id="matricula" name="matricula" placeholder="Matr&iacute;cula" required>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <label for="dni" class="col-form-label">DNI Propietario</label>
                    <div class="col">
                        <input autocomplete="off" list="ciudadanosOptions" class="form-control input-form"  id="dni" name="dni" placeholder="DNI" onblur="buscarCiudadano()" required >
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
                    <label for="nombreCiudadano" class="col-form-label">Propietario</label>
                    <div class="col">
                        <input class="form-control input-form" autocomplete="off" id="nombreCiudadano" name="nombreCiudadano" placeholder="Nombre del propietario" required>
                    </div>
                </div>
                <div class="form-group row mx-3">
                    <label for="modelo" class="col-form-label">Modelo</label>
                    <div class="col">
                        <input type="text" autocomplete="off" list="modeloOptions" class="form-control input-form"  id="modelo" name="modelo" placeholder="Modelo" required >
                        <input type="hidden" name="idModelo" id="idModelo">
                    </div>
                    <datalist id="modeloOptions">
                        <c:if test="${not empty listaModelos}">
                            <c:forEach items="${listaModelos}" var="modelod">
                                <option value="${modelod.marca} ${modelod.modelo}" data-id="${modelod.id}"</option>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty listaModelos}">
                            <option value="Error en base de datos">
                            </c:if>
                    </datalist>
                </div> 
                <div class="row justify-content-center text-center my-3 ">
                    <div class="col-md-6 col-lg-4">
                        <button id="toPopUp" class="boton mx-4 mt-4">Confirmar Registro</button>
                        <a href="vehiculos"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                    </div>
                </div>
                <%@ include file="./modal_registrarVehiculo.jsp" %>
                <script>
                    const btnToPopUp = document.querySelector("#toPopUp");
                    const btnCancelar = document.querySelector("#cancelar");
                    const confirmar = document.querySelector("#confirmar");
                    const form = document.getElementById('registrarVehiculo');

                    btnToPopUp.addEventListener("click", () => {
                        if (validarCamposRequeridos()) {
                            const matricula = document.getElementById('matricula').value;
                            const bastidor = document.getElementById('bastidor').value;
                            const dniPropietario = document.getElementById('dni').value;
                            const nombrePropietario = document.getElementById('nombreCiudadano').value;
                            const modelo = document.getElementById('modelo').value;

                            document.getElementById('matricula_d').textContent = matricula;
                            document.getElementById('bastidor_d').textContent = bastidor;
                            document.getElementById('dniPropietario_d').textContent = dniPropietario;
                            document.getElementById('nombrePropietario_d').textContent = nombrePropietario;
                            document.getElementById('modelo_d').textContent = modelo;
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
                    function buscarCiudadano() {
                        var dni = document.getElementById("dni").value;
                        if (dni.trim() !== '') {
                            var xhr = new XMLHttpRequest();
                            xhr.onreadystatechange = function () {
                                if (xhr.readyState === XMLHttpRequest.DONE) {
                                    if (xhr.status === 200) {
                                        document.getElementById("nombreCiudadano").value = xhr.responseText;
                                    } else {
                                        console.error('Error en la solicitud: ' + xhr.status);
                                    }
                                }
                            };
                            xhr.open('GET', 'BuscarCiudadano?id=' + encodeURIComponent(dni), true);
                            xhr.send();
                        } else {
                            document.getElementById("nombreCiudadano").value = "";
                        }
                    }

                    document.getElementById('modelo').addEventListener('change', function () {
                        var input = this;
                        var dataList = input.list;
                        var options = dataList.options;
                        var selectedOption = null;

                        for (var i = 0; i < options.length; i++) {
                            if (options[i].value === input.value) {
                                selectedOption = options[i];
                                break;
                            }
                        }

                        if (selectedOption) {
                            var modeloId = selectedOption.getAttribute('data-id');
                            document.getElementById('idModelo').value = modeloId;
                        } else {
                            document.getElementById('idModelo').value = '';
                        }
                    });
                </script>
            </form>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>

