<%@ include file="../header.jsp" %>
<div class="container bg-primary border border-dark rounded">
    <form id="nuevaMulta" method="post" action="nuevaMulta">        
        <div class="row" style="background-color: #9acbfd;">
            <div class="row">
                <div class="d-flex justify-content-center mt-2"><h2>EMISION DE DENUNCIA</h2></div>
            </div>
            <div class="row">
                <div class="col-md-12 mb-2">
                    <div class="row">                     
                        <label for = "numReferencia" class="col rounded ms-3 me-3">Num. Referencia</label>
                        <label for = "fechaEmision" class="col rounded ms-4 me-2">Fecha</label>                                  
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 me-3 mb-2"><div class="form-control input-form">asdasd</div></div>
                        <div class="col rounded ms-4 me-2 mb-2"><input type="date" class="form-control input-form" id="fechaEmision" name="fechaEmision" required></div>                                         
                    </div>
                    <div class="row">
                        <label for = "ciudadano" class="col rounded ms-3 me-3">Denunciado/a</label>                        
                        <label for = "vehiculo" class="col rounded ms-4 me-2">Vehiculo Implicado*</label> 
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 me-3 mb-2">
                            <input class="form-control input-form" list="datalistOptions" id="ciudadano" placeholder="Ciudadano">
                            <datalist id="datalistOptions">
                                <c:forEach var="ciudadano" items="${listaCiudadanos}">
                                    <option value="${ciudadano.nombre} ${ciudadano.apellidos}">
                                    </c:forEach>
                            </datalist>
                        </div>

                        <div class="col rounded  mb-2 ms-4 me-2"><input type="text" class="form-control input-form" id="matricula" name="matricula"></div> 
                    </div>
                    <div class="row">
                        <label for= "ubicacion" class="col rounded ms-3 me-2">Ubicacion</label>                                                 
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 mb-2 me-2"><input type="text" class="form-control input-form" id="ubicacion" name="ubicacion"></div>
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
                              // Obtener la lista de artículos del atributo de solicitud
                              List<InfraccionDTO> listaInfracciones = (List<InfraccionDTO>) request.getAttribute("listaInfracciones");
                              // Variables para controlar los capítulos
                              int capituloActual = -1;
                              boolean primerCapitulo = true;
                      

                              // Iterar sobre la lista de artículos
                              for (InfraccionDTO articulo : listaInfracciones) {
                                // Verificar si cambia el capítulo
                                if (articulo.getId() / 100 != capituloActual) {
                                  capituloActual = articulo.getId() / 100;
                                  if (primerCapitulo==false) {
                            %>
                        </div> <! -- Si no es el primer capítulo y se ha cambiado de capítulo, hay que cerrar el body y el item del acordeón anterior>
                    </div>  
                </div>
                <%
              }
              // Mostrar el nuevo capítulo en el acordeón
                          
                %>
                <div class="accordion-item" style="background-color: #bbddf5;">
                    <h2 class="accordion-header" id="heading<%= capituloActual %>">
                        <button class="accordion-button <%= primerCapitulo ? "" : "collapsed" %>" type="button" data-bs-toggle="collapse" data-bs-target="#collapse<%= capituloActual %>" aria-expanded="<%= primerCapitulo ? "true" : "false" %>" aria-controls="collapse<%= capituloActual %>" style="background-color: #1e549f; color: white;">
                            Capítulo <%= capituloActual %>
                        </button>
                    </h2>
                    <div id="collapse<%= capituloActual %>" class="accordion-collapse collapse<%= primerCapitulo ? " show" : "" %>" aria-labelledby="heading<%= capituloActual %>" data-bs-parent="#accordionArticulos">
                        <div class="accordion-body">
                            <%
                                      primerCapitulo = false;
                                }
                            %>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="<%= articulo.getId() %>" name="articuloSeleccionado">
                                <label class="form-check-label" for="<%= articulo.getId() %>">
                                    Artículo <%= articulo.getId() %> - <%= articulo.getTitulo() %>
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
                    <a href="dashboard"><button type="button" class="boton mx-4 mt-4">Cancelar</button></a>
                </div>                       
            </div>

            <dialog class = "boton" id="confirmar"> 
                <button id="confirmarBtn" class="boton mx-4 mt-4">Confirmar</button>
                <button id="cancelar" class="boton mx-4 mt-4">Cancelar</button>
            </dialog>

            <script>
                const btnEmitirDenuncia = document.querySelector("#emitirDenuncia");
                const btnCancelar = document.querySelector("#cancelar");
                const confirmar = document.querySelector("#confirmar");
                const form = document.getElementById('nuevaMulta'); // Get the form by its id

                btnEmitirDenuncia.addEventListener("click", () => {
                    confirmar.showModal();
                });
                btnCancelar.addEventListener("click", () => {
                    confirmar.close();
                });

                document.querySelector('#confirmarBtn').addEventListener("click", () => {
                    // Form will be submitted to nuevaMulta servlet
                    form.submit(); // Submit the form
                });

                // Prevent form submission
                form.addEventListener('submit', function (event) {
                    event.preventDefault();
                });
            </script>     
        </div>
</div></div></div>
</form>
</div>      
<%@ include file="../footer.jsp" %>
