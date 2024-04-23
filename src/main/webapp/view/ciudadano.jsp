<%@ include file="./header.jsp" %>
<div class="container border border-dark rounded" style="background-color: #9acbfd">

    <div class="row px-4">
        <div class="col-md-12 g-3">
            <h2 style="padding-left: 20%;">Nombre - DNI</h2>
        </div>
    </div>
    <!-- Segundo row con imagen y parámetros -->
    <div class="row p-3">
        <!-- Imagen a la izquierda -->
        <div class="col-md-3 border border-dark rounded m-0 p-0">
            <img src="https://i.imgur.com/VflHOjr.png" class="img-fluid" alt="FotoCiudadano">
        </div>
        <!-- Contenedor para otros parámetros a la derecha -->
        <div class="col-md-9">
            <!-- Nueva fila para dividir los parámetros -->
            <div class="row">
                <div class="col-md-6 px-3">
                    <div class="col p-1">
                        Fecha de Nacimiento
                    </div>
                    <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                        15/04/1996
                    </div>
                </div>
                <div class="col-md-6 rounded px-3">
                    <div class="col p-1">
                        Teléfono
                    </div>
                    <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;">
                        657475837
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col px-3">
                    <div class="col p-1">
                        Dirección
                    </div>
                    <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                        Calle super grande de la hostia 3434343523 piso 3424234234
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col px-3">
                    <div class="col p-1">
                        E-mail
                    </div>
                    <div class="col border border-dark rounded p-1" style="background-color: #bbddf5;color:#0757af;overflow-wrap: break-word;">
                        correodeejemplosuperlargodelamuerte@dominiosuperlargodelamuerto.com
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row justify-content-center text-center">
        <div class="col-md-6 col-lg-4"> <!-- Tamaño alargado para dispositivos medianos y grandes -->
            <button class="btn btn-primary btn-block m-1 px-5" style="background-color: #bbddf5;color:#0757af;">Editar perfil</button>
        </div>
        <div class="col-md-6 col-lg-4"> <!-- Tamaño alargado para dispositivos medianos y grandes -->
            <button class="btn btn-primary btn-block m-1 mb-3 px-5" style="background-color: #bbddf5;color:#0757af;">Ver Multas</button>
        </div>
    </div>

</div>
<%@ include file="./footer.jsp" %>
