<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read Page</title>
	<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" /> <!-- or you can use as href="../css/style.css" -->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<input type="button" value="Add Customer" 
				onclick="window.location.href='addForm'; return false;" 
				class="add-button" /> <!-- if clicked on button, then display addForm else display nothing, or you can use href as ./customer/addForm -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="customer" items="${ customers }">
					<c:url var="updateLink" value="updateForm">
						<c:param name="customerId" value="${ customer.id }"></c:param>	<!-- particular customer id to be sent for updation particular customer as query parameter -->
					</c:url>
				
					<c:url var="deleteLink" value="delete">
						<c:param name="customerId" value="${ customer.id }"></c:param>
					</c:url>
				
					<tr>
						<td>${ customer.firstName }</td>
						<td>${ customer.lastName }</td>
						<td>${ customer.email }</td>
						<td>
							<a href="${ updateLink }">UPDATE</a> <!-- update url will be crm/customer/updateForm?customerId=1, else will take default url crm/customer/list -->
										|
							<a href="${ deleteLink }" 
								onclick="if(!(confirm('Are you sure to delete this record ?'))) return false;">DELETE</a> <!-- delete url will be crm/customer/deleteForm?customerId=2, else will take default url crm/customer/list -->
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>