package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {
    @Autowired
    MovieDao movieDao;

    public List<MovieDto> keywordFind(MovieDto movieDto){
        return movieDao.selectKeyword(movieDto);
    }
}
