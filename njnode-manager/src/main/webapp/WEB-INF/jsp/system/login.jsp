<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="${rootPath}H-ui/static/h-ui.admin/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="${rootPath}H-ui/static/h-ui/css/H-ui.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}H-ui/static/h-ui.admin/css/H-ui.login.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}H-ui/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${rootPath}H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body style="background-color: #F3F3F3">

	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="" method="post">
			
				<div class = "formControls col-xs-8 col-xs-offset-3">
           			<%-- <span class="c-red"><h5>${error}</h5></span>
					<%String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);%>
					<c:set var="exp_type" value="<%=error %>"></c:set>
					<c:set var="tips" value=""></c:set>
					<c:if test="${fn:contains(exp_type,'UnknownAccountException') }">
						<c:set var="tips" value="账号不存在!"></c:set>
					</c:if>
					<c:if test="${fn:contains(exp_type,'IncorrectCredentialsException')}">
               			<c:set var="tips" value="密码错误!"></c:set>
           			</c:if> --%>
				</div>
			
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="" name="username" type="text" class="input-text size-L" value="${error}">
					</div>
				</div>
				
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="" name="password" type="password" class="input-text size-L">
					</div>
				</div>

				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="captcha" class="input-text size-L" type="text" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width: 150px;">
						<img onclick="refreshCode(this)" id="captcha" src="${rootPath}getCaptcha">
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online">
							<input type="checkbox" name="online" id="online" value=""> 使我保持登录状态
						</label>
					</div>
				</div>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">&nbsp;&nbsp;&nbsp; 
						<input data-toggle="modal" data-target="#myModal" type="button" class="btn btn-default radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">注册用户</h4>
            </div>
            <div class="modal-body" id="registerDiv">
            	<form id = "form_user_register" class="form form-horizontal" action="" method="post">
			      <div class="row cl">
			        <label class="form-label col-xs-3"><i class="Hui-iconfont"></i></label>
			        <div class="formControls col-xs-8">
			          <input id="username" name="username" type="text" placeholder="用户名" class="input-text size-L" style="width: 200px">
			        </div>
			      </div>
			      <div class="row cl">
			        <label class="form-label col-xs-3"><i class="Hui-iconfont"></i></label>
			        <div class="formControls col-xs-8">
			          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L" style="width: 250px">
			        </div>
			      </div>
			      <div class="row cl">
			        <label class="form-label col-xs-3"><i class="Hui-iconfont"></i></label>
			        <div class="formControls col-xs-8">
			          <input id="rePassword" name="rePassword" type="password" placeholder="确认密码" class="input-text size-L" style="width: 250px">
			        </div>
			      </div>
			      <div class="row cl">
			        <label class="form-label col-xs-3"><i class="Hui-iconfont"></i></label>
			        <div class="formControls col-xs-8">
			          <input id="tel" name="tel" type="text" placeholder="手机号码" class="input-text size-L" style="width: 250px">
			        </div>
			      </div>
			      <div class="row cl ">
			        <label class="form-label col-xs-3"><i class="Hui-iconfont"></i></label>
			        <div class="formControls col-xs-8">
						<input id="sub" type="submit" class="btn btn-primary radius" value="&nbsp;&nbsp;保存并提交审核&nbsp;&nbsp;">
						<button  class="btn btn-default radius" type="reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
			        </div>
				  </div>
			    </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div class="footer">Copyright @njnode.cn</div>
<script type="text/javascript" src="${rootPath}H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript" src="${rootPath}H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${rootPath}H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${rootPath}H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${rootPath}H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${rootPath}H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${rootPath}H-ui/lib/common.js"></script>
<script type="text/javascript">
$(function() {
	var validate = $("#form_user_register").validate({ 
		errorPlacement: function(error, element) {  
	        if (element.is(":input")){ 
	        	error.appendTo(element.parent());
	        }
	    },
		debug: true, //调试模式取消submit的默认提交功能   
	    focusInvalid: false, //当为false时，验证无效时，没有焦点响应  
	    onkeyup: false,   
	    submitHandler: function(){   //表单提交句柄,为一回调函数，带一个参数：form    
	    	username = $("#registerDiv input[name='username']").val();
	    	password = $("#registerDiv input[name='password']").val();
	    	tel = $("#registerDiv input[name='tel']").val();
// 	    	console.log(username+"  ===  "+password+"  ===  "+tel);
			var d = {username:username,password:password,tel:tel};
	    	NJ_NODE.ajaxPost(d,"text","${rootPath}sys/_/register",function(data){
	    		if(data){
	    			console.log(data)
	    			layer.msg('注册成功！',{icon:1,time:3000});
	    	    	setTimeout(function(){
	    	    		var index = parent.layer.getFrameIndex(window.name);
		    	 		parent.location.reload(true);
		    	 		parent.layer.close(index);	
	    	    	},1500)
	    		}else{
	    	    	layer.msg('网络不稳！注册用户失败！',{icon:5,time:1000});
	    	    	setTimeout(function(){
	    	    		var index = parent.layer.getFrameIndex(window.name);
		    	 		parent.location.reload(true);
		    	 		parent.layer.close(index);	
	    	    	},1500)
	    		}
    		});
	    },   
	    
	    rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			tel:{
				required:true,
				isPhone:true
			},
	        password:{
	            required:true,
	            rangelength:[3,10]
	        },
	        rePassword:{
	            equalTo:"#password"
	        }                    
	    },
	    messages:{
	        password:{
	            required: "不能为空",
	            rangelength: $.format("最少:{0}位, 最长:{1}位")
	        },
	        rePassword:{
	            equalTo:"两次密码输入不一致"
	        }                                    
	    }
	});

});
function refreshCode(obj){
	obj.src = "${rootPath}getCaptcha?random="+Math.random();;
}
</script>
</body>
</html>