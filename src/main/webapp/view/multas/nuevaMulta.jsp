<%@ include file="../header.jsp" %>
    <form method="post" action="nuevaMulta">
        <div class="container bg-primary border border-dark rounded">
            <div class = "row" style="background-color: #9acbfd;">
                <div class ="row">
                    <div class = "d-flex justify-content-center mt-2"><h2>EMISION DE DENUNCIA</h2></div>
                </div>
                <div class = "row">
                    <div class = "col-md-9 mb-2">
                        <div class ="row">
                            <div class = "col rounded ms-3 me-3">Num. Referencia</div>
                            <div class = "col rounded mx-4">Fecha</div>
                            <div class = "col rounded ms-4 me-5">Importe</div>                        
                        </div>
                        <div class ="row">
                            <div class = "col rounded ms-3 me-3 mb-2"><div class = "form-control input-form">asdasd</div></div>
                            <div class = "col rounded mx-4 mb-2"><input type="date" class="form-control input-form" id="fechaEmision" name="fechaEmision"></div>
                            <div class = "col rounded ms-4 mb-2 me-5"><input type="number" class="form-control input-form" id="importe" name="importe"></div>                        
                        </div>
                        <div class ="row">
                            <div class = "col rounded ms-3">Denunciado/a</div>                        
                            <div class = "col rounded ms-4 ps-4 me-5">Vehiculo Implicado*</div> 
                        </div>
                        <div class ="row">
                            <div class = "col rounded ms-3 me-3 mb-2">
                                <input class="form-control input-form" list="datalistOptions" id="exampleDataList" placeholder="Ciudadano">
                                <datalist id="datalistOptions">
                                    <%@ page import="java.util.List" %>
                                    <%@ page import="model.DTO.CiudadanoDTO" %>
                                    <%@ page import="java.util.ArrayList" %>

                                    <% 
                                        List<CiudadanoDTO> listaCiudadanos = (List<CiudadanoDTO>) request.getAttribute("listaCiudadanos");                                      
                                        for(CiudadanoDTO ciudadano : listaCiudadanos) {
                                    %>
                                        <option value="<%= ciudadano.getNombre() %> <%= ciudadano.getApellidos() %>">
                                    <%
                                        }
                                    %>
                                </datalist>
                            </div>                                                
                            <div class = "col rounded  mb-2 ms-4 me-5"><input type="text" class="form-control input-form" id="bastidor" name="bastidor"></div> 
                        </div>
                        <div class ="row">
                            <div class = "col-md-11 rounded ms-3">Ubicacion</div>                        
                            <div class = "col-md-11 rounded ms-3 mb-2"><input type="text" class="form-control input-form" id="" name=""></div>
                        </div>
                        <div class ="row">
                            <div class = "col-md-11 rounded ms-3">Hechos</div>                        
                            <div class = "col-md-11 rounded ms-3"><input type="text" class="form-control input-form" id="" name=""></div>
                        </div>
                    </div>
                    <div class ="col-md-3 border-start border-dark mb-2">
                        <div class ="row">
                            <div class = "col-md-11 ms-3 me-2">Articulos</div>
                            
                        </div>
                        <div class ="row">
                            <div class = "col-md-11 rounded ms-3 me-2"><input type="text" class="form-control input-form" id="" name=""></div>
                        </div>
                    </div>
                    <div class = "row">
                                <div class = "col d-flex justify-content-center">  
                                    <button type="submit" class="boton mx-4 my-3">Emitir denuncia</button>
                                    <button type="submit" class="boton mx-4 my-3">Cancelar</button>
                                </div>                       
                    </div>
                </div>
            </div>
            <div class="container mt-5">
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
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="heading<%= capituloActual %>">
                                  <button class="accordion-button <%= primerCapitulo ? "" : "collapsed" %>" type="button" data-bs-toggle="collapse" data-bs-target="#collapse<%= capituloActual %>" aria-expanded="<%= primerCapitulo ? "true" : "false" %>" aria-controls="collapse<%= capituloActual %>">
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
                                                <input class="form-check-input" type="checkbox" value="" id="check<%= articulo.getId() %>">
                                                <label class="form-check-label" for="check<%= articulo.getId() %>">
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
            </div>
        </div>
    </form>

<%@ include file="../footer.jsp" %>