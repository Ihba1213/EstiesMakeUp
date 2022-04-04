package com.esties.android.model;

import java.util.List;

public class NoseModel {
    private String success;

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

    public List<NoseDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<NoseDataModel> payload) {
        this.payload = payload;
    }

    private String msg;
    private List<NoseDataModel> payload;

    public class NoseDataModel {
        private int noseId;

        public int getNoseId() {
            return noseId;
        }

        public void setNoseId(int noseId) {
            this.noseId = noseId;
        }

        public String getNoseImage() {
            return noseImage;
        }

        public void setNoseImage(String noseImage) {
            this.noseImage = noseImage;
        }

        public String getNoseImageWithMakeup() {
            return noseImageWithMakeup;
        }

        public void setNoseImageWithMakeup(String noseImageWithMakeup) {
            this.noseImageWithMakeup = noseImageWithMakeup;
        }

        private String noseImage;
        private String noseImageWithMakeup;
    }
}
