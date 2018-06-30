package cn.njnode.item.server.impl;

import cn.njnode.Base;
import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.item.ItemCategory;
import cn.njnode.common.config.ConfigUtils;
import cn.njnode.common.http.HttpUtil;
import cn.njnode.item.server.ItemCategoryServer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryServerImpl extends Base<ItemCategoryServer> implements ItemCategoryServer {

    private Logger log = LogManager.getLogger(getClass());

    private static final String WEBSERVICE_URL = ConfigUtils.getProperty("WEBSERVICE_URL", ItemCategoryServer.class, "config.properties");

    @Override
    public HandlerResult<ItemCategory> addItemCategory(ItemCategory itemCategory) {
        HandlerResult<ItemCategory> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("addItemCategory");
            result = HttpUtil.post(url, itemCategory, ItemCategory.class);
        } catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<String> deleteItemCategoryById(Long id) {
        HandlerResult<String> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("deleteItemCategoryById",id.toString());
            result = HttpUtil.get(url, String.class);
        }catch(Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<String> updateItemCategoryById(ItemCategory itemCategory) {
        HandlerResult<String> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("updateItemCategoryById");
            result = HttpUtil.post(url, itemCategory, String.class);
        }catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<ItemCategory> queryItemCategoryById(Long id) {
        HandlerResult<ItemCategory> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("queryItemCategoryById", id.toString());
            result = HttpUtil.get(url, ItemCategory.class);
        } catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<List<ItemCategory>> queryItemCategoryList(ItemCategory itemCategory
            , Integer pageNum, Integer pageSize) {
        HandlerResult<List<ItemCategory>> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("queryItemCategoryList"
                    , pageNum.toString(), pageSize.toString());
            result = HttpUtil.postArray(url, itemCategory, ItemCategory.class);
        } catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }
}
