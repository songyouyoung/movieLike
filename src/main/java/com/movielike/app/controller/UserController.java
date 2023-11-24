package com.movielike.app.controller;

import com.movielike.app.domain.UserDto;
import com.movielike.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /* 세션 */
        HttpSession session = request.getSession();
        session.setAttribute("liogdin", 2);
        return "redirect:/";
    }

    @GetMapping("/show/findEmail")
    public String showFindEmail() {
        return "find_id";
    }

    @PostMapping("/find/email")
    @ResponseBody
    public ResponseEntity<String> findEmail(@RequestBody Map<String, String> map) {
        try {
            Date date = new Date();
            date.setYear(Integer.parseInt(map.get("birth_year")) - 1900);
            date.setMonth(Integer.parseInt(map.get("birth_month")) - 1);
            date.setDate(Integer.parseInt(map.get("birth_date")));

            UserDto userDto = new UserDto(map.get("userName"), new java.sql.Date(date.getTime()), map.get("userPhone"));
            String result = userService.findEmail(userDto);
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/findPassword")
    public String showFindPassword() {
        return "find_password";
    }

    @PostMapping("/find/password")
    @ResponseBody
    public ResponseEntity<String> showFindPassword(@RequestBody UserDto userDto) {
        try {
            if(userService.updatePassword(userDto) == 1) {
//                return new ResponseEntity<String>("비밀번호 수정하였습니다!",HttpStatus.OK);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
