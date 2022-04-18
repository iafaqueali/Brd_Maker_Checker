<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home Page</title>
  <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/homeLayout/layout/styles/layout.css">
   <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/customerRegistrationForm.css">
</style>
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
 <c:if test="${not empty customerSuccessfullyAdd}">
             <h2>${customerSuccessfullyAdd}</h2>
 </c:if>

<!-- Top Background Image Wrapper -->
<div class="bgded overlay padtop" style="background-image:url('https://rb.gy/uxsxzb');">
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <header id="header" class="hoc clear">
    <div id="logo" class="fl_left">
      <!-- ################################################################################################ -->
      <h1><a href="index.html">BRDApp</a></h1>
      <!-- ################################################################################################ -->
    </div>
    <nav id="mainav" class="fl_right">
      <!-- ################################################################################################ -->
      <ul class="clear">
        <li class="active" style="float:left;"><a href="index.html">Home</a></li>
        	<c:if test="${not empty maker}">
        <li><a class="drop" href="#">Maker</a>
          <ul>
            <li><a href="javascript:void(0);" onclick="return customerRegistrationForm();">Add</a></li>
            <li><a href="pages/full-width.html">Search</a></li>
            <li><a href="pages/sidebar-left.html">Clear</a></li>
             <li><a href="showcustomers/${maker}">View All Customers</a></li>


          </ul>
        </li>
        </c:if>
        <c:if test="${not empty checker}">
        <li><a class="drop" href="#">Checker</a>
          <ul>
            <li><a href="showcustomersbychecker/${checker}">View All Customer</a></li>
            <li><a class="drop" href="#">Search</a>
              <ul>
                <li><a href="#">Level 3</a></li>
                <li><a href="#">Level 3</a></li>
                <li><a href="#">Level 3</a></li>
              </ul>
            </li>
            <li><a href="#">Clear</a></li>
          </ul>
        </li>
        </c:if>
                                	<c:if test="${not empty noneUser}">
                                	<li><a href="loginform">Login</a></li>
                                </c:if>
                                <c:if test="${not empty loggedUser}">
                                <li>${loggedUser.username}</li>
                                </c:if>

        <c:if test="${empty noneUser}">
                                         	<li><a href="home">Logout</a></li>
 </c:if>


      </ul>
      <!-- ################################################################################################ -->
    </nav>

  </header>
  <!-- ################################################################################################ -->
<c:if test="${not empty maker}">
<div class="inner-container" id="customerRegistrationFormDiv" style="margin-top: -400px; display:none;">
    <div class="box">
      <h1>Customer Entry</h1>
      <form:form method="post" modelAttribute="customer" action="addcustomer">
      			<form:input class="form-control" path="customerID" type="number" placeholder="Enter Customer Id" required="true" />
      			<form:input class="form-control" path="customerCode" type="text" placeholder="Enter Customer Code" required="true" />
      			<form:input class="form-control" path="customerName" type="text" placeholder="Enter Customer Name" required="true" />
      			<form:input class="form-control" path="customerPinCode" type="text" placeholder="Enter Pin Code" required="true" />
      			<form:input class="form-control" path="emailAddress" type="email" placeholder="Enter Email Address" required="true" />
      			<form:input class="form-control" path="contactNumber" type="text" placeholder="Enter Contact Number" />
      			<form:input class="form-control" path="primaryContactPerson" type="text" placeholder="Enter primary Contact Person name" required="true" />
      			<form:input class="form-control" path="createdBy" type="text" value="${maker}"  required="true" />
      			<form:textarea style="height: 60px;" class="form-control" path="customerAddress1" type="text"  placeholder="Enter address1" required="true"></form:textarea>
      			<form:textarea style="height: 60px;" class="form-control" path="customerAddress2" type="text"  placeholder="Enter address2" ></form:textarea>

      			   <form:select path="isActive" items="${flagStatus}" class="form-select mt-3 form-select-lg mb-3 flag_status" aria-label=".form-select-lg example"/>
      			<button type="submit">Save</button>
      		  </form:form>
    </div>
    </div>
</c:if>
<!-- ################################################################################################ -->















  <!-- ################################################################################################ -->
  <!-- ################################################################################################ -->
  <div id="pageintro" class="hoc clear">
    <!-- ################################################################################################ -->
    <article>
      <h3 class="heading">Welcome to Our Portal</h3>
      <p>Hello..................................................................................................................................................</p>

    </article>
    <!-- ################################################################################################ -->
  </div>
  <!-- ################################################################################################ -->
</div>
<!-- End Top Background Image Wrapper -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <section id="ctdetails" class="hoc clear">
    <!-- ################################################################################################ -->
    <ul class="nospace clear">
      <li class="one_quarter first">
        <div class="block clear"><a href="#"><i class="fas fa-phone"></i></a> <span><strong>Give us a call:</strong> +00 (123) 456 7890</span></div>
      </li>
      <li class="one_quarter">
        <div class="block clear"><a href="#"><i class="fas fa-envelope"></i></a> <span><strong>Send us a mail:</strong> support@domain.com</span></div>
      </li>
      <li class="one_quarter">
        <div class="block clear"><a href="#"><i class="fas fa-clock"></i></a> <span><strong> Mon. - Sat.:</strong> 08.00am - 18.00pm</span></div>
      </li>
      <li class="one_quarter">
        <div class="block clear"><a href="#"><i class="fas fa-map-marker-alt"></i></a> <span><strong>Come visit us:</strong> Directions to <a href="#">our location</a></span></div>
      </li>
    </ul>
    <!-- ################################################################################################ -->
  </section>
</div>




<a id="backtotop" href="#top"><i class="fas fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="homeLayout/layout/scripts/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="homeLayout/layout/scripts/jquery.backtotop.js"></script>
<script src="homeLayout/layout/scripts/jquery.mobilemenu.js"></script>
<script>
function customerRegistrationForm() {
         document.getElementById("customerRegistrationFormDiv").style.display = "block";
     }
</script>


</body>
</html>