<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="container bg-primary border border-dark rounded">
        <form method="post" action="crearCondecoracion">
            <div class="row" style="background-color: #9acbfd">
                <div class="row">
                    <div class="d-flex justify-content-center mt-2">
                        <h2><strong><u>NUEVA CONDECORACI&Oacute;N</u></strong></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 mb-2">
                        <div class="row">
                            <div class="col rounded ms-3 me-3">T&iacute;tulo</div>
                            <div class="col rounded ms-3 me-3">Imagen</div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3 mb-2">
                                <input
                                    class="form-control input-form"
                                    name="titulo"
                                    />
                            </div>
                            <div class="col rounded ms-3 me-3 mb-2">
                                <input
                                    class="form-control input-form"
                                    name="imagen"
                                    />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3">Descripci&oacute;n</div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3 mb-2">
                                <textarea class="form-control input-form" name="descripcion" rows="4" cols="50"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col d-flex justify-content-center mb-3">
                            <button type="submit" class="boton mx-4 mt-4">Crear Condecoraci&oacute;n</button>
                            <button type="button" class="boton mx-4 mt-4" onclick="redirigir('admin')">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</c:if>
<%@ include file="../footer.jsp" %>
