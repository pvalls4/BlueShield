<%@ include file="../header.jsp"%>
<div id="fondo" class="container bg-primary rounded">
    <c:set var="formattedImporte" value="${String.format('%.2f', visualizarMulta.importe_total)}" />
    <c:if test="${empty visualizarMulta}">
        <div class="row justify-content-center text-center py-5 m-3" style="background-color: #bbddf5; color:#0757af;">
            No se encontró esta multa.   
        </div>

    </c:if>
    <c:if test="${not empty visualizarMulta}">
        <div class = "row" style= " background-color: #9acbfd;">
            <div class ="row">
                <div class = "d-flex justify-content-center mt-2"><h2><Strong><u>VISUALIZACI&Oacute;N DE DENUNCIA</u></Strong></h2></div>
            </div>
            <div class = "row">
                <div class = "col-md-9 mb-5 ">
                    <div class ="row">
                        <div class = "col rounded ms-4 me-3">Num. Referencia</div>
                        <div class = "col rounded mx-3">Fecha</div>
                        <div class = "col rounded ms-3 me-4">Importe</div>                        
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-4 me-3 mb-2" style="background-color: #bbddf5;">${visualizarMulta.id}</div>
                        <div class = "col rounded mx-3 mb-2" style="background-color: #bbddf5;">${visualizarMulta.fecha_emision}</div>
                        <div class= "col rounded ms-3 mb-2 me-4" style="background-color: #bbddf5;">${formattedImporte}&euro;</div>
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-4">Denunciado/a</div>                        
                        <div class = "col rounded ms-4 pe-2 me-4">Veh&iacute;culo Implicado*</div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-4 me-3 mb-2" style="background-color: #bbddf5;">${visualizarMulta.ciudadano.nombre} ${visualizarMulta.ciudadano.apellidos} - <strong>${visualizarMulta.ciudadano.dni}</strong></div>                                                
                        <c:if test="${empty visualizarMulta.vehiculo}"><div class = "col rounded mb-2 ms-4 me-4" style="background-color: #bbddf5;">N/A</div></c:if>
                        <c:if test="${not empty visualizarMulta.vehiculo}"><div class = "col rounded mb-2 ms-4 me-4" style="background-color: #bbddf5;">${visualizarMulta.vehiculo.modelo.marca} ${visualizarMulta.vehiculo.modelo.modelo} <strong>${visualizarMulta.vehiculo.matricula}</strong></div></c:if>
                        </div>
                        <div class ="row">
                            <div class = "col rounded ms-4">Ubicación</div>                        
                            <div class = "col rounded ms-4 pe-2 me-4">Estado</div> 
                        </div>
                        <div class ="row">
                            <div class = "col rounded ms-4 me-3 mb-2" style="background-color: #bbddf5;">${visualizarMulta.ubicacion}</div>                                     
                        <div class = "col rounded mb-2 ms-4 me-4" style="background-color: #bbddf5;">${visualizarMulta.isPagado ? 'Pagada' : 'No pagada'}</strong></div> 
                    </div>
                    <div class ="row">
                        <div class = "col rounded ms-4 me-4">Hechos</div> 
                    </div>
                    <div class ="row">
                        <c:if test="${empty visualizarMulta.observaciones}"><div class = "col rounded ms-4 me-4" style="background-color: #bbddf5;">N/A</div></c:if>
                        <c:if test="${not empty visualizarMulta.observaciones}"><div class = "col rounded ms-4 me-4" style="background-color: #bbddf5;">${visualizarMulta.observaciones}</div></c:if>
                        </div>
                    </div>
                    <div class ="col-md-3 border-start border-dark mb-5">
                        <div class ="row">
                            <div class = "col rounded ms-4 me-4">Art&iacute;culos</div>
                        </div>
                        <div class ="row">
                            <div class = "col rounded ms-4 me-4" style="background-color: #bbddf5;">
                            <c:forEach items="${infraccionesInfo}" var="info">
                                <p><Strong>${info.infraccion.articulo}:</Strong> ${info.infraccion.titulo}.</p>
                                    </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<%@ include file="../footer.jsp" %>
