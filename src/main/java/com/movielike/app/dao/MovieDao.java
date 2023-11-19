package com.movielike.app.dao;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.domain.OttDto;
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
    SqlSession session;
    String namespace="com.movielike.app.dao.movieMapper.";

    public List<MovieDto> selectMovie(MovieDto movieDto) {
        return session.selectList(namespace+"selectMovie" , movieDto);
    }
    
    // perJob에 값 넣으면 감독만, 배우만 조회. ""면 둘 다 조회
    public List<PersonDto> selectPerson(int movId, String perJob){
        Map<String, String> movMap = new HashMap<>();
        movMap.put("movId", String.valueOf(movId));
        movMap.put("perJob", perJob);
        return session.selectList(namespace+"selectPerson", movMap);
    }

    public List<String> selectCountry(int movId) {
        return session.selectList(namespace+"selectCountry" , movId);
    }

    public List<String> selectGenre(int movId) {
        return session.selectList(namespace+"selectGenre" , movId);
    }

    public List<OttDto> selectOtt(int movId) {
        return session.selectList(namespace+"selectOtt" , movId);
    }
}