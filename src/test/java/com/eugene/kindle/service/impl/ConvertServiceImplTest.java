package com.eugene.kindle.service.impl;

import com.eugene.kindle.bean.Note;
import com.eugene.kindle.utils.NoteConfig;
import java.util.List;
import org.junit.Test;

/**
 * 笔记转换-单元测试
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public class ConvertServiceImplTest {

    @Test
    public void queryBookNames() {
        String path = NoteConfig.getSourcePath();
        System.out.println(path);
        ConvertServiceImpl service = new ConvertServiceImpl();
        List<String> bookNames = service.getBookNames(path);
        for (String bookName : bookNames) {
            System.out.println(bookName);
        }
    }

    @Test
    public void queryNotesByName() {
        String path = NoteConfig.getSourcePath();
        ConvertServiceImpl service = new ConvertServiceImpl();
        List<Note> notes = service.getNotes(path, "阿弥陀佛么么哒 (大冰)");
        for (Note note : notes) {
            System.out.println(note.toString());
        }
    }
}