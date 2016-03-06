<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Static Top Navbar Example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"  rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<c:url value="/resources/bootstrap/assets/css/ie10-viewport-bug-workaround.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/bootstrap/navbar-static-top.css"></c:url>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/resources/bootstrap/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<c:url value="/resources/bootstrap/assets/js/ie-emulation-modes-warning.js"/>"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/myweb/">My Restaurant</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ><a href="/myweb/home">Home</a></li>
            <li><a href="/myweb/menuList">Menus</a></li>
            
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Order<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/myweb/orders/1">Lunch</a></li>
                <li><a href="/myweb/orders/2">Dinner</a></li>
              </ul>
            </li>
            
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/myweb/admin">Admin</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manager<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/myweb/foods">Foods</a></li>
                <li><a href="/myweb/menus">Menus</a></li>
                <!--  <li><a href="/myweb/orderList">OrderList</a></li>-->
              </ul>
            </li>
            </sec:authorize>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <sec:authorize access="isAnonymous()">
            <li><a href="/myweb/userLogin">Login</a></li>
          </sec:authorize>
          <sec:authorize access="isAnonymous()">
          <li><a href="/myweb/register">Register</a></li>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
          	<li><a href="#"><sec:authentication property="principal.username" /></a></li>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <li><a href="/myweb/logout">Logout</a></li>
          </sec:authorize>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


   

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
