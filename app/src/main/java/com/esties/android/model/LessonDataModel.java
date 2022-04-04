package com.esties.android.model;

import java.util.List;

public class LessonDataModel {
    private List<LessonAfterAndBeforeImageList> lessonAfterAndBeforeImageList;

    private String videoUrl;

    public List<LessonAfterAndBeforeImageList> getLessonAfterAndBeforeImageList() {
        return lessonAfterAndBeforeImageList;
    }

    public void setLessonAfterAndBeforeImageList(List<LessonAfterAndBeforeImageList> lessonAfterAndBeforeImageList) {
        this.lessonAfterAndBeforeImageList = lessonAfterAndBeforeImageList;
    }

    public List<LessonSliderImagesList> getLessonSliderImagesList() {
        return lessonSliderImagesList;
    }

    public void setLessonSliderImagesList(List<LessonSliderImagesList> lessonSliderImagesList) {
        this.lessonSliderImagesList = lessonSliderImagesList;
    }

    private List<LessonSliderImagesList> lessonSliderImagesList;

    private String description;

    private String content;



    public String getVideoUrl ()
    {
        return videoUrl;
    }

    public void setVideoUrl (String videoUrl)
    {
        this.videoUrl = videoUrl;
    }



    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lessonAfterAndBeforeImageList = "+lessonAfterAndBeforeImageList+", videoUrl = "+videoUrl+", lessonSliderImagesList = "+lessonSliderImagesList+", description = "+description+", content = "+content+"]";
    }
}
