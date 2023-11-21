package com.movielike.app.dao;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.domain.OttDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MovieDaoTest {
    @Autowired
    MovieDao movieDao;

    @Test
    public void selectMovie() {
        List<OttDto> ottList = new ArrayList<>();
        OttDto ottDto = new OttDto();
        ottDto.setOttName("Netflix");
        ottList.add(ottDto);
        ottDto.setOttName("Watcha");
        ottList.add(ottDto);

        List<String> genreList = new ArrayList<>();
        genreList.add("모험");
        genreList.add("범죄");

        List<String> countryList = new ArrayList<>();
        countryList.add("스위스");

        MovieDto movieDto = new MovieDto(0, 0, countryList, null, null, 0, 20, 0);
        assertTrue(!movieDao.selectMovie(movieDto).get(0).getMovName().equals(null));
    }

    @Test
    public void selectCountry() {
        assertTrue(movieDao.selectCountry(11) != null);
    }

    @Test
    public void selectOtt() {
        assertTrue(movieDao.selectOtt(492008) != null);
    }

    @Test
    public void selectMainBanner(){
        Integer userId = 1;
        List<String> genrList = new ArrayList<>();
        System.out.println("genrList : " + genrList);

        assertTrue(movieDao.selectMainBanner(genrList) != null);
    }

    @Test
    public void selectBest(){
        String search = "netflix";
        assertTrue(movieDao.selectBest(search) != null);
    }

    @Test
    public void selectSeries(){
        String serName = "marble";
        assertTrue(movieDao.selectSeries(serName) != null);
    }

//    @Test
//    public void selectSearchMov() {
//        String search = "";
//        assertTrue(movieDao.selectSearchMov(search) != null);
//    }

}