package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "/user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if(user.getPassword().equals(verify)){
            return "user/index";
        }else{
            model.addAttribute("error", "your password don't match");

            return "user/add";
        }

    }
}
