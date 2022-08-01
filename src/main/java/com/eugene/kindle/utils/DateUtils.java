package com.eugene.kindle.utils;

/**
 * 日期工具类
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/31
 */
public class DateUtils {

    /**
     * 时间若为个位，进行补零
     *
     * @return 2022年5月30日星期一 下午6:19:37 ===>> 2022年05月30日星期一 下午06:19:37
     */
    public static String makeUpZero(String dateTimeStr) {
        char[] time = dateTimeStr.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = time.length - 1; i >= 0; i--) {
            builder.insert(0, time[i]);
            if (Character.isDigit(time[i])) {
                if (i > 0 && !Character.isDigit(time[i - 1])
                    && i < time.length - 1 && !Character.isDigit(time[i + 1])
                    || i == 0 && !Character.isDigit(time[i + 1])
                    || i == time.length - 1 && !Character.isDigit(time[i - 1])
                ) {
                    // 补零
                    builder.insert(0, '0');
                }
            }
        }
        return builder.toString();
    }

}
