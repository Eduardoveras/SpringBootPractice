package com.pucmm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Eduardo veras on 02-Oct-16.
 */
@Controller
public class registerController {
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
