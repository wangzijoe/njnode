package cn.njnode.service.impl;

import cn.njnode.cache.CacheUtil;
import cn.njnode.dao.ItemDao;
import cn.njnode.service.ItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    private Log log = LogFactory.getLog(ItemServiceImpl.class);

    @Resource
    private CacheUtil cacheUtil;

    @Resource
    private ItemDao itemDao;

    @Override
    public List<Map<String, Object>> getAllItemCat() {
        return cacheUtil.getAllItemCat();
    }

    @Override
    public List<Map<String, Object>> getItemCatsByParentId(Long parent_id) {
        return cacheUtil.getgetItemCatsByParentId(parent_id);
    }
}
