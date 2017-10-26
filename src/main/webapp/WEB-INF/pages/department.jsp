<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2017/8/16
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN" class="ax-vertical-centered">
<head>
    <meta charset="UTF-8">
    <title>部门信息管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-dropdown.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/ajaxutils.js"></script>

    <script src="${pageContext.request.contextPath}/js/deleteEmployee.js"></script>
    <script src="${pageContext.request.contextPath}/js/getEmployeeInfo.js"></script>
</head>

<body class="bootstrap-admin-with-small-navbar">
<nav class="navbar navbar-inverse navbar-fixed-top bootstrap-admin-navbar bootstrap-admin-navbar-under-small" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="collapse navbar-collapse main-navbar-collapse">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/main.jsp"><strong>欢迎使用石油管道工程管理系统</strong></a>
                    <ul class="nav navbar-nav navbar-right">
                        <s:if test="#session.reader!=null"><!-- 判断是否已经登录 -->
                        <li class="dropdown">
                            <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i class="glyphicon glyphicon-user"></i> 欢迎您，<s:property value="#session.reader.name"/> <i class="caret"></i></a>

                            <ul class="dropdown-menu">
                                <li><a href="#updateinfo" data-toggle="modal">个人资料</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="#updatepwd" data-toggle="modal">修改密码</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/readerLoginAction_logout.action">退出</a></li>
                            </ul>

                        </li>
                        </s:if>
                        <s:else><!-- 如果未登录，出现登录按钮 -->
                        <button type="button" class="btn btn-default btn-sm "  id="btn_login" style="margin: 10" data-dismiss="modal">登录</button>
                        </s:else>
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
                <li class="active">
                    <a href="${pageContext.request.contextPath}/employeeAction_findEmployeeByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 员工信息管理</a>
                </li>
                <s:if test="#session.reader!=null"><!-- 判断是否登录 -->
                <li>
                    <a href="${pageContext.request.contextPath}/reader/borrowAction_findMyBorrowInfoByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 借阅信息</a>
                </li>
                </s:if>

                <s:if test="#session.reader!=null"><!-- 判断是否登录 -->
                <li>
                    <a href="${pageContext.request.contextPath}/reader/forfeitAction_findMyForfeitInfoByPage.action"><i class="glyphicon glyphicon-chevron-right"></i> 逾期信息</a>
                </li>
                </s:if>


            </ul>
        </div>

        <!-- content -->
        <div class="col-md-10">







            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default bootstrap-admin-no-table-panel">
                        <div class="panel-heading">
                            <div class="text-muted bootstrap-admin-box-title">查询</div>
                            <a href="employeeAction_testJson.action">测试Json</a>
                        </div>
                        <div class="bootstrap-admin-no-table-panel-content bootstrap-admin-panel-content collapse in">
                            <form class="form-horizontal" action="${pageContext.request.contextPath}/employeeAction_queryEmployee.action" method="post">
                                <div class="col-lg-5 form-group">
                                    <label class="col-lg-4 control-label" for="ename">员工姓名</label>
                                    <div class="col-lg-8">
                                        <input class="form-control" id="ename" name="ename" type="text" value="">
                                    </div>
                                </div>

                                <div class="col-lg-5 form-group">
                                    <label class="col-lg-4 control-label" for="gender">员工性别</label>
                                    <div class="col-lg-8">
                                        <select class="form-control" id="gender" name="gender">
                                            <option value="-1">请选择</option>
                                            <option value="0">女</option>
                                            <option value="1">男</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-lg-5 form-group">
                                    <label class="col-lg-4 control-label" for="department">所在部门</label>
                                    <div class="col-lg-8">
                                        <input class="form-control" id="department" name="department" type="text" value="">
                                        <!-- <label class="control-label" for="query_bname" style="display: none;"></label> -->
                                    </div>
                                </div>

                                <div class="col-lg-5 form-group">
                                    <label class="col-lg-4 control-label" for="level">职位</label>
                                    <div class="col-lg-8">
                                        <input class="form-control" id="level" name="level" type="text" value="">
                                        <!-- <label class="control-label" for="query_bname2" style="display: none;"></label> -->
                                    </div>
                                </div>

                                <div class="col-lg-5 form-group">
                                    <label class="col-lg-4 control-label" for="eid">员工编号</label>
                                    <div class="col-lg-8">
                                        <input class="form-control" id="eid" name="eid" type="text" value="">
                                        <!-- <label class="control-label" for="query_bname2" style="display: none;"></label> -->
                                    </div>
                                </div>

                                <div class="col-lg-3 form-group">
                                    <button type="submit" class="btn btn-primary" id="btn_query" onclick="query()">查询</button>
                                </div>
                                <div class="col-lg-2 form-group">
                                    <button type="button" class="btn btn-primary"   data-toggle="modal" data-target="#addModal">添加</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <table id="data_list" class="table table-hover table-bordered" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>部门编号</th>
                            <th>部门名称</th>
                            <th>部门描述</th>
                            <th>成立日期</th>
                            <th>员工数</th>
                            <th>操作</th>
                        </tr>
                        </thead>


                        <!---在此插入信息-->
                        <s:if test="#request.pb.beanList!=null">
                            <s:iterator value="#request.pb.beanList" var="department">
                                <tbody>
                                <td><s:property value="#department.did"/></td>
                                <td><s:property value="#department.dname"/></td>
                                <td><s:property value="#department.ddesc"/></td>
                                <td><s:date name="#department.setdate" format="yyyy-MM-dd"/></td>
                                <td><s:property value="#department.employees.size()"/></td>
                                <td>
                                    <button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#findModal" onclick="getEmployeeInfo(<s:property value="#employee.eid"/>)">查看</button>
                                    <button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#updateModal" id="btn_update" onclick="updateEmployee(<s:property value="#employee.eid"/>)">修改</button>
                                    <button type="button" class="btn btn-danger btn-xs" onclick="deleteEmployee(<s:property value="#employee.eid"/>)">删除</button>
                                </td>
                                </tbody>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            <tbody>
                            <td>暂无数据</td>
                            <td>暂无数据</td>
                            <td>暂无数据</td>
                            <td>暂无数据</td>
                            <td>暂无数据</td>
                            <td>暂无数据</td>
                            </tbody>
                        </s:else>

                    </table>


                    <s:if test="#request.pb!=null">

                        <%-- 定义页码列表的长度，5个长 --%>
                        <c:choose>
                            <%-- 第一条：如果总页数<=5，那么页码列表为1 ~ totaPage 从第一页到总页数--%>
                            <%--如果总页数<=5的情况 --%>
                            <c:when test="${pb.totalPage <= 5 }">
                                <c:set var="begin" value="1"/>
                                <c:set var="end" value="${pb.totalPage }"/>
                            </c:when>
                            <%--总页数>5的情况 --%>
                            <c:otherwise>
                                <%-- 第二条：按公式计算，让列表的头为当前页-2；列表的尾为当前页+2 --%>
                                <c:set var="begin" value="${pb.pageCode-2 }"/>
                                <c:set var="end" value="${pb.pageCode+2 }"/>

                                <%-- 第三条：第二条只适合在中间，而两端会出问题。这里处理begin出界！ --%>
                                <%-- 如果begin<1，那么让begin=1，相应end=5 --%>
                                <c:if test="${begin<1 }">
                                    <c:set var="begin" value="1"/>
                                    <c:set var="end" value="5"/>
                                </c:if>
                                <%-- 第四条：处理end出界。如果end>tp，那么让end=tp，相应begin=tp-4 --%>
                                <c:if test="${end>pb.totalPage }">
                                    <c:set var="begin" value="${pb.totalPage-4 }"/>
                                    <c:set var="end" value="${pb.totalPage }"/>
                                </c:if>
                            </c:otherwise>
                        </c:choose>


                        <div class="pull-right"><!--右对齐--->
                            <ul class="pagination">
                                <li class="disabled"><a href="#">第<s:property value="#request.pb.pageCode"/>页/共<s:property value="#request.pb.totaPage"/>页</a></li>
                                <li><a href="${pageContext.request.contextPath}/employeeAction_${pb.url }pageCode=1">首页</a></li>
                                <li><a href="${pageContext.request.contextPath}/employeeAction_${pb.url }pageCode=${pb.pageCode-1 }">&laquo;</a></li><!-- 上一页 -->
                                    <%-- 循环显示页码列表 --%>
                                <c:forEach begin="${begin }" end="${end }" var="i">
                                    <c:choose>
                                        <%--如果是当前页则设置无法点击超链接 --%>
                                        <c:when test="${i eq pb.pageCode }">
                                            <li class="active"><a>${i }</a><li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${pageContext.request.contextPath}/employeeAction_${pb.url }pageCode=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                    <%--如果当前页数没到总页数，即没到最后一页,则需要显示下一页 --%>
                                <c:if test="${pb.pageCode < pb.totalPage }">
                                    <li><a href="${pageContext.request.contextPath}/employeeAction_${pb.url }pageCode=${pb.pageCode+1}">&raquo;</a></li>
                                </c:if>
                                    <%--否则显示尾页 --%>
                                <li><a href="${pageContext.request.contextPath}/employeeAction_${pb.url }pageCode=${pb.totalPage}">尾页</a></li>
                            </ul>
                        </div>
                    </s:if>
                </div>
            </div>
        </div>
    </div>
