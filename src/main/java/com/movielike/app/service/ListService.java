package com.movielike.app.service;

import com.movielike.app.dao.MovieDao;
import com.movielike.app.domain.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListService {
    @Autowired
    MovieDao movieDao;
    @Autowired
    CommonService commonService;

    public List<MovieDto> listSearch(String title, String val, String userId, String nowPage, String sort){
        Map<String, String> search = new HashMap<>();

        search.put("title", title);
        search.put("val", val);
        search.put("sort", sort);
        search.put("nowPage", nowPage);
        if (title == "year" ) {
            int year = Integer.parseInt(val);
            if (val == "1989"){
                search.put("endYear", (year + 1) + "0101");
            }else{
                search.put("startYear", year + "0101");
                search.put("endYear", (year + 10) + "0101");
            }
        } else if (title == "age" ) {
            int age = Integer.parseInt(val);
            LocalDate nowDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
            int year = nowDate.getYear();

            if (val == "50"){
                search.put("startAge", (year - age - 10 + 1) + "0101");
            }else {
                search.put("startAge", (year - age - 10 + 1) + "0101");
                search.put("endAge", (year - age + 1) + "0101");
            }
        } else if (title == "myView" || title == "myLike" || title == "myScore" ) {
            search.put("userId", userId);
        }
        System.out.println("search : " + search);

        return movieDao.selectSearchMov(search);
    }
}
