package com.movielike.app.controller;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.service.KeywordService;
import com.movielike.app.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ListController {
    @Autowired
    ListService service;

    @GetMapping("/list/chart")
    public String showListMovie(String title, String val, Model model){
        List<MovieDto> movieList = service.listSearch(title, val);
        System.out.println("movieList : " + movieList);

        model.addAttribute("title", title);
        model.addAttribute("val", val);
        model.addAttribute("movieList", movieList);
        return "Movie_Like_group";
    }
}
