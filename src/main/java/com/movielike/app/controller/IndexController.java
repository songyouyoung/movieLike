package com.movielike.app.controller;

import com.movielike.app.domain.MovieDto;
import com.movielike.app.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    IndexService service;

    @GetMapping("/")
    public String showIndex(HttpSession session, Model model){
        Integer userId = (int)session.getAttribute("uID");
        List<List<MovieDto>> movieList = service.showIndexMovies(userId);
        List<MovieDto> allBestList = movieList.get(0);
        List<MovieDto> netflixBestList = movieList.get(1);
        List<MovieDto> searchBestList = movieList.get(2);
        List<MovieDto> gibliList = movieList.get(3);
        List<MovieDto> marbleList = movieList.get(4);
        List<MovieDto> harryList = movieList.get(5);

        model.addAttribute("allBestList", allBestList);
        model.addAttribute("netflixBestList", netflixBestList);
        model.addAttribute("searchBestList", searchBestList);
        model.addAttribute("gibliList", gibliList);
        model.addAttribute("marbleList", marbleList);
        model.addAttribute("harryList", harryList);
        return "index";
    }
}