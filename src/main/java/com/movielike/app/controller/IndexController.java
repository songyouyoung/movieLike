package com.movielike.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movielike.app.domain.MovieDto;
import com.movielike.app.domain.ReviewDto;
import com.movielike.app.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    IndexService service;

    @GetMapping("/")
    public String showIndex(HttpSession session, Model model) throws JsonProcessingException {
        Integer userId = (Integer) session.getAttribute("liogdin");
        List<List<MovieDto>> movieList = service.showIndexMovies(userId);
        System.out.println("userId : " + userId);
        List<MovieDto> bannerList = movieList.get(0);
        List<MovieDto> allBestList = movieList.get(1);
        List<MovieDto> netflixBestList = movieList.get(2);
        List<MovieDto> searchBestList = movieList.get(3);
        List<MovieDto> gibliList = movieList.get(4);
        List<MovieDto> marbleList = movieList.get(5);
        List<MovieDto> harryList = movieList.get(6);

        List<ReviewDto> reviewList = service.showBestReview();
        System.out.println(reviewList);

        ObjectMapper mapper = new ObjectMapper();
        String bannerString = mapper.writeValueAsString( bannerList );
        String allBestString = mapper.writeValueAsString( allBestList );
        String netflixBestString = mapper.writeValueAsString( netflixBestList );
        String searchBestString = mapper.writeValueAsString( searchBestList );
        String gibliString = mapper.writeValueAsString( gibliList );
        String marbleString = mapper.writeValueAsString( marbleList );
        String harryString = mapper.writeValueAsString( harryList );

        model.addAttribute( "bannerList", bannerString );
        model.addAttribute( "allBestList", allBestString );
        model.addAttribute( "netflixBestList", netflixBestString );
        model.addAttribute( "searchBestList", searchBestString );
        model.addAttribute( "gibliList", gibliString );
        model.addAttribute( "marbleList", marbleString );
        model.addAttribute( "harryList", harryString );
        model.addAttribute( "reviewList", reviewList );
        return "index";
    }
    
    // 임시 세션값 생성
    @GetMapping("/login")
    public String sessionMake(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("liogdin", 1);
        return "redirect:/";
    }
}