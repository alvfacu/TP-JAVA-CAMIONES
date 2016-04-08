function validacion(f)  {
	valor = document.getElementById("campo_numerico").value;
if (isNaN(valor)) {
alert("Error:\nEste campo debe tener sólo números.");
f.valor.focus();
return (false);}}