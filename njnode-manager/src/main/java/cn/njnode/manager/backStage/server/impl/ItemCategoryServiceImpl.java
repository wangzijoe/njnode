package cn.njnode.manager.backStage.server.impl;

import cn.njnode.HandlerResult;
import cn.njnode.beans.item.ItemCategory;
import cn.njnode.common.exception.ExceptionUtil;
import cn.njnode.item.server.ItemCategoryServer;
import cn.njnode.manager.backStage.server.ItemCategoryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private Logger log = LogManager.getLogger(getClass());

    @Resource
    private ItemCategoryServer ItemCategoryServer;

    private static final List<ItemCategory> returnList = new ArrayList<>();

    @Override
    public HandlerResult<List<ItemCategory>> getItemCategoryList(ItemCategory itemCategory) {
        HandlerResult<List<ItemCategory>> result = HandlerResult.getHandlerResult();
        try {
            result = getChildItemCategory(itemCategory);
        } catch (Exception e) {
            log.info(ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    /**
     * 根据当前节点找到子节点的递归
     * @param itemCategory
     * @return
     */
    private HandlerResult<List<ItemCategory>> getChildItemCategory(ItemCategory itemCategory){
        HandlerResult<List<ItemCategory>> result = HandlerResult.getHandlerResult();
        try {

            ItemCategory ic = new ItemCategory();
            ic.setParentId(itemCategory.getId());
            result = ItemCategoryServer.queryItemCategoryList(ic, 1, 1000);
            List<ItemCategory> list = result.getResultObj();

            if(!list.isEmpty()){
                for (ItemCategory childIc: list ) {
                    returnList.add(childIc);
                    if(isParent(childIc)){
                        getChildItemCategory(childIc);
                    }
                }
            }

            result.setResultObj(returnList);
        } catch (Exception e) {
            log.info(ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    /**
     * 判断是否是子节点
     * @return
     */
    private boolean isParent(ItemCategory itemCategory){
        return itemCategory.getIsParent();
    }
}
