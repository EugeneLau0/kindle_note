package com.eugene.kindle.service.impl;

import com.eugene.kindle.bean.Note;
import com.eugene.kindle.service.INoteService;
import com.eugene.kindle.utils.NoteConfig;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class NoteServiceImpl implements INoteService {

    @Override
    public void createMarkDownNote(List<Note> notes) {
        if (notes.size() == 0) {
            throw new RuntimeException("没有待输出的笔记！");
        }
        // 按照 location 升序排列 TODO
        String targetFile = NoteConfig.getOutComePath() + notes.get(0).getName() + ".md";
        writeNote(targetFile, notes);
    }

    private void writeNote(String targetFile, List<Note> notes) {
        File file = new File(targetFile);
        if (file.exists()) {
            System.out.printf("删除文件：%s%n", targetFile);
            boolean delete = file.delete();
            if (!delete) {
                System.out.println("文件删除失败，请先手工删除");
                return;
            }
        }
        try {
            if (!file.createNewFile()) {
                throw new RuntimeException("创建文件失败！");
            }
            FileWriter fileWriter = new FileWriter(targetFile,true);
            // 输出书名
            fileWriter.write("# " + file.getName() + "\n\n");
            for (Note note : notes) {
                // 笔记以无序列表的形式输出
                fileWriter.write("- " + note.getContent() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输出路径：" + targetFile);
    }

    @Override
    public void createNoteByIndex(int index) {
        ConvertServiceImpl convertService = new ConvertServiceImpl();
        List<String> bookNames = convertService.getBookNames(NoteConfig.getSourcePath());
        if (bookNames.size() == 0) {
            System.out.println("空的书录");
            return;
        }
        if (index > bookNames.size() || index < 0) {
            System.out.println("非法的索引");
            return;
        }
        List<Note> notes = convertService
            .getNotes(NoteConfig.getSourcePath(), bookNames.get(index - 1));
        createMarkDownNote(notes);
    }
}
