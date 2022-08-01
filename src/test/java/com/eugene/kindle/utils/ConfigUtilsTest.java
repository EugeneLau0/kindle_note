package com.eugene.kindle.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * 配置工具-单元测试
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/31
 */
public class ConfigUtilsTest {

    @Test
    public void test() {
        String fail = ConfigUtils.get("source_name");
        Assert.assertEquals("错误示例通过！", "", fail);
        String success = ConfigUtils.get("source_file");
        Assert.assertEquals("正确示例通过！", "My Clippings.txt", success);
    }
}