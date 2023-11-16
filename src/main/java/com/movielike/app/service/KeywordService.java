package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
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
        for (int i = 0; i < movieList.size(); i++){
            // 감독데이터 출력
            List<PersonDto> personList = movieDao.selectPerson(0, movieList.get(i).getMovId(), "감독");
            String perName = "";
            for(int j = 0; j < personList.size(); j++){
                perName += personList.get(j).getPerName() + ",";
            }
            perName = perName.substring(0, perName.length()-1);
            movieList.get(i).setDirName(perName);

            // 나라데이터 출력
            movieList.get(i).setCName(movieDao.selectCountry(movieList.get(i).getMovId()));
            System.out.println("asdf : "+movieList.get(i).getCName());

            // 장르데이터 출력
            movieList.get(i).setGenrName(movieDao.selectGenre(movieList.get(i).getMovId()));
            
            // ott데이터 출력

        }
        return movieList;
    }
}