</div>









<!--------------------------------------查看的模态框------------------------>
<form class="form-horizontal">   <!--保证样式水平不混乱-->
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="findModal" tabindex="-1" role="dialog" aria-labelledby="findModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="findModalLabel">
                        查看员工信息
                    </h4>
                </div>
                <div class="modal-body">

                    <!---------------------表单-------------------->
                    <div class="form-group">
                        <label for="findEid" class="col-sm-3 control-label">员工编号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findEid" readonly="readonly">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="findEname" class="col-sm-3 control-label">员工名称</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findEname"  readonly="readonly">

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="findGender" class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findGender"  readonly="readonly">

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="findBirthday" class="col-sm-3 control-label">出生日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findBirthday"  readonly="readonly">

                        </div>
                    </div>


                    <div class="form-group">
                        <label for="findJoindate" class="col-sm-3 control-label">入职日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findJoindate"  readonly="readonly">

                        </div>
                    </div>


                    <div class="form-group">
                        <label for="findPhone" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findPhone"  readonly="readonly">

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="findDeptId" class="col-sm-3 control-label">部门编号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findDeptId"  readonly="readonly">

                        </div>
                    </div>


                    <div class="form-group">
                        <label for="findDepartment" class="col-sm-3 control-label">所在部门</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findDepartment"  readonly="readonly">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="findLevel" class="col-sm-3 control-label">职位</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="findLevel"  readonly="readonly">

                        </div>
                    </div>


                    <div class="form-group">
                        <label for="findDescription" class="col-sm-3 control-label">部门简介</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" rows="3" id="findDescription" readonly="readonly"></textarea>
                        </div>
                    </div>

                    <!---------------------表单-------------------->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</form>
