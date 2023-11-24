package com.movielike.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    @GetMapping("/find/chart")
    public String showChart() {
        return "Movie_Like_find";
    }
}
