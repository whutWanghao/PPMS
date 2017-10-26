<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2017/6/30
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
    <meta charset="UTF-8">
    <title>石油管道工程管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-dropdown.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/ajaxutils.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminUpdateInfo.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminUpdatePwd.js"></script>

</head>

<body class="bootstrap-admin-with-small-navbar">
<nav class="navbar navbar-inverse navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="collapse navbar-collapse main-navbar-collapse">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/admin.jsp"><strong>欢迎使用石油管道工程管理系统</strong></a>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i class="glyphicon glyphicon-user"></i> 欢迎您， <s:property value="#session.admin.name"/> <i class="caret"></i></a>

                            <ul class="dropdown-menu">
                                <li><a href="#updateinfo" data-toggle="modal">个人资料</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
                                <li role="presentation" class="divider"></li>
                                <!-- href="#identifier"  来指定要切换的特定的模态框（带有 id="identifier"）。-->
                                <li><a href="${pageContext.request.contextPath}/adminLoginAction_logout.action">退出</a></li>
                            </ul>

                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <!-- left, vertical navbar & content -->
    <div class="row">
        <!-- left, vertical navbar -->
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li>
                    <a href="${pageContext.request.contextPath}/employeeAction_findEmployeeByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 员工信息管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/departmentAction_findDepartmentByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 部门信息管理</a>
                </li>

                <s:if test="#session.admin.authorization.superSet==1"><!-- 对超级管理员和普通管理员进行权限区分 -->
                <li>
                    <a href="${pageContext.request.contextPath}/admin/adminManageAction_findAdminByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 管理员管理</a>
                </li>
                </s:if>



            </ul>




        </div>

        <!-- content -->
        <div class="col-md-10">








            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">员工信息管理</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>根据员工编号、员工名称查询员工基本信息</li>
                                <li>添加、修改、删除员工</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">部门信息管理</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>根据分类名称查询部门信息</li>
                                <li>添加、修改、删除部门分类</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">地图展示</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>1</li>
                                <li>1</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">2</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>2</li>
                                <li>2</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">3</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>3</li>
                                <li>3</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">4</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>4</li>
                                <li>4</li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>


            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">5</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>5</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">6</div>
                        </div>
                        <div class="bootstrap-admin-panel-content">
                            <ul>
                                <li>6</li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>










    <!------------------------------修改密码模糊框-------------------------------->

    <form class="form-horizontal">   <!--保证样式水平不混乱-->
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="updatepwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">
                            修改密码
                        </h4>
                    </div>

                    <div class="modal-body">

                        <!--正文-->
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">原密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="oldPwd"  placeholder="请输入原密码">
                                <label class="control-label" for="oldPwd" style="display: none;"></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">新密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="newPwd"  placeholder="请输入新密码">
                                <label class="control-label" for="newPwd" style="display: none;"></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">确认密码</label>
                            <div class="col-sm-7">
                                <input type="password" class="form-control" id="confirmPwd"  placeholder="请输入确认密码">
                                <label class="control-label" for="confirmPwd" style="display: none;"></label>
                            </div>
                        </div>
                        <!--正文-->


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" id="update_adminPwd">
                            修改
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>

    </form>
    <!-------------------------------------------------------------->









    <!-------------------------个人资料模糊框------------------------------------->

    <form class="form-horizontal">   <!--保证样式水平不混乱-->
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="updateinfo" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title" id="ModalLabel">
                            个人资料
                        </h4>
                    </div>

                    <div class="modal-body">

                        <!--正文-->
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">用户名</label>
                            <div class="col-sm-7">

                                <input type="text" class="form-control" id="username"  value='<s:property value="#session.admin.username"/>'>
                                <label class="control-label" for="username" style="display: none;"></label>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">真实姓名</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="name"  placeholder="请输入您的真实姓名" value='<s:property value="#session.admin.name"/>'>
                                <label class="control-label" for="name" style="display: none;"></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">联系号码</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="phone"  placeholder="请输入您的联系号码" value='<s:property value="#session.admin.phone"/>'>
                                <label class="control-label" for="phone" style="display: none;"></label>
                            </div>
                        </div>

                        <!--正文-->


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" id="admin_updateInfo" >
                            修改
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>

    </form>
    <!-------------------------------------------------------------->




    <div class="modal fade" id="modal_info" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="infoModalLabel">提示</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12" id="div_info"></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="btn_info_close" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>





</body>
</html>