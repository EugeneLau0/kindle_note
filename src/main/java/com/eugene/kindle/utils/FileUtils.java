package com.eugene.kindle.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取文件
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public class FileUtils {

    public static List<String> readLine(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new RuntimeException("file not exist!");
            }
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);
                String line;
                List<String> result = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    result.add(line);
                }
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("failed read file!");
        }
    }
}
