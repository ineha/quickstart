package com.myproject.quickcontact.Controller;

import com.myproject.quickcontact.Entities.User;
import com.myproject.quickcontact.Helper.Message;
import com.myproject.quickcontact.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
        model.addAttribute("user",new User());
        return "signup";
    }

    //handler for register user
    @RequestMapping(value = "/do_register",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value = "agreement",defaultValue = "false") boolean agreement, Model model,HttpSession session){
      try {
          if (!agreement) {
              System.out.println("You have not agreed the terms and conditions");
             throw new Exception("You have not agreed the terms and conditions");

          }
          user.setRole("ROLE_USER");
          user.setEnabled(true);
          User result1 = this.userRepository.save(user);
          System.out.println(result1);
          session.setAttribute("message",new Message("Successfully Registered!!","alert-success"));

          model.addAttribute("user", new User());
          return "signup";
      }
      catch (Exception e){
          e.printStackTrace();
          model.addAttribute("user",user);
          session.setAttribute("message",new Message("Something went wrong!!"+e.getMessage(),"alert-danger"));
          return "signup";
      }

    }
}
