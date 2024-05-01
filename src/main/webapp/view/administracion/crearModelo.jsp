<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="container bg-primary border border-dark rounded">
        <form method="post" action="crearModelo">
            <div class="row" style="background-color: #9acbfd">
                <div class="row">
                    <div class="d-flex justify-content-center mt-2">
                        <h2><strong><u>NUEVA MARCA</u></strong></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 mb-2">
                        <div class="row">
                            <div class="col rounded ms-3 me-3">Marca</div>
                            <div class="col rounded ms-3 me-3">Modelo</div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3 mb-2">
                                <input
                                    class="form-control input-form"
                                    name="marca"
                                    />
                            </div>
                            <div class="col rounded ms-3 me-3 mb-2">
                                <input
                                    class="form-control input-form"
                                    name="modelo"
                                    />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3">Imagen</div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3 mb-2">
                                <input
                                    class="form-control input-form"
                                    name="imagen"
                                    />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col d-flex justify-content-center mb-3">
                            <button type="submit" class="boton mx-4 mt-4">Crear Modelo</button>
                            <button type="button" class="boton mx-4 mt-4" onclick="redirigir('admin')">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</c:if>
<%@ include file="../footer.jsp" %>
