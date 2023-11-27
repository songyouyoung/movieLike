package com.movielike.app.dao;

import com.movielike.app.domain.GenreDto;
import com.movielike.app.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public int deleteUser(int userId) {
        return session.delete(namespace + "deleteUser", userId);
    }

//    송유영 추가
/////////////////////////////////
///////// 회원 정보 수정 //////////
/////////////////////////////////
    public int checkIdModify(UserDto userDto){
        return session.selectOne(namespace + "checkIdModify", userDto);
    }
    public int checkNickModify(UserDto userDto){
        return session.selectOne(namespace + "checkNickModify", userDto);
    }
    public int checkPhoneModify(UserDto userDto){
        return session.selectOne(namespace + "checkPhoneModify", userDto);
    }
    public UserDto selectUser(int userId) {
        return session.selectOne(namespace + "selectUser", userId);
    }

    public int updateUser(UserDto userDto){
        return session.update(namespace + "updateUser", userDto);
    }

    public int deleteUserGenre(int userId) {
        return session.delete(namespace + "deleteUserGenre", userId);
    }
    public int insertUserGenre(List<GenreDto> genreDto){
        return session.insert(namespace + "insertUserGenre", genreDto);
    }

    ///////////////// 주영
    public int checkId(String email) {
        return session.selectOne(namespace + "checkId", email);
    }
    public int checkNick(String nickname) {return session.selectOne(namespace + "checkNick", nickname);}
    public int checkPhone(String Phone) {return session.selectOne(namespace + "checkPhone", Phone);}
}
