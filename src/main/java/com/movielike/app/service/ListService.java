package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListService {
    @Autowired
    MovieDao movieDao;
    @Autowired
    CommonService commonService;

    public List<MovieDto> listSearch(String title, String val){
        Map<String, String> search = new HashMap<>();
        search.put("title", title);
        System.out.println("search : " + search);
        return movieDao.selectSearchMov(search);
    }
}
