package com.movielike.app.dao;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.domain.PersonDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieDao {
    @Autowired
    DataSource ds;

//    @Autowired
//    UserDao userDao;

    @Autowired
    SqlSession session;
    String namespace="com.movielike.app.dao.movieMapper.";

    public List<MovieDto> selectMovie(MovieDto movieDto) {
        return session.selectList(namespace+"selectMovie" , movieDto);
    }
    
    //searchType : (0 : 감독만 or 배우만, 1 : 둘 다)
    public List<PersonDto> selectPerson(int searchType, int movId, String perJob){
        Map<String, String> movMap = new HashMap<>();
        movMap.put("searchType", String.valueOf(searchType));
        movMap.put("movId", String.valueOf(movId));
        movMap.put("perJob", perJob);
        return session.selectList(namespace+"selectPerson", movMap);
    }

    public String selectCountry(int movId) {
        return session.selectOne(namespace+"selectCountry" , movId);
    }

    public String selectGenre(int movId) {
        return session.selectOne(namespace+"selectGenre" , movId);
    }

    public String selectOtt(int movId) {
        return session.selectOne(namespace+"selectOtt" , movId);
    }
}
