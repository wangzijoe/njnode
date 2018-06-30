package cn.njnode.item.dao;

import cn.njnode.beans.item.ItemCategory;

import java.util.List;

public interface ItemCategoryDao {

    /**
     * @param itemCategory
     */
    void addItemCategory(ItemCategory itemCategory);

    /**
     * @param id
     */
    void deleteItemCategoryById(Long id);


    /**
     * @param itemCategory
     */
    void updateItemCategoryById(ItemCategory itemCategory);


    /**
     * @param id
     */
    ItemCategory queryItemCategoryById(Long id);

    /**
     * @param itemCategory
     */
    List<ItemCategory> queryItemCategoryList(ItemCategory itemCategory);
}