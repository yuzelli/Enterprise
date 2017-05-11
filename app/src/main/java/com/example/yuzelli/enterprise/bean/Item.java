package com.example.yuzelli.enterprise.bean;

/**
 * Created by 51644 on 2017/5/10.
 */

public class Item {
    private String title;
    private boolean flag;

    public Item(String title, boolean flag) {
        this.title = title;
        this.flag = flag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
