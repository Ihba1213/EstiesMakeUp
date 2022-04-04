package com.esties.android.model;

import java.util.List;

public class AboutusDataModel {
    private String description;
    private String videoUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<HomeBannerList> getBannersList() {
        return bannersList;
    }

    public void setBannersList(List<HomeBannerList> bannersList) {
        this.bannersList = bannersList;
    }

    private String heading;
    private String content;
    private List<BottomImageModel> aboutBottomImageList;
    private List<HomeBannerList> bannersList;

    public List<BottomImageModel> getAboutBottomImageList() {
        return aboutBottomImageList;
    }

    public void setAboutBottomImageList(List<BottomImageModel> aboutBottomImageList) {
        this.aboutBottomImageList = aboutBottomImageList;
    }

    public List<TopImageModel> getAboutTopImageList() {
        return aboutTopImageList;
    }

    public void setAboutTopImageList(List<TopImageModel> aboutTopImageList) {
        this.aboutTopImageList = aboutTopImageList;
    }

    private List<TopImageModel> aboutTopImageList;
    private List<TopImageModel> homegallerybottomsList;

    public List<TopImageModel> getHomegallerybottomsList() {
        return homegallerybottomsList;
    }

    public void setHomegallerybottomsList(List<TopImageModel> homegallerybottomsList) {
        this.homegallerybottomsList = homegallerybottomsList;
    }
}
