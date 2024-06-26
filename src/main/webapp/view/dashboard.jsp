<%@ include file="./header.jsp" %>
<div class="d-flex justify-content-center flex-wrap">
    <img id="ciudadanos" src="./images/ciudadanos.png" class="dash-option m-3" onclick="redirigir(this.id)">
    <img id="vehiculos" src="./images/vehiculos.png" class="dash-option m-3" onclick="redirigir(this.id)">
    <img id="multas" src="./images/multas.png" class="dash-option m-3" onclick="redirigir(this.id)">
</div>
<div class="d-flex justify-content-center flex-wrap">
    <img id="agentes" src="./images/agentes.png" class="dash-option m-3" onclick="redirigir(this.id)">
    <img id="condecoraciones" src="./images/condecoraciones.png" class="dash-option m-3" onclick="redirigir(this.id)">
    <c:if test="${username.isAdmin()}">
        <img id="admin" src="./images/admin1.png" class="dash-option m-3" onclick="redirigir(this.id)">
    </c:if>
</div>
<script>
    function redirigir(id) {
        window.location.href = id;
    }
</script>
<%@ include file="./footer.jsp" %>