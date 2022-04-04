package com.esties.android.model;

import java.util.List;

public class AboutusModel {
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

    public List<AboutusDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<AboutusDataModel> payload) {
        this.payload = payload;
    }

    private List<AboutusDataModel> payload;
}
