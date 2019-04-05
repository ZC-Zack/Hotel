package com.xmut.hotel;

public class Massage {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 0;
    private String content;
    private int type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
