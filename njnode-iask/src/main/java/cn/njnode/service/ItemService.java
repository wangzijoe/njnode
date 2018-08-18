package cn.njnode.service;

import java.util.List;
import java.util.Map;

public interface ItemService {

    List<Map<String, Object>> getAllItemCat();

    List<Map<String, Object>> getItemCatsByParentId(Long parent_id);
}
