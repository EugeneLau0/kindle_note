package com.eugene.kindle.service.impl;

import com.eugene.kindle.bean.Note;
import com.eugene.kindle.utils.NoteConfig;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * 笔记服务实现-测试用例
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/31
 */
public class NoteServiceImplTest {

    @Test
    public void test() {
        String path = NoteConfig.getSourcePath();
        ConvertServiceImpl service = new ConvertServiceImpl();
        List<String> bookNames = service.getBookNames(path);
        Assert.assertTrue("书名集合为空", bookNames.size() > 0);
        List<Note> notes = service.getNotes(path, bookNames.get(0));
        for (Note note : notes) {
            System.out.println(note.toString());
        }
        Assert.assertNotEquals("没有可输出的笔记", 0, notes.size());
        NoteServiceImpl noteService = new NoteServiceImpl();
        noteService.createMarkDownNote(notes);
    }
}