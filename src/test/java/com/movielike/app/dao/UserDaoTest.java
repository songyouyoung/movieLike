package com.movielike.app.dao;

import com.movielike.app.domain.GenreDto;
import com.movielike.app.domain.UserDto;
import com.movielike.app.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Test
    public void selectUser() {
        System.out.println("user : " + userService.selectUser(2));
    }

    @Test
    public void updateUser() {
        //UserDto userDto, List<GenreDto> genreDto
        UserDto userDto = userDao.selectUser(2);
        List<GenreDto> genreDtoList = new ArrayList<>();
        GenreDto genreDto1 = new GenreDto("878", 2);
        GenreDto genreDto2 = new GenreDto("10402", 2);
        GenreDto genreDto3 = new GenreDto("10751", 2);
        genreDtoList.add(genreDto1);
        genreDtoList.add(genreDto2);
        genreDtoList.add(genreDto3);
//        userService.updateUser(userDto, genreDtoList);
        Map<String, String> map = new HashMap<>();
        map.put("user", "gg");
        map.put("gernr", "ee");
        System.out.println("map : " + map);
        System.out.println("map : " + map.get("user"));
    }
}