<%@ page import="com.model.Students" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>成绩查询</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="static/css/googleapisfonts.css" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <!-- adminpro icon CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/adminpro-custon-icon.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/meanmenu.min.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/jquery.mCustomScrollbar.min.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/data-table/bootstrap-table.css">
    <link rel="stylesheet" href="static/css/data-table/bootstrap-editable.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/normalize.css">
    <!-- charts CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/c3.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="static/css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="static/js/vendor/modernizr-2.8.3.min.js"></script>
    <script src="static/js/echarts.min.js"></script>
</head>

<body class="darklayout">
<%
    Students students=(Students) request.getSession().getAttribute("students");
    if(students==null){
        response.sendRedirect("index.jsp");
    }else{
        session.setAttribute("students",students);
%>
<!-- Header top area start-->
<div class="wrapper-pro">
    <div class="left-sidebar-pro">
        <nav id="sidebar">
            <div class="sidebar-header">
                <a href="#"><img src="static/img/message/1.jpg" alt="" />
                </a>
                <h3>${students.lpy_Sname15}</h3>
                <p>学生</p>
                <strong>AP+</strong>
            </div>
            <div class="left-custom-menu-adp-wrap">
                <ul class="nav navbar-nav left-sidebar-menu-pro">
                    <li class="nav-item">
                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-home"></i> <span class="mini-dn">主页</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="StuMain" class="dropdown-item">我的主页</a>
                            <a href="StuPersonal" class="dropdown-item">个人信息</a>
                        </div>
                    </li>
                    <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="fa big-icon fa-envelope"></i> <span class="mini-dn">查询</span> <span class="indicator-right-menu mini-dn"><i class="fa indicator-mn fa-angle-left"></i></span></a>
                        <div role="menu" class="dropdown-menu left-menu-dropdown animated flipInX">
                            <a href="StuCourse" class="dropdown-item">课程查询</a>
                            <a href="StuGrade" class="dropdown-item">成绩查询</a>
                            <a href="StuGPA" class="dropdown-item">平均绩点查询</a>
                            <a href="StuCredit" class="dropdown-item">已修学分查询</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- Header top area start-->
    <div class="content-inner-all">
        <div class="header-top-area">
            <div class="fixed-header-top">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-1 col-md-6 col-sm-6 col-xs-12">
                            <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
                                <i class="fa fa-bars"></i>
                            </button>
                            <div class="admin-logo logo-wrap-pro">
                                <a href="#"><img src="static/img/logo/log.png" alt="" />
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12" style="position:absolute;right: 200px;">
                            <div class="header-right-info">
                                <ul class="nav navbar-nav mai-top-nav header-right-menu">
                                    <li class="nav-item">
                                        <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
                                            <span class="adminpro-icon adminpro-user-rounded header-riht-inf"></span>
                                            <span class="admin-name">${students.lpy_Sname15}</span>
                                            <span class="author-project-icon adminpro-icon adminpro-down-arrow"></span>
                                        </a>
                                        <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated flipInX">
                                            <li><a href="stuChangePassword.jsp"><span class="adminpro-icon adminpro-locked author-log-ic"></span>修改密码</a>
                                            </li>
                                            <li><a href="index.jsp"><span class="adminpro-icon adminpro-locked author-log-ic"></span>退出登录</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Header top area end-->
        <!-- Breadcome start-->
        <div class="breadcome-area mg-b-30 small-dn">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="breadcome-list shadow-reset">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="breadcome-heading">
                                        <h2>欢迎使用高校成绩管理系统</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcome End-->
        <!-- Mobile Menu start -->
        <div class="mobile-menu-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="mobile-menu">
                            <nav id="dropdown">
                                <ul class="mobile-menu-nav">
                                    <li><a data-toggle="collapse" data-target="#Charts" href="#">主页 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul class="collapse dropdown-header-top">
                                            <li><a href="StuMain">我的主页</a>
                                            </li>
                                            <li><a href="StuPersonal">个人信息</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a data-toggle="collapse" data-target="#demo" href="#">查询 <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>
                                        <ul id="demo" class="collapse dropdown-header-top">
                                            <li><a href="StuCourse">课程查询</a>
                                            </li>
                                            <li><a href="StuGrade">成绩查询</a>
                                            </li>
                                            <li><a href="StuGPA">平均绩点查询</a>
                                            </li>
                                            <li><a href="StuCredit">已修学分查询</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Mobile Menu end -->
        <!-- Breadcome start-->
        <div class="breadcome-area mg-b-30 des-none">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="breadcome-list map-mg-t-40-gl shadow-reset">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <div class="breadcome-heading">
                                        <h2>Thanks for Visits</h2>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                    <ul class="breadcome-menu">
                                        <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                        </li>
                                        <li><span class="bread-blod">Dashboard</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcome End-->
        <!-- stockprice, feed area end-->
        <div class="admin-dashone-data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="sparkline8-list shadow-reset">
                            <div class="sparkline8-hd">
                                <div class="main-sparkline8-hd">
                                    <h1>学生成绩查询</h1>
                                    <div class="sparkline8-outline-icon">
                                        <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                        <span><i class="fa fa-wrench"></i></span>
                                        <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div>
                                        <form action="StuPersonalTermGrade" method="post" style="position:relative;float:left;">
                                            <select name="term" id="term" style="width: 320px;height: 35px;">
                                                <option value="全部学期">全部学期</option>
                                                <option value="大一">大一</option>
                                                <option value="大二">大二</option>
                                                <option value="大三">大三</option>
                                                <option value="大四">大四</option>
                                                <option value="一1">一1</option>
                                                <option value="一2">一2</option>
                                                <option value="二1">二1</option>
                                                <option value="二2">二2</option>
                                                <option value="三1">三1</option>
                                                <option value="三2">三2</option>
                                                <option value="四1">四1</option>
                                                <option value="四2">四2</option>
                                            </select>
                                            <input type="submit" class="btn btn-primary btn-sm" style="border-radius: 5px;width: 80px;" value="确定">
                                        </form>
                                    </div>
                                    <br>
                                    <br>
                                    <br>
                                    <div id="toolbar">
                                        <select class="form-control">
                                            <option value="">Export Basic</option>
                                            <option value="all">Export All</option>
                                            <option value="selected">Export Selected</option>
                                        </select>
                                    </div>
                                    <table id="table" data-toggle="table" data-pagination="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true" data-cookie-id-table="saveId" data-show-export="true" data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                        <tr>
                                            <th data-field="state" data-checkbox="true"></th>
                                            <th data-field="id" data-editable="true">学号</th>
                                            <th data-field="name" data-editable="true">姓名</th>
                                            <th data-field="classname" data-editable="true">班级</th>
                                            <th data-field="coursename" data-editable="true">课程名</th>
                                            <th data-field="credit" data-editable="true">学分</th>
                                            <th data-field="hour" data-editable="true">学时</th>
                                            <th data-field="term" data-editable="true">学期</th>
                                            <th data-field="grade" data-editable="true">成绩</th>
                                            <th data-field="gpa" data-editable="true">绩点</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="stuGradeInfos" items="${sessionScope.stuGradeInfos}" varStatus="status">
                                            <tr>
                                                <td></td>
                                                <td>${stuGradeInfos.lpy_Sno15}</td>
                                                <td>${stuGradeInfos.lpy_Sname15}</td>
                                                <td>${stuGradeInfos.lpy_Classname15}</td>
                                                <td>${stuGradeInfos.lpy_Coursename15}</td>
                                                <td>${stuGradeInfos.lpy_Credit15}</td>
                                                <td>${stuGradeInfos.lpy_Chours15}</td>
                                                <td>${stuGradeInfos.lpy_Cterm15}</td>
                                                <td>${stuGradeInfos.lpy_Grade15}</td>
                                                <td>${stuGradeInfos.lpy_Gpa15}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Start-->
<div class="footer-copyright-area">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="footer-copy-right">
                    <p>Copyright &#169; 2021 Colorlib All rights reserved. 高校成绩管理系统.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer End-->
<!-- jquery
    ============================================ -->
<script src="static/js/vendor/jquery-1.11.3.min.js"></script>
<!-- bootstrap JS
    ============================================ -->
<script src="static/js/bootstrap.min.js"></script>
<!-- meanmenu JS
    ============================================ -->
<script src="static/js/jquery.meanmenu.js"></script>
<!-- mCustomScrollbar JS
    ============================================ -->
<script src="static/js/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- sticky JS
    ============================================ -->
<script src="static/js/jquery.sticky.js"></script>
<!-- scrollUp JS
    ============================================ -->
<script src="static/js/jquery.scrollUp.min.js"></script>
<!-- counterup JS
    ============================================ -->
<script src="static/js/counterup/jquery.counterup.min.js"></script>
<script src="static/js/counterup/waypoints.min.js"></script>
<!-- peity JS
    ============================================ -->
<script src="static/js/peity/jquery.peity.min.js"></script>
<script src="static/js/peity/peity-active.js"></script>
<!-- sparkline JS
    ============================================ -->
<script src="static/js/sparkline/jquery.sparkline.min.js"></script>
<script src="static/js/sparkline/sparkline-active.js"></script>
<!-- datapicker JS
       ============================================ -->
<script src="static/js/datapicker/bootstrap-datepicker.js"></script>
<script src="static/js/datapicker/datepicker-active.js"></script>
<!-- Data Maps JS
        ============================================ -->
<script src="static/js/data-map/d3.min.js"></script>
<script src="static/js/data-map/topojson.js"></script>
<script src="static/js/data-map/datamaps.all.min.js"></script>
<script src="static/js/data-map/data-maps-active.js"></script>
<!-- data table JS
    ============================================ -->
<script src="static/js/data-table/bootstrap-table.js"></script>
<script src="static/js/data-table/tableExport.js"></script>
<script src="static/js/data-table/data-table-active.js"></script>
<script src="static/js/data-table/bootstrap-table-editable.js"></script>
<script src="static/js/data-table/bootstrap-editable.js"></script>
<script src="static/js/data-table/bootstrap-table-resizable.js"></script>
<script src="static/js/data-table/colResizable-1.5.source.js"></script>
<script src="static/js/data-table/bootstrap-table-export.js"></script>
<!-- main JS
    ============================================ -->
<script src="static/js/main.js"></script>
</body>

</html>
<%
    }
%>

