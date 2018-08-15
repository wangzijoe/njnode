package cn.njnode.dbServer.service.impl;

import cn.njnode.dbServer.dao.ItemDao;
import cn.njnode.dbServer.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    ItemDao itemDao;

    @Override
    public List<Map<String, Object>> getAllItem() {
        return itemDao.getAllItem();
    }

    @Override
    public List<Map<String, Object>> getAllItemCat() {
        return itemDao.getAllItemCat();
    }
}
