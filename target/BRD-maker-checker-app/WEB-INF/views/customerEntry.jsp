<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/customerEntry.css">

<head>
<title>Customer Entry Page</title>

</head>
<body>

	<div class="inner-container">
		<div class="box">
		  <h1>Customer Entry</h1>
		  <form>
			<input class="form-control" name="customerCode" type="text" placeholder="Enter Customer Code" required>
			<input class="form-control" path="customerName" type="text" placeholder="Enter Customer Name" required>
			<input class="form-control" path="pinCode" type="number" placeholder="Enter Pin Code" required>
			<input class="form-control" path="emailAddress" type="email" placeholder="Enter Email Address" required>
			<input class="form-control" path="contactNumber" type="number" placeholder="Enter Contact Number" required>
			<input class="form-control" path="primaryContactPerson" type="text" placeholder="Enter primary Contact Person name" required>
			<input class="form-control" path="primaryContactPerson" type="text" placeholder="Enter primary Contact Person name" required>
			<button type="submit">Save</button>
		  </form>
		</div>
	  </div>
</body>
</html>
</body>
</html>
