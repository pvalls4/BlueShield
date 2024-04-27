<%@ include file="../header.jsp" %>
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
            <div class="col rounded ms-3 me-3">Correo</div>
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
            <div class="col rounded ms-3 me-3 mb-2">
              <input
                class="form-control input-form"
                placeholder="example@gmail.com"
                name="correo"
              />
            </div>
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
<%@ include file="../footer.jsp" %>
