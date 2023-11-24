package com.movielike.app.domain;

public class MyListDto {
    private int mlId;
    private int movId;
    private int userId;

    public MyListDto() {
    }

    public MyListDto(int movId, int userId) {
        this.movId = movId;
        this.userId = userId;
    }

    public int getMlId() {
        return mlId;
    }

    public void setMlId(int mlId) {
        this.mlId = mlId;
    }

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MyListDto{" +
                "mlId=" + mlId +
                ", movId=" + movId +
                ", userId=" + userId +
                '}';
    }
}
