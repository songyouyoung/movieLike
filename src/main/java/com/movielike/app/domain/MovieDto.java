package com.movielike.app.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

public class MovieDto {
    private int movId;
    private String movName;
    private String movNameEng;//협의 전 컬럼
    private String movDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date movReleaseDate;
    private int movRunTime;
    private int movSearchCnt;
    private String movPosterPath;
    private String movTrailer;

//    아래 영어 이름, 나라, 평점, ott, 장르, 감독/배우는 아직 합의 전
    private String movCountry;
    private double movScore;
    private int movScoreCount;
    private String ottName;
    private String genrName;
    private String dirId;
    private String actId;

    public MovieDto() {
    }

    public MovieDto(int movSearchCnt) {
        this.movSearchCnt = movSearchCnt;
    }

    public MovieDto(double movScore, int movScoreCount) {
        this.movScore = movScore;
        this.movScoreCount = movScoreCount;
    }

    public MovieDto(double movScore, int movScoreCount, String ottName, String genrName){
        this.movScore = movScore;
        this.movScoreCount = movScoreCount;
        this.ottName = ottName;
        this.genrName = genrName;
    }

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public String getMovName() {
        return movName;
    }

    public void setMovName(String movName) {
        this.movName = movName;
    }

    public String getMovNameEng() {
        return movNameEng;
    }

    public void setMovNameEng(String movNameEng) {
        this.movNameEng = movNameEng;
    }

    public String getMovDesc() {
        return movDesc;
    }

    public void setMovDesc(String movDesc) {
        this.movDesc = movDesc;
    }

    public Date getMovReleaseDate() {
        return movReleaseDate;
    }

    public void setMovReleaseDate(Date movReleaseDate) {
        this.movReleaseDate = movReleaseDate;
    }

    public int getMovRunTime() {
        return movRunTime;
    }

    public void setMovRunTime(int movRunTime) {
        this.movRunTime = movRunTime;
    }

    public int getMovSearchCnt() {
        return movSearchCnt;
    }

    public void setMovSearchCnt(int movSearchCnt) {
        this.movSearchCnt = movSearchCnt;
    }

    public String getMovPosterPath() {
        return movPosterPath;
    }

    public void setMovPosterPath(String movPosterPath) {
        this.movPosterPath = movPosterPath;
    }

    public String getMovTrailer() {
        return movTrailer;
    }

    public void setMovTrailer(String movTrailer) {
        this.movTrailer = movTrailer;
    }

    public String getMovCountry() {
        return movCountry;
    }

    public void setMovCountry(String movCountry) {
        this.movCountry = movCountry;
    }

    public double getMovScore() {
        return movScore;
    }

    public void setMovScore(double movScore) {
        this.movScore = movScore;
    }

    public int getMovScoreCount() {
        return movScoreCount;
    }

    public void setMovScoreCount(int movScoreCount) {
        this.movScoreCount = movScoreCount;
    }

    public String getOttName() {
        return ottName;
    }

    public void setOttName(String ottName) throws UnsupportedEncodingException {
        this.ottName = URLDecoder.decode(ottName, "UTF-8");
    }

    public String getGenrName() {
        return genrName;
    }

    public void setGenrName(String genrName) throws UnsupportedEncodingException {
//        this.genrName = URLDecoder.decode(genrName, "UTF-8");
        this.genrName = genrName;
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "movId=" + movId +
                ", movName='" + movName + '\'' +
                ", movNameEng='" + movNameEng + '\'' +
                ", movDesc='" + movDesc + '\'' +
                ", movReleaseDate=" + movReleaseDate +
                ", movRunTime=" + movRunTime +
                ", movSearchCnt=" + movSearchCnt +
                ", movPosterPath='" + movPosterPath + '\'' +
                ", movTrailer='" + movTrailer + '\'' +
                ", movCountry='" + movCountry + '\'' +
                ", movScore=" + movScore +
                ", movScoreCount=" + movScoreCount +
                ", ottName='" + ottName + '\'' +
                ", genrName='" + genrName + '\'' +
                ", dirId='" + dirId + '\'' +
                ", actId='" + actId + '\'' +
                '}';
    }
}
