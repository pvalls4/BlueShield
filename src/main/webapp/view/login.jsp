<%@ include file="./header.jsp" %>
<div class="d-flex justify-content-center">
    <div class="d-flex flex-column justify-content-center w-40"> 
        <div class="d-flex justify-content-center">
            <img src="./images/logoBS.png" class="logo2">
        </div>
         <form method="post" action="login">
                <c:if test="${invalidUser}">
                    <span class="text-darkblue">${errorMessage}</span>
                </c:if>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label text-darkblue">Identificador:</label>
                <input type="number" class="form-control input-form" id="placa" placeholder="Número de placa" name="placa">
            </div>
            <div class="mb-3">
                <label for="pwd" class="form-label text-darkblue">Contraseña:</label>
                <input type="password" class="form-control input-form" id="pwd" placeholder="Contraseña" name="pwd">
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary b-login mb-2">Log In</button>
            </div>
          </form>
    </div>
</div>
<%@ include file="./footer.jsp" %>
