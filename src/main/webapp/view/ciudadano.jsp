<%@ include file="./header.jsp" %>
<div class="d-flex justify-content-center">
    <div class="d-flex flex-column justify-content-center w-30"> 
        <div class="container">
            <!-- Primer row con título -->
            <div class="row">
                <div class="col-md-12">
                    <h2>Nombre - DNI</h2>
                </div>
            </div>
            <!-- Segundo row con imagen y parámetros -->
            <div class="row align-items-center">
                <!-- Imagen a la izquierda -->
                <div class="col-md-3">
                    <img src="https://i.imgur.com/VflHOjr.png" alt="FotoCiudadano">
                </div>
                <!-- Contenedor para otros parámetros a la derecha -->
                <div class="col-md-9">
                    <!-- Nueva fila para dividir los parámetros -->
                    <div class="row">
                        <div class="col-md-6">
                            Nacionalidad
                        </div>
                        <div class="col-md-6">
                            Fecha de Nacimiento
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>
<%@ include file="./footer.jsp" %>
