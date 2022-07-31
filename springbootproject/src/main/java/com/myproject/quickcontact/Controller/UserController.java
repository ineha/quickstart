package com.myproject.quickcontact.Controller;

import com.myproject.quickcontact.Entities.User;
import com.myproject.quickcontact.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal){

        String name = principal.getName();
        User user = userRepository.getUserByUserName(name);
       model.addAttribute(user);
        return "normal/user_dashboard";
    }

}
