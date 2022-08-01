package com.eugene.kindle.service;

import com.eugene.kindle.bean.Note;
import java.util.List;

/**
 * 创建笔记
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public interface INoteService {

    /**
     * 生成 Markdown 笔记文件
     *
     * @param notes 笔记对象
     */
    void createMarkDownNote(List<Note> notes);

    /**
     * 通过索引创建笔记
     */
    void createNoteByIndex(int index);
}
