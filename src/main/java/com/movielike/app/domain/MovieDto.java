package com.movielike.app.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

public class MovieDto {
    private int movId;
    private String movName;
    private String movNameEng;
    private String movDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date movDate;
    private int movTime;
    private int movSearchCnt;
    private String movPoster;
    private String movTrailer;

    private double movScore;
    private int movScoreCnt;
    private String cName; //movie Table에 없음. 나라이름.
    private String ottName; //movie Table에 없음. ott이름.
    private String genrName; //movie Table에 없음. 장르이름.
    private String dirName; //movie Table에 없음. 감독이름.
    private String actName; //movie Table에 없음. 배우이름.
    

    public MovieDto() {
    }

    public MovieDto(double movScore, int movScoreCnt) {
        this.movScore = movScore;
        this.movScoreCnt = movScoreCnt;
    }

    public MovieDto(double movScore, int movScoreCnt, String ottName, String genrName){
        this.movScore = movScore;
        this.movScoreCnt = movScoreCnt;
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

    public Date getMovDate() {
        return movDate;
    }

    public void setMovDate(Date movDate) {
        this.movDate = movDate;
    }

    public int getMovTime() {
        return movTime;
    }

    public void setMovTime(int movTime) {
        this.movTime = movTime;
    }

    public int getMovSearchCnt() {
        return movSearchCnt;
    }

    public void setMovSearchCnt(int movSearchCnt) {
        this.movSearchCnt = movSearchCnt;
    }

    public String getMovPoster() {
        return movPoster;
    }

    public void setMovPoster(String movPoster) {
        this.movPoster = movPoster;
    }

    public String getMovTrailer() {
        return movTrailer;
    }

    public void setMovTrailer(String movTrailer) {
        this.movTrailer = movTrailer;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public double getMovScore() {
        return movScore;
    }

    public void setMovScore(double movScore) {
        this.movScore = movScore;
    }

    public int getMovScoreCnt() {
        return movScoreCnt;
    }

    public void setMovScoreCnt(int movScoreCnt) {
        this.movScoreCnt = movScoreCnt;
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

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "movId=" + movId +
                ", movName='" + movName + '\'' +
                ", movNameEng='" + movNameEng + '\'' +
                ", movDesc='" + movDesc + '\'' +
                ", movDate=" + movDate +
                ", movTime=" + movTime +
                ", movSearchCnt=" + movSearchCnt +
                ", movPoster='" + movPoster + '\'' +
                ", movTrailer='" + movTrailer + '\'' +
                ", cName='" + cName + '\'' +
                ", movScore=" + movScore +
                ", movScoreCnt=" + movScoreCnt +
                ", ottName='" + ottName + '\'' +
                ", genrName='" + genrName + '\'' +
                ", dirName='" + dirName + '\'' +
                ", actName='" + actName + '\'' +
                '}';
    }
}
