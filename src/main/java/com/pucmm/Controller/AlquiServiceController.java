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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;

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

        java.util.Date utilDate = new java.util.Date();
        model.addAttribute("today", new Date(utilDate.getTime()));

        model.addAttribute("equipments", inventoryService.findAllEquipments());
        model.addAttribute("totalE", inventoryService.findAllEquipments().size());

        model.addAttribute("clients", clientService.findAllClients());
        model.addAttribute("totalC", clientService.findAllClients().size());

        model.addAttribute("rents", alquiService.findAllActiveRents());
        model.addAttribute("totalR", alquiService.findAllActiveRents().size());

        return new ModelAndView("AlquiService");
    }

    @RequestMapping("/Rents")
    public ModelAndView getRents(Model model){
        
        java.util.Date utilDate = new java.util.Date();
        model.addAttribute("today", new Date(utilDate.getTime()));

        model.addAttribute("actives", alquiService.findAllActiveRents());
        model.addAttribute("totalA", alquiService.findAllActiveRents().size());
        model.addAttribute("inactives", alquiService.findAllCompletedRent());
        model.addAttribute("totalI", alquiService.findAllCompletedRent().size());

        return new ModelAndView("rents");
    }

    @PostMapping("/lend")
    public String registerNewLend(@RequestParam("equipment") String equipmentName, @RequestParam("return") String promisedDate, @RequestParam("rate") float priceRate, @RequestParam("client") String clientId){

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = new java.util.Date();
        try {
           date = sdf1.parse(promisedDate);
        } catch (Exception exp){

        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        alquiService.lendRegisteredEquipment(inventoryService.findEquipmentByName(equipmentName).getEquipmentId(), sqlDate, priceRate, clientId);

        return "redirect:/AlquiService";
    }

    @PostMapping("/return")
    public String returnBorrowedEquipment(@RequestParam("equipment") String equipmentName, @RequestParam("id") String rentId){

        alquiService.returnRegisteredEquipment(inventoryService.findEquipmentByName(equipmentName).getEquipmentId(), rentId);

        return "redirect:/AlquiService";
    }
}
