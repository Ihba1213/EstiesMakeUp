package com.esties.android.model;

import java.util.List;

public class GalleryModel {
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

    public List<GalleryDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<GalleryDataModel> payload) {
        this.payload = payload;
    }

    private String success;
    private String msg;
    private List<GalleryDataModel> payload;

    public class GalleryDataModel {
        private String beforeImage;
        private String afterImages;

        public String getBeforeImage() {
            return beforeImage;
        }

        public void setBeforeImage(String beforeImage) {
            this.beforeImage = beforeImage;
        }

        public String getAfterImages() {
            return afterImages;
        }

        public void setAfterImages(String afterImages) {
            this.afterImages = afterImages;
        }
    }
}
