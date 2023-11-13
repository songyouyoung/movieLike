package com.movielike.app.dao;

import com.movielike.app.domain.movieDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class movieDao {
    @Autowired
    DataSource ds;

//    @Autowired
//    UserDao userDao;

    @Autowired
    SqlSession session;
    String namespace="com.bitstudy.app.dao.movieMapper.";

    public List<movieDto> insertUser(movieDto movieDto) {
        return session.selectList(namespace+"selectKeyword" , movieDto);
    }
}
