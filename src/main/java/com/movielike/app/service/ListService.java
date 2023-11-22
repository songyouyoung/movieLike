package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    @Autowired
    MovieDao movieDao;
    @Autowired
    CommonService commonService;
}
