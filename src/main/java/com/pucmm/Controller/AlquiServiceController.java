/**
 * Created by Djidjelly Siclait on 10/12/2016.
 */
package com.pucmm.Controller;

import com.pucmm.Service.AlquiService;
import com.pucmm.Service.ClientService;
import com.pucmm.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlquiServiceController {

    @Autowired
    private AlquiService alquiService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ClientService clientService;

    @RequestMapping("/AlquiService")
    public ModelAndView register(Model model){

        model.addAttribute("equipments", inventoryService.findAllEquipments());
        model.addAttribute("totalE", inventoryService.findAllEquipments().size());

        model.addAttribute("clients", clientService.findAllClients());

        return new ModelAndView("AlquiService");
    }


}
