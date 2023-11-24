package com.movielike.app.dao;

import com.movielike.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    SqlSession session;

    String namespace = "com.movielike.app.dao.userMapper.";

    public String findEmail(UserDto userDto) {
        return session.selectOne(namespace + "findEmail", userDto);
    }

    public int updatePassword(UserDto userDto) {
        return session.update(namespace + "updatePassword", userDto);
    }

    public int selectUserInfo(UserDto userDto) {
        return session.selectOne(namespace + "selectUserInfo", userDto);
    }
}
