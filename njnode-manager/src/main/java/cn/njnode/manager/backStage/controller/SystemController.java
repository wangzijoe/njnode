package cn.njnode.manager.backStage.controller;

import cn.njnode.common.http.HttpUtil;
import cn.njnode.common.image.CaptchaUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SystemController {

	private static Logger log = Logger.getLogger(SystemController.class);

	/**
	 * 
	 * 功能实现描述：首页
	 * 
	 * @return
	 * @author: joe
	 * @date: Created on 2018年4月11日 下午9:58:49
	 * @return
	 */
	@RequestMapping(value = "")
	public String index() {
		return "index";
	}

	/**
	 * 
	 * 功能实现描述：验证码
	 * 
	 * @param request
	 * @param response
	 * @author: joe
	 * @date: Created on 2018年4月11日 下午9:59:10
	 * @return
	 */
	@RequestMapping(value = "getCaptcha", method = { GET, POST })
	public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
		try {
			CaptchaUtil.getCaptcha(request, response);
			log.info("当前用户验证码:" + request.getSession().getAttribute("captcha"));
		} catch (Exception e) {
			log.error("SysController getCaptcha", e);
		}
	}

	@RequestMapping(value = "login", method = { GET, POST })
	public String login(HttpServletRequest request, Model model) {
		try {
			if (HttpUtil.isGet(request)) {
				log.info("login GET 请求");
			} else {
				log.info("login POST 请求");
			}
			
			String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
			String error = null;
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				error = "用户名/密码错误";
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				error = "用户名/密码错误";
			}  else if (exceptionClassName != null) {
				error = "其他错误：" + exceptionClassName;
			}
			model.addAttribute("error", error);
		} catch (Exception e) {
			log.error("SysController login", e);
		}
		return "system/login";
	}

	@RequestMapping(value = "manager", method = { GET, POST })
	public String manager(HttpServletRequest request) {
		
		return "system/manager";
	}
}
