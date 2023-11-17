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
        for (int i = 0; i < movieList.size(); i++) {
            // 감독데이터 출력
            List<PersonDto> personList = movieDao.selectPerson(movieList.get(i).getMovId(), "감독");
            String perName = "감독 : ";
            for (int j = 0; j < personList.size(); j++) {
                perName += personList.get(j).getPerName() + ", ";
            }
            perName = perName.substring(0, perName.length() - 2);
            movieList.get(i).setDirName(perName);

            // 나라데이터 출력
            movieList.get(i).setCName(movieDao.selectCountry(movieList.get(i).getMovId()));

            // 장르데이터 출력
            movieList.get(i).setGenrName(movieDao.selectGenre(movieList.get(i).getMovId()));

            // ott데이터 출력
            List<OttDto> ottList = movieDao.selectOtt(movieList.get(i).getMovId());
            if (ottList.size() != 0) {
                String ottId = "";
                String ottName = "";
                for (int j = 0; j < ottList.size(); j++) {
                    ottId += ottList.get(j).getOttId() + ",";
                    ottName += ottList.get(j).getOttName() + ",";
                }
                movieList.get(i).setOttId(ottId);
                movieList.get(i).setOttName(ottName);
            }

        }
        return movieList;
    }
}
