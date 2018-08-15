<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
This is index.jsp!!
<script>  
    var path = "192.168.1.157:8088/";
    var userId ="AAA";  
    if(userId == -1){  
        window.location.href = "192.168.1.157:8088/";
    }  
    var websocket;  
    if ('WebSocket' in window) {  
        websocket = new WebSocket("ws://" + path + "wsMsg?userId=" + userId);  
    } else if ('MozWebSocket' in window) {  
        websocket = new MozWebSocket("ws://" + path + "wsMsg?userId=" + userId);  
    } else {  
        websocket = new SockJS("http://" + path + "wsMsg/sockjs?userId=" + userId);  
    }  
    websocket.onopen = function(event) {  
        console.log("WebSocket:已连接");  
        console.log(event);  
    };  
    websocket.onmessage = function(event) {  
        var data = JSON.parse(event.data);  
        console.log("WebSocket:收到一条消息：", data);  
    };  
    websocket.onerror = function(event) {  
        console.log("WebSocket:发生错误 ");  
        console.log(event);  
    };  
    websocket.onclose = function(event) {  
        console.log("WebSocket:已关闭");  
        console.log(event);  
    }  
</script>  
</body>
</html>