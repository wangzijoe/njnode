package cn.njnode.web;

import cn.njnode.common.http.ResponseWrite;
import cn.njnode.service.ItemService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("item")
public class ItemController {


    @Resource
    private ItemService itemService;

    @ResponseBody
    @RequestMapping("getItemCatByParentId")
    public void getItemCatByParentId(String parent_id, HttpServletResponse response) {
        ResponseWrite.write(response, JSON.toJSONString(itemService.getItemCatsByParentId(Long.valueOf(parent_id))));
    }

    @ResponseBody
    @RequestMapping("getAllItemCat")
    public void getAllItemCat(HttpServletResponse response) {
        ResponseWrite.write(response, JSON.toJSONString(itemService.getAllItemCat()));
    }
}
