<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>Lista de Pessoas</title>

    <link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

    <div class="container">

        <h1 class="p-3">Lista de Pessoas</h1>

        <form:form>

            <table class="table table-bordered">

				<tr>
            		<th>Id</th>
            		<th>Nome</th>
            		<th>Data de Nascimento</th>
					<th>CPF</th>
					<th>Funcionário</th>
					<th>Gerente</th>
            		<th>Editar</th>
            		<th>Apagar</th>
            	</tr>

            	<c:forEach var="person" items="${personList}">
                    <tr>
                		<td>${person.id}</td>
                		<td>${person.nome}</td>
                		<td>${person.dataNascimento}</td>
						<td>${person.cpf}</td>
						<td>${person.funcionario}</td>
						<td>${person.gerente}</td>
                		<td>
							<button type="button" class="btn btn-success">
                		    	<a href="/editPerson/${person.id}">Editar</a>
                			</button>
						</td>
                		<td>
							<button type="button" class="btn btn-danger">
                				<a href="/deletePerson/${person.id}">Apagar</a>
                			</button>
						</td>
                	</tr>
            	</c:forEach>

            </table>

        </form:form>

        <button type="button" class="btn btn-primary btn-block">
        	<a href="/addPerson">Adicionar</a>
        </button>

		<button type="button" class="btn btn-dark btn-block">
			<a href="/index.jsp">Voltar</a>
		</button>

    </div>

    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Save Success") {
        				Command: toastr["success"]("Salvo com sucesso!!")
        			} else if (msg == "Delete Success") {
        				Command: toastr["success"]("Apagado com sucesso!!")
        			} else if (msg == "Delete Failure") {
        			    Command: toastr["error"]("Ocorreu algum erro, não foi possível excluir registro")
        			} else if (msg == "Edit Success") {
        				Command: toastr["success"]("Atualizado com sucesso!!")
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