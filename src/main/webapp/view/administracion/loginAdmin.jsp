<%@ include file="../header.jsp" %>
<div class="d-flex justify-content-center">
    <div class="d-flex flex-column justify-content-center w-40">
        <div class="d-flex justify-content-center">
            <img src="./images/logoBS.png" class="logo2" />
        </div>
        <form method="post" action="loginAdmin">
            <c:if test="${invalidUser}">
                <span class="text-darkblue">${errorMessage}</span>
            </c:if>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label text-darkblue">Correo</label>
                <input
                    type="text"
                    class="form-control input-form"
                    id="correo"
                    placeholder="Correo"
                    name="correo"
                    />
            </div>
            <div class="mb-3">
                <label for="pwd" class="form-label text-darkblue"
                       >Contrase&nacute;a:</label
                >
                <input
                    type="password"
                    class="form-control input-form"
                    id="pwd"
                    placeholder="Contraseña"
                    name="pwd"
                    />
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary b-login mb-2">
                    Log In
                </button>
                <button
                    type="button"
                    class="btn btn-primary b-login mb-2"
                    onclick="window.location.href = 'login'"
                    >
                    Cancelar
                </button>
            </div>
        </form>
    </div>
</div>
<%@ include file="../footer.jsp" %>
