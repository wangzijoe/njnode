package cn.njnode.reptileRobot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyze {

    //使用时调用此方法，传入uid，如 5ef5edbdc64c1bb49e9d6899，返回的是一个字符串，可以打印出来看一下
    public HouseInfo regexMain(String uid) {
        String url = "http://map.baidu.com/detail?qt=ninf&from=housezt&detail=house&uid=" + uid;
        String result = ConnectionUtil.Connect(url);
        HouseInfo h = getHouseInfo(result);
        h.setUid(uid);
        return h;
    }

    private HouseInfo getHouseInfo(String targetStr) {
        //houseInfo这个对象就是用来存放我们需要的信息
        HouseInfo houseInfo = new HouseInfo();
        //提取图片url
        Pattern imgpattern = Pattern.compile("<img class=\"img-large\".*\" />");
        Matcher imgmatcher = imgpattern.matcher(targetStr);
        while (imgmatcher.find()) {
            String imgString = imgmatcher.group();
            int n = imgString.lastIndexOf("=\"");
            String imgUrl = imgString.substring(n + 2, imgString.length() - 3);
//System.out.println("imgRul:"+imgUrl);
            houseInfo.setImgUrl(imgUrl);//存图片url
        }
        //首先提取出包含房产信息的html片段，再分别处理
        Pattern pattern1 = Pattern
                .compile("fcg\">\\w*.+\\s*<dd>\\w*.+</dd>");
        Matcher matcher1 = pattern1.matcher(targetStr);
        String info = "";
        while (matcher1.find()) {
            info = matcher1.group();                //提取出的片段
            Pattern pattern2 = Pattern
                    .compile("f24 fcr\">[0-9]+");
            Matcher matcher2 = pattern2.matcher(info);
            while (matcher2.find()) {
                String price = matcher2.group().substring(9);    //提取出价格
                houseInfo.setPrice(price);//存价格
            }

            Pattern pattern3 = Pattern
                    .compile("房屋类型：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher3 = pattern3.matcher(info);
            String houseType = "";            //可能有的没有
            while (matcher3.find()) {
                int n = matcher3.group().lastIndexOf(">");
                houseType = matcher3.group().substring(n + 1);
            }
            houseInfo.setHouseType(houseType);
            //建筑类型同理
            Pattern pattern4 = Pattern
                    .compile("建筑类型：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher4 = pattern4.matcher(info);
            String blockType = "";            //可能有的
            while (matcher4.find()) {
                int n = matcher4.group().lastIndexOf(">");
                blockType = matcher4.group().substring(n + 1);
            }
            houseInfo.setBlockType(blockType);
            //建筑年代
            Pattern pattern5 = Pattern
                    .compile("建筑年代：</dt>\\s*<dd>[0-9]+");
            Matcher matcher5 = pattern5.matcher(info);
            String blockAge = "";            //可能有的没有
            while (matcher5.find()) {
                int n = matcher5.group().lastIndexOf(">");
                blockAge = matcher5.group().substring(n + 1);
            }
            houseInfo.setBlockAge(blockAge);
            //容积率
            Pattern pattern6 = Pattern
                    .compile("容积率：</dt>\\s*<dd>[0-9]+\\.[0-9]+");
            Matcher matcher6 = pattern6.matcher(info);
            String FAR = "";            //可能有的没有
            while (matcher6.find()) {
                int n = matcher6.group().lastIndexOf(">");
                FAR = matcher6.group().substring(n + 1);
            }
            houseInfo.setFAR(FAR);
            //物业费
            Pattern pattern9 = Pattern
                    .compile("物业费：</dt>\\s*<dd>[0-9]+\\.[0-9]+");
            Matcher matcher9 = pattern9.matcher(info);
            String fee = "";            //可能有的没有
            while (matcher9.find()) {
                int n = matcher9.group().lastIndexOf(">");
                fee = matcher9.group().substring(n + 1);
            }
            houseInfo.setFee(fee);
            //物业公司
            Pattern pattern7 = Pattern
                    .compile("物业公司：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher7 = pattern7.matcher(info);
            String pManage = "";            //可能有的没有
            while (matcher7.find()) {
                int n = matcher7.group().lastIndexOf(">");
                pManage = matcher7.group().substring(n + 1);
            }
            houseInfo.setpManage(pManage);
            //开发商
            Pattern pattern8 = Pattern
                    .compile("开发商：</dt>\\s*<dd>[\\u4e00-\\u9fa5]+( *[\\u4e00-\\u9fa5]+)*");
            Matcher matcher8 = pattern8.matcher(info);
            String company = "";            //可能有的没有
            while (matcher8.find()) {
                int n = matcher8.group().lastIndexOf(">");
                company = matcher8.group().substring(n + 1);
            }
            houseInfo.setCompany(company);
        }
        return houseInfo;
    }

    public static void main(String[] args) {
        Analyze analyze = new Analyze();
        HouseInfo houseInfo = analyze.regexMain("5ef5edbdc64c1bb49e9d6899");
        System.out.println(houseInfo);
    }

}