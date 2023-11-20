package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {
    @Autowired
    MovieDao movieDao;
    public List<MovieDto> movieList(List<MovieDto> movieList){
        for (int i = 0; i < movieList.size(); i++) {
            // 감독데이터 출력
            System.out.println("null? " + movieList.get(i).getMovId());
            movieList.get(i).setActorList(movieDao.selectPerson(movieList.get(i).getMovId(), "감독"));

            // 나라데이터 출력
            movieList.get(i).setCountryNameList(movieDao.selectCountry(movieList.get(i).getMovId()));

            // 장르데이터 출력
            movieList.get(i).setGenreList(movieDao.selectGenre(movieList.get(i).getMovId()));

            // ott데이터 출력
            movieList.get(i).setOttList(movieDao.selectOtt(movieList.get(i).getMovId()));
        }
        return movieList;
    }
}
