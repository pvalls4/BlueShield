const btnToPopUp = document.querySelector("#toPopUp");
const btnCancelar = document.querySelector("#cancelar");
const confirmar = document.querySelector("#confirmar");
const form = document.getElementById('registrarCiudadano');

btnToPopUp.addEventListener("click", () => {
    if (validarCamposRequeridos()) {
        const dni = document.getElementById('dni').value;
        const nombre = document.getElementById('nombre').value;
        const apellidos = document.getElementById('apellidos').value;
        const fechaNacimiento = document.getElementById('fechaNacimiento').value;
        const telefono = document.getElementById('telefono').value;
        const email = document.getElementById('email').value;
        const calle = document.getElementById('calle').value;
        const municipio = document.getElementById('municipio').value;
        const numero = document.getElementById('numero').value;
        const piso = document.getElementById('piso').value;
        const puerta = document.getElementById('puerta').value;
        const codigoPostal = document.getElementById('codigoPostal').value;

        document.getElementById('dni_d').textContent = dni;
        document.getElementById('nombre_d').textContent = nombre;
        document.getElementById('apellidos_d').textContent = apellidos;
        document.getElementById('fechaNacimiento_d').textContent = fechaNacimiento;
        document.getElementById('telefono_d').textContent = telefono;
        document.getElementById('email_d').textContent = email;
        document.getElementById('calle_d').textContent = calle;
        document.getElementById('municipio_d').textContent = municipio;
        document.getElementById('numero_d').textContent = numero;
        document.getElementById('piso_d').textContent = piso;
        document.getElementById('puerta_d').textContent = puerta;
        document.getElementById('codigoPostal_d').textContent = codigoPostal;
        confirmar.showModal();
    } else {
        alert('Por favor, completa todos los campos requeridos y marca al menos una opción.');
    }
});

btnCancelar.addEventListener("click", () => {
    confirmar.close();
});

document.querySelector('#confirmarBtn').addEventListener("click", () => {
    if (validarCamposRequeridos()) {
        form.submit();
    } else {
        alert('Por favor, completa todos los campos requeridos.');
    }
});

form.addEventListener('submit', function (event) {
    event.preventDefault();
});

function validarCamposRequeridos() {
    var campos = form.querySelectorAll('[required]');
    for (var i = 0; i < campos.length; i++) {
        if (!campos[i].value) {
            return false;
        }
    }
    return true;
}

function generarDNI() {
    var dniGenerado = generarDNIUnico();
    document.getElementById("dni").value = dniGenerado;
}
function generarDNIUnico() {
    var dni;
    do {
        var numeroAleatorio = Math.floor(Math.random() * 100000000);
        var letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
        var residuo = numeroAleatorio % 23;
        dni = numeroAleatorio.toString() + letras.charAt(residuo);
    } while (existeDNI(dni));
    return dni;
}
function existeDNI(dni) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "existeDNI?id=" + dni, false); // Solicitud sincrónica
    xhr.send();
    return xhr.responseText === "1";
}