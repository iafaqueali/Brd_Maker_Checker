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
    <title>Login Page</title>

    </head>
    <body>
     <div class="inner-container">
          <div class="box">
            <h1>Login</h1>
            <form:form method="post" modelAttribute="user" action="login">
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
              <button type="submit" class="btn-sign_in">Login</button>
            </form:form>
<p>Not a member? <span></span><a href="userregistrationform" class="register_here">Register Here</a></p>
          </div>
        </div>

    </body>
    </html>
