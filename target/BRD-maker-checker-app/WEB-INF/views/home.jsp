<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home Page</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/home.css">

</style>
</head>
<body>
<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
	<a href="#" class="navbar-brand"><i class="fa fa-cube"></i>BRD<b>Portal</b></a>
    <div style="width: 100px;"></div>
    <a href="#" class="nav-item nav-link active c_nav_link"><span>Home</span></a>
    <a href="#" class="nav-item nav-link c_nav_link"><span>Update</span></a>
    <a href="#" class="nav-item nav-link c_nav_link"><span>Delete</span></a>
	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
		<div class="navbar-nav ml-auto">

		<form class="navbar-form form-inline">
			<div class="input-group search-box">
				<input type="text" id="search" class="form-control" placeholder="Search here...">
				<span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
			</div>
		</form>
			<div class="nav-item dropdown">
				<a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img src="https://www.tutorialrepublic.com/examples/images/avatar/3.jpg" class="avatar" alt="Avatar"> Antonio Moreno <b class="caret"></b></a>
				<div class="dropdown-menu">
					<a href="#" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a>
					<a href="#" class="dropdown-item"><i class="fa fa-calendar-o"></i> Calendar</a>
					<a href="#" class="dropdown-item"><i class="fa fa-sliders"></i> Settings</a>
					<div class="divider dropdown-divider"></div>
					<a href="#" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Logout</a>
				</div>
			</div>
		</div>

	</div>
    <!-- ------ -->

</nav>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>