package cn.edu.tsinghua.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liulei on 2014/6/23.
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    public static String STD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取yyyyMMdd格式的日期
     * @param date 要转换的Date
     * @return
     */
    public static String getDayFormatDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    /**
     * 获取yyyy-MM-dd HH:mm:ss格式的日期
     * @param date 要转换的Date
     * @return
     */
    public static String getSecondFormatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(STD_DATE_FORMAT);
        return dateFormat.format(date);
    }

    /**
     *根据日期Date和minutes获取时间，minutes可以为正数或者负数，返回的结果是date+minutes的结果值
     *格式为yyyy-MM-dd HH:mm:ss
     * @param date 要转换的日期
     * @param minutes 加上的分钟数
     * @return
     */
    public static String getSecondFormatDateAddMinutes(Date date, int minutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return getSecondFormatDate(calendar.getTime());
    }

    /**
     * 根据yyyy-MM-dd HH:mm:ss类型的日期获取Date类型
     * @param strDate String类型的日期值
     * @return Date类型的日期值
     * @throws ParseException
     */
    public static Date parseSTDStringtoDate(String strDate) throws ParseException {
        DateFormat format = new SimpleDateFormat(STD_DATE_FORMAT);
        return format.parse(strDate);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
    }
}
