package com.eugene.kindle.constant;

/**
 * 笔记类型
 *
 * @author EUGENE
 * @version 1.0.0
 * @since 2022/7/29
 */
public enum NoteType {
    CALLOUT("标注", 1),
    NOTE("笔记", 2),
    UNKNOWN("未知", 3);

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    private final String name;
    private final int type;

    NoteType(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public static NoteType fromVal(String name) {
        for (NoteType value : NoteType.values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
