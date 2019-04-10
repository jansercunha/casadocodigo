<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Usuarios">
	<jsp:body>
	<c:if test="${not empty message }">
		<h1 class="cdc-call">${message }</h1>
	</c:if>
	<div class="container">
		<br/>
		<a href="${s:mvcUrl('UC#form').build() }" rel="nofollow"><fmt:message key="usuario.novo"/></a>
	
		<br/>
		<h1><fmt:message key="usuario.titulo"/></h1>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="usuario.nome"/></th>
				<th><fmt:message key="usuario.email"/></th> 
				<th><fmt:message key="usuario.role"/></th> 
				<th></th> 
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.roles}</td>
					<td align="center"><a href=""><img alt="Adicionar" src="${contextPath}resources/imagens/adicionar.png"></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	</jsp:body>
</tags:pageTemplate>