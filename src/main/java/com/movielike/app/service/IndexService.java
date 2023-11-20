package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {
    @Autowired
    MovieDao movieDao;
    @Autowired
    CommonService commonService;

    public List<List<MovieDto>> showIndexMovies(Integer userId){
        List<String> genreList = movieDao.selectUserGenre(userId);
        List<List<MovieDto>> movieList = new ArrayList<>(6);
        movieList.add(movieDao.selectMainBanner(genreList));
        movieList.add(movieDao.selectBest("")); // 전체 인기순
        movieList.add(movieDao.selectBest("netflix")); // 넷플릭스 인기순
        movieList.add(movieDao.selectBest("search")); // 검색 많이 한 순
        movieList.add(movieDao.selectSeries("gibli")); // 지브리 시리즈
        movieList.add(movieDao.selectSeries("marble")); // 마블 시리즈
        movieList.add(movieDao.selectSeries("harry")); // 해리포터 시리즈
        return movieList;
    }

    public List<MovieDto> indexSearch(String search){
        // 영화데이터 출력
        List<MovieDto> movieList = movieDao.selectSearchMov(search);
        System.out.println(movieList);
        movieList = commonService.movieList(movieList);
        return movieList;
    }

}
