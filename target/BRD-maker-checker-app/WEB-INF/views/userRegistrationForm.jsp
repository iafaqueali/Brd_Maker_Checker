<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <link type="text/css"rel="stylesheet"href="${pageContext.request.contextPath}/resources/css/loginForm.css">

    <head>
    <title>User Registration Page</title>

    </head>
    <body>
     <div class="inner-container">
          <div class="box">
            <h1>User Registration</h1>
            <form:form method="post" modelAttribute="user" action="saveuser">
              <div class="input-box">
                <i class="fa fa-user" aria-hidden="true">
                  <form:input type="text" path="username" placeholder="Enter username"
                /></i>
              </div>

              <div class="input-box">
                <i class="fa fa-lock">
                  <form:input type="password" path="password" placeholder="Enter password" />
                </i>
              </div>

                  <form:select path="roleType" items="${roleTypeItems}" class="input-box"/>
              <button type="submit" class="btn-sign_in">Register</button>
            </form:form>
<p>Already Have an account? <span></span><a href="loginform" style="color: #0d6810;">Login here</a></p>
          </div>
        </div>

    </body>
    </html>
