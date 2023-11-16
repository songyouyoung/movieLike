package com.movielike.app.domain;

public class PersonDto {
    private int perId;
    private String perName;
    private String perImgSrc;
    private String perJob;

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerImgSrc() {
        return perImgSrc;
    }

    public void setPerImgSrc(String perImgSrc) {
        this.perImgSrc = perImgSrc;
    }

    public String getPerJob() {
        return perJob;
    }

    public void setPerJob(String perJob) {
        this.perJob = perJob;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "perId=" + perId +
                ", perName='" + perName + '\'' +
                ", perImgSrc='" + perImgSrc + '\'' +
                ", perJob='" + perJob + '\'' +
                '}';
    }
}
