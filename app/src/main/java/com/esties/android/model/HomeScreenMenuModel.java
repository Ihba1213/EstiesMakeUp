package com.esties.android.model;

public class HomeScreenMenuModel {
    private int image_icon;
    private String title;

    public HomeScreenMenuModel(int image_icon,String title){
        this.image_icon = image_icon;
        this.title =title;
    }

    public int getImage_icon() {
        return image_icon;
    }

    public void setImage_icon(int image_icon) {
        this.image_icon = image_icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
