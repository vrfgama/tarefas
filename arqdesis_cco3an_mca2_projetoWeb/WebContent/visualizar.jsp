<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Usuario" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Consultar Usuário</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                <!-- Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Usuário</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir este usuário?
                            </div>
                            <div class="modal-footer">
                                <form action="crudUsuario" method="post">
                                    <input type="hidden" name="id" value="${usuario.id}" />
                                    <button type="submit" class="btn btn-primary" name="command" value="Remover">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <!-- Barra superior com os menus de navegação -->
				<c:import url="menu.jsp"/>
                <!-- Container Principal -->
				
                <div id="main" class="container">
                    <h3 class="page-header">Visualizar Usuário # ${usuario.id}</h3>
                            
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>ID</strong>
                            </p>
                            <p>
                                ${usuario.id}
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Senha</strong>
                            </p>
                            <p>
                                ${usuario.senha}
                            </p>
                        </div>
                    </div> 
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>Nome</strong>
                            </p>
                            <p>
                                ${usuario.nome}
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <p><strong>CPF</strong>
                            </p>
                            <p>
                                ${usuario.cpf}
                            </p>
                        </div>
                    </div>
                    <div class="row">    
                        <div class="col-md-12">
                            <p><strong>Função</strong>
                            </p>
                            <p>
								<c:if test="${usuario.perfil == 0}"><p>Funcionário</p></c:if>
								<c:if test="${usuario.perfil == 1}"><p>Atendente</p></c:if>
								<c:if test="${usuario.perfil == 2}"><p>Síndico</p></c:if>
                            </p>
                        </div>
                    </div>
                     <div class="row">    
                        <div class="col-md-12">
                            <p><strong>Autorizado a config. temperatuta?</strong>
                            </p>
								 <c:if test="${usuario.mudaTemp == true}"><p>Sim</p></c:if>
                                 <c:if test="${usuario.mudaTemp == false}"><p>Não</p></c:if>															 	
                         </div>
                    </div>
                    <div class="row">
                    	
                        <div class="col-md-12">
                        	<p><strong>Jornada de trabalho</strong></p>
                        </div>
                        <div class="col-md-6">	
                            <p><strong>Hora inicial</strong>
                            </p>
                            <p>
                                ${usuario.horaEnt}
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Hora Final</strong>
                            </p>
                            <p>
                                ${usuario.horaSai}
                            </p>
                        </div>
                    </div>
                     <div class="row">    
                        <div class="col-md-12">
                            <p><strong>CNPJ da empresa em que trabalha</strong>
                            </p>
                            <p>
                                ${usuario.cnpj}
                            </p>
                        </div>
                    </div>
     
                    <hr />
                    <div id="actions" class="row">
                        <div class="col-md-12">
                            <a href="crudUsuario?command=Editar&id=${usuario.id}" class="btn btn-primary">Editar</a>
                            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                            <!-- <a href="crudUsuario?command=listar" class="btn btn-default">Voltar</a> -->
                            <a href="listar.jsp" class="btn btn-default">Voltar</a>   
                        </div>
                    </div>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>