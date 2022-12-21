package com.xuekai.test;

import com.xuekai.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author shixuekai
 * @CreateDate 2021/4/20
 * @Description
 **/
@Slf4j
public class Txtest {

    private static List<Integer> typeList = new ArrayList<>();
    static {
        //冒泡事件
        typeList.add(10);
        //首页事件
        typeList.add(12);
    }

    public static  Random random = new Random();
    public static void main(String[] args) {
        String order = "";

        System.out.println(order.isEmpty());
    }

    /**
     * 获取date前第N天日期 包括date
     *
     * @return yyyy-MM-dd 00:00:00
     */
    public static Date getDataBeforeDays(Date date, int days) {
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).withHour(0).withMinute(0)
                .withSecond(0).withNano(0).minusDays(days - 1L).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date today() {
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
