package com.esties.android.model;

import java.util.List;

public class EyeBrowsModel {
    private  String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<EyeBrowsDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<EyeBrowsDataModel> payload) {
        this.payload = payload;
    }

    private  String success;
    private List<EyeBrowsDataModel> payload;

    public class EyeBrowsDataModel {
        private int eyeBrowId;
        private String leftEyeBrow;

        public int getEyeBrowId() {
            return eyeBrowId;
        }

        public void setEyeBrowId(int eyeBrowId) {
            this.eyeBrowId = eyeBrowId;
        }

        public String getLeftEyeBrow() {
            return leftEyeBrow;
        }

        public void setLeftEyeBrow(String leftEyeBrow) {
            this.leftEyeBrow = leftEyeBrow;
        }

        public String getRightEyeBrow() {
            return rightEyeBrow;
        }

        public void setRightEyeBrow(String rightEyeBrow) {
            this.rightEyeBrow = rightEyeBrow;
        }

        public String getLeftEyeBrowWithMakeUp() {
            return leftEyeBrowWithMakeUp;
        }

        public void setLeftEyeBrowWithMakeUp(String leftEyeBrowWithMakeUp) {
            this.leftEyeBrowWithMakeUp = leftEyeBrowWithMakeUp;
        }

        public String getRightEyeBrowWithMakeUp() {
            return rightEyeBrowWithMakeUp;
        }

        public void setRightEyeBrowWithMakeUp(String rightEyeBrowWithMakeUp) {
            this.rightEyeBrowWithMakeUp = rightEyeBrowWithMakeUp;
        }

        private String rightEyeBrow;
        private String leftEyeBrowWithMakeUp;
        private String rightEyeBrowWithMakeUp;
    }
}
