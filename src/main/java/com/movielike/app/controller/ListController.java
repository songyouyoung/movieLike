package com.movielike.app.controller;

import com.movielike.app.service.KeywordService;
import com.movielike.app.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ListController {
    @Autowired
    ListService service;

    @GetMapping("/list/chart")
    public String showListMovie(String title, String val, Model model){
        model.addAttribute("title", title);
        model.addAttribute("val", val);
        Map<String, String> search = new HashMap<>();
        search.put("val", val);
        search.put("title", title);
        System.out.println(search);
        return "Movie_Like_group";
    }
}
