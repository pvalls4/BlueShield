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
                            <div class = "col rounded ms-3 me-3 mb-2"><input type="text" class="form-control input-form" id="ciudadano" name="ciudadano"></div>                                                
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
        </div>
    </form>
<%@ include file="../footer.jsp" %>