package com.movielike.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movielike.app.domain.*;
import com.movielike.app.service.MyPageService;
import com.movielike.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyPageController {
    @Autowired
    MyPageService myPageService;
    @Autowired
    UserService userService;


    @GetMapping("/myPage")
    public String mypage(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam(required = false, defaultValue = "new") String orderType,
            Model model, HttpSession session) {
        session.setAttribute("loginNick","hello@hanmail.com");

        Integer loginId = (int)session.getAttribute("liogdin");

        List<ReviewDto> reviews = myPageService.reviewFind(page, pageSize, orderType, loginId);
        int totalItems = myPageService.reviewCount(loginId);
        model.addAttribute("reviews_count", reviews.size());
        System.out.println("review:  : " + reviews);
        model.addAttribute("review_list", reviews);

        int totalPages = (int) Math.ceil((double) totalItems / pageSize);


        List<WatchedMovieDto> watchedMovies = myPageService.watchedMovieFind(loginId);
        model.addAttribute("watched_count", watchedMovies.size());

        List<MyListDto> myList = myPageService.myListFind(loginId);
        model.addAttribute("list_count", myList.size());

        // 평점 차트
        List<ReviewScoreDto> reviewScore = myPageService.reviewScoreFind(loginId);
        model.addAttribute("review_score", reviewScore);

        // 장르 정보
        List<GenreDto> genreList = myPageService.genreFind(loginId);
        model.addAttribute("genre_list", genreList);

        // 페이징 정보를 전달
        model.addAttribute("currentPage", page);
        model.addAttribute("startPage", page - (page - 1) % 10);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("orderType", orderType);

        return "Movie_Like_mypage";
    }


    // 수빈 + 송유영
    @PostMapping("/myPage/modifyInfo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> modifyInfo(HttpSession httpSession) {
        Integer loginId = (int)httpSession.getAttribute("liogdin");
        try {
            return new ResponseEntity<Map<String, Object>>(userService.selectUser(loginId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/myPage/modifyUser")
    @ResponseBody
    public ResponseEntity<String> modifyUser(@RequestBody Map<String, Object> user, HttpSession httpSession) {
        Integer loginId = (int)httpSession.getAttribute("liogdin");
        String success = "";
        try {
            success = userService.updateUser(user);
            System.out.println("success : " + success);
            if (success.equals("")) {
                return new ResponseEntity<String>(success, HttpStatus.OK);
            }else {
                return new ResponseEntity<String>(success, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(success, HttpStatus.BAD_REQUEST);
        }
    }
}
