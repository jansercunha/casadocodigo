
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />


<tags:pageTemplate titulo="Usuarios">
	<jsp:body>
	<div class="container">
		<h1><fmt:message key="usuario.cadastro"/></h1>
		<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post" commandName="usuario" enctype="multipart/form-data" >
			<div class="form-group">
				<label><fmt:message key="usuario.nome"/></label>
				<form:input path="nome" cssClass="form-control" style="width: 100%"/>
				<form:errors path="nome" />
			</div>
			<div class="form-group">
		        <label><fmt:message key="usuario.email"/></label>
				<form:input path="email" cssClass="form-control" style="width: 100%"/>
		        <form:errors path="email" />
			</div>
			<div class="form-group">
		        <label><fmt:message key="usuario.senha"/></label>
				<form:password path="senha" cssClass="form-control" />
				<form:errors path="senha" />
			</div>
			<div class="form-group">
		        <label><fmt:message key="usuario.repetirsenha"/></label>
				<form:password path="repetirSenha" cssClass="form-control" />
		        <form:errors path="repetirSenha" />
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
	<br/><br/><br/><br/>
	</jsp:body>
</tags:pageTemplate>