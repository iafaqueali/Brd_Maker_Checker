<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home Page</title>
   <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/customerEntryForm.css">
</style>
</head>
<body>
          <div class="inner-container" id="customerRegistrationFormDiv">
              <div class="box">
                <h1>Customer Entry</h1>
                <form:form method="post" modelAttribute="customer" action="../../modifycustomerfrommaster">
                               <form:hidden  path="customerID" />
                               <form:hidden  path="customerCode" />
                			<form:input class="form-control" path="customerName" type="text"  placeholder="Enter Customer Name" required="true" />
                			<form:input class="form-control" path="customerPinCode" type="text" placeholder="Enter Pin Code" required="true" />
                			<form:input class="form-control" path="emailAddress" type="email" placeholder="Enter Email Address" required="true" />
                			<form:input class="form-control" path="contactNumber" type="text" placeholder="Enter Contact Number" />
                			<form:input class="form-control" path="primaryContactPerson" type="text" placeholder="Enter primary Contact Person name" required="true" />
                			<form:input class="form-control" path="modifiedBy" type="text" value="${username}"  required="true" />
                			<form:textarea style="height: 60px;" class="form-control" path="customerAddress1" type="text"  placeholder="Enter address1" required="true"></form:textarea>
                			<form:textarea style="height: 60px;" class="form-control" path="customerAddress2" type="text"  placeholder="Enter address2" ></form:textarea>

                			   <form:select path="isActive" items="${flagStatus}" class="form-select mt-3 form-select-lg mb-3 flag_status" aria-label=".form-select-lg example"/>
                			<button type="submit">Save</button>
                		  </form:form>
              </div>

</body>
</html>
</body>
</html>


