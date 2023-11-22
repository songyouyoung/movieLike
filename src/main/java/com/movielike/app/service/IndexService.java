package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.dao.ReviewDao;
import com.movielike.app.domain.MovieDto;
import com.movielike.app.domain.ReviewDto;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexService {
    @Autowired
    MovieDao movieDao;
    @Autowired
    ReviewDao reviewDao;
    @Autowired
    CommonService commonService;

    public List<List<MovieDto>> showIndexMovies(Integer userId){
        List<String> genreList = new ArrayList<>();
        if (userId != null && userId > 0) {
            genreList = movieDao.selectUserGenre(userId);
        }
        List<List<MovieDto>> movieList = new ArrayList<>(7);
        movieList.add(movieDao.selectMainBanner(genreList)); // 메인배너에 넣을 선택 장르별 or 전체 최신순
        movieList.add(movieDao.selectBest("")); // 전체 인기순
        movieList.add(movieDao.selectBest("netflix")); // 넷플릭스 인기순
        movieList.add(movieDao.selectBest("search")); // 검색 많이 한 순
        movieList.add(movieDao.selectSeries("gibli")); // 지브리 시리즈
        movieList.add(movieDao.selectSeries("marble")); // 마블 시리즈
        movieList.add(movieDao.selectSeries("harry")); // 해리포터 시리즈
        return movieList;
    }

    public List<ReviewDto> showBestReview(){
        List<ReviewDto> reviewList = reviewDao.selectBestReview(0); // 베스트 리뷰
        return reviewList;
    }
}
