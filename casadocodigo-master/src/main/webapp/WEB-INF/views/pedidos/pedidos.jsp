<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="${pedido.titulo }">
	<jsp:body>
	<div class="container">
		<h1>Lista de Pedidos</h1>
<%-- 		<p> ${sucesso} </p> --%>
<%-- 		<p> ${falha} </p> --%>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>ID</th>
				<th>Valor</th>
				<th>Data pedido</th> 
				<th>Título do produto</th>
			</tr>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td><a
							href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build() }">${produto.titulo }</a> </td>
					<td>${produto.descricao }</td>
					<td>${produto.precos }</td>
					<td>${produto.paginas }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	</jsp:body>
</tags:pageTemplate>