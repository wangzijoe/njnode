package cn.njnode.webSocket.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;

import cn.njnode.HandlerConstants;
import cn.njnode.common.http.ResponseWrite;
import cn.njnode.webSocket.handler.NjNodeWebSocketHandler;

@Controller
@RequestMapping("NjNodeMsg")
public class NjNodeMsgController {

	private static Logger log = Logger.getLogger(NjNodeMsgController.class);
	
	@Resource
	NjNodeWebSocketHandler handler;
	
	@RequestMapping("")
	public String index() {
		return "webSocket/webSocketTest";
	}

	@RequestMapping(value = "sendMsg", method = { RequestMethod.GET })
	public void sendMsg(HttpServletRequest request, HttpServletResponse response) {
		try {
			handler.sendMessageToFriend(new TextMessage(new GsonBuilder().create().toJson("\"number\":\""+"GarlicPriceController/testWebSocket"+"\"")), "AAA");  
			ResponseWrite.Write(response, JSON.toJSONString(HandlerConstants.SUCCESS));
		} catch (Exception e) {
			log.error("NjNodeMsgController error", e);
			ResponseWrite.Write(response, JSON.toJSONString(HandlerConstants.ERROR));
		}
	}
}
