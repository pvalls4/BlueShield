<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="container bg-primary border border-dark rounded">
        <form method="post" action="crearAgente">
            <div class="row" style="background-color: #9acbfd">
                <div class="row">
                    <div class="d-flex justify-content-center mt-2">
                        <h2><strong><u>NUEVO AGENTE</u></strong></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 mb-2">
                        <div class="row">
                            <div class="col rounded ms-3 me-3">DNI</div>
                            <div class="col rounded ms-3 me-3">Rango</div>
                        </div>
                        <div class="row">
                            <div class="col rounded ms-3 me-3 mb-2">
                                <input type="text" autocomplete="off" class="form-control input-form" list="ciudadanosOptions" name="dni" placeholder="DNI agente" aria-label="Buscar por DNI" aria-describedby="button-addon2">
                                <datalist id="ciudadanosOptions">
                                    <c:if test="${not empty listaCiudadanosFiltrada}">
                                        <c:forEach items="${listaCiudadanosFiltrada}" var="ciudadano">
                                            <option value="${ciudadano.dni}">${ciudadano.dni} - ${ciudadano.nombre} ${ciudadano.apellidos}</option>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${empty listaCiudadanosFiltrada}">
                                        <option value="Error en base de datos">
                                        </c:if>
                                </datalist>
                            </div>
                            <div class="col rounded ms-3 me-3 mb-2">
                                <select name="rangos" class="form-control input-form col rounded">
                                    <optgroup label="Escala de Oficiales">
                                        <option value="Cadete">Cadete</option>
                                        <option value="Oficial I">Oficial I</option>
                                        <option value="Oficial II">Oficial II</option>
                                        <option value="Oficial III">Oficial III</option>
                                        <option value="Oficial III+">Oficial III+</option>
                                        <option value="Detective I">Detective I</option>
                                    </optgroup>
                                    <optgroup label="Escala de Mandos">
                                        <option value="Sargento I">Sargento I</option>
                                        <option value="Detective II">Detective II</option>
                                        <option value="Sargento II">Sargento II</option>
                                        <option value="Detective III+">Detective III</option>
                                        <option value="Teniente I">Teniente I</option>
                                        <option value="Teniente II">Teniente II</option>
                                    </optgroup>
                                    <optgroup label="Escala de Jefatura">
                                        <option value="Capitán I">Capit&aacute;n I</option>
                                        <option value="Capitán II">Capit&aacute;n II</option>
                                        <option value="Capitán III">Capit&aacute;n III</option>
                                        <option value="Comandante">Comandante</option>
                                        <option value="Deputy Chief">Deputy Chief</option>
                                        <option value="Assistant Chief">Assistant Chief</option>
                                        <option value="Chief">Chief</option> 
                                    </optgroup>
                                </select>
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
                                    placeholder="Enlace a imgur"
                                    />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 me-3">Permisos de Administrador</div>
                    </div>
                    <div class="row">
                        <div class="col rounded ms-3 me-3 mb-2">
                            <input class="form-check-input input-form mx-2" name="adminCheckbox" type="checkbox" id="adminCheckbox">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col d-flex justify-content-center mb-3">
                            <button type="submit" class="boton mx-4 mt-4">Crear Agente</button>
                            <button type="button" class="boton mx-4 mt-4" onclick="redirigir('admin')">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</c:if>
<%@ include file="../footer.jsp" %>
