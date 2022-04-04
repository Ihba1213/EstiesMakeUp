package com.esties.android.model;

import java.io.Serializable;
import java.util.List;

public class FinalImageDataModel implements Serializable {
    private List<FaceContentList> faceContentList;
    private List<EyesContentList> eyesContentList;
    private List<EyeBrowContentList> eyeBrowContentList;

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

    private List<NoseContentList> noseContentList;
    private List<LipsContentList> lipsContentList;
}
