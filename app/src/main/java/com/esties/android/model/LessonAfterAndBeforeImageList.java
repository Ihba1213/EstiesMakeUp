package com.esties.android.model;

public class LessonAfterAndBeforeImageList {
    private String beforeImage;

    private String afterImage;

    public String getBeforeImage ()
    {
        return beforeImage;
    }

    public void setBeforeImage (String beforeImage)
    {
        this.beforeImage = beforeImage;
    }

    public String getAfterImage ()
    {
        return afterImage;
    }

    public void setAfterImage (String afterImage)
    {
        this.afterImage = afterImage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [beforeImage = "+beforeImage+", afterImage = "+afterImage+"]";
    }

}
