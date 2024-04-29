<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <c:if test="${dniInvalid}">
        <div class="d-flex justify-content-center">
        <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
            <div class="d-flex flex-column">
                <img src="./images/logoBS.png" class="logo2 text-center">
                <div class="boton m-3">
                    El documento ${dni} es invalido
            </div>
        </div>
        </div>
    </c:if>
    <c:if test="${!dniInvalid}">
        <div class="d-flex justify-content-center">
            <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
                <div class="d-flex flex-column">
                    <img src="./images/logoBS.png" class="logo2 text-center">
                    <div class="boton m-3">
                        El agente ${placa} con documento ${dni} ha sido creado correctamente.
                    </div>
                    <div class="boton m-3">
                        No se olvide que su clave es la placa + los 3 ultimos digitos de su documento.
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</c:if>
<%@ include file="../footer.jsp" %>