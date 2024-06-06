package com.libarary.Library.service;

import com.libarary.Library.dao.AuthDao;
import com.libarary.Library.dto.LoginDto;
import com.libarary.Library.dto.SignupDto;
import com.libarary.Library.entity.Kitab;
import com.libarary.Library.entity.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthDao authdao;

    public String add(SignupDto signupdto) {
        if (signupdto.getEmail() == null || signupdto.getEmail().isEmpty()) {
            return "Email cannot be blank";
        }
        if (signupdto.getPassword() == null || signupdto.getPassword().isEmpty()) {
            return "Password cannot be blank";
        }

        if (authdao.existsByMail(signupdto.getEmail())) {
            return "User already registered";
        }

        Signup signup=new Signup();
        signup.setName(signupdto.getName());
        signup.setId(signupdto.getId());
        signup.setMail(signupdto.getEmail());
        signup.setPassword(signupdto.getPassword());
        authdao.save(signup);
        return "success";
    }
    public String login(LoginDto loginDto) {
        Optional<Signup> optionalUser = authdao.findByMail(loginDto.getEmail());
        if (optionalUser.isEmpty()) {
            return "Email is incorrect";
        }
        Signup user = optionalUser.get();
        if (!user.getPassword().equals(loginDto.getPassword())) {
            return "Incorrect password";
        }
        return "Login successful";
    }
}
