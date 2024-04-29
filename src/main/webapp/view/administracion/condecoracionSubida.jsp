<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="d-flex justify-content-center">
        <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
            <div class="d-flex flex-column">
                <img src="./images/logoBS.png" class="logo2 text-center">
                <div class="boton m-3">
                    La condecoraci&oacute;n ${titulo} ha sido creado correctamente.
                </div>
            </div>
        </div>
    </div>
</c:if>
<%@ include file="../footer.jsp" %>