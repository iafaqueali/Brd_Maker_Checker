<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/showCustomer.css">
<head>
<title>Show Customer Page</title>

</head>
<body>
<div class="container-xl min-vw-100">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Temp <b>Table</b></h2>
					</div> <c:if test="${not empty recordStatus}">
                                       <h2>${recordStatus}</h2>
                           </c:if>
                           <form action="../searchResultByStatus" method="post">
                           							<div class="row">
                           								<div class="form-group">
                           									<label for="exampleFormControlSelect1">select Record Status</label>
                           									<select class="form-control" name="recordStatus">
                           									  <option value="N">New</option>
                           									  <option value="M">Modified</option>
                           									  <option value="NR">New Rejected</option>
                           									  <option value="MR">Modified Rejected</option>

                           									</select>
                           							</div>
                           							<div style="width: 50px;"></div>
                           							<div class="form-group">
                           								<label for="exampleFormControlSelect1">select Flag Status</label>
                           								<select class="form-control" name="flagStatus">
                           								  <option value="1">Active</option>
                           								  <option value="0">InActive</option>
                           								</select>
                           						</div>
                           						<div><button type="submit" class="btn btn-success mt-4">search</button></div>
                           							</div>

                           						</form>

				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>id</th>
						<th>Customer Code</th>
						<th>Name</th>
						<th>Address1</th>
						<th>Address2</th>
						<th>Pin Code</th>
						<th>Email Address</th>
						<th>Contact Number</th>
						<th>Primary Contact Person</th>
						<th>Record Status</th>
						<th>Flag Status</th>
						<th>Create Date</th>
						<th>Created By</th>
						<th>Modified Date</th>
						<th>Modified By</th>
						<th>Authorized Date</th>
						<th>Authorized By</th>
						<th style="min-width: 200px;">Actions</th>

					</tr>
				</thead>
				<tbody>
				<c:forEach var="customer" items="${customerTempLst}">
					<tr>
						<td>${customer.customerID}</td>
						<td>${customer.customerCode}</td>
						<td>${customer.customerName}</td>
						<td>${customer.customerAddress1}</td>
						<td>${customer.customerAddress2}</td>
						<td>${customer.customerPinCode}</td>
						<td>${customer.emailAddress}</td>
						<td>${customer.contactNumber}</td>
						<td>${customer.primaryContactPerson}</td>
						<td>${customer.recordStatus}</td>
						<td>${customer.isActive}</td>
						<td>${customer.createdDate}</td>
						<td>${customer.createdBy}</td>
						<td>${customer.modifiedDate}</td>
						<td>${customer.modifiedBy}</td>
						<td>${customer.authorizedDate}</td>
						<td>${customer.authorizedBy}</td>

						<td>
							<a href="../modifycustomerform/${customer.customerCode}/${username}" class="edit edit_confirmation"><i class="material-icons" title="Edit">&#xE254;</i></a>
							<a href="../deletecustomer/${customer.customerCode}/${customer.recordStatus}/${username}" class="delete delete_confirmation"><i class="material-icons" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
						          </c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">Showing <b>the</b> number of <b></b> entries</div>
				<ul class="pagination">
					<li class="page-item disabled"><a href="#">Previous</a></li>
					<li class="page-item"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">2</a></li>
					<li class="page-item active"><a href="#" class="page-link">3</a></li>
					<li class="page-item"><a href="#" class="page-link">4</a></li>
					<li class="page-item"><a href="#" class="page-link">5</a></li>
					<li class="page-item"><a href="#" class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

----------------------------------------------------------
---------------------------------------------------------
<div class="container-xl min-vw-100">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Master <b>Table</b></h2>
					</div>

				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>id</th>
						<th>Customer Code</th>
						<th>Name</th>
						<th>Address1</th>
						<th>Address2</th>
						<th>Pin Code</th>
						<th>Email Address</th>
						<th>Contact Number</th>
						<th>Primary Contact Person</th>
						<th>Record Status</th>
						<th>Flag Status</th>
						<th>Create Date</th>
						<th>Created By</th>
						<th>Modified Date</th>
						<th>Modified By</th>
						<th>Authorized Date</th>
						<th>Authorized By</th>
						<th style="min-width: 200px;">Actions</th>


					</tr>
				</thead>
				<tbody>
				<c:forEach var="customer" items="${customerMasterLst}">
					<tr>
						<td>${customer.customerID}</td>
						<td>${customer.customerCode}</td>
						<td>${customer.customerName}</td>
						<td>${customer.customerAddress1}</td>
						<td>${customer.customerAddress2}</td>
						<td>${customer.customerPinCode}</td>
						<td>${customer.emailAddress}</td>
						<td>${customer.contactNumber}</td>
						<td>${customer.primaryContactPerson}</td>
						<td>${customer.recordStatus}</td>
						<td>${customer.isActive}</td>
						<td>${customer.createdDate}</td>
						<td>${customer.createdBy}</td>
						<td>${customer.modifiedDate}</td>
						<td>${customer.modifiedBy}</td>
						<td>${customer.authorizedDate}</td>
						<td>${customer.authorizedBy}</td>

<td>
							<a href="../modifycustomerfrommasterform/${customer.customerCode}/${username}" class="edit"><i class="material-icons" title="Edit">&#xE254;</i></a>
							<a href="../deletecustomer/${customer.customerCode}/${customer.recordStatus}/${username}" class="delete""><i class="material-icons" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
						          </c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">Showing <b>the</b> number of <b></b> entries</div>
					<ul class="pagination">
					<li class="page-item disabled"><a href="#">Previous</a></li>
					<li class="page-item"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">2</a></li>
					<li class="page-item active"><a href="#" class="page-link">3</a></li>
					<li class="page-item"><a href="#" class="page-link">4</a></li>
					<li class="page-item"><a href="#" class="page-link">5</a></li>
					<li class="page-item"><a href="#" class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>









<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var elems = document.getElementsByClassName('edit_confirmation');
    var confirmIt = function (e) {
        if (!confirm('Are you sure edit?')) e.preventDefault();
    };
    for (var i = 0, l = elems.length; i < l; i++) {
        elems[i].addEventListener('click', confirmIt, false);
    }
</script>
<script type="text/javascript">
    var elems = document.getElementsByClassName('delete_confirmation');
    var confirmIt = function (e) {
        if (!confirm('Are you sure to delete?')) e.preventDefault();
    };
    for (var i = 0, l = elems.length; i < l; i++) {
        elems[i].addEventListener('click', confirmIt, false);
    }
</script>
</body>
</html>
</body>
</html>
