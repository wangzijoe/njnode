package cn.njnode.manager.backStage.controller;

import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.item.ItemCategory;
import cn.njnode.common.http.ResponseWrite;
import cn.njnode.item.server.ItemCategoryServer;
import cn.njnode.manager.backStage.server.ItemCategoryService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("item")
public class ItemController {

    private static Logger log = Logger.getLogger(ItemController.class);

    @Resource
    private ItemCategoryServer ItemCategoryServer;

    @Resource
    private ItemCategoryService ItemCategoryService;

    @RequestMapping(value = "getItemCategoryTree", method = RequestMethod.GET)
    public void getItemCategoryTree(ItemCategory itemCategory, HttpServletResponse response){
        try {
            HandlerResult<List<ItemCategory>> result = ItemCategoryService.getItemCategoryList(itemCategory);
            ResponseWrite.write(response, JSON.toJSONString(result));
        } catch (Exception e) {
            log.info("ItemController Error", e);
            ResponseWrite.write(response,JSON.toJSONString(HandlerConstants.ERROR));
        }
    }
}
