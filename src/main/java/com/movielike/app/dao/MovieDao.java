package com.movielike.app.dao;

import com.movielike.app.domain.MovieDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MovieDao {
    @Autowired
    DataSource ds;

//    @Autowired
//    UserDao userDao;

    @Autowired
    SqlSession session;
    String namespace="com.movielike.app.dao.movieMapper.";

    public List<MovieDto> selectKeyword(MovieDto movieDto) {
        return session.selectList(namespace+"selectKeyword" , movieDto);
    }
}
