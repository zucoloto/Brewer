//Exemplo de JavaScript inicial para desabilitar envios de formulários se houver campos inválidos
(function() {
	'use strict'

	// Busque todos os formulários aos quais desejamos aplicar estilos de validação Bootstrap personalizados
	var forms = document.querySelectorAll('.needs-validation')

	// Faça um loop sobre eles e evite a submissão
	Array.prototype.slice.call(forms).forEach(function(form) {
		form.addEventListener('submit', function(event) {
			if (!form.checkValidity()) {
				event.preventDefault()
				event.stopPropagation()
			}
			form.classList.add('was-validated')
		}, false)
	})
})()