/**
 * Created by Djidjelly Siclait on 10/12/2016.
 */
package com.pucmm.Controller;

import com.pucmm.Service.AlquiService;
import com.pucmm.Service.ClientService;
import com.pucmm.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

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
        model.addAttribute("totalC", clientService.findAllClients().size());

        return new ModelAndView("AlquiService");
    }

    @PostMapping("/lend")
    public String registerNewLend(@RequestParam("equipment") String equipmentName, @RequestParam("return") Date promisedDate, @RequestParam("rate") float priceRate, @RequestParam("client") String clientId){

        alquiService.lendRegisteredEquipment(inventoryService.findEquipmentByName(equipmentName).getEquipmentId(), promisedDate, priceRate, clientId);

        return "redirect:/AlquiService";
    }
}
