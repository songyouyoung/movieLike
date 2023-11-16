package com.movielike.app.dao;

import com.movielike.app.domain.MovieDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MovieDaoTest {
    @Autowired
    MovieDao movieDao;

    @Test
    public void selectKeyword() {
        MovieDto movieDto = new MovieDto(0, 500, "", "액션|");
        System.out.println("ottName : " + movieDto.getOttName());
        System.out.println("genrName : " + movieDto.getGenrName());
        System.out.println("movScoreCount : " + movieDto.getMovScoreCnt());
        System.out.println("movScore : " + movieDto.getMovScore());
        System.out.println(movieDao.selectKeyword(movieDto).get(0).getMovName());
        assertTrue(!movieDao.selectKeyword(movieDto).get(0).getMovName().equals(null));
    }
}