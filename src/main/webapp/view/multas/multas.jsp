<%@ include file="../header.jsp" %>
<div class="d-flex justify-content-center">
    <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
        <div class="d-flex flex-column">
            <img src="./images/logoBStrazo.png" class="logo2 text-center">
            <button onclick="redirigir('nuevaMulta')" class="boton m-3">
                Nueva Multa
            </button>
            <button onclick="redirigir('ultimasMultas')" class="boton m-3">
                Últimas Multas
            </button>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>