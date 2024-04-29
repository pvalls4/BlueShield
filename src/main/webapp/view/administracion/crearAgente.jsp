<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="container bg-primary border border-dark rounded">
      <form method="post" action="crearAgente">
        <div class="row" style="background-color: #9acbfd">
          <div class="row">
            <div class="d-flex justify-content-center mt-2">
              <h2>NUEVO AGENTE</h2>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 mb-2">
              <div class="row">
                <div class="col rounded ms-3 me-3">DNI</div>
                <div class="col rounded ms-3 me-3">Imagen</div>
              </div>
              <div class="row">
                <div class="col rounded ms-3 me-3 mb-2">
                  <input
                    class="form-control input-form"
                    placeholder="Z9999999X"
                    name="dni"
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
                <div class="col rounded ms-3 me-3">Placa</div>
                <label for="rangos" class="col rounded ms-3 me-3">Rango</label>
              </div>
              <div class="row">
                <div class="col rounded ms-3 me-3 mb-2">
                  <input
                    class="form-control input-form"
                    placeholder="666666"
                    name="placa"
                    value="${idPlaca}"
                    readonly
                  />
                </div>
              <select name="rangos" class="col rounded ms-3 me-3 mb-2">
                    <option value="Cadete">Cadete</option>
                    <option value="Oficial I">Oficial I</option>
                    <option value="Oficial II">Oficial II</option>
                    <option value="Oficial III">Oficial III</option>
                    <option value="Oficial III+">Oficial III+</option>
                    <option value="Detective I">Detective I</option>
                    <option value="Sargento I">Sargento I</option>
                    <option value="Detective II">Detective II</option>
                    <option value="Sargento II">Sargento II</option>
                    <option value="Detective III+">Detective III+</option>
                    <option value="Teniente I">Teniente I</option>
                    <option value="Teniente II">Teniente II</option>
                    <option value="Capitán I">Capit&aacute;n I</option>
                    <option value="Capitán II">Capit&aacute;n II</option>
                    <option value="Capitán III">Capit&aacute;n III</option>
                    <option value="Comandante">Comandante</option>
                    <option value="Deputy Chief">Deputy Chief</option>
                    <option value="Assistant Chief">Assistant Chief</option>
                    <option value="Chief">Chief</option>  
                </select>
              </div>
            </div>
              <div class="row">
                <div class="col rounded ms-3 me-3">Correo</div>
              </div>
              <div class="row">
                <div class="col rounded ms-3 me-3 mb-2">
                  <input
                    class="form-control input-form"
                    placeholder="example@gmail.com"
                    name="correo"
                  />
                </div>
              </div>
            <div class="row">
              <div class="col d-flex justify-content-center">
                <button type="submit" class="boton mx-4 mt-4">Crear Agente</button>
                <button type="button" class="boton mx-4 mt-4" onclick="window.location.href='login'">Cancelar</button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
</c:if>
<%@ include file="../footer.jsp" %>
