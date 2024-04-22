<%@ include file="./header.jsp" %>
<div class="container bg-primary border border-dark rounded">

    <div class="row px-4">
        <div class="col-md-12 g-3">
            <h2>Nombre - DNI</h2>
        </div>
    </div>
    <!-- Segundo row con imagen y par�metros -->
    <div class="row px-3">
        <!-- Imagen a la izquierda -->
        <div class="col-md-3 border border-dark rounded p-3">
            <img src="https://i.imgur.com/VflHOjr.png" class="img-fluid" alt="FotoCiudadano">
        </div>
        <!-- Contenedor para otros par�metros a la derecha -->
        <div class="col-md-9 p-3">
            <!-- Nueva fila para dividir los par�metros -->
            <div class="row">
                <div class="col-md-6 border border-dark rounded">
                    Nacionalidad
                </div>
                <div class="col-md-6 border border-dark rounded">
                    Fecha de Nacimiento
                </div>
            </div>
            <div class="row">
                <div class="col border border-dark rounded">
                    Direcci�n
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 border border-dark rounded">
                    Estado civil
                </div>
                <div class="col-md-6 border border-dark rounded">
                    G�nero
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="./footer.jsp" %>
