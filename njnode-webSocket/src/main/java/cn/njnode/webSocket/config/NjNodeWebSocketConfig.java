package cn.njnode.webSocket.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import cn.njnode.webSocket.handler.NjNodeWebSocketHandler;
import cn.njnode.webSocket.handshake.HandShake;

@Component  
@EnableWebMvc  
@EnableWebSocket  
public class NjNodeWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Resource
	NjNodeWebSocketHandler handler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/wsMsg").addInterceptors(new HandShake());
		registry.addHandler(handler, "/wsMsg/sockjs").addInterceptors(new HandShake()).withSockJS();
	}
}
