<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2017/6/20
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/form-elements.css">
    <link rel="stylesheet" href="css/style.css">
    <style type="text/css">
        body{background: url(imgs/bg.jpg) no-repeat center fixed;background-size: cover}
    </style>

    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>用户登录</title>
</head>
<body>
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>欢迎使用</strong> 石油管道综合管理平台</h1>
                    <div class="description">
                        <p>
                            这是一个集成管道路由规划，任务分派，信息维护等常用功能的综合管理平台
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Welcome to visit our site</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="user_login.action" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
</body>
</html>
