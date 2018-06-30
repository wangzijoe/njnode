package cn.njnode.item.server.impl;


import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.item.ItemCategory;
import cn.njnode.item.dao.ItemCategoryDao;
import cn.njnode.item.server.ItemCategoryServer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemCategoryServerImpl implements ItemCategoryServer {

    private Logger log = LogManager.getLogger(getClass());

    @Resource
    private ItemCategoryDao ItemCategoryDao;

    @Override
    public HandlerResult<ItemCategory> addItemCategory(ItemCategory itemCategory) {
        HandlerResult<ItemCategory> result = HandlerResult.getHandlerResult();
        try {
            Assert.notNull(itemCategory, "itemCategory");
            ItemCategoryDao.addItemCategory(itemCategory);
            result.setResultObj(itemCategory);
        } catch (Exception e) {
            log.error("ItemCategoryServerImpl addItemCategory fail", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<String> deleteItemCategoryById(Long id) {
        HandlerResult<String> result = HandlerResult.getHandlerResult();
        try {
            Assert.notNull(id, "id");
            ItemCategoryDao.deleteItemCategoryById(id);
        } catch (Exception e) {
            log.error("ItemCategoryServerImpl deleteItemCategoryById fail", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<String> updateItemCategoryById(ItemCategory itemCategory) {
        HandlerResult<String> result = HandlerResult.getHandlerResult();
        try {
            Assert.notNull(itemCategory, "itemCategory");
            ItemCategoryDao.updateItemCategoryById(itemCategory);
        } catch (Exception e) {
            log.error("ItemCategoryServerImpl updateItemCategoryById fail", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<ItemCategory> queryItemCategoryById(Long id) {
        HandlerResult<ItemCategory> result = HandlerResult.getHandlerResult();
        try {
            Assert.notNull(id, "id");
            ItemCategory itemCategory = ItemCategoryDao.queryItemCategoryById(id);
            result.setResultObj(itemCategory);
        } catch (Exception e) {
            log.error("ItemCategoryServerImpl queryItemCategoryById fail", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<List<ItemCategory>> queryItemCategoryList(ItemCategory itemCategory
            , Integer pageNum, Integer pageSize) {
        HandlerResult<List<ItemCategory>> result = HandlerResult.getHandlerResult();
        try {
            Assert.notNull(itemCategory, "itemCategory");
            PageHelper.startPage(pageNum, pageSize);
            List<ItemCategory> list = ItemCategoryDao.queryItemCategoryList(itemCategory);
            result.setPageInfo(new PageInfo<>(list));
            result.setResultObj(list);
        } catch (Exception e) {
            log.error("ItemCategoryServerImpl queryItemCategoryList fail", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }
}
