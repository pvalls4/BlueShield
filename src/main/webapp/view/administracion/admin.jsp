<%@ include file="../header.jsp" %>
<div class="d-flex justify-content-center">
    <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
        <div class="d-flex flex-column">
            <img src="./images/logoBS.png" class="logo2 text-center">
            <button onclick="ir(1)" class="boton m-3">
                Crear Agente
            </button>
<!--            <button onclick="ir(2)" class="boton m-3">
                Añadir Condecoración
            </button>
            <button onclick="ir(3)" class="boton m-3">
                Añadir Sanción
            </button>-->
        </div>
    </div>
</div>
<script>
    function ir(option) {
        switch (option) {
            case 1: 
                window.location.href = "crearAgente";
                break;
            case 2:
                window.location.href = "anadirCondecoracion";
                break;
            case 3:
                window.location.href = "anadirSancion";
        }
    }

</script>
<%@ include file="../footer.jsp" %>