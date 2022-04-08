package com.esties.android.model;

public class DescriptionTextModel {
    private String title;
    private String Desc;

    public DescriptionTextModel(String title, String desc) {
        this.title = title;
        Desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
