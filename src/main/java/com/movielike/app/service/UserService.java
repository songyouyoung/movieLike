package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.dao.UserDao;
import com.movielike.app.domain.GenreDto;
import com.movielike.app.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
//    송유영 추가
    @Autowired
    MovieDao movieDao;

    public String findEmail(UserDto userDto) {
        return userDao.findEmail(userDto);
    }

    public int updatePassword(UserDto userDto) {
        return userDao.updatePassword(userDto);
    }

    public int selectUserInfo(UserDto userDto) {
        return userDao.selectUserInfo(userDto);
    }

//    송유영 추가
/////////////////////////////////
///////// 회원 정보 수정 //////////
/////////////////////////////////
//    수정 전 유저 정보 조회
    public Map<String, Object> selectUser(int userId){
        Map<String, Object> userAll = new HashMap<>();
        userAll.put("user", userDao.selectUser(userId));
        userAll.put("userGenre", movieDao.selectUserGenre(userId));
        return userAll;
    }
//    회원 정보 수정
    public boolean updateUser(UserDto userDto, List<GenreDto> genreDto){
        int updateUserAll = userDao.updateUser(userDto);
        int deleteUserGenre = userDao.deleteUserGenre(userDto.getUserId());
        int insertUserGenre = userDao.insertUserGenre(genreDto);
        boolean success = updateUserAll > 0 && deleteUserGenre > 0 && insertUserGenre > 0;
        return success;
    }

}
