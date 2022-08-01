package com.eugene.kindle.service;

import com.eugene.kindle.bean.Note;
import java.util.List;

/**
 * 笔记转换服务
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public interface IConvertService {

    List<Note> getNotes(String path, String bookName);

    List<String> getBookNames(String path);
}
