<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="aa" uri="http://com.nerderg/ajaxanywhere" %>
<%--
  Created by IntelliJ IDEA.
  User: huhongchun
  Date: 2018/8/7
  Time: 下午6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/main.css" />
    <title>用户11</title>
</head>
<body>
<header class="navbar navbar-expand navbar-dark app-header">
    <div class="navbar-nav-scroll">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link">菜单1</a></li>
            <li class="nav-item"><a class="nav-link">菜单2</a></li>
            <li class="nav-item"><a class="nav-link">菜单3</a></li>
        </ul>
    </div>
</header>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <div class="col-12 col-md-3 col-xl-2 left-menu">
            <nav class="nav flex-column">
                <a href="#" class="nav-link active">Active</a>
                <a href="#" class="nav-link">Link</a>
                <a href="#" class="nav-link">Link</a>
                <a href="#" class="nav-link disabled">Disabled</a>
                <a href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                         class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单</a><a href="#"
                                                                                          class="nav-link">菜单</a><a
                    href="#" class="nav-link">菜单</a><a href="#" class="nav-link">菜单50</a>
            </nav>

        </div>
        <aa:zone id="myZone">
            <main class="col-12 col-md-9 bd-content" role="main">main</main>
        </aa:zone>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="<c:url value="/webjars/ajaxanywhere/2.1/aa.js"/>"></script>
</body>
</html>
