<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Editar</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-maskmoney/3.0.2/jquery.maskMoney.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

	<script>
		$(document).ready(function () {
			$('.datepicker').datepicker({
				dateFormat: 'dd-mm-yy', // Formato da data
				changeMonth: true,
				changeYear: true
			});
		});

		$(document).ready(function() {
			$('.money').maskMoney({ prefix: 'R$ ', allowNegative: false, thousands: '.', decimal: ',' });
		});
	</script>
</head>
<body>

    <div class="container">

        <h1 class="p-3">Editar Projeto</h1>

        <form:form action="/project/editSaveProject" method="post" modelAttribute="project">

                    <div class="row">
                    	<div class="form-group col-md-12">
                    		<div class="col-md-6">
                    			<form:hidden path="id" class="form-control input-sm" />
                    		</div>
                    	</div>
                    </div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="nome">Nome</label>
							<div class="col-md-6">
								<form:input type="text" path="nome" id="nome"
											class="form-control input-sm" required="required" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="dataInicio">Início</label>
							<div class="col-md-6">
								<form:input type="text" id="dataInicio" path="dataInicio" name="dataInicio" class="datepicker" required="required" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="dataPrevisaoFim">Previsão de Término</label>
							<div class="col-md-6">
								<form:input type="text" id="dataPrevisaoFim" path="dataPrevisaoFim" name="dataPrevisaoFim" class="datepicker" required="required" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="dataFim">Término</label>
							<div class="col-md-6">
								<form:input type="text" id="dataFim" path="dataFim" name="dataFim" class="datepicker" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="descricao">Descriçao</label>
							<div class="col-md-6">
								<form:input type="text" path="descricao" id="descricao"
											class="form-control input-sm" required="required"/>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="status">Status</label>
							<div class="col-md-6">
								<form:select path="statusProject" id="statusProject">
									<form:options items="${statusProject}" itemLabel="name" itemValue="name" />
								</form:select>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="orcamento">Orçamento</label>
							<div class="col-md-6">
								<form:input type="text" path="orcamento" id="orcamento" class="form-control input-sm money" required="required"/>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="gerente">Gerentes</label>
							<div class="col-md-6">
								<form:select path="gerente" class="form-control">
									<form:option value="" label="Selecione um gerente" />
									<form:options items="${managers}" itemLabel="nome" itemValue="id" />
								</form:select>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3" for="risco">Risco</label>
							<div class="col-md-6">
								<form:select path="riskClassification" id="riskClassification">
									<form:options items="${riskClassifications}" itemLabel="name" itemValue="name" />
								</form:select>
							</div>
						</div>
					</div>

                    <div class="row p-2">
                    	<div class="col-md-2">
<%--                    		<button type="submit" value="Register" class="btn btn-success">Salvar</button>--%>
							<button type="button" class="btn btn-success" value="Register" onclick="removeMaskAndSubmit()">Salvar</button>
                    	</div>

						<div class="col-md-2">
							<a href="<%= request.getHeader("Referer") %>" class="btn btn-primary">Voltar</a>
						</div>
                    </div>

                </form:form>

    </div>

	<script>
		function removeMaskAndSubmit() {
			// Obter o valor do campo orcamento
			var orcamentoInput = document.getElementById('orcamento');
			var orcamentoValue = orcamentoInput.value;

			// Remover o prefixo "R$" e substituir vírgulas por ponto
			orcamentoValue = orcamentoValue.replace('R$', '').replace(/\./g, '').replace(",", ".");

			// Atualizar o valor no campo
			orcamentoInput.value = orcamentoValue;

			// Submeter o formulário
			document.forms["project"].submit();
		}
	</script>

    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Edit Failure") {
        				Command: toastr["error"]("Something went wrong with the edit.")
        			}

        			toastr.options = {
                          "closeButton": true,
                          "debug": false,
                          "newestOnTop": false,
                          "progressBar": true,
                          "positionClass": "toast-top-right",
                          "preventDuplicates": false,
                          "showDuration": "300",
                          "hideDuration": "1000",
                          "timeOut": "5000",
                          "extendedTimeOut": "1000",
                          "showEasing": "swing",
                          "hideEasing": "linear",
                          "showMethod": "fadeIn",
                          "hideMethod": "fadeOut"
                        }
        	    }
            </script>

</body>

</html>