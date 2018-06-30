<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json Format</title>
<link rel="icon" href="http://192.168.1.157/H-ui/static/h-ui.admin/images/favicon.ico">
<link type="text/css" rel="stylesheet" href="http://192.168.1.157/H-ui/bootstrap/dist/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="http://192.168.1.157/H-ui/static/h-ui/css/jsonEditor.css">
</head>
<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">njnode.cn</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<shiro:guest>
						<li><a href="#">成功案例</a></li>
					</shiro:guest>
					<shiro:authenticated>
						<li><a href="http://192.168.1.157/manager">后台管理</a></li>
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
		        	    <li><a href="http://192.168.1.157/manager"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
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

	    

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="donateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel"></h4>
	            </div>
	            <div class="modal-body">
					<img id="donateImage" alt="donate.jpg" src="http://192.168.1.157/H-ui/static/h-ui.admin/images/donate.jpg" style="width: 50%;">
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>


	<div class="container">
		<div class="jumbotron">
			<!-- json工具 -->
			<div class="table-responsive">
				<table class="table">
					<caption></caption>
					<thead>
						<tr>
							<th>Json Format</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<div class="jsoneditor-menu">
									<button class="jsoneditor-menu jsoneditor-format" id="formatJson" title="格式化JSON数据"></button>
									<button class="jsoneditor-menu jsoneditor-compact" id="compressJson" title="压缩JSON数据, 清除所有空白字符"></button>
								</div>
								<div class="jsoneditor-content"><textarea id="sourcejson" class="jsonformatter-textarea" rows="20"></textarea></div>
							</td>
							<!-- <td>
								<div id="splitter">
									<br>
									<br>
									<br>
									<button id="toForm" title="解析JSON" class="convert" onclick="formatJson();">
										<div class="convert-right"></div>
									</button>
									<br>
									<br>
									<button id="toJSON" title="保存JSON" class="convert">
										<div class="convert-left"></div>
									</button>
								</div>
							</td>
							<td>
								<div class="jsoneditor-menu">
									<button class="jsoneditor-menu jsoneditor-format" title="格式化JSON数据"></button>
									<button class="jsoneditor-menu jsoneditor-compact" title="压缩JSON数据, 清除所有空白字符"></button>
								</div>
								<div class="jsoneditor-content"><textarea id="targetjson" class="jsonformatter-textarea" rows="20"></textarea></div>
							</td> -->
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td><button type="button" class="btn btn-danger">保存</button></td>
							<td></td>
							<td></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>

	



<script type="text/javascript" src="http://192.168.1.157/H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="http://192.168.1.157/H-ui/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="http://192.168.1.157/H-ui/lib/common.js"></script>
<script type="text/javascript">

	$(function() {

		$("#compressJson").click(function(){
			try{
				let sourceJson = $("#sourcejson").val()
				if (NJ_NODE.isJson(sourceJson)) {
					$("#sourcejson").val(sourceJson.replace(/\n|\s+/g, ""))
				} else {
					alert(sourceJson.slice(0, 3) + "... is not a json")
				}					
			}catch(e){
				console.log(e)
			}
			
		})
		
		$("#donate").click(function() {
			$("#donateModal").modal("show")
		})

		$("#formatJson").click(function() {
			try {
				let sourceJson = $("#sourcejson").val()
				if (NJ_NODE.isJson(sourceJson)) {
					$("#sourcejson").val(NJ_NODE.formatJson(sourceJson))
				} else {
					alert(sourceJson.slice(0, 3) + "... is not a json")
				}
			} catch (e) {
				concole.log(e)
			}
		})
	});
</script>
</body>
</html>