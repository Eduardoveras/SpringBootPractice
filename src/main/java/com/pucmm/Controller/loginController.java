package com.pucmm.Controller;

import com.pucmm.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by Eduardo veras on 05-Oct-16.
 */
@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error, @RequestParam("username") String username, @RequestParam("password") String password) {

        if(userService.validateUserAccount(username, password))
            return new ModelAndView("AlquiService");

        return new ModelAndView("login", "error", error);
    }
}
