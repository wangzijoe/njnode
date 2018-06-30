<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
    <div style = "width:100%">
    	<div style = "width:1200px;margin:0 auto;text-align: center;">
    	   <div style = "position: relative;">
	    	   <!-- 1: 打样 2： 下架 3：装修  -->
	    	 
			    <c:choose>
				   <c:when test="${errorCode == 1}">  
				         	  <img  style ="height:450px;"src = "${webImg}error1.jpg"/> 
				   </c:when>
				   <c:when test="${errorCode == 2}">  
				         	   <img  style ="height:450px;"src = "${webImg}error2.jpg"/> 
				   </c:when>
				   <c:when test="${errorCode == 3}">  
				         	    <img  style ="height:450px;"src = "${webImg}error3.jpg"/>
				   </c:when>
				   <c:when test="${errorCode == 401}">  
				         	   401错误！！<%--  <img  style ="height:450px;"src = "${webImg}/error3.jpg"/> --%>
				   </c:when>
				   <c:when test="${errorCode == 403}">  
				         	   403错误！！<%-- <img  style ="height:450px;"src = "${webImg}/error3.jpg"/> --%>
				   </c:when>
				   <c:when test="${errorCode == 404}">  
				         	  <img  style ="height:450px;"src = "${webImg}imgs/404.jpg"/>
				   </c:when>
				   <c:when test="${errorCode == 500}">  
				         	     <script type="text/javascript">
                                      window.location.href="<%=basePath%>index.jhtml";
                                 </script>   500错误！！<%-- <img  style ="height:450px;"src = "${webImg}/error3.jpg"/> --%>
				   </c:when>
				   <c:otherwise> 
				  	<div> 未知错误！！！</div>
				   </c:otherwise>
				</c:choose>
				
				<a href = "<%=basePath%>index.html" style = "position: absolute; bottom: 100px;left: 500px;color:red"> 返回首页 </a>
			</div>
			
		</div>
 	</div>
</body>
</html>