package com.esties.android.model;

import java.util.List;

public class EyesModel {
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

    public List<EyesDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<EyesDataModel> payload) {
        this.payload = payload;
    }

    private List<EyesDataModel> payload;

    public class EyesDataModel {
        private int eyeId;

        public int getEyeId() {
            return eyeId;
        }

        public void setEyeId(int eyeId) {
            this.eyeId = eyeId;
        }

        public String getLeftEyeImage() {
            return leftEyeImage;
        }

        public void setLeftEyeImage(String leftEyeImage) {
            this.leftEyeImage = leftEyeImage;
        }

        public String getRightEyeImage() {
            return rightEyeImage;
        }

        public void setRightEyeImage(String rightEyeImage) {
            this.rightEyeImage = rightEyeImage;
        }

        public String getLeftEyeWithMakeUpImage() {
            return leftEyeWithMakeUpImage;
        }

        public void setLeftEyeWithMakeUpImage(String leftEyeWithMakeUpImage) {
            this.leftEyeWithMakeUpImage = leftEyeWithMakeUpImage;
        }

        public String getRightWithMakeUpImage() {
            return rightWithMakeUpImage;
        }

        public void setRightWithMakeUpImage(String rightWithMakeUpImage) {
            this.rightWithMakeUpImage = rightWithMakeUpImage;
        }

        private String leftEyeImage;
        private String rightEyeImage;
        private String leftEyeWithMakeUpImage;
        private String rightWithMakeUpImage;
    }
}
