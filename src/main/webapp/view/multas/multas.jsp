<%@ include file="../header.jsp" %>
<div class="d-flex justify-content-center">
    <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
        <div class="d-flex flex-column">
            <img src="./images/logoBS.png" class="logo2 text-center">
            <button onclick="redirigir(1)" class="boton m-3">
                Nueva Multa
            </button>
            <button onclick="redirigir(2)" class="boton m-3">
                Últimas Multas
            </button>
        </div>
    </div>
</div>
<script>
    function redirigir(option) {
        switch (option) {
            case 1: 
                window.location.href = "nuevamulta";
                break;
            case 2:
                window.location.href = "ultimasMultas";
                break;
        }
    }

</script>
<%@ include file="../footer.jsp" %>