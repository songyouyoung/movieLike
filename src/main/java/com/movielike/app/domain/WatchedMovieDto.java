package com.movielike.app.domain;

public class WatchedMovieDto {
    private int wmId;
    private int movId;
    private int userId;

    public WatchedMovieDto() {
    }

    public WatchedMovieDto(int movId, int userId) {
        this.movId = movId;
        this.userId = userId;
    }

    public int getWmId() {
        return wmId;
    }

    public void setWmId(int wmId) {
        this.wmId = wmId;
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
        return "WatchedMovieDto{" +
                "wmId=" + wmId +
                ", movId=" + movId +
                ", userId=" + userId +
                '}';
    }
}
