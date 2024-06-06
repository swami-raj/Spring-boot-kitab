package com.libarary.Library.controller;

import com.libarary.Library.dao.AuthDao;
import com.libarary.Library.dto.KitabDto;
import com.libarary.Library.dto.LoginDto;
import com.libarary.Library.dto.SignupDto;
import com.libarary.Library.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    AuthService authservice;
    @Autowired
    AuthDao authdao;

    @PostMapping("/signup")
    public String add(@RequestBody SignupDto signupdto){
        return authservice.add(signupdto);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return authservice.login(loginDto);
    }
}
