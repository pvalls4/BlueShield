<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="d-flex justify-content-center">
        <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
            <div class="d-flex flex-column">
                <img src="./images/logoBS.png" class="logo2 text-center">
                <button onclick="ir(1)" class="boton m-3">
                    Crear Agente
                </button>
                <button onclick="ir(4)" class="boton m-3">
                    Crear Modelo
                </button><!--
                            <button onclick="ir(3)" class="boton m-3">
                                Añadir Sanción
                            </button>-->
                <button onclick="ir(2)" class="boton m-3">
                    Crear Condecoraci&oacuten
                </button>
            </div>
        </div>
    </div>
</c:if>
<script>
    function ir(option) {
        switch (option) {
            case 1:
                window.location.href = "crearAgente";
                break;
            case 2:
                window.location.href = "crearCondecoracion";
                break;
            case 3:
                window.location.href = "anadirSancion";
                break;
            case 4:
                window.location.href = "crearModelo";
                break;
        }
    }

</script>
<%@ include file="../footer.jsp" %>