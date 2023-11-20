package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
import com.movielike.app.domain.OttDto;
import com.movielike.app.domain.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class KeywordService {
    @Autowired
    MovieDao movieDao;

    public List<MovieDto> keywordFind(MovieDto movieDto) throws UnsupportedEncodingException {
        // 영화데이터 출력
        List<MovieDto> movieList = movieDao.selectMovie(movieDto);
        System.out.println(movieList);
        CommonService common = new CommonService();
        movieList = common.movieList(movieList);
//        for (int i = 0; i < movieList.size(); i++) {
//            // 감독데이터 출력
//            movieList.get(i).setActorList(movieDao.selectPerson(movieList.get(i).getMovId(), "감독"));
//
//            // 나라데이터 출력
//            movieList.get(i).setCountryNameList(movieDao.selectCountry(movieList.get(i).getMovId()));
//
//            // 장르데이터 출력
//            movieList.get(i).setGenreList(movieDao.selectGenre(movieList.get(i).getMovId()));
//
//            // ott데이터 출력
//            movieList.get(i).setOttList(movieDao.selectOtt(movieList.get(i).getMovId()));
//        }
        return movieList;
    }
}