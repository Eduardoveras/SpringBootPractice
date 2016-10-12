package com.pucmm.Controller;

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

/**
 * Created by Eduardo veras on 06-Oct-16.
 */
@Controller
public class EquipmentController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/Equipments")
    public ModelAndView index(Model model) {
        model.addAttribute("inventory", inventoryService.findAllEquipments().size() + 1);
        model.addAttribute("equipments", inventoryService.findAllEquipments());
        model.addAttribute("subfamilies", inventoryService.findAllSubFamilies());
        return new ModelAndView("registerEquipment");
    }


    @Secured("ADMIN")
    @PostMapping("/addNewEquipment")
    public String newEquipment(@RequestParam("name") String name, @RequestParam("subfamily") String subFamily, @RequestParam("stock") Integer stock){

        inventoryService.registerNewEquipment(name,inventoryService.findSubFamilyBySubFamilyName(subFamily).getSubFamilyKey(),stock);

        return "redirect:/Equipments";
    }
}
