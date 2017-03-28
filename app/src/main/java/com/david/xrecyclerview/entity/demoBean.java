package com.david.xrecyclerview.entity;

/**
 * Created by david on 17/3/28.
 */

public class DemoBean {
    private int imageId;
    private String content;

    public DemoBean(int imageId, String content) {
        this.imageId = imageId;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
