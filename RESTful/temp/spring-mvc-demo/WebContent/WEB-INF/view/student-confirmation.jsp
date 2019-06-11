<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- get foreach function for html from papa oracle -->

<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation Form</title>
</head>

<body>
	The student is confirmed: ${student.firstName} ${student.lastName} ${student.country}
	<br><br>
	Operating systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems }">
		<li>${temp}</li>
		</c:forEach>
	</ul>
	
	
</body>

</html>


