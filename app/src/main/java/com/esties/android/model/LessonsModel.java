package com.esties.android.model;

import java.util.List;

public class LessonsModel {
    private String msg;

    public List<LessonDataModel> getPayload() {
        return payload;
    }

    public void setPayload(List<LessonDataModel> payload) {
        this.payload = payload;
    }

    private List<LessonDataModel> payload;

    private String success;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }



    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", payload = "+payload+", success = "+success+"]";
    }
}
