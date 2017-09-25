<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="menu.jsp" />
	<!-- Container Principal -->

	<div id="main" class="container">
		<h3 class="page-header">Falha ao realizar a tarefa!</h3>
		<div id="actions" class="row">
    	<div class="col-md-12">
        	<a href="listar.jsp" class="btn btn-default">Voltar</a>
        </div>
    </div>
	</div>
	
</body>
</html>