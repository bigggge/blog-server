package cc.haoduoyu.blog.controller;

import cc.haoduoyu.blog.exception.CustomException;
import cc.haoduoyu.blog.model.User;
import cc.haoduoyu.blog.model.dto.UserDTO;
import cc.haoduoyu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "register")
    public @ResponseBody
    String register(@RequestBody UserDTO dto) {
        if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            throw new CustomException("the repeatPassword is not equal to password", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return userService.signup(user);
    }

    @PostMapping(path = "login")
    public @ResponseBody
    String login(@RequestBody Map<String, String> map) {
        System.out.println("in " + map);
        String username = map.get("username");
        String password = map.get("password");
        return userService.signin(username, password);
    }
}
