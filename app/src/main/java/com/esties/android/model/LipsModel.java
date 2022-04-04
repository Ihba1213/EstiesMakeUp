package com.esties.android.model;

import java.util.List;

public class LipsModel {
    private String success;
    private String msg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<LipsDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<LipsDataModel> payload) {
        this.payload = payload;
    }

    private List<LipsDataModel> payload;

    public class LipsDataModel {
        private int lipId;

        public int getLipId() {
            return lipId;
        }

        public void setLipId(int lipId) {
            this.lipId = lipId;
        }

        public String getLipImage() {
            return lipImage;
        }

        public void setLipImage(String lipImage) {
            this.lipImage = lipImage;
        }

        public String getLipImageWithMakeUp() {
            return lipImageWithMakeUp;
        }

        public void setLipImageWithMakeUp(String lipImageWithMakeUp) {
            this.lipImageWithMakeUp = lipImageWithMakeUp;
        }

        private String lipImage;
        private String lipImageWithMakeUp;
    }
}
