/**
 * Created by Djidjelly Siclait on 10/12/2016.
 */
package com.pucmm.Controller;

import com.pucmm.Service.AlquiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlquiServiceController {

    @Autowired
    private AlquiService alquiService;

    @RequestMapping("/AlquiService")
    public ModelAndView register(Model model){

        return new ModelAndView("AlquiService");
    }
}
