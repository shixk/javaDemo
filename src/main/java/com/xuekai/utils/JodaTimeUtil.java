package com.xuekai.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JodaTimeUtil {


    public static final String PARSE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_CHINESE_HOUR_MINUTE = "MM月dd日 HH:mm";

    public static final String FORMAT_CHINESE_DAY = "MM月dd日";

    public static final String MAGIC_PATTERN = "yyyyMMddHHmmss";

    public static final Integer MAGIC_PATTERN_LENGTH = 14;

    public static final String Simple_PATTERN = "yyyy-MM-dd";

    public static final String MONTH_PATTERN = "yyyyMM";
    public static final String MONTH_PATTERN_WITHSEPERATOR = "yyyy-MM";

    public static final String SIMPLE_PATTERN = "yyyyMMdd";

    public static final String YYYY_MM_DD_HH_mm_SS = "yyyy-MM-ddHHmmss";

    public static final Integer SIMPLE_PATTERN_LENGTH = 8;

    public static final DateFormat FORMAT_YYYY_MM_DD = new SimpleDateFormat(Simple_PATTERN);

    public static final DateFormat FORMAT_YYYY_MM = new SimpleDateFormat(MONTH_PATTERN);


    /**
     * 将date对象格式化为yyyy-MM-dd格式
     * @param date
     * @return
     */
    public static String formatYYYYMMDD(Date date) {
        return FORMAT_YYYY_MM_DD.format(date);
    }

    /**
     * 将date对象格式化为yyyy-MM格式
     * @param date
     * @return
     */
    public static String formatYYYYMM(Date date) {
        return FORMAT_YYYY_MM.format(date);
    }


    public static DateTime dateTimeOfDesignated(String date) {
        String desDate = date.replaceAll("\\s|-|/|:","");
        DateTime dt = DateTime.now();
        if (desDate.length() == MAGIC_PATTERN_LENGTH) {
            dt = DateTime.parse(desDate, DateTimeFormat.forPattern(MAGIC_PATTERN));
        } else if (desDate.length() == SIMPLE_PATTERN_LENGTH) {
            dt = DateTime.parse(desDate, DateTimeFormat.forPattern(SIMPLE_PATTERN));
        }
        return dt;
    }

    public static long millisTimeAtStartOfDay() {
        return DateTime.now().withTimeAtStartOfDay().getMillis();
    }

    public static long millisTimeOfDesignated(String date) {
        String desDate = date.replaceAll("\\s|-|/|:","");
        DateTime dt = DateTime.parse(desDate, DateTimeFormat.forPattern(MAGIC_PATTERN));
        return dt.getMillis();
    }

    public static DateTime dateTimeFromMills(long millis) {
        DateTime dateTime = new DateTime(millis);
        return dateTime;
    }

    public static String parsePatternString(long mills, String pattern) {
        DateTime dateTime = dateTimeFromMills(mills);
        return dateTime.toString(pattern);
    }

    public static Date parseStringToDate(String dateTimeStr,String pattern){
        DateTime dateTime = DateTime.parse(dateTimeStr, DateTimeFormat.forPattern(pattern));

        return dateTime.toDate();
    }

    public static Long parseStringToMills(String dateTimeStr,String pattern){
        DateTime dateTime = DateTime.parse(dateTimeStr, DateTimeFormat.forPattern(pattern));

        return dateTime.getMillis();
    }

    /**
     * 某个季度第一天
     * @param mills
     * @return
     */
    public static DateTime getFirstDayInQuarter(long mills) {
        DateTime dateTime = dateTimeFromMills(mills);
        return getFirstDayInQuarter(dateTime);
    }


    public static DateTime getFirstDayInQuarter(DateTime dateTime) {
        int month = dateTime.getMonthOfYear();
        int quarter = getQuarterByMonth(month);
        int quarterMonth = (quarter - 1) * 3 + 1;
        DateTime quarterFirstDay = dateTime
                .withMonthOfYear(quarterMonth)
                .withDayOfMonth(1)
                .withTime(0, 0, 0, 0);
        return quarterFirstDay;
    }

    public static int getHalfYearByMonth(int month) {
        if (month >= 1 && month <= 12) {
            return ((month + 5) / 6);
        } else {
            return -1;
        }
    }

    /**
     * 判定当前月属于哪个季度
     * @param month
     * @return
     */
    public static int getQuarterByMonth(int month) {
        if (month >= 1 && month <= 12) {
            return ((month + 2) / 3);
        } else {
            return -1;
        }
    }

    public static DateTime getFirstDayNextQuarter(long mills) {
        return getFirstDayNextQuarter(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayNextQuarter(DateTime dateTime) {
        DateTime firstDay = getFirstDayInQuarter(dateTime);
        DateTime nextQuarter = firstDay.plusMonths(3);
        return nextQuarter;
    }

    public static DateTime getLastDayInQuarter(long mills) {
        return getLastDayInQuarter(dateTimeFromMills(mills));
    }

    public static DateTime getLastDayInQuarter(DateTime dateTime) {
        DateTime firstDayNextQuarter = getFirstDayNextQuarter(dateTime);
        DateTime lastDayInQuarter = firstDayNextQuarter.minusDays(1);
        return lastDayInQuarter;
    }

    public static DateTime getFirstDayInHalfYear(long mills) {
        return getFirstDayInHalfYear(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayInHalfYear(DateTime dateTime) {
        int month = dateTime.getMonthOfYear();
        int halfYear = getHalfYearByMonth(month);
        int halfYearMonth = (halfYear - 1) * 6 + 1;
        DateTime firstDay = dateTime
                .withMonthOfYear(halfYearMonth)
                .withDayOfMonth(1)
                .withTime(0, 0, 0, 0);
        return firstDay;
    }

    public static DateTime getFirstDayNextHalf(long mills) {
        return getFirstDayNextHalf(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayNextHalf(DateTime dateTime) {
        return getFirstDayInHalfYear(dateTime).plusMonths(6);
    }

    public static DateTime getLastDayInHalf(long mills) {
        return getLastDayInHalf(dateTimeFromMills(mills));
    }

    public static DateTime getLastDayInHalf(DateTime dateTime) {
        return getFirstDayNextHalf(dateTime).minusDays(1);
    }

    public static DateTime getFirstDayInYear(long mills) {
        return getFirstDayInYear(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayInYear(DateTime dateTime) {
        return dateTime.withMonthOfYear(1)
                .withDayOfMonth(1)
                .withTime(0, 0, 0, 0);
    }

    public static DateTime getFirstDayNextYear(long mills) {
        return getFirstDayNextYear(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayNextYear(DateTime dateTime) {
        return getFirstDayInYear(dateTime).plusYears(1);
    }

    public static DateTime getLastDayInYear(long mills) {
        return getLastDayInYear(dateTimeFromMills(mills));
    }

    public static DateTime getLastDayInYear(DateTime dateTime) {
        return getFirstDayNextYear(dateTime).minusDays(1);
    }

    public static DateTime getFirstDayInMonth(long mills) {
        return getFirstDayInMonth(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayInMonth(DateTime dateTime) {
        return dateTime.withDayOfMonth(1)
                .withTime(0, 0, 0, 0);
    }

    public static DateTime getFirstDayNextMonth(long mills) {
        return getFirstDayNextMonth(dateTimeFromMills(mills));
    }

    public static DateTime getFirstDayNextMonth(DateTime dateTime) {
        return getFirstDayInMonth(dateTime).plusMonths(1);
    }

    public static DateTime getLastDayInMonth(long mills) {
        return getLastDayInMonth(dateTimeFromMills(mills));
    }

    public static DateTime getLastDayInMonth(DateTime dateTime) {
        return getFirstDayNextMonth(dateTime).minusDays(1);
    }

    /**
     * 取当天的最后时间
     * @param mills
     * @return
     */
    public static DateTime getEndTimeInDay(long mills) {
        DateTime dateTime = dateTimeFromMills(mills);
        return dateTime.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(0);
    }

    /**
     * 取当天的开始时间
     * @param mills
     * @return
     */
    public static DateTime getFirstTimeInDay(long mills) {
        DateTime dateTime = dateTimeFromMills(mills);
        return dateTime.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
    }

    public static long getTodayBeginTime() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前时间的第二天0点
     * @param mills
     * @return
     */
    public static DateTime getNextDayZero(long mills) {
        DateTime dateTime = dateTimeFromMills(mills);
        return dateTime.plusDays(1).withTime(0, 0, 0, 0);
    }
    /**
     * 获取当前时间的第二天24点
     * @param mills
     * @return
     */
    public static DateTime getNextDayEnd(long mills) {
        DateTime dateTime = dateTimeFromMills(mills);
        return dateTime.plusDays(1).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
    }

    /**
     * 判断时间是否为一天中的前半段
     * @return 没超过12点返回true，否则false
     */
    private static Boolean judgeFirstHalf(DateTime dateTime){
        int hour = dateTime.getHourOfDay();
        return hour<=23;
    }

    public static void main(String[] args) {
        Long oneDay = 86400000L;

        Long days = 2L;

        Long today = getTodayBeginTime();

        Long target = today + oneDay*days;

        System.out.println(target);
    }
}
