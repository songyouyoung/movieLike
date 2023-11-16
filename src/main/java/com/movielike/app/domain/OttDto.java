package com.movielike.app.domain;

public class OttDto {
    private int ottId;
    private String ottName;

    public int getOttId() {
        return ottId;
    }

    public void setOttId(int ottId) {
        this.ottId = ottId;
    }

    public String getOttName() {
        return ottName;
    }

    public void setOttName(String ottName) {
        this.ottName = ottName;
    }

    @Override
    public String toString() {
        return "OttDto{" +
                "ottId=" + ottId +
                ", ottName='" + ottName + '\'' +
                '}';
    }
}
