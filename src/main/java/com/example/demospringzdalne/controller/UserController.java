package com.example.demospringzdalne.controller;

import com.example.demospringzdalne.model.LoginUser;
import com.example.demospringzdalne.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    private UserLoginService service;

    public UserController(UserLoginService service) {
        this.service = service;
    }

    @RequestMapping("/addUser")
    public String getAddUserView(Model model){
        model.addAttribute("newUser", new LoginUser());
        return "add_login_user";
    }
    @PostMapping("/addloginuser")
    public String addNewUser(@ModelAttribute LoginUser newUser) {
//        System.out.println(newUser.getLogin() + " " + newUser.getPassword());
//        return new RedirectView("/index");
        service.addLoginUser(newUser);
        return "redirect:/index";
    }
}
