<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
	<!-- link css -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
	<div id = "wrapper">
		<div id ="header">
			<h2>Customer Relationship Manager Application</h2>
		</div>
	</div>
	
	<div id ="container">
		<div id = "content">
		<!-- button for add customer -->
		<!-- when user clicks spring will call showformforadd -->
		<input type="button" value= "Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>
		
		<!-- search box -->
         <form:form action="search" method="GET">
         Search customer: <input type="text" name="theSearchName"/>
         <input type="submit" value="Search" class="add-button"/>
         </form:form>
		
			<!-- table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				
				<!-- loop over customer in list -->
				<c:forEach var="tempCustomer" items="${customers}">
				<!-- update link -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
				<!-- delete link -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id }"/>
				</c:url>
				
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
						<a href="${updateLink}">Update Details</a>
						|
						<a href="${deleteLink}" onclick="if (!(confirm('Customer info will be deleted ?'))) return false">Delete Customer</a>
						</td>
						
					</tr>
					
					
				</c:forEach>
				
			</table>
			
		</div>
	
	</div>
	
	
	
	
</body>

</html>