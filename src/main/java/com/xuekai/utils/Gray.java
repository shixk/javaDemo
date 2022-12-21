package com.xuekai.utils;

import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gray {

    public static boolean isGray(Long driverId, String grayPercent) {
        try {
            //校验手机号
            //校验配置表达式
            if (!isMatchPercent(grayPercent)) {

                return Boolean.FALSE;
            }
            //解析数据
            String driverIdStr = driverId.toString();
            String result = driverIdStr.substring(driverIdStr.length() - 2);
            int current = Integer.parseInt(result);
            String[] grays = grayPercent.split("-");
            int grayStart = Integer.parseInt(grays[0]);
            int grayEnd = Integer.parseInt(grays[1]);
            return current >= grayStart && current <= grayEnd;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private static boolean isMatchPercent(String grayPercent) {
        if (StringUtils.isEmpty(grayPercent)) {
            return Boolean.FALSE;
        }
        // 按指定模式在字符串查找
        String pattern = "^\\d+-\\d+$";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(grayPercent);
        if (m.find()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static void main(String[] args) {

        //Boolean bl = isGray(18611095610L,"0-0");


        BigDecimal fenzi = new BigDecimal(86);
        BigDecimal fenmu = new BigDecimal(99);

        BigDecimal result = fenzi.divide(fenmu,2,BigDecimal.ROUND_HALF_UP);

        BigDecimal nintyPercent = new BigDecimal(0.9);
        if(result.compareTo(nintyPercent)>=0){
            System.out.println(true);
        }
        System.out.println(result);
    }
}
