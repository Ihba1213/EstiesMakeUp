package com.esties.android.model;

import java.util.List;

public class FaceModel {
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

    public  List<FaceDataModel> getPayload() {
        return payload;
    }

    public void setPayload( List<FaceDataModel> payload) {
        this.payload = payload;
    }

    private List<FaceDataModel> payload;

    public class FaceDataModel {
        private int faceId;
        private String faceImage;

        public int getFaceId() {
            return faceId;
        }

        public void setFaceId(int faceId) {
            this.faceId = faceId;
        }

        public String getFaceImage() {
            return faceImage;
        }

        public void setFaceImage(String faceImage) {
            this.faceImage = faceImage;
        }

        public String getFaceImageWithMakeUp() {
            return faceImageWithMakeUp;
        }

        public void setFaceImageWithMakeUp(String faceImageWithMakeUp) {
            this.faceImageWithMakeUp = faceImageWithMakeUp;
        }

        private String faceImageWithMakeUp;
    }
}
