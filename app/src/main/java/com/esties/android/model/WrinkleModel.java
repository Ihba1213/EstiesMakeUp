package com.esties.android.model;

import java.util.List;

public class WrinkleModel {
    private String status;
    private String msg;
    private  List<CheekWrinkle> cheek_wrinkles;
        private List<DoubleChinWrinkle> double_chin;
        private List<ForheadWrinkle> forehead_wrinkles;
        private List<LipsTopWrinkle> lips_top_wrinkles;
        private List<LipsNoseWrinkle> lips_nose_wrinkles;
        private List<EyesWrinkle> eyes_wrinkles;
        private List<LipsCornerWrinkle> lips_corner_wrinkles;
        private List<EyebrowsWrinkle> eyebrow_wrinkles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CheekWrinkle> getCheek_wrinkles() {
        return cheek_wrinkles;
    }

    public void setCheek_wrinkles(List<CheekWrinkle> cheek_wrinkles) {
        this.cheek_wrinkles = cheek_wrinkles;
    }

    public List<DoubleChinWrinkle> getDouble_chin() {
        return double_chin;
    }

    public void setDouble_chin(List<DoubleChinWrinkle> double_chin) {
        this.double_chin = double_chin;
    }

    public List<ForheadWrinkle> getForehead_wrinkles() {
        return forehead_wrinkles;
    }

    public void setForehead_wrinkles(List<ForheadWrinkle> forehead_wrinkles) {
        this.forehead_wrinkles = forehead_wrinkles;
    }

    public List<LipsTopWrinkle> getLips_top_wrinkles() {
        return lips_top_wrinkles;
    }

    public void setLips_top_wrinkles(List<LipsTopWrinkle> lips_top_wrinkles) {
        this.lips_top_wrinkles = lips_top_wrinkles;
    }

    public List<LipsNoseWrinkle> getLips_nose_wrinkles() {
        return lips_nose_wrinkles;
    }

    public void setLips_nose_wrinkles(List<LipsNoseWrinkle> lips_nose_wrinkles) {
        this.lips_nose_wrinkles = lips_nose_wrinkles;
    }

    public List<EyesWrinkle> getEyes_wrinkles() {
        return eyes_wrinkles;
    }

    public void setEyes_wrinkles(List<EyesWrinkle> eyes_wrinkles) {
        this.eyes_wrinkles = eyes_wrinkles;
    }

    public List<LipsCornerWrinkle> getLips_corner_wrinkles() {
        return lips_corner_wrinkles;
    }

    public void setLips_corner_wrinkles(List<LipsCornerWrinkle> lips_corner_wrinkles) {
        this.lips_corner_wrinkles = lips_corner_wrinkles;
    }

    public List<EyebrowsWrinkle> getEyebrow_wrinkles() {
        return eyebrow_wrinkles;
    }

    public void setEyebrow_wrinkles(List<EyebrowsWrinkle> eyebrow_wrinkles) {
        this.eyebrow_wrinkles = eyebrow_wrinkles;
    }
}
