package com.myproject.quickcontact.Controller;

import com.myproject.quickcontact.Entities.User;
import com.myproject.quickcontact.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/")
    public String home(Model model){

        model.addAttribute("title","Home - QucikContact");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){

        model.addAttribute("title","About - QucikContact");
        return "about";
    }

    @RequestMapping("/signup")
    public String Signup(Model model){

        model.addAttribute("title","Register - QucikContact");
        return "signup";
    }
}
