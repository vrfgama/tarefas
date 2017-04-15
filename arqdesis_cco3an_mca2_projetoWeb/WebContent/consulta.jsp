<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.Usuario" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Usu�rio</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />
	<!-- Container Principal -->	 
	<div id="main" class="container">  
		<h3 class="page-header">Consultar Usu�rio</h3>	
		<div id="painel" class="row">
			
			<%Usuario usuario= (Usuario)request.getAttribute("usuario"); %> 
			<strong>ID:</strong>   ${usuario.id}<br>
			<strong>Senha:</strong>   ${usuario.senha}<br>
			<strong>Nome:</strong>   ${usuario.nome}<br>
			<strong>CPF:</strong>   ${usuario.cpf}<br>
			<strong>Fun��o:</strong>   <%=funcao(usuario.getPerfil())%><br>
			<strong>Autorizado a config. temperatuta?:   </strong><%= temp(usuario.isMudaTemp())%><br>
			<strong>Jornada de trabalho:</strong><br>
			<strong>Hora inicial:</strong>   ${usuario.horaEnt}   <strong>Hora Final:</strong>   ${usuario.horaSai}<br>
			<strong>CNPJ da empresa em que trabalha:</strong>   ${usuario.cnpj}<br>
	
    	</div>      
     </div>   
         
    <%! String funcao(int perfil){
		if(perfil==0) return "Funcion�rio";
		else if(perfil==1) return "Atendente";
		else return "Sindico";
		} 
				
		String temp(boolean t){
		if(t==true) return "Sim";
		else return "N�o";
	} %>    
	
</body>
</html>