<%@ include file="../header.jsp" %>
<div id="fondo" class="container rounded" style="background-color: #9acbfd">      
    <div class="row" style="
         background-color: #9acbfd;">
        <form id="nuevaMulta" method="post" action="nuevaMulta" accept-charset="UTF-8">  
            <div class="row">
                <div class="d-flex justify-content-center mt-2"><h2><strong><u>EMISI&Oacute;N DE DENUNCIA</u></strong></h2></div>
            </div>
            <div class="row">
                <div class="col-md-12 mb-2">
                    <div class="row">
                        <label for = "ciudadano" class="col rounded ms-3 me-2">Denunciado/a</label>                        
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 mb-2 me-2">
                            <input class="form-control input-form" autocomplete="off" list="ciudadanosOptions" id="dni" name="dni" placeholder="DNI Ciudadano" onblur="buscarCiudadano()">
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
                    </div>

                    <div class="row">
                        <label for= "nombreCiudadano" class="col rounded ms-3 me-2">Nombre del Denunciado</label>                                                 
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 mb-2 me-2">
                            <input class="form-control input-form" id="nombreCiudadano" name="nombreCiudadano" placeholder="Nombre del Ciudadano">
                        </div>
                    </div>

                    <div class="row">
                        <label for = "fechaEmision" class="col rounded ms-3 me-2">Fecha</label>                                  
                        <label for = "vehiculo" class="col rounded ms-4 me-2">Veh&iacute;culo Implicado (Opcional)</label> 
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 me-2 mb-2"><input type="date" class="form-control input-form" id="fechaEmision" name="fechaEmision" required></div>                                         
                        <div class="col rounded  mb-2 ms-4 me-2">
                            <input type="text" autocomplete="off" class="form-control input-form" list="vehiculosOptions" id="matricula" name="matricula" placeholder="Matricula">
                            <datalist id="vehiculosOptions">
                                <c:if test="${not empty listaVehiculos}">
                                    <c:forEach items="${listaVehiculos}" var="vehiculo">
                                        <option value="${vehiculo.matricula}">${vehiculo.matricula} - ${vehiculo.modelo.modelo} (${vehiculo.ciudadano.nombre} ${vehiculo.ciudadano.apellidos})</option>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty listaVehiculos}">
                                    <option value="Error en la base de datos">
                                    </c:if>
                            </datalist>
                        </div>
                    </div>
                    <div class="row">
                        <label for= "ubicacion" class="col rounded ms-3 me-2">Ubicaci&oacute;n</label>                                                 
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 mb-2 me-2"><input type="text" class="form-control input-form" id="ubicacion" name="ubicacion" required></div>
                    </div>
                    <div class="row">
                        <label for= "observaciones" class="col rounded ms-3 me-2">Hechos</label>                        
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 mb-2 me-2"><input type="text" class="form-control input-form" id="observaciones" name="observaciones"></div>
                    </div>    
                </div>
                <div class="row">
                    <div class="container my-3 ms-3">
                        <div class="accordion" id="accordionArticulos">
                            <%@ page import="java.util.List" %>
                            <%@ page import="model.DTO.InfraccionDTO" %>
                            <%@ page import="java.util.ArrayList" %>
                            <%
                              // Obtener la lista de art�culos del atributo de solicitud
                              List<InfraccionDTO> listaInfracciones = (List<InfraccionDTO>) request.getAttribute("listaInfracciones");
                              // Variables para controlar los cap�tulos
                              int capituloActual = -1;
                              boolean primerCapitulo = true;
                      

                              // Iterar sobre la lista de art�culos
                              for (InfraccionDTO articulo : listaInfracciones) {
                                // Verificar si cambia el cap�tulo
                                if (articulo.getId() / 100 != capituloActual) {
                                  capituloActual = articulo.getId() / 100;
                                  if (primerCapitulo==false) {
                            %>
                        </div> <! -- Si no es el primer cap�tulo y se ha cambiado de cap�tulo, hay que cerrar el body y el item del acorde�n anterior>
                    </div>  
                </div>
                <%
              }
              // Mostrar el nuevo cap�tulo en el acorde�n
                %>
                <div class="accordion-item" style="background-color: #bbddf5;">
                    <h2 class="accordion-header" id="heading<%= capituloActual %>">
                        <button class="accordion-button <%= primerCapitulo ? "" : "collapsed" %>" type="button" data-bs-toggle="collapse" data-bs-target="#collapse<%= capituloActual %>" aria-expanded="<%= primerCapitulo ? "true" : "false" %>" aria-controls="collapse<%= capituloActual %>" style="background-color: #1e549f; color: white;">
                            Cap&iacute;tulo <%= capituloActual %>
                        </button>
                    </h2>
                    <div id="collapse<%= capituloActual %>" class="accordion-collapse collapse<%= primerCapitulo ? " show" : "" %>" aria-labelledby="heading<%= capituloActual %>" data-bs-parent="#accordionArticulos">
                        <div class="accordion-body">
                            <%
                                      primerCapitulo = false;
                                }
                            %>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value='{"importe": <%= articulo.getImporte() %>, "id": <%= articulo.getId() %>}' id="<%= articulo.getId() %>" name="articuloSeleccionado">
                                <label class="form-check-label" for="<%= articulo.getId() %>">
                                    <%= articulo.getArticulo() %> - <%= articulo.getTitulo() %>
                                </label>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col d-flex justify-content-center">  
                    <button id="emitirDenuncia" class="boton mx-4 mt-4">Emitir denuncia</button>
                    <a href="multas"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                </div>                       
            </div>

            <dialog class="boton" id="confirmar"> 
                <p class="text-center">�Confirmar Denuncia?</p>
                <div class="row">
                    <div class="col" style="color:black">
                        Denunciado/a: 
                    </div>
                    <div class="col" style="color:black">
                        Fecha emision: 
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <strong id="dniDenunciado" style="color: #1e549f;"></strong>
                    </div>
                    <div class="col">
                        <span id="fechaEmisionMulta"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col" style="color:black">
                        Infracciones:
                    </div>
                    <div class="col" style="color:black">
                        Importe total:
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <textarea id="infracciones" class="form-control input-form" rows="4" readonly></textarea>
                    </div>
                    <div class="col">
                        <span id="importeTotal"></span>
                    </div>
                </div>
                <button id="confirmarBtn" class="boton mx-4 mt-4">Confirmar</button>
                <button id="cancelar" class="boton mx-4 mt-4">Cancelar</button>
            </dialog>

            <script>
                const btnEmitirDenuncia = document.querySelector("#emitirDenuncia");
                const btnCancelar = document.querySelector("#cancelar");
                const confirmar = document.querySelector("#confirmar");
                const form = document.getElementById('nuevaMulta');
                btnEmitirDenuncia.addEventListener("click", () => {
                    if (validarCamposRequeridos() && alMenosUnCheckboxMarcado()) {
                        const dniDenunciado = document.getElementById("dni").value;
                        const fechaEmisionMulta = document.getElementById("fechaEmision").value;
                        const infraccionesSeleccionadas = [];
                        let importeTotal = 0;

                        const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
                        checkboxes.forEach((checkbox) => {
                            const jsonValue = JSON.parse(checkbox.value);
                            const importeArticulo = parseFloat(jsonValue.importe);
                            const articulo = (parseFloat(jsonValue.id) / 100).toFixed(2);
                            importeTotal += importeArticulo;
                            infraccionesSeleccionadas.push("Art�culo: " + articulo);
                        });

                        document.getElementById("infracciones").textContent = infraccionesSeleccionadas.join("\n");
                        document.getElementById("importeTotal").textContent = importeTotal.toFixed(2) + ("\u20AC");
                        document.getElementById("dniDenunciado").textContent = dniDenunciado;
                        document.getElementById("fechaEmisionMulta").textContent = fechaEmisionMulta;

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
                        form.submit(); // Enviar el formulario
                    } else {
                        alert('Por favor, completa todos los campos requeridos.');
                    }
                });

                form.addEventListener('submit', function (event) {
                    event.preventDefault();
                });

                function alMenosUnCheckboxMarcado() {
                    var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
                    return checkboxes.length > 0;
                }

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
            </script>
    </div>
</div></div>
</form>
</div>
</div>      
<%@ include file="../footer.jsp" %>
