package cn.njnode.cache;

import cn.njnode.dao.ItemDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * * ehcache-spring-annotations简介
 * * @see -------------------------------------------------------------------------------------------------------------
 * * @see 关于Spring与Ehcache的集成,googlecode上有一个经Apache认证的开源项目叫做ehcache-spring-annotations
 * * @see 目前已经到了1.2.0版本,它只是简化了Spring和Ehcache集成的复杂性(事实上我觉得完全没必要,因为它俩集成并不复杂)
 * * @see 尽管如此还是要提一下,它的项目主页为https://code.google.com/p/ehcache-spring-annotations/
 * * @see 这篇文章中描述了其用法http://blog.goyello.com/2010/07/29/quick-start-with-ehcache-annotations-for-spring/
 * * @see -------------------------------------------------------------------------------------------------------------
 * * @see 1)使用时在项目中引入ehcache-spring-annotations-1.2.0.jar和guava-r09.jar两个jar文件
 * * @see 2)然后在applicationContext.xml按照如下配置
 * * @see   <beans xmlns:ehcache="http://ehcache-spring-annotations.googlecode.com/svn/schema/ehcache-spring"
 * * @see         xsi:schemaLocation="http://ehcache-spring-annotations.googlecode.com/svn/schema/ehcache-spring
 * * @see         http://ehcache-spring-annotations.googlecode.com/svn/schema/ehcache-spring/ehcache-spring-1.2.xsd">
 * * @see   <ehcache:annotation-driven/>
 * * @see   <ehcache:config cache-manager="cacheManager">
 * * @see       <ehcache:evict-expired-elements interval="60"/>
 * * @see   </ehcache:config>
 * * @see   <bean id="cacheManager" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean">
 * * @see       <property name="configLocation" value="classpath:ehcache.xml"/>
 * * @see   </bean>
 * * @see 3)最后在需要缓存的方法上使用@Cacheable和@TriggersRemove注解即可
 * * @see   经我亲测,@TriggersRemove(cacheName="..", when="..", removeAll=true)可移除缓存中的全部对象
 * * @see   但若写成@TriggersRemove(cacheName="..", when="..")则不会移除缓存中的单一的或所有的对象,即缓存中的对象无变化
 * * @see -------------------------------------------------------------------------------------------------------------
 */
@Service
public class CacheUtil {

    private Log log = LogFactory.getLog(CacheUtil.class);

    @Resource
    private CacheManager cacheManager;

    @Resource
    private ItemDao itemDao;

    @Value("${item.cache}")
    private String ITEMCAT_CACHE_KEY;

    @PostConstruct
    public void initCache() {
        initItemCat();
    }

    private void initItemCat() {
        try {
            //获取缓存实例
            Cache iaskCache = cacheManager.getCache("iaskCache");
            List<Map<String, Object>> allItemCat = itemDao.getAllItemCat();
            //将字典表存入缓存
            iaskCache.put(ITEMCAT_CACHE_KEY, allItemCat);
            Map<Object, List<Map<String, Object>>> groupByParentId = allItemCat.stream().collect(Collectors.groupingBy(map -> map.get("parent_id")));
            Iterator<Object> iterator = groupByParentId.keySet().iterator();
            while (iterator.hasNext()) {
                Object parentId = iterator.next();
                //将商品分类根据parentId分类以后存入缓存
                iaskCache.put(parentId, groupByParentId.get(parentId));
            }
        } catch (Exception e) {
            log.info("缓存初始化失败", e);
        }
    }

    @Cacheable(value = "iaskCache")
    public List<Map<String, Object>> getAllItemCat() {
        List<Map<String, Object>> allItemCat = new ArrayList<>();
        try {
            allItemCat = itemDao.getAllItemCat();
        } catch (Exception e) {
            log.info("CacheUtil getAllItemCat error", e);
        }
        return allItemCat;
    }

    @Cacheable(value = "iaskCache", key = "#parent_id")
    public List<Map<String, Object>> getgetItemCatsByParentId(Long parent_id) {
        List<Map<String, Object>> itemCatsByParentId = new ArrayList<>();
        try {
            itemCatsByParentId = itemDao.getItemCatsByParentId(parent_id);
        } catch (Exception e) {
            log.info("CacheUtil getgetItemCatsByParentId", e);
        }
        return itemCatsByParentId;
    }
}
