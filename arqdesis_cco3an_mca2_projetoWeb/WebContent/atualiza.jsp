<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.Usuario" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados do Usu�rio Atualizados</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />
	<!-- Container Principal -->
	
	<div id="main" class="container">
		<h3 class="page-header">Alterar Usu�rio</h3>	
		<div class="row">

		<%Usuario antigo= (Usuario)request.getAttribute("antigo"); %>	
		<h3>Dados antigos</h3>
		<strong>ID:</strong>   ${antigo.id}<br>
		<strong>Senha:</strong>   ${antigo.senha}<br>
		<strong>Nome:</strong>   ${antigo.nome}<br>
		<strong>CPF:</strong>   ${antigo.cpf}<br>
		<strong>Fun��o:</strong>   <%= funcao(antigo.getPerfil()) %> <br>
		<strong>Autorizado a config. temperatuta?:</strong>   <%= temp(antigo.isMudaTemp()) %> <br>
		<strong>Jornada de trabalho:</strong><br>
		<strong>Hora inicial:</strong>   ${antigo.horaEnt}   <strong>Hora Final:</strong>   ${antigo.horaSai}<br>
		<strong>CNPJ da empresa em que trabalha:</strong>   ${antigo.cnpj}<br><br>
           
        <%Usuario novo= (Usuario)request.getAttribute("novo"); %>   
    	<h3>Dados atualizados</h3>
    	<strong>ID:</strong>   ${novo.id}<br>
		<strong>Senha:</strong>   ${novo.senha}<br>
		<strong>Nome:</strong>   ${novo.nome}<br>
		<strong>CPF:</strong>   ${novo.cpf}<br>
		<strong>Fun��o:</strong>   <%= funcao(novo.getPerfil()) %> <br>
		<strong>Autorizado a config. temperatuta?:</strong>   <%= temp(novo.isMudaTemp()) %> <br>
		<strong>Jornada de trabalho:</strong><br>
		<strong>Hora inicial:</strong>   ${novo.horaEnt}   <strong>Hora Final:</strong>   ${novo.horaSai}<br>
		<strong>CNPJ da empresa em que trabalha:</strong>   ${novo.cnpj}<br><br>  
	
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