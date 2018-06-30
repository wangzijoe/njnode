package cn.njnode.manager.backStage.server;

import cn.njnode.HandlerResult;
import cn.njnode.beans.item.ItemCategory;

import java.util.List;

/**
 * 商品分类的Service接口
 */
public interface ItemCategoryService {

    /**
     * 根据当前节点找到他下面的所有子节点
     * @return
     */
    HandlerResult<List<ItemCategory>> getItemCategoryList(ItemCategory itemCategory);
}
