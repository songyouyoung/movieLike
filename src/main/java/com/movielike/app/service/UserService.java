package com.movielike.app.service;

import com.movielike.app.dao.UserDao;
import com.movielike.app.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public String findEmail(UserDto userDto) {
        return userDao.findEmail(userDto);
    }

    public int updatePassword(UserDto userDto) {
        return userDao.updatePassword(userDto);
    }

//    public int
}
