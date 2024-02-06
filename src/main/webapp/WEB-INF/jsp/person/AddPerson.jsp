<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Adicionar Pessoa</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>

    <script>
        $(document).ready(function () {
            $('.datepicker').datepicker({
                dateFormat: 'dd-mm-yy', // Formato da data
                changeMonth: true,
                changeYear: true
            });
        });
    </script>

</head>
<body>

    <div class="container">

        <h1 class="p-3"> Adicionar Pessoa </h1>

        <form:form action="/savePerson" method="post" modelAttribute="person">

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
                    <label class="col-md-3" for="dataNascimento">Aniversário</label>
                    <div class="col-md-6">
                        <form:input type="text" id="dataNascimento" path="dataNascimento" name="dataNascimento" class="datepicker" required="required" />
                    </div>
                </div>
            </div>

            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="cpf">CPF</label>
            		<div class="col-md-6">
            			<form:input type="text" path="cpf" id="cpf"
            				class="form-control input-sm" required="required" onkeypress="$(this).mask('000.000.000-00');"/>
            		</div>
            	</div>
            </div>

            <div class="row">
                <div class="form-group col-md-6">
                    <div class="form-group">
                        <label for="funcionario">Funcionário</label>
                        <div class="form-check">
                            <form:checkbox path="funcionario" id="funcionario" class="form-check-input"/>
                            <label class="form-check-label" for="funcionario">Ativo</label>
                        </div>
                    </div>
                </div>

                <!-- Segunda coluna -->
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="gerente">Gerente</label>
                        <div class="form-check">
                            <form:checkbox path="gerente" id="gerente" class="form-check-input"/>
                            <label class="form-check-label" for="gerente">Sim</label>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row p-2">
            	<div class="col-md-2">
            		<button type="submit" value="Register" class="btn btn-success">Salvar</button>
            	</div>

                <div class="col-md-2">
                    <a href="<%= request.getHeader("Referer") %>" class="btn btn-primary">Voltar</a>
                </div>
            </div>

        </form:form>

    </div>

    <script th:inline="javascript">
            window.onload = function() {

                var msg = "${message}";
                console.log(msg);
                if (msg == "Save Failure") {
    				Command: toastr["error"]("Something went wrong with the save.")
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