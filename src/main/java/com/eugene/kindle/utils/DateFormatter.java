package com.eugene.kindle.utils;

import static java.time.temporal.ChronoField.AMPM_OF_DAY;
import static java.time.temporal.ChronoField.CLOCK_HOUR_OF_AMPM;
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
import static java.time.temporal.ChronoField.YEAR;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 日期工具
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public class DateFormatter {
    /**
     * 源格式：2021年3月26日星期五
     */
    public static final DateTimeFormatter RFC_1123_DATE;
    static {
        Map<Long, String> dow = new HashMap<>();
        dow.put(1L, "星期一");
        dow.put(2L, "星期二");
        dow.put(3L, "星期三");
        dow.put(4L, "星期四");
        dow.put(5L, "星期五");
        dow.put(6L, "星期六");
        dow.put(7L, "星期日");
        RFC_1123_DATE = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendValue(YEAR, 4)
            .appendLiteral('年')
            .appendValue(MONTH_OF_YEAR, 2)
            .appendLiteral('月')
            .appendValue(DAY_OF_MONTH, 2)
            .appendLiteral('日')
            .optionalStart()
            .appendText(DAY_OF_WEEK, dow)
            .optionalEnd()
            .toFormatter(Locale.getDefault(Locale.Category.FORMAT));
    }

    public static final DateTimeFormatter RFC_1123_DATE_TIME;
    static {
        Map<Long, String> dow = new HashMap<>();
        dow.put(1L, "星期一");
        dow.put(2L, "星期二");
        dow.put(3L, "星期三");
        dow.put(4L, "星期四");
        dow.put(5L, "星期五");
        dow.put(6L, "星期六");
        dow.put(7L, "星期日");
        Map<Long, String> meri = new HashMap<>();
        meri.put(0L, "上午");
        meri.put(1L, "下午");
        RFC_1123_DATE_TIME = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendValue(YEAR, 4)
            .appendLiteral('年')
            .appendValue(MONTH_OF_YEAR, 2)
            .appendLiteral('月')
            .appendValue(DAY_OF_MONTH, 2)
            .appendLiteral('日')
            .optionalStart()
            .appendText(DAY_OF_WEEK, dow)
            .optionalEnd()
            .appendLiteral(' ')
            .optionalStart()
            .appendText(AMPM_OF_DAY, meri)
            .optionalEnd()
            .appendValue(CLOCK_HOUR_OF_AMPM, 2)
            .appendLiteral(':')
            .appendValue(MINUTE_OF_HOUR, 2)
            .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2)
            .toFormatter(Locale.getDefault(Locale.Category.FORMAT));
    }

}
