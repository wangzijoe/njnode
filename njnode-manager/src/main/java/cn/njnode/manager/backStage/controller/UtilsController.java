package cn.njnode.manager.backStage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * 
 * 文件名：UtilsController.java
 *
 * 创建人：joe 
 *
 * 创建时间：2018年5月31日 下午6:11:01
 *
 * 功能描述：专门暴露工具页面的
 */
@Controller
@RequestMapping("utils")
public class UtilsController {

	@RequestMapping(value = "json", method = { GET, POST })
	public String json(HttpServletRequest request, HttpServletResponse response) {
		return "utils/json";
	}
}
