package cn.njnode.dbServer.manager;

import cn.njnode.dbServer.service.ItemService;
import org.joda.time.DateTimeUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
public class ItemController {

    @Resource
    ItemService itemService;

    @RequestMapping(value = "getAllItem")
    public void getAllItem() {
        List<Map<String, Object>> allItem = itemService.getAllItem();
        for (Map<String, Object> map : allItem) {
            System.out.println(map);
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ItemService itemService = (ItemService) ac.getBean("itemServiceImpl");
        List<Map<String, Object>> allItemCat = itemService.getAllItemCat();

//        allItemCat.stream().map(map -> map.get("sort_order")).

        Map<Object, List<Map<String, Object>>> sort_order = allItemCat.stream().collect(Collectors.groupingBy(map -> map.get("sort_order")));
        Iterator<Object> iterator = sort_order.keySet().iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            List<Map<String, Object>> maps = sort_order.get(key);
            System.out.println(maps);
        }


//        long start = DateTimeUtils.currentTimeMillis();
//        List<Object> id = allItemCat.stream().map(map -> map.get("id")).collect(Collectors.toList());
//        System.out.println(id);
//        System.out.println(DateTimeUtils.currentTimeMillis() - start);
//        List<Object> id1 = allItemCat.stream().parallel().map(map -> map.get("id")).collect(Collectors.toList());
//        System.out.println(id1);
//        System.out.println(DateTimeUtils.currentTimeMillis() - start);
//        Stream<String> stream = Stream.of("I", "love", "you", "too");
//
//        Integer lengthSum = stream.reduce(0,/* 初始值　// (1)*/
//        (sum, str) -> sum+str.length(), // 累加器 // (2)
//
//                (a, b) -> a+b);// 部分和拼接器，并行执行时才会用到 // (3)

// int lengthSum = stream.mapToInt(str -> str.length()).sum();
//        Stream<String> stream = Stream.of("I", "love", "you", "too");
//
//        stream.forEach(str -> System.out.println(str));
//
//
//        Stream<String> stream1 = Stream.of("I", "love", "you", "too");
//        stream1.distinct().forEach(str -> System.out.println(str));
//
//        Stream<String> stream = Stream.of("I", "love", "you", "too");
//
//        stream.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));

//        Stream<String> stream= Stream.of("I", "love", "you", "too");
//
//        stream.sorted((str1, str2) -> str1.length()-str2.length()).forEach(str -> System.out.println(str));
//        IntStream.range(0, 4)
//                .forEach(System.out::println);
//
//        for(int i = 0; i < 4 ; i++){
//            System.out.println(i);
//        }

//        ItemController ic = new ItemController();
//        ic.test1();
    }

    public void test1() {
        // 串行
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long count = IntStream.range(0, 100000).filter(this::isPrime).count();
        System.out.println(count);

        System.out.println(Calendar.getInstance().getTimeInMillis() -  timeInMillis);
        // 并行
        long count1 = IntStream.range(0, 100000).parallel().filter(this::isPrime).count();
        System.out.println(count1);

        System.out.println(Calendar.getInstance().getTimeInMillis() -  timeInMillis);
    }

    /**
     * 判断是否质数
     * @param num
     * @return
     */
    public Boolean isPrime(int num) {
        int tmp = num;
        if (tmp < 2) return false;
        for (int i = 2; Math.sqrt(tmp) >= i; i++) {
            if (tmp % i == 0) return false;
        }
        return true;
    }
}

