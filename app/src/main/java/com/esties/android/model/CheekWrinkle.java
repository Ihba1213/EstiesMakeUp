package com.esties.android.model;

public class CheekWrinkle {
    private String updated_at;

    private String after_img;

    private String name;

    private String description;

    private String created_at;

    private String language;

    private int id;

    private String type;

    private String isActive;

    private String before_img;
    private String befor_img_makeup;
    private String after_img_makeup;

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getAfter_img ()
    {
        return after_img;
    }

    public void setAfter_img (String after_img)
    {
        this.after_img = after_img;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getIsActive ()
    {
        return isActive;
    }

    public void setIsActive (String isActive)
    {
        this.isActive = isActive;
    }

    public String getBefore_img ()
    {
        return before_img;
    }

    public void setBefore_img (String before_img)
    {
        this.before_img = before_img;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [updated_at = "+updated_at+", after_img = "+after_img+", name = "+name+", description = "+description+", created_at = "+created_at+", language = "+language+", id = "+id+", type = "+type+", isActive = "+isActive+", before_img = "+before_img+"]";
    }

    public String getBefor_img_makeup() {
        return befor_img_makeup;
    }

    public void setBefor_img_makeup(String befor_img_makeup) {
        this.befor_img_makeup = befor_img_makeup;
    }

    public String getAfter_img_makeup() {
        return after_img_makeup;
    }

    public void setAfter_img_makeup(String after_img_makeup) {
        this.after_img_makeup = after_img_makeup;
    }
}
