package com.eugene.kindle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置工具类
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/31
 */
public class ConfigUtils {
    private static final Properties configProperties;
    static {
        configProperties = new Properties();
        InputStream in;
        in = ConfigUtils.class.getResourceAsStream("/config.properties");
        if (in == null) {
            System.out.println("读取 config.properties 异常！");
        }
        try {
            configProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if (configProperties == null) {
            return "";
        }
        String property = configProperties.getProperty(key);
        return property == null ? "" : property;
    }
}
