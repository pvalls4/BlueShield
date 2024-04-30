<%@ include file="../header.jsp" %>
<c:if test="${isAdmin}">
    <div class="d-flex justify-content-center">
        <div id="fondo" class="d-flex justify-content-center" style="width: 500px; background-color: #9acbfd"">
            <div class="d-flex flex-column">
                <div class="d-flex justify-content-center">
                    <img src="./images/logoBS.png" class="logo2 text-center">                    
                </div>
                <div class="boton m-3 px-2">
                    La condecoraci&oacute;n ${titulo} ha sido creado correctamente.
                </div>
            </div>
        </div>
    </div>
</c:if>
<%@ include file="../footer.jsp" %>