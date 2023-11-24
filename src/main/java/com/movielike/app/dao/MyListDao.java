package com.movielike.app.dao;

import com.movielike.app.domain.MyListDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyListDao {

    @Autowired
    SqlSession session;


    String namespace="com.movielike.app.dao.myListMapper.";

    public int selectMDmylist(MyListDto myListDto) {
        return session.selectOne(namespace + "selectMDmylist" , myListDto);
    }

    public int insertMyList(MyListDto myListDto) {
        return session.insert(namespace + "insertMyList", myListDto);
    }

    public int deleteMyList(MyListDto myListDto) {
        return session.delete(namespace + "deleteMyList", myListDto);
    }
}
