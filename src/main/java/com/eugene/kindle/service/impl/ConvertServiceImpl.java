package com.eugene.kindle.service.impl;

import com.eugene.kindle.constant.NoteType;
import com.eugene.kindle.bean.Note;
import com.eugene.kindle.service.IConvertService;
import com.eugene.kindle.utils.DateFormatter;
import com.eugene.kindle.utils.DateUtils;
import com.eugene.kindle.utils.FileUtils;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertServiceImpl implements IConvertService {

    @Override
    public List<Note> getNotes(String path, String bookName) {
        List<String> lines = FileUtils.readLine(path);
        List<Note> result = new ArrayList<>();
        for (int i = 1; i <= lines.size(); i = i + 5) {
            // 书名不匹配
            if (!lines.get(i - 1).equals(bookName)) {
                continue;
            }
            Note note = new Note();
            note.setName(lines.get(i - 1));
            setNodeInfo(note, lines.get(i));
            note.setContent(lines.get(i + 2));
            result.add(note);
        }
        return result;
    }

    /**
     * 翻译标注的位置、时间行
     *
     * @param line - 您在位置 #1877-1878的标注 | 添加于 2022年5月30日星期一 下午6:19:37
     */
    private void setNodeInfo(Note node, String line) {
//        System.out.println(line);
        if (!line.startsWith("-")) {
            return;
        }
        String[] split = line.replaceFirst("-", "").trim().split("\\|");
        // 0:您在位置 #1877-1878的标注
        // 1:添加于 2022年5月30日星期一 下午6:19:37
        String locationAndType = split[0].replace("您在位置 #", "").trim();
        // 1877-1878的标注
        String[] local = locationAndType.split("的");
        int location = Integer.parseInt(local[0].split("-")[0].trim())
            + Integer.parseInt(local[0].split("-")[0].trim());
        node.setLocation((float) location / 2);
        node.setType(NoteType.fromVal(local[1].trim()));
        String dateTimeStr = split[1].replace("添加于", "").trim();
        // 2022年5月30日星期一 下午6:19:37
        dateTimeStr = DateUtils.makeUpZero(dateTimeStr);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateFormatter.RFC_1123_DATE_TIME);
        node.setDateTime(dateTime);
    }

    @Override
    public List<String> getBookNames(String path) {
        List<String> lines = FileUtils.readLine(path);
        Set<String> names = new HashSet<>();
        for (int i = 1; i <= lines.size(); i = i + 5) {
            names.add(lines.get(i - 1));
        }
        return new ArrayList<>(names);
    }
}
