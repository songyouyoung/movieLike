package com.movielike.app.controller;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<MovieDto> findKeyword(@RequestBody MovieDto movieDto){
        System.out.println(movieDto);
        List<MovieDto> listMovie = service.keywordFind(movieDto);
        System.out.println("asdf : " + listMovie.get(0).getMovName());
        return listMovie;
    }
}
