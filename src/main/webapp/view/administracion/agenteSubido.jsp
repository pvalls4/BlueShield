<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <c:if test="${dniInvalid}">
        <div class="d-flex justify-content-center">
            <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
                <div class="d-flex flex-column">
                    <div class="d-flex justify-content-center">
                        <img src="./images/logoBS.png" class="logo2 text-center">                    
                    </div>
                    <div class="boton m-3 px-2">
                        El documento ${dni} es invalido
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${!dniInvalid}">
            <div class="d-flex justify-content-center">
                <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
                    <div class="d-flex flex-column">
                        <div class="d-flex justify-content-center">
                            <img src="./images/logoBS.png" class="logo2 text-center">                    
                        </div>
                        <div class="boton m-3 px-2">
                            El agente ${idPlaca} con documento ${dni} ha sido creado correctamente.
                        </div>
                        <div class="boton m-3 px-2">
                            No se olvide que su clave es el n�mero del DNI.
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </c:if>
    <%@ include file="../footer.jsp" %>