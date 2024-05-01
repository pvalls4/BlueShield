
const btnToPopUp = document.querySelector("#toPopUp");
const btnCancelar = document.querySelector("#cancelar");
const confirmar = document.querySelector("#confirmar");
const form = document.getElementById('editarCiudadano');

btnToPopUp.addEventListener("click", () => {
    if (validarCamposRequeridos()) {
        const telefono = document.getElementById('telefono').value;
        const email = document.getElementById('email').value;
        const calle = document.getElementById('calle').value;
        const municipio = document.getElementById('municipio').value;
        const numero = document.getElementById('numero').value;
        const piso = document.getElementById('piso').value;
        const puerta = document.getElementById('puerta').value;
        const codigoPostal = document.getElementById('codigoPostal').value;
        
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