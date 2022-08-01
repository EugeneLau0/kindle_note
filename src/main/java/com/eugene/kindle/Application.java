package com.eugene.kindle;

import com.eugene.kindle.service.impl.ConvertServiceImpl;
import com.eugene.kindle.service.impl.NoteServiceImpl;
import com.eugene.kindle.utils.NoteConfig;
import java.util.List;
import java.util.Scanner;

/**
 * 主程序入口
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/8/1
 */
public class Application {

    private static final String TIPS = "1. A: 显示所有书的列表；"
        + "\n2. [num]: 列表的前面数字输出笔记；"
        + "\n3. h: 输出提示";

    public static void main(String[] args) {
        System.out.println("===请将文件'My Clippings.txt'放在'下载'目录下===");
        System.out.println(TIPS);
        try {
            exec();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exec();
        }
    }

    private static void exec() {
        ConvertServiceImpl convertService = new ConvertServiceImpl();
        NoteServiceImpl noteService = new NoteServiceImpl();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String param = scanner.nextLine();
            switch (param) {
                case "h":
                    System.out.println(TIPS);
                    break;
                case "A":
                    List<String> bookNames = convertService
                        .getBookNames(NoteConfig.getSourcePath());
                    for (int i = 1; i <= bookNames.size(); i++) {
                        System.out.printf("%s: %s%n", i, bookNames.get(i - 1));
                    }
                    break;
                default:
                    noteService.createNoteByIndex(Integer.parseInt(param));
                    break;
            }
        }
    }
}
