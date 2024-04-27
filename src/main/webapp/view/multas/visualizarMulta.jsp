<%@ include file="../header.jsp"%>
<div class="container bg-primary border border-dark rounded">
    <c:set var="formattedImporte" value="${String.format('%.2f', visualizarMulta.importe_total)}" />
    <c:if test="${empty visualizarMulta}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5; color:#0757af;">
            No se encontr� esta multa.   
        </div>

    </c:if>
    <c:if test="${not empty visualizarMulta}">
        <div class = "row" style= " background-color: #9acbfd;">
            <div class ="row">
                <div class = "d-flex justify-content-center mt-2"><h2>VISUALIZACION DE DENUNCIA</h2></div>
            </div>
            <div class = "row">
                <div class = "col-md-9 mb-5 ">
                    <div class ="row">
                        <div class = "col rounded ms-3 me-3">Num. Referencia</div>
                        <div class = "col rounded mx-3">Fecha</div>
                        <div class = "col rounded ms-3 me-4">Importe</div>                        
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3 me-3 mb-2" style="background-color: #bbddf5;">${visualizarMulta.id}</div>
                        <div class = "col rounded mx-3 mb-2" style="background-color: #bbddf5;">${visualizarMulta.fecha_emision}</div>
                        <div class= "col rounded ms-3 mb-2 me-4" style="background-color: #bbddf5;">${formattedImporte}&euro;</div>
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3">Denunciado/a</div>                        
                        <div class = "col rounded ms-4 pe-2 me-4">Vehiculo Implicado*</div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3 me-3 mb-2" style="background-color: #bbddf5;"><p>${visualizarMulta.ciudadano.nombre} ${visualizarMulta.ciudadano.apellidos} <strong>${visualizarMulta.ciudadano.dni}</strong></p></div>                                                
                        <div class = "col rounded mb-2 ms-4 me-4" style="background-color: #bbddf5;"><p>${visualizarMulta.vehiculo.modelo.marca} ${visualizarMulta.vehiculo.modelo.modelo} <strong>${visualizarMulta.vehiculo.matricula}</strong></p></div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3">Ubicaci�n</div>                        
                        <div class = "col rounded ms-4 pe-2 me-4">Estado</div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3 me-3 mb-2" style="background-color: #bbddf5;"><p>${visualizarMulta.ubicacion}</p></div>                                                
                        <div class = "col rounded mb-2 ms-4 me-4" style="background-color: #bbddf5;"><p>${visualizarMulta.isPagado ? 'Pagada' : 'No pagada'}</strong></p></div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3 me-4">Hechos</div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-3 me-4" style="background-color: #bbddf5;"><p>${visualizarMulta.observaciones}</p></div>
                    </div>
                </div>
                <div class ="col-md-3 border-start border-dark mb-5">
                    <div class ="row">
                        <div class = "col-md-11 ms-3 me-2">Articulos</div>
                    </div>
                    <div class ="row">
                        <div class = "col-md-11 rounded ms-3 me-2" style="background-color: #bbddf5;">
                            <c:forEach items="${infraccionesInfo}" var="info">
                                <p>${info.infraccion.articulo}: ${info.infraccion.titulo}.</p>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<%@ include file="../footer.jsp" %>