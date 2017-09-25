<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Usuário</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script>
	function formatar(mascara, documento) {
		var i = documento.value.length;
		var saida = mascara.substring(0, 1);
		var texto = mascara.substring(i)

		if (texto.substring(0, 1) != saida) {
			documento.value += texto.substring(0, 1);
		}
	}
</script>
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Usuário #${usuario.id }</h3>
		<!-- Formulario para alteração de clientes -->
		<form action="crudUsuario" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${usuario.id}" />
			<div class="row">

				<div class="form-group col-md-6">
					<label for="senha_usuario">Senha</label> <input type="text"
						class="form-control" name="senhaUsuario" id="senha_usuario"
						maxlength="4" placeholder="senha do usuário"
						value="${usuario.senha}">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome_usuario">Nome</label> <input type="text"
						class="form-control" name="nomeUsuario" id="nome_usuario"
						maxlength="50" placeholder="nome completo" value="${usuario.nome}">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="cpf_usuario">CPF</label> <input type="text"
						class="form-control" name="cpfUsuario" id="cpf_usuario"
						maxlength="14" placeholder="CPF do usuário" value="${usuario.cpf}"
						OnKeyPress="formatar('###.###.###-##', this)">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label for="funcao_usuario">Função</label><br> <input
						type="radio" class="radio-inline" id="funcao_funcionario"
						name="funcaoUsuario" value="0" checked/> <label>Funcionário</label><br>
					<input type="radio" class="radio-inline" id="funcao_atendente"
						name="funcaoUsuario" value="1" /> <label>Atendente</label><br>
					<input type="radio" class="radio-inline" id="funcao_sindico"
						name="funcaoUsuario" value="2" /> <label>Sindico</label><br>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="temp_usuario">Autorizado a Configurar
						Temperatura</label><br> <input type="radio" class="radio-inline"
						id="temp_usuario" name="tempUsuario" value="true" /> <label>Sim</label><br>
					<input type="radio" class="radio-inline" id="temp_usuario"
						name="tempUsuario" value="false" checked /> <label>Não</label><br>
				</div>
			</div>

			<div class="row">
				<label for="hr_usuario" class="form-group col-md-12">Jornada
					de Trabalho</label>
				<div class="form-group col-md-6">

					<label>Hora inicial</label> <input type="text" class="form-control"
						name="hrInicialUsuario" id="hr_inicial_usuario" maxlength="8"
						OnKeyPress="formatar('##:##:##', this)"
						placeholder="hora de inicio da jornada de trabalho"
						value="${usuario.horaEnt}">
				</div>
				<div class="form-group col-md-6">
					<label>Hora final</label> <input type="text" class="form-control"
						name="hrFinalUsuario" id="hr_final_usuario" maxlength="8"
						OnKeyPress="formatar('##:##:##', this)"
						placeholder="hora de término da jornada de trabalho"
						value="${usuario.horaSai}">
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="empresa_usuario">CNPJ da Empresa em que
						Trabalha</label> <input type="text" class="form-control"
						name="EmpresaUsuario" id="empresa_usuario" maxlength="18"
						OnKeyPress="formatar('##.###.###/####-##', this)"
						placeholder="CNPJ da empresa do usuário" value="${usuario.cnpj}">
				</div>
			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command" value="Atualizar">Salvar</button>
					<a href="listar.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>