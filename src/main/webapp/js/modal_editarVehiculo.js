const btnToPopUp = document.querySelector("#toPopUp");
const btnCancelar = document.querySelector("#cancelar");
const confirmar = document.querySelector("#confirmar");
const form = document.getElementById('editarVehiculo');

btnToPopUp.addEventListener("click", () => {
    if (validarCamposRequeridos()) {
        const dniPropietario = document.getElementById('dni').value;
        const nombrePropietario = document.getElementById('nombreCiudadano').value;
        const modelo = document.getElementById('modelo').value;

        document.getElementById('dniPropietario_d').textContent = dniPropietario;
        document.getElementById('nombrePropietario_d').textContent = nombrePropietario;
        document.getElementById('modelo_d').textContent = modelo;
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
function buscarCiudadano() {
    var dni = document.getElementById("dni").value;
    if (dni.trim() !== '') {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    document.getElementById("nombreCiudadano").value = xhr.responseText;
                } else {
                    console.error('Error en la solicitud: ' + xhr.status);
                }
            }
        };
        xhr.open('GET', 'BuscarCiudadano?id=' + encodeURIComponent(dni), true);
        xhr.send();
    } else {
        document.getElementById("nombreCiudadano").value = "";
    }
}

document.getElementById('modelo').addEventListener('change', function () {
    var input = this;
    var dataList = input.list;
    var options = dataList.options;
    var selectedOption = null;

    for (var i = 0; i < options.length; i++) {
        if (options[i].value === input.value) {
            selectedOption = options[i];
            break;
        }
    }

    if (selectedOption) {
        var modeloId = selectedOption.getAttribute('data-id');
        document.getElementById('idModelo').value = modeloId;
    } else {
        document.getElementById('idModelo').value = '';
    }
});

