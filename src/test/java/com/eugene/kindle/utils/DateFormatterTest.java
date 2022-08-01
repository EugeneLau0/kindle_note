package com.eugene.kindle.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 * 日期格式-单元测试
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public class DateFormatterTest {

    @Test
    public void testDate() {
        String dateTimeStr = "2022年7月29日星期五";
        dateTimeStr = DateUtils.makeUpZero(dateTimeStr);
        System.out.println(dateTimeStr);
        System.out.println(LocalDate.parse(dateTimeStr, DateFormatter.RFC_1123_DATE));
        Assert.assertTrue(true);
    }

    @Test
    public void testDateTime() {
        String dateTimeStr = "2022年7月29日星期五 下午11:57:07";
        dateTimeStr = DateUtils.makeUpZero(dateTimeStr);
        System.out.println(LocalDateTime.parse(dateTimeStr, DateFormatter.RFC_1123_DATE_TIME));
        dateTimeStr = "2022年7月29日星期五 上午11:57:07";
        dateTimeStr = DateUtils.makeUpZero(dateTimeStr);
        System.out.println(LocalDateTime.parse(dateTimeStr, DateFormatter.RFC_1123_DATE_TIME));
        dateTimeStr = "2022年5月30日星期一 下午6:19:37";
        dateTimeStr = DateUtils.makeUpZero(dateTimeStr);
        System.out.println(LocalDateTime.parse(dateTimeStr, DateFormatter.RFC_1123_DATE_TIME));
        dateTimeStr = "2022年5月30日星期一 下午06:19:37";
        dateTimeStr = DateUtils.makeUpZero(dateTimeStr);
        System.out.println(LocalDateTime.parse(dateTimeStr, DateFormatter.RFC_1123_DATE_TIME));
        Assert.assertTrue(true);
    }

}