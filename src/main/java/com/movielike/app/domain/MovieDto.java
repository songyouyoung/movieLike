package com.movielike.app.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

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
    private List<String> countryNameList; //movie Table에 없음. 나라 이름 리스트.
    private List<OttDto> ottList; //movie Table에 없음. ott 리스트
    private List<String> genreList; //movie Table에 없음. 장르 이름 리스트
    private List<PersonDto> actorList; // 배우 리스트
    private int nowPage;
    private int pageSize;


    public MovieDto() {
    }

    public MovieDto(double movScore, int movScoreCnt) {
        this.movScore = movScore;
        this.movScoreCnt = movScoreCnt;
    }

    //    public MovieDto(double movScore, int movScoreCnt, String ottName, String genrName){
//        this.movScore = movScore;
//        this.movScoreCnt = movScoreCnt;
//        this.ottName = ottName;
//        this.genrName = genrName;
//    }

    public MovieDto(double movScore, int movScoreCnt, List<OttDto> ottList, List<String> genreList, int nowPage, int pageSize) {
        this.movScore = movScore;
        this.movScoreCnt = movScoreCnt;
        this.ottList = ottList;
        this.genreList = genreList;
        this.nowPage = nowPage;
        this.pageSize = pageSize;
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

    public List<String> getCountryNameList() {
        return countryNameList;
    }

    public void setCountryNameList(List<String> countryNameList) {
        this.countryNameList = countryNameList;
    }
    public List<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }
    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<PersonDto> getActorList() {
        return actorList;
    }

    public void setActorList(List<PersonDto> actorList) {
        this.actorList = actorList;
    }

    public List<OttDto> getOttList() {
        return ottList;
    }

    public void setOttList(List<OttDto> ottList) {
        this.ottList = ottList;
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
                ", movScore=" + movScore +
                ", movScoreCnt=" + movScoreCnt +
                ", countryNameList=" + countryNameList +
                ", ottList=" + ottList +
                ", genreList=" + genreList +
                ", actorList=" + actorList +
                ", nowPage=" + nowPage +
                ", pageSize=" + pageSize +
                '}';
    }
}