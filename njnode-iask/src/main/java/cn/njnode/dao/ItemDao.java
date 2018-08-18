package cn.njnode.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDao {

    private Log log = LogFactory.getLog(ItemDao.class);

    @Resource
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllItemCat() throws Exception {
        log.info("ItemDao getAllItemCat");
        String sql = "select * from item_cat";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getItemCatsByParentId(Long parent_id) throws Exception {
        log.info("ItemDao getItemCatsByParentId");
        String sql = new StringBuilder()
                .append(" select * from item_cat where 1 =1 ")
                .append(StringUtils.isEmpty(parent_id) ? "" : " and parent_id = " + parent_id).toString();
        return jdbcTemplate.queryForList(sql);
    }
}
