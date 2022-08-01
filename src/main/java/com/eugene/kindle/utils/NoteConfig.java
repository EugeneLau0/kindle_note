package com.eugene.kindle.utils;

/**
 * 笔记配置类
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/31
 */
public class NoteConfig {

    public static String getSourcePath() {
        return System.getProperty("user.home")
            + ConfigUtils.get("source_path")
            + ConfigUtils.get("source_file");
    }

    public static String getOutComePath() {
        return System.getProperty("user.home")
            + ConfigUtils.get("target_path");
    }

}
