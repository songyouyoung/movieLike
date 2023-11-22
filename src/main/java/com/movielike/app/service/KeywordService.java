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
    @Autowired
    CommonService commonService;

    public List<MovieDto> keywordFind(MovieDto movieDto) throws UnsupportedEncodingException {
        // 영화데이터 출력
        List<MovieDto> movieList = movieDao.selectMovie(movieDto);
        movieList = commonService.movieList(movieList);
        return movieList;
    }
}