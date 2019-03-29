<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Pedidos">
	<jsp:body>
	<div class="container">
		<h1><fmt:message key="pedido.titulo"/></h1>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="pedido.id"/></th>
				<th><fmt:message key="pedido.valor"/></th>
				<th><fmt:message key="pedido.data"/></th> 
				<th><fmt:message key="pedido.titulos"/></th>
			</tr>
			<c:forEach items="${pedidos}" var="pedido">
				<tr>
					<td>${pedido.id}</td>
					<td align="right" ><fmt:formatNumber value="${pedido.valor}" type="currency" currencySymbol="" />  </td>
					<td><fmt:formatDate value="${pedido.data.time}" pattern="dd/MM/yyyy"/></td>
					<td>${pedido.titulos} </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	</jsp:body>
</tags:pageTemplate>