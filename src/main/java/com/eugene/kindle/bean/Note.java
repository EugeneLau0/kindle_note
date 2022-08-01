package com.eugene.kindle.bean;

import com.eugene.kindle.constant.NoteType;
import java.time.LocalDateTime;

/**
 * 笔记对象
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public class Note {

    private String name;
    private float location;
    private NoteType type;
    private LocalDateTime dateTime;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLocation() {
        return location;
    }

    public void setLocation(float location) {
        this.location = location;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("%s#%s#%s#%s#%s", this.name, this.location, this.type.getName(),
            this.dateTime, this.content);
    }
}
