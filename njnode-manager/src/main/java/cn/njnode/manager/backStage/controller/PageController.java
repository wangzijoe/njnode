package cn.njnode.manager.backStage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * 
 * 文件名：PageController.java
 *
 * 创建人：joe 
 *
 * 创建时间：2018年5月31日 下午6:11:25
 *
 * 功能描述：负责跳转页面的
 */
@Controller
@RequestMapping("page")
public class PageController {

	@RequestMapping(value = "{pageUrl}/toPage", method={GET,POST})
	public String toPage(@PathVariable String pageUrl, HttpServletRequest request, Model model){
		return pageUrl.replaceAll("_", "/");
	}
}
