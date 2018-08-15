<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <link rel="icon" href="192.168.1.157:8088H-ui/static/h-ui.admin/images/favicon.ico">
    <link type="text/css" rel="stylesheet" href="192.168.1.157:8088H-ui/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">njnode.cn小程序平台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <shiro:guest>
                    <li><a href="#">成功案例</a></li>
                </shiro:guest>
                <shiro:authenticated>
                    <li><a href="192.168.1.157:8088manager">后台管理</a></li>
                </shiro:authenticated>
                <li><a href="#">使用教程</a></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">关于我们<b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">小程序介绍</a></li>
                        <li><a href="#">小程序发展</a></li>
                        <li><a href="#">小程序应用</a></li>
                        <li class="divider"></li>
                        <li><a href="#">加入我们</a></li>
                        <li class="divider"></li>
                        <li><a id="donate" href="#">我愿捐助</a></li>
                    </ul></li>
                <li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <shiro:guest>
                    <li><a href="192.168.1.157:8088manager"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                </shiro:guest>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <shiro:authenticated>
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;<shiro:principal></shiro:principal></a></li>
                </shiro:authenticated>
            </ul>
        </div>
    </div>
</nav>

<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="192.168.1.157:8088H-ui/static/h-ui/images/home/15160158279.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="192.168.1.157:8088H-ui/static/h-ui/images/home/15160158279.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="192.168.1.157:8088H-ui/static/h-ui/images/home/15160158279.jpg" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container">
    <div class="jumbotron" style="background: white">
        <h2>小程序解决方案</h2>
        <p>不管什么样的行业，我们都可以为您提供深入行业的解决方案</p>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <img alt="网络异常" src="192.168.1.157:8088H-ui/static/h-ui/images/home/home_linghuo.png">
            <h3>灵活</h3>
            <p>像积木一样，</p>
            <p>可以拼出您的定制程序</p>
        </div>
        <div class="col-sm-3">
            <img alt="网络异常" src="192.168.1.157:8088H-ui/static/h-ui/images/home/home_jiandan.png">
            <h3>简单</h3>
            <p>简单方便，</p>
            <p>响应速度更快</p>
        </div>
        <div class="col-sm-3">
            <img alt="网络异常" src="192.168.1.157:8088H-ui/static/h-ui/images/home/home_zhuanye.png">
            <h3>专业</h3>
            <p>功能强大，</p>
            <p>插件式集成小程序系统</p>
        </div>
        <div class="col-sm-3">
            <img alt="网络异常" src="192.168.1.157:8088H-ui/static/h-ui/images/home/home_shuju.png">
            <h3>数据</h3>
            <p>全面的用户数据</p>
            <p>方便运营分析和管理</p>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="donateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"></h4>
            </div>
            <div class="modal-body">
                <img id="donateImage" alt="donate.jpg" src="192.168.1.157:8088H-ui/static/h-ui.admin/images/donate.jpg" style="width: 50%;">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<script type="text/javascript" src="192.168.1.157:8088H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="192.168.1.157:8088H-ui/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function(){
        $("#donate").click(function(){
            $("#donateModal").modal("show")
        })
    });
</script>
</body>
</html>