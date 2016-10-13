/**
 * Created by Djidjelly Siclait on 10/12/2016.
 */
package com.pucmm.Controller;

import com.pucmm.Entiy.Equipment;
import com.pucmm.Entiy.Family;
import com.pucmm.Entiy.Rent;
import com.pucmm.Entiy.SubFamily;
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
import java.util.ArrayList;
import java.util.List;

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
        /*
        try {
            alquiService.lendRegisteredEquipment(inventoryService.findEquipmentByName("Laptop").getEquipmentId(), new Date(new SimpleDateFormat("dd-MM-yyyy").parse("9-10-2016").getTime()), new Date(new SimpleDateFormat("dd-MM-yyyy").parse("20-11-2016").getTime()), 100.54f, "3");
            alquiService.lendRegisteredEquipment(inventoryService.findEquipmentByName("Laptop").getEquipmentId(), new Date(new SimpleDateFormat("dd-MM-yyyy").parse("01-10-2016").getTime()), new Date(new SimpleDateFormat("dd-MM-yyyy").parse("09-10-2016").getTime()), 100.54f, "4");
        } catch (Exception exp){

        }
        */

        java.util.Date utilDate = new java.util.Date();
        model.addAttribute("today", new Date(utilDate.getTime()));

        model.addAttribute("actives", alquiService.findAllActiveRents());
        model.addAttribute("totalA", alquiService.findAllActiveRents().size());
        model.addAttribute("inactives", alquiService.findAllCompletedRent());
        model.addAttribute("totalI", alquiService.findAllCompletedRent().size());

        return new ModelAndView("rents");
    }

    @RequestMapping("/Statistics")
    public ModelAndView getStatistics(Model model){

        model.addAttribute("clients", clientService.findAllClients().size());

        List<String> most = findMostPopular();
        model.addAttribute("popularE", most.get(0));
        model.addAttribute("popularF", most.get(1));
        model.addAttribute("popularSF", most.get(2));

        model.addAttribute("rents", alquiService.findAllRents());
        model.addAttribute("totalR", alquiService.findAllRents().size());
        model.addAttribute("receipts", alquiService.findAllReceipts());
        model.addAttribute("totalT", alquiService.findAllReceipts().size());

        return new ModelAndView("statistics");
    }

    // Posts
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

    // Auxiliary Functions
    private List<String> findMostPopular(){
        List<String> stats = new ArrayList<>();

        stats.add("Equipment");
        stats.add("Family");
        stats.add("SubFamily");

        int max = 0;

        for (Equipment e:
             inventoryService.findAllEquipments()) {
            int count = 0;

            for (Rent r:
                 alquiService.findAllRents()) {
                if (r.getEquipment().getEquipmentId().equals(e.getEquipmentId()))
                    count++;
            }

            if (count > max){
                max = count;
                stats.remove(0);
                stats.add(0, e.getEquipmentName());
            }
        }

        for (Family f:
                inventoryService.findAllFamilies()) {
            int count = 0;

            for (Rent r:
                    alquiService.findAllRents()) {
                if (r.getEquipment().getFamily().getFamilyName().equals(f.getFamilyName()))
                    count++;
            }

            if (count > max){
                max = count;
                stats.remove(1);
                stats.add(1, f.getFamilyName());
            }
        }

        for (SubFamily s:
                inventoryService.findAllSubFamilies()) {
            int count = 0;

            for (Rent r:
                    alquiService.findAllRents()) {
                if (r.getEquipment().getSubFamily().getSubFamilyName().equals(s.getSubFamilyName()))
                    count++;
            }

            if (count > max){
                max = count;
                stats.remove(2);
                stats.add(2, s.getSubFamilyName());
            }
        }
        
        return stats;
    }
}