<!--------------------------------------查看的模糊框------------------------>

<!--------------------------------------添加员工模态框------------------------>
<form class="form-horizontal">   <!--保证样式水平不混乱-->
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">
                        添加新图书
                    </h4>
                </div>
                <div class="modal-body">

                    <!---------------------表单-------------------->

                    <div class="form-group">
                        <label for="addeid" class="col-sm-3 control-label">员工编号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="addeid"  placeholder="系统可以默认添加" >
                            <label class="control-label" for="addeid" style="display: none;"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addename" class="col-sm-3 control-label">员工姓名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="addename"  placeholder="请输入员工姓名">
                            <label class="control-label" for="addename" style="display: none;"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="adddept" class="col-sm-3 control-label">所在部门</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="adddept">
                                <option value="-1">请选择</option>
                            </select>
                            <label class="control-label" for="adddept" style="display: none;"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="addgender" class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="addgender">
                                <option value="-1">请选择</option>
                                <option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                            <label class="control-label" for="addgender" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="addbirthday" class="col-sm-3 control-label">出生日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="addbirthday"  placeholder="请输入出生日期">
                            <label class="control-label" for="addbirthday" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="addjoindate" class="col-sm-3 control-label">参加日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="addjoindate"  placeholder="请输入参加工作日期">
                            <label class="control-label" for="addjoindate" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="addphone" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="addphone"  placeholder="请输入联系电话">
                            <label class="control-label" for="addphone" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="addlevel" class="col-sm-3 control-label">职位</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" rows="3" id="addlevel" placeholder="请输入职位"></textarea>
                            <label class="control-label" for="addlevel" style="display: none;"></label>
                        </div>
                    </div>

                    <!---------------------表单-------------------->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" id="addEmployee">
                        添加
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>

<!-- 修改模态框（Modal） -->
<form class="form-horizontal">   <!--保证样式水平不混乱-->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="updateModalLabel">
                        修改员工信息
                    </h4>
                </div>
                <div class="modal-body">

                    <!---------------------表单-------------------->

                    <div class="form-group">
                        <label for="updateEid" class="col-sm-3 control-label">员工编号</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="updateEid"  placeholder="请输入正确的员工编号" readonly="readonly">
                            <label class="control-label" for="updateEid" style="display: none;"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="updateEname" class="col-sm-3 control-label">员工姓名</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="updateEname"  placeholder="请输入员工姓名">
                            <label class="control-label" for="updateEname" style="display: none;"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="updateDept" class="col-sm-3 control-label">所在部门</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="updateDept">
                                <option value="-1">请选择</option>
                            </select>
                            <label class="control-label" for="updateDept" style="display: none;"></label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="updateGender" class="col-sm-3 control-label">性别</label>
                        <div class="col-sm-7">
                            <select class="form-control" id="updateGender">
                                <option value="-1">请选择</option>
                                <option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                            <label class="control-label" for="updateGender" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="updateBirthday" class="col-sm-3 control-label">出生日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="updateBirthday"  placeholder="请输入出生日期,格式yyyy-MM-dd">
                            <label class="control-label" for="updateBirthday" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="updateJoindate" class="col-sm-3 control-label">参加日期</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="updateJoindate"  placeholder="请输入参加工作日期，格式yyyy-MM-dd"">
                            <label class="control-label" for="updateJoindate" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="updatePhone" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="updatePhone"  placeholder="请输入联系电话">
                            <label class="control-label" for="updatePhone" style="display: none;"></label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="updateLevel" class="col-sm-3 control-label">职位</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" rows="3" id="updateLevel" placeholder="请输入职位"></textarea>
                            <label class="control-label" for="updateLevel" style="display: none;"></label>
                        </div>
                    </div>

                    <!---------------------表单-------------------->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" id="updateEmployee">
                        修改
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</form>


</body>
<script src="${pageContext.request.contextPath}/js/addEmployee.js"></script>
<script src="${pageContext.request.contextPath}/js/updateEmployee.js"></script>

</html>
