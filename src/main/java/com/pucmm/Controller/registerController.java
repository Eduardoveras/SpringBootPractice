package com.pucmm.Controller;

import com.pucmm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Eduardo veras on 02-Oct-16.
 */
@Controller
public class registerController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Users")
    public ModelAndView register(Model model){

        return new ModelAndView("register");
    }

    @Secured("ADMIN")
    @PostMapping("/addNewUserAccount")
    public String addNewUser(){

        return "redirect:/Users";
    }

}
