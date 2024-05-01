<dialog class="boton" id="confirmar"> 
    <p class="text-center" style="font-weight: bold;">¿Confirmar edición del vehiculo </p>
    <p class="text-center" style="font-weight: bold;"> ${vehiculo.modelo.modelo} - ${vehiculo.matricula}?</p>
       <div class="row">
    <div class="col" style="color:black">
        DNI: 
    </div>
    <div class="col" style="color:black">
        Nombre:
    </div>
</div>
<div class="row">
    <div class="col">
        <span id="dniPropietario_d" style="color: #1e549f;font-weight: bold;"></span>
    </div>
    <div class="col">
        <span id="nombrePropietario_d" style="color: #1e549f;font-weight: bold;"></span>
    </div>
</div>
<div class="row">
    <div class="col-12" style="color:black">
        Modelo:
    </div>
</div>
<div class="row">
    <div class="col-12">
        <span id="modelo_d" style="color: #1e549f;font-weight: bold;"></span>
    </div>
</div>

<button id="confirmarBtn" class="boton mx-4 mt-4">Confirmar</button>
<button id="cancelar" class="boton mx-4 mt-4">Cancelar</button>
</dialog>
