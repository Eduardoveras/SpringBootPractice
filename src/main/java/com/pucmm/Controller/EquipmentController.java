package com.pucmm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Eduardo veras on 06-Oct-16.
 */
@Controller
public class EquipmentController {

    @RequestMapping("/addEquipment")
    public String register(){
        return "registerEquipment";
    }
}
