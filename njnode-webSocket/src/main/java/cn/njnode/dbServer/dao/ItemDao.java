package cn.njnode.dbServer.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Repository
public class ItemDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllItem(){
        String sql = "SELECT * FROM tb_item";
        jdbcTemplate.execute("", new CallableStatementCallback<Object>() {
            @Override
            public Object doInCallableStatement(CallableStatement callableStatement) throws SQLException, DataAccessException {
                return null;
            }
        });
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getAllItemCat(){
        String sql = "SELECT * FROM tb_item_cat";
        return jdbcTemplate.queryForList(sql);
    }


}
