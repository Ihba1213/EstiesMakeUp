package com.esties.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FinalMakeupModel {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("payload")
    @Expose
    private List<Payload> payload = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Payload> getPayload() {
        return payload;
    }

    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public class Payload {

        @SerializedName("faceContentList")
        @Expose
        private List<FaceContentList> faceContentList = null;
        @SerializedName("eyesContentList")
        @Expose
        private List<EyesContentList> eyesContentList = null;
        @SerializedName("eyeBrowContentList")
        @Expose
        private List<EyeBrowContentList> eyeBrowContentList = null;
        @SerializedName("noseContentList")
        @Expose
        private List<NoseContentList> noseContentList = null;
        @SerializedName("lipsContentList")
        @Expose
        private List<LipsContentList> lipsContentList = null;
        @SerializedName("cheek_wrinkles")
        @Expose
        private List<CheekWrinkleContentList> cheekWrinkles = null;
        @SerializedName("lips_nose_wrinkles")
        @Expose
        private List<LipsNoseWrinkleContentList> lipsNoseWrinkles = null;
        @SerializedName("lips_corner_wrinkles")
        @Expose
        private List<LipsCornerWrinklesList> lipsCornerWrinkles = null;
        @SerializedName("eyebrow_wrinkles")
        @Expose
        private List<EyebrowWrinklesList> eyebrowWrinkles = null;
        @SerializedName("lips_top_wrinkles")
        @Expose
        private List<LipsTopWrinkleList> lipsTopWrinkles = null;
        @SerializedName("forehead_wrinkles")
        @Expose
        private List<ForeHeadWrinklesList> foreheadWrinkles = null;
        @SerializedName("duble_chin")
        @Expose
        private List<DoubleChinWrinkleList> dubleChin = null;

        public List<FaceContentList> getFaceContentList() {
            return faceContentList;
        }

        public void setFaceContentList(List<FaceContentList> faceContentList) {
            this.faceContentList = faceContentList;
        }

        public List<EyesContentList> getEyesContentList() {
            return eyesContentList;
        }

        public void setEyesContentList(List<EyesContentList> eyesContentList) {
            this.eyesContentList = eyesContentList;
        }

        public List<EyeBrowContentList> getEyeBrowContentList() {
            return eyeBrowContentList;
        }

        public void setEyeBrowContentList(List<EyeBrowContentList> eyeBrowContentList) {
            this.eyeBrowContentList = eyeBrowContentList;
        }

        public List<NoseContentList> getNoseContentList() {
            return noseContentList;
        }

        public void setNoseContentList(List<NoseContentList> noseContentList) {
            this.noseContentList = noseContentList;
        }

        public List<LipsContentList> getLipsContentList() {
            return lipsContentList;
        }

        public void setLipsContentList(List<LipsContentList> lipsContentList) {
            this.lipsContentList = lipsContentList;
        }

        public List<CheekWrinkleContentList> getCheekWrinkles() {
            return cheekWrinkles;
        }

        public void setCheekWrinkles(List<CheekWrinkleContentList> cheekWrinkles) {
            this.cheekWrinkles = cheekWrinkles;
        }

        public List<LipsNoseWrinkleContentList> getLipsNoseWrinkles() {
            return lipsNoseWrinkles;
        }

        public void setLipsNoseWrinkles(List<LipsNoseWrinkleContentList> lipsNoseWrinkles) {
            this.lipsNoseWrinkles = lipsNoseWrinkles;
        }

        public List<LipsCornerWrinklesList> getLipsCornerWrinkles() {
            return lipsCornerWrinkles;
        }

        public void setLipsCornerWrinkles(List<LipsCornerWrinklesList> lipsCornerWrinkles) {
            this.lipsCornerWrinkles = lipsCornerWrinkles;
        }

        public List<EyebrowWrinklesList> getEyebrowWrinkles() {
            return eyebrowWrinkles;
        }

        public void setEyebrowWrinkles(List<EyebrowWrinklesList> eyebrowWrinkles) {
            this.eyebrowWrinkles = eyebrowWrinkles;
        }

        public List<LipsTopWrinkleList> getLipsTopWrinkles() {
            return lipsTopWrinkles;
        }

        public void setLipsTopWrinkles(List<LipsTopWrinkleList> lipsTopWrinkles) {
            this.lipsTopWrinkles = lipsTopWrinkles;
        }

        public List<ForeHeadWrinklesList> getForeheadWrinkles() {
            return foreheadWrinkles;
        }

        public void setForeheadWrinkles(List<ForeHeadWrinklesList> foreheadWrinkles) {
            this.foreheadWrinkles = foreheadWrinkles;
        }

        public List<DoubleChinWrinkleList> getDubleChin() {
            return dubleChin;
        }

        public void setDubleChin(List<DoubleChinWrinkleList> dubleChin) {
            this.dubleChin = dubleChin;
        }
    }
}
