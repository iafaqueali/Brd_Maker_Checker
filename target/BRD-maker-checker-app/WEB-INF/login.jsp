<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/login.css">
<head>
<title>Login Page</title>

</head>
<body>
 <div class="inner-container">
      <div class="box">
        <h1>Login</h1>
        <form>
          <div class="input-box">
            <i class="fa fa-user" aria-hidden="true">
              <input type="text" name="user_name" placeholder="username"
            /></i>
          </div>

          <div class="input-box">
            <i class="fa fa-lock">
              <input type="password" name="password" placeholder="password" />
            </i>
          </div>

          <button type="submit" class="btn-sign_in">Sign in</button>
        </form>

        <!--
        <p>Not a member? <span>Sign Up</span></p> -->
      </div>
    </div>

</body>
</html>
