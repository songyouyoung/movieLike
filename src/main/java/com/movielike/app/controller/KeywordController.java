package com.movielike.app.controller;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class KeywordController {
    @Autowired
    KeywordService service;

    @GetMapping("/find/keyword")
    public String goKeyword(){
        return "Movie_Like_keyword";
    }
    @PostMapping("/findKeyword")
    @ResponseBody
    public ResponseEntity<List<MovieDto>> findKeyword(@RequestBody MovieDto movieDto) throws UnsupportedEncodingException {
        System.out.println(movieDto);
        try {
            List<MovieDto> listMovie = service.keywordFind(movieDto);
            if (listMovie == null || listMovie.isEmpty()){
                throw new Exception("출력할 값이 없습니다. ");
            }
            System.out.println("controller 구동 완료");
            System.out.println(listMovie);
            return new ResponseEntity<List<MovieDto>>(listMovie, HttpStatus.OK); // 200
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<MovieDto>> (HttpStatus.BAD_REQUEST); // 400
        }
        /* ResponseEntity - 응답이나 요청시 전송할 정보를 보낼 대상에게 상태코드를 설정 */
    }
}