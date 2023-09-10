<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
	<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/style.css" />	<!-- or you can use as href="../css/style.css" -->
	<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath }/css/add-customer-style.css" /> <!-- or you can use as href="../css/add-customer-style.css" -->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Customer Form</h3>
		
		<form:form action="saveOrUpdate" method="post" modelAttribute="customer">
			<table>
				<tbody>
					<!-- Not displaying customer id to end user, sending as hidden to update the existing customer instead of creating a new customer for updation -->
					<form:hidden path="id" />	<!-- id will be null for new customer, and send old id value for old customer for updation -->
				
					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName" /></td>	<!-- To access the customer object field in spring form, it should be saved in model else gives error and same will be used to access the form data after submitting the form in controller -->
					</tr>
					
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td>Email :</td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	
	<div>
		<center>
			<p>
				<a href="${ pageContext.request.contextPath }/customer/list">Go Back to View All Records</a>	
			</p>
		</center>
	</div>
</body>
</html>