package com.esties.android.model;

import java.util.List;

public class FinalImageModel {
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

    public List<FinalImageDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<FinalImageDataModel> payload) {
        this.payload = payload;
    }

    private List<FinalImageDataModel> payload;
}
