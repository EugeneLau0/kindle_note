package com.eugene.kindle.utils;

import org.junit.Test;

/**
 * 日期工具-单元测试
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/31
 */
public class DateUtilsTest {

    @Test
    public void test() {
        String dateTimeStr = "2022年5月3日星期一 下午6:19:37";
        System.out.println(DateUtils.makeUpZero(dateTimeStr));
        dateTimeStr = "1 6:19:7";
        System.out.println(DateUtils.makeUpZero(dateTimeStr));
    }
}