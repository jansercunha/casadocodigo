
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />


<tags:pageTemplate titulo="Roles">
	<jsp:body>
	<div class="container">
		<form:form action="${s:mvcUrl('RC#alterarPermissoes').build() }" method="post" enctype="multipart/form-data" modelAttribute="usuario">
			<h1><fmt:message key="role.cadastro"/> ${usuario.nome}</h1>
			<div class="form-group">
				<label><fmt:message key="role.roles"/>:</label><br/>
				<form:checkboxes items="${listaRoles}" path="roles" itemValue="nome" cssClass="form-check-input" delimiter="<br/>" />
				<input type="hidden" name="email" value="${usuario.email}"/>
			</div>
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form:form>
	</div>
	<br/><br/><br/><br/>
	</jsp:body>
</tags:pageTemplate>